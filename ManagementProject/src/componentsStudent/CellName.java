package componentsStudent;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CellName extends TableCustomCell{
	    private JLabel jLabel1;
	    private JTextField txtFullName;
	
	
	public CellName() {
		init();
	}

	public void init() {
		jLabel1 = new javax.swing.JLabel();
        txtFullName = new JTextField();
        txtFullName.setEnabled(false);
        jLabel1.setForeground(new java.awt.Color(200, 200, 200));
        jLabel1.setText("Full Name");

        GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(jLabel1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtFullName, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(txtFullName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	@Override
	public TableCustomCell createComponentCellEditor(TableCustom arg0, TableRowData arg1, Object arg2, int arg3,
			int arg4) {
		CellName cell = new CellName();
		cell.setData(arg2);
		return cell;
	}

	@Override
	public Object getData() {
		String fullName = txtFullName.getText();
		return new ModelName(fullName);
	}

	@Override
	public void setData(Object o) {
		if(o != null) {
			ModelName d = (ModelName)o;
			txtFullName.setText(d.getFullName());

		}
		
	}

}
