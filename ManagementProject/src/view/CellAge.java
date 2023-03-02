package view;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

import model.ModelAge;

public class CellAge extends TableCustomCell {
	private JTextField txtAge;
	private JLabel lblAge;
	
	public CellAge() {
		
		lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(200,200,200));
		txtAge = new JTextField();
		txtAge.setEnabled(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(2)
					.addComponent(lblAge)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblAge))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}


	@Override
	public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row,
			int col) {
		CellAge cell = new CellAge();
		cell.setData(o);
		return cell;
	}


	@Override
	public Object getData() {
		String age = txtAge.getText().trim();
		return new ModelAge(age);
	}


	@Override
	public void setData(Object o) {
		if(o != null) {
			ModelAge age = (ModelAge)o;
			txtAge.setText(age.getAge());
		}
		
	}

}
