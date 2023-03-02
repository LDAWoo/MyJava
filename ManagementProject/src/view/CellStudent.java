package view;

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
import model.ModelAge;
import model.ModelCourses;
import model.ModelGrade;
import model.ModelLearners;
import model.ModelName;
import model.ModelSex;
import model.ModelStudent;
import model.ModelStudents;


public class CellStudent extends TableCustomCell {
	private JTextField txtCodeStudent;
	private AnimationButtonSave btnSave;
	
	private DialogQuestion question = new DialogQuestion(null);
	public CellStudent() {
		
		JLabel lblCodeStudent = new JLabel("Code Student");
		lblCodeStudent.setForeground(new Color(191,191,191));
		txtCodeStudent = new JTextField();

		txtCodeStudent.setEnabled(false);
		
		btnSave = new AnimationButtonSave("Cập nhật");
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
				
				if(grade > 10) {
					getDialogPosition();
					question.lblQuestion.setText("Vui lòng nhập");
					question.lblTextMessage.setText("\"Thang điểm từ 0 - 10\"");
					return;
				}else if(grade < -1) {
					getDialogPosition();
					question.lblQuestion.setText("Vui lòng nhập");
					question.lblTextMessage.setText("\"Điểm bằng -1 nếu không nhập điểm\"");
					return;
				}

				ModelStudents st= (ModelStudents)table.getModelData(row);
				ModelStudents data = new ModelStudents(st.getID(), new ModelStudent(codeStudent),new ModelCourses(codeCourse), new ModelLearners(codeLearner), new ModelName(nameLearner), new ModelSex(gender), new ModelAge(age), new ModelGrade(grade));
				
				try {
				if(st.getID() == 0) {
					// INSERT 
					
					
				}else {
					ManagerLearnerCourseDAO dao = new ManagerLearnerCourseDAO();
					
					if( dao.Update(data)>0) {
						getDialogPosition();
						question.lblQuestion.setText("Cập nhật");
						question.lblTextMessage.setText("\"Thành công\"");
					}else {
						getDialogPosition();
						question.lblQuestion.setText("Cập nhật");
						question.lblTextMessage.setText("\"Thất bại\"");
					}
					
					table.updateModelData(row, data);
				}
				
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
	}
	
	public void getDialogPosition() {
		if(MainEmployee.role == "Employee") {
			question.setLocation(MainEmployee.xScreen, MainEmployee.yScreen);
			question.setVisible(true);
		}else if(Main.role == "Manager") {
			question.setLocation(Main.xScreen, Main.yScreen);
			question.setVisible(true);
		}	
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
