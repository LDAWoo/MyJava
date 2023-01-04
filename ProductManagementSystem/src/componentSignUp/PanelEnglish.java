package componentSignUp;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import animation.TextField;
import java.awt.Font;
import javax.swing.JLabel;
import animation.TextPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelEnglish extends JPanel {

	
	public PanelEnglish() {
		setLayout(null);
		JPanel panelVietnamese = new JPanel();
		panelVietnamese.setOpaque(false);
		panelVietnamese.setBackground(new Color(250, 250, 250));
		panelVietnamese.setBounds(0, 0, 735, 537);
		add(panelVietnamese);
		
		TextField txtUsername = new TextField();
		txtUsername.setSelectionColor(new Color(0, 40, 255));
		txtUsername.setHint("Username");
		txtUsername.setForeground(new Color(150, 150, 150));
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblErrorUsername = new JLabel("");
		lblErrorUsername.setForeground(new Color(220, 20, 20));
		lblErrorUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		TextPasswordField txtPassword = new TextPasswordField();
		txtPassword.setSelectionColor(new Color(0, 40, 255));
		txtPassword.setHint("Password\r\n");
		txtPassword.setForeground(new Color(150, 150, 150));
		txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblErrorPassword = new JLabel("");
		lblErrorPassword.setForeground(new Color(220, 20, 20));
		lblErrorPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		TextPasswordField txtPasswordConfirm = new TextPasswordField();
		txtPasswordConfirm.setSelectionColor(new Color(0, 40, 255));
		txtPasswordConfirm.setHint("Re-enter password");
		txtPasswordConfirm.setForeground(new Color(150, 150, 150));
		txtPasswordConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblErrorPasswordConfirm = new JLabel("");
		lblErrorPasswordConfirm.setForeground(new Color(220, 20, 20));
		lblErrorPasswordConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		TextField txtEmail = new TextField();
		txtEmail.setSelectionColor(new Color(0, 40, 255));
		txtEmail.setHint("Email");
		txtEmail.setForeground(new Color(150, 150, 150));
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblErrorEmail = new JLabel("");
		lblErrorEmail.setForeground(new Color(220, 20, 20));
		lblErrorEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		TextField txtPhoneNumber = new TextField();
		txtPhoneNumber.setSelectionColor(new Color(0, 40, 255));
		txtPhoneNumber.setHint("Phone Number");
		txtPhoneNumber.setForeground(new Color(150, 150, 150));
		txtPhoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblErrorPhone = new JLabel("");
		lblErrorPhone.setForeground(new Color(220, 20, 20));
		lblErrorPhone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JCheckBox chckbxIAgreeTo = new JCheckBox("I agree to the Term of Service and Privacy Policy");
		chckbxIAgreeTo.setOpaque(false);
		chckbxIAgreeTo.setForeground(new Color(150, 150, 150));
		chckbxIAgreeTo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxIAgreeTo.setFocusPainted(false);
		
		JButton btnSignUpNow = new JButton("Register Now");
		btnSignUpNow.setForeground(new Color(230, 230, 230));
		btnSignUpNow.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnSignUpNow.setFocusPainted(false);
		btnSignUpNow.setBorder(null);
		btnSignUpNow.setBackground(new Color(220, 20, 20));
		
		JLabel lblSignUp = new JLabel("Resgistration");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		GroupLayout gl_panelVietnamese = new GroupLayout(panelVietnamese);
		gl_panelVietnamese.setHorizontalGroup(
			gl_panelVietnamese.createParallelGroup(Alignment.LEADING)
				.addGap(0, 735, Short.MAX_VALUE)
				.addGroup(gl_panelVietnamese.createSequentialGroup()
					.addGroup(gl_panelVietnamese.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVietnamese.createSequentialGroup()
							.addGap(125)
							.addGroup(gl_panelVietnamese.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
								.addComponent(lblErrorUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
								.addComponent(lblErrorPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
								.addComponent(txtPasswordConfirm, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
								.addComponent(lblErrorPasswordConfirm, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
								.addComponent(txtEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
								.addComponent(lblErrorEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
								.addComponent(txtPhoneNumber, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblErrorPhone, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxIAgreeTo, Alignment.LEADING)
								.addComponent(btnSignUpNow, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panelVietnamese.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSignUp, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelVietnamese.setVerticalGroup(
			gl_panelVietnamese.createParallelGroup(Alignment.LEADING)
				.addGap(0, 537, Short.MAX_VALUE)
				.addGroup(gl_panelVietnamese.createSequentialGroup()
					.addGap(19)
					.addComponent(lblSignUp, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorUsername, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPasswordConfirm, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorPasswordConfirm, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorEmail, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPhoneNumber, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorPhone, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxIAgreeTo)
					.addGap(18)
					.addComponent(btnSignUpNow, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panelVietnamese.setLayout(gl_panelVietnamese);

	}

}
