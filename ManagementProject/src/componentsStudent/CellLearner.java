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

public class CellLearner extends TableCustomCell {
	private JLabel lblCodeLearner;
	private JTextField txtCodeLearner;

	public CellLearner() {
		
		lblCodeLearner = new JLabel("Learner code");
		lblCodeLearner.setForeground(new Color(200,200,200));
		txtCodeLearner = new JTextField();
		txtCodeLearner.setEnabled(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblCodeLearner)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCodeLearner, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodeLearner)
						.addComponent(txtCodeLearner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}

	@Override
	public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row,
			int col) {
		CellLearner cell = new CellLearner();
		cell.setData(o);
		return cell;
	}

	@Override
	public Object getData() {
		return new ModelLearner(txtCodeLearner.getText());
	}

	@Override
	public void setData(Object o) {
		if(o !=null) {
			ModelLearner l = (ModelLearner)o;
			txtCodeLearner.setText(l.getCodeLerner());
		}
		
	}

}
