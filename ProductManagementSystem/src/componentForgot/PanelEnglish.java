package componentForgot;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import animation.TextField;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PanelEnglish extends JPanel {

	
	public PanelEnglish() {
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 250, 250));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
		);
		
		JLabel lblChangePassword = new JLabel("Reset password");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		TextField txtUsername = new TextField();
		txtUsername.setSelectionColor(new Color(0, 40, 255));
		txtUsername.setHint("Username/Email");
		txtUsername.setForeground(new Color(150, 150, 150));
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		TextField txtPhoneNumber = new TextField();
		txtPhoneNumber.setSelectionColor(new Color(0, 40, 255));
		txtPhoneNumber.setHint("Phone Number");
		txtPhoneNumber.setForeground(new Color(150, 150, 150));
		txtPhoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblErrorUsername = new JLabel("");
		lblErrorUsername.setForeground(new Color(220, 20, 20));
		lblErrorUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblErrorPhoneNumber = new JLabel("");
		lblErrorPhoneNumber.setForeground(new Color(220, 20, 20));
		lblErrorPhoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setForeground(new Color(230, 230, 230));
		btnContinue.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnContinue.setFocusPainted(false);
		btnContinue.setBorder(null);
		btnContinue.setBackground(new Color(220, 20, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
						.addComponent(lblChangePassword, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
						.addComponent(lblErrorUsername, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
						.addComponent(txtPhoneNumber, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
						.addComponent(lblErrorPhoneNumber, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
						.addComponent(btnContinue, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblChangePassword, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorUsername, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPhoneNumber, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblErrorPhoneNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnContinue, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
}
