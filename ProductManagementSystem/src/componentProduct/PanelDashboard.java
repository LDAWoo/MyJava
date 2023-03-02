package componentProduct;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import color.ColorBackground;
import view.MainForm;
import view.PanelMode;

public class PanelDashboard extends JPanel {

	private Color color1 = new Color(252, 252, 252);
	private JLabel lblTitle;
	
	public PanelDashboard() {
		setOpaque(false);
		
		lblTitle = new JLabel("Bảng Điều Khiển");
		lblTitle.setForeground(color1);
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 30));
		
		PanelOverview panel = new PanelOverview();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		if(MainForm.mode == "Dark") {
			lblTitle.setForeground(ColorBackground.colorLight);
		}else {
			lblTitle.setForeground(ColorBackground.colorDark);
		}
		action();
	}
	public void action() {
		PanelMode.actionButonModeLight(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setForeground(ColorBackground.colorDark);
				
			}
		});
		
		PanelMode.actionButonModeDark(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setForeground(ColorBackground.colorLight);
				
			}
		});
	}
	
	
}
