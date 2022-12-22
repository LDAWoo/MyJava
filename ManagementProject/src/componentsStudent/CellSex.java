package componentsStudent;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

public class CellSex extends TableCustomCell {

	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;

	public CellSex() {

		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setForeground(new Color(200,200,200));
		ButtonGroup buttonGroup = new ButtonGroup();

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(new Color(200,200,200));
		rdbtnMale.setBackground(getBackground());
		rdbtnMale.setEnabled(false);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setForeground(new Color(200,200,200));
		rdbtnFemale.setBackground(getBackground());
		rdbtnFemale.setEnabled(false);
		
		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnMale)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnFemale)
						.addContainerGap(344, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(rdbtnMale).addComponent(rdbtnFemale))
						.addContainerGap(36, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}

	@Override
	public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row,
			int col) {
		CellSex cell = new CellSex();
		cell.setData(o);
		return cell;
	}

	@Override
	public Object getData() {
		boolean is =true;
		if(rdbtnMale.isSelected()) {
			is = true;
		}else if( rdbtnFemale.isSelected()){
			is = false;
		}	
		return new ModelSex(is);
	}

	@Override
	public void setData(Object o) {
		if(o != null) {
			ModelSex data = (ModelSex)o;			
			if(data.isSex()) {
				rdbtnMale.setSelected(true);
			}else {
				rdbtnFemale.setSelected(true);
			}
		}
		
	}
	
	

}
