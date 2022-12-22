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
import com.raven.table.cell.TableCustomCelLEditor;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;


import animation.AnimationButtonSave;
import dao.ManagerLearnerCourseDAO;
import img.img;
import view.Main;

import javax.swing.JButton;

public class CellCourse extends TableCustomCell {
	private JTextField txtCodeCourse;

	public CellCourse() {

		JLabel lblCodeCourse = new JLabel("Course code");
		lblCodeCourse.setForeground(new Color(200, 200, 200));

		txtCodeCourse = new JTextField();
		txtCodeCourse.setEnabled(false);
		

		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCodeCourse)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCodeCourse, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							
					.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodeCourse)
						.addComponent(txtCodeCourse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
					)
		);
		setLayout(groupLayout);
		
		
	}

	
	
	@Override
	public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int col) {
		CellCourse cell = new CellCourse();
		cell.setData(o);
		return cell;
	}

	@Override
	public Object getData() {
		String CodeCourse = txtCodeCourse.getText();
		return new ModelCourse(CodeCourse);
	}

	@Override
	public void setData(Object o) {
		if (o != null) {
			ModelCourse d = (ModelCourse) o;
			txtCodeCourse.setText(d.getCodeCourse());
		}

	}
}
