package componentsStudent;

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

public class CellGrade extends TableCustomCell {
	private JTextField txtGrade;

	public CellGrade() {
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setForeground(new Color(200,200,200));
		txtGrade = new JTextField();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(2)
					.addComponent(lblGrade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtGrade, GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblGrade))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(txtGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	@Override
	public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row,
			int col) {
		CellGrade cell = new CellGrade();
		cell.setData(o);
		return cell;
	}

	@Override
	public Object getData() {
		return new ModelGrade(Double.parseDouble(txtGrade.getText()));
	}

	@Override
	public void setData(Object o) {
		if(o != null) {
			ModelGrade grade = (ModelGrade)o;
			txtGrade.setText(grade.getGrade()+"");
		}
		
	}

}
