package componentsStudent;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

import animation.AnimationButtonSave;
import dao.ManagerLearnerCourseDAO;
import img.img;

public class CellStudent extends TableCustomCell {
	private JTextField txtCodeStudent;
	private AnimationButtonSave btnSave;
	public CellStudent() {
		
		JLabel lblCodeStudent = new JLabel("Code Student");
		lblCodeStudent.setForeground(new Color(191,191,191));
		txtCodeStudent = new JTextField();

		txtCodeStudent.setEnabled(false);
		
		btnSave = new AnimationButtonSave("Update");
		btnSave.setForeground(new Color(50,50,50));
		btnSave.setBackground(new Color(200,200,200));
		btnSave.setFocusPainted(false);
		btnSave.setFont(new Font("SansSerif",Font.PLAIN,16));
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCodeStudent)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCodeStudent, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodeStudent)
						.addComponent(txtCodeStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
	
	
	private void addEventSave(TableCustom table) {
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.stopCellEditing();
				int row = getRow();
				String codeStudent = table.getValueAt(row, 0).toString();
				
				String codeCourse = table.getValueAt(row, 1).toString();
				String codeLearner = table.getValueAt(row, 2).toString();
				String nameLearner = table.getValueAt(row, 3).toString();
				boolean gender = Boolean.parseBoolean(table.getValueAt(row, 4).toString());
				String age = table.getValueAt(row, 5).toString();
				double grade = Double.parseDouble(table.getValueAt(row, 6).toString());	

				ModelStudents st= (ModelStudents)table.getModelData(row);
				
				ModelStudents data = new ModelStudents(st.getID(), new ModelStudent(codeStudent),new ModelCourse(codeCourse), new ModelLearner(codeLearner), new ModelName(nameLearner), new ModelSex(gender), new ModelAge(age), new ModelGrade(grade));
				
				try {
				if(st.getID() == 0) {
					// INSERT 
					
					
				}else {
					ManagerLearnerCourseDAO dao = new ManagerLearnerCourseDAO();
					
					if( dao.Update(data)>0) {
						JOptionPane.showMessageDialog(null, "Update Succesfully","Update",JOptionPane.INFORMATION_MESSAGE,img.iconEdit32x32());
					}else {
						JOptionPane.showMessageDialog(null, "Update Faield","Update",JOptionPane.WARNING_MESSAGE,img.iconEdit32x32());
					}
					
					table.updateModelData(row, data);
				}
				
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
	}
	

	@Override
	public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row,
			int col) {
		CellStudent cell = new CellStudent();
		cell.setData(o);
		cell.addEventSave(table);
		return cell;
	}

	@Override
	public Object getData() {
		return new ModelStudent(txtCodeStudent.getText());
	}

	@Override
	public void setData(Object o) {
		ModelStudent data = (ModelStudent) o;
		txtCodeStudent.setText(data.getCodeStudent());
		
	}
}
