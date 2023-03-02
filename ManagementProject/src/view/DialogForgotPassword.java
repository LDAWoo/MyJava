package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import view.Button;
import view.ButtonHelp;
import view.MainStudent;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import animation.TextField;
import animation.TextFieldForgot;
import animation.TextFieldForgotPassword;
import dao.ForgotPasswordDAO;
import model.ModelAccount;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

public class DialogForgotPassword extends JDialog {

	PanelForgotPassword panel;
	private TextFieldForgot txtEmail;
	private TextFieldForgotPassword txtConfirmPassword;
	private JButton btnExitForgot;
	private JButton btnConfirm;

	private String password_pattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

	private String email_pattern = "^([a-z0-9_\\.-]){2,}+@([\\da-z]){2,}\\.([a-z]){2,}(\\.|[a-z]{2,}){0,}$";

	private String phone_pattern = "^0+[1-9]{1}[0-9]{8}$";

	private ForgotPasswordDAO dao = new ForgotPasswordDAO();
	private ArrayList<ModelAccount> datas = new ArrayList<ModelAccount>();

	private JLabel disable;
	private JLabel disableConfirm;
	private JLabel show;
	private JLabel showConfirm;
	private TextFieldForgotPassword txtNewPassword;
	private JLabel IconEmail;
	private JLabel lblMessage;
	private JLabel IconMessage;
	private JLabel lblPhoneNumber;
	private JLabel lbl2;
	private TextFieldForgot txtPhoneNumber;

	public DialogForgotPassword(JFrame parent) {
		super(parent, false);
		init();
		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension(480, 540));

	}

	public void init() {
		setUndecorated(true);
		panel = new PanelForgotPassword();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap(34, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JLabel lblForgot = new JLabel("Đổi mật khẩu");
		lblForgot.setBounds(0, 35, 460, 46);
		lblForgot.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblForgot.setForeground(new Color(70, 70, 70));
		lblForgot.setBackground(new Color(170, 170, 170));
		lblForgot.setOpaque(true);

		lblForgot.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 112, 439, 24);
		lblEmail.setForeground(new Color(200, 200, 200));

		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 15));

		JLabel lblNewLabel = new JLabel("_____________________________________________________");
		lblNewLabel.setBounds(46, 160, 374, 13);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(200, 200, 200));

		txtEmail = new TextFieldForgot();
		txtEmail.setBounds(46, 147, 374, 25);
		txtEmail.setBorder(null);
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtEmail.setForeground(new Color(200, 200, 200));
		txtEmail.setBackground(new Color(70, 70, 70));
		txtEmail.setCaretColor(new Color(255, 255, 255));

		JLabel lblPassword = new JLabel("Mật khẩu mới");
		lblPassword.setBounds(10, 251, 439, 24);
		lblPassword.setForeground(SystemColor.scrollbar);
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("_____________________________________________________");
		lblNewLabel_1.setBounds(46, 300, 374, 13);
		lblNewLabel_1.setForeground(SystemColor.scrollbar);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblConfirmPassword = new JLabel("Nhập lại mật khẩu");
		lblConfirmPassword.setBounds(10, 324, 439, 24);
		lblConfirmPassword.setForeground(SystemColor.scrollbar);
		lblConfirmPassword.setFont(new Font("SansSerif", Font.PLAIN, 15));

		txtConfirmPassword = new TextFieldForgotPassword();
		txtConfirmPassword.setBounds(46, 362, 374, 25);
		txtConfirmPassword.setForeground(SystemColor.scrollbar);
		txtConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtConfirmPassword.setCaretColor(Color.WHITE);
		txtConfirmPassword.setBorder(null);
		txtConfirmPassword.setBackground(new Color(70, 70, 70));

		JLabel lblNewLabel_1_1 = new JLabel("_____________________________________________________");
		lblNewLabel_1_1.setBounds(46, 375, 374, 13);
		lblNewLabel_1_1.setForeground(SystemColor.scrollbar);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnConfirm = new JButton();
		btnConfirm.setBounds(10, 427, 439, 51);
		btnConfirm.setOpaque(true);
		btnConfirm.setFont(new Font("SansSerif", Font.BOLD, 25));
		btnConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		btnConfirm.setText("XÁC NHẬN");
		btnConfirm.setBackground(new Color(191, 191, 191));
		btnConfirm.setForeground(new Color(70, 70, 70));
		btnConfirm.setFocusPainted(false);
		btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnExitForgot = new JButton("X");
		btnExitForgot.setBounds(409, 0, 51, 24);
		btnExitForgot.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnExitForgot.setBorder(null);
		btnExitForgot.setOpaque(false);
		btnExitForgot.setForeground(new Color(200, 200, 200));
		btnExitForgot.setFocusPainted(false);
		panel.setLayout(null);
		panel.add(lblEmail);
		panel.add(lblNewLabel);
		panel.add(txtEmail);
		panel.add(lblPassword);
		panel.add(lblConfirmPassword);
		panel.add(lblNewLabel_1_1);
		panel.add(txtConfirmPassword);
		panel.add(btnConfirm);
		panel.add(lblNewLabel_1);
		panel.add(lblForgot);
		panel.add(btnExitForgot);

		disable = new JLabel();
		disable.setIcon(img.img.IconEyesInvisible());
		disable.setHorizontalAlignment(SwingConstants.CENTER);
		disable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		disable.setBorder(null);
		disable.setVisible(true);
		disable.setBounds(420, 275, 35, 35);
		panel.add(disable);

		disableConfirm = new JLabel("");
		disableConfirm.setIcon(img.img.IconEyesInvisible());
		disableConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		disableConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		disableConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		disableConfirm.setBounds(420, 350, 35, 35);
		panel.add(disableConfirm);

		show = new JLabel("");
		show.setHorizontalAlignment(SwingConstants.CENTER);
		show.setIcon(img.img.IconEyes());
		show.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		show.setBounds(420, 275, 35, 35);
		panel.add(show);

		showConfirm = new JLabel("");
		showConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		showConfirm.setIcon(img.img.IconEyes());
		showConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showConfirm.setBounds(420, 350, 35, 35);
		panel.add(showConfirm);

		txtNewPassword = new TextFieldForgotPassword();
		txtNewPassword.setSelectionColor(new Color(220, 204, 182));
		txtNewPassword.setForeground(new Color(191, 191, 191));
		txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNewPassword.setCaretColor(Color.WHITE);
		txtNewPassword.setBorder(null);
		txtNewPassword.setBackground(new Color(70, 70, 70));
		txtNewPassword.setBounds(46, 287, 374, 25);
		panel.add(txtNewPassword);

		IconEmail = new JLabel("");
		IconEmail.setHorizontalAlignment(SwingConstants.CENTER);
		IconEmail.setIcon(img.img.IconEmail());
		IconEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconEmail.setBounds(420, 135, 35, 35);
		panel.add(IconEmail);

		lblMessage = new JLabel("Đổi mật khẩu thành công !");
		lblMessage.setForeground(SystemColor.scrollbar);
		lblMessage.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMessage.setBounds(46, 395, 403, 24);
		panel.add(lblMessage);
		lblMessage.setVisible(false);

		IconMessage = new JLabel("");
		IconMessage.setIcon(img.img.iconMessageCheck());
		IconMessage.setHorizontalAlignment(SwingConstants.LEFT);
		IconMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconMessage.setBounds(10, 390, 35, 35);
		panel.add(IconMessage);

		lblPhoneNumber = new JLabel("Số điện thoại");
		lblPhoneNumber.setForeground(SystemColor.scrollbar);
		lblPhoneNumber.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(10, 184, 439, 24);
		panel.add(lblPhoneNumber);

		lbl2 = new JLabel("_____________________________________________________");
		lbl2.setForeground(SystemColor.scrollbar);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl2.setBounds(46, 228, 374, 13);
		panel.add(lbl2);

		txtPhoneNumber = new TextFieldForgot();
		txtPhoneNumber.setSelectionColor(new Color(220, 204, 182));
		txtPhoneNumber.setForeground(new Color(191, 191, 191));
		txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhoneNumber.setCaretColor(Color.WHITE);
		txtPhoneNumber.setBorder(null);
		txtPhoneNumber.setBackground(new Color(70, 70, 70));
		txtPhoneNumber.setBounds(46, 215, 374, 25);
		panel.add(txtPhoneNumber);

		JLabel IconPhone = new JLabel("");
		IconPhone.setIcon(img.img.iconPhone());
		IconPhone.setHorizontalAlignment(SwingConstants.CENTER);
		IconPhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IconPhone.setBounds(420, 200, 35, 35);
		panel.add(IconPhone);
		lblMessage.setVisible(false);
		IconMessage.setVisible(false);

		getContentPane().setLayout(groupLayout);
		action();
		pack();

	}
	

	public boolean Validate() {
		String newPassword = new String(txtNewPassword.getPassword());
		String passwordConfirm = new String(txtConfirmPassword.getPassword());

		if (txtEmail.getText().equals("")) {
			txtEmail.setForeground(new Color(220, 20, 20));
			txtEmail.setColor(new Color(250, 110, 110));
			txtEmail.setFont(new Font("SansSerif", Font.ITALIC, 15));
			txtEmail.setHint("<Vui lòng nhập email của bạn>");
			lblMessage.setVisible(false);
			IconMessage.setVisible(false);
			return false;
		}

		if (!txtEmail.getText().matches(email_pattern)) {
			txtEmail.setText("");
			txtEmail.setForeground(new Color(220, 20, 20));
			txtEmail.setColor(new Color(250, 110, 110));
			txtEmail.setFont(new Font("SansSerif", Font.ITALIC, 15));
			txtEmail.setHint("<Vui lòng nhập email đúng định dạng>");
			lblMessage.setVisible(false);
			IconMessage.setVisible(false);
			return false;
		}

		if (txtPhoneNumber.getText().equals("")) {
			txtPhoneNumber.setForeground(new Color(220, 20, 20));
			txtPhoneNumber.setColor(new Color(250, 110, 110));
			txtPhoneNumber.setFont(new Font("SansSerif", Font.ITALIC, 15));
			txtPhoneNumber.setHint("<Vui lòng nhập số điện thoại của bạn>");
			lblMessage.setVisible(false);
			IconMessage.setVisible(false);
			return false;
		}

		if (!txtPhoneNumber.getText().matches(phone_pattern)) {
			txtPhoneNumber.setText("");
			txtPhoneNumber.setForeground(new Color(220, 20, 20));
			txtPhoneNumber.setColor(new Color(250, 110, 110));
			txtPhoneNumber.setFont(new Font("SansSerif", Font.ITALIC, 15));
			txtPhoneNumber.setHint("<Vui lòng nhập số điện thoại đúng định dạng>");
			lblMessage.setVisible(false);
			IconMessage.setVisible(false);
			return false;
		}

		if (newPassword.equals("")) {
			txtNewPassword.setText("");
			txtNewPassword.setForeground(new Color(220, 20, 20));
			txtNewPassword.setColor(new Color(250, 110, 110));
			txtNewPassword.setFont(new Font("Tahoma", Font.ITALIC, 15));
			txtNewPassword.setHint("<Vui lòng nhập mật khẩu>");
			lblMessage.setVisible(false);
			IconMessage.setVisible(false);
			return false;
		}

		if (!newPassword.matches(password_pattern)) {
			txtNewPassword.setText("");
			txtNewPassword.setForeground(new Color(220, 20, 20));
			txtNewPassword.setColor(new Color(250, 110, 110));
			txtNewPassword.setFont(new Font("Tahoma", Font.ITALIC, 15));
			txtNewPassword.setHint("<Vui lòng nhập mật khẩu đúng định dạng>");
			lblMessage.setVisible(false);
			IconMessage.setVisible(false);
			return false;
		}

		if (passwordConfirm.equals("")) {
			txtConfirmPassword.setText("");
			txtConfirmPassword.setForeground(new Color(220, 20, 20));
			txtConfirmPassword.setColor(new Color(250, 110, 110));
			txtConfirmPassword.setFont(new Font("Tahoma", Font.ITALIC, 15));
			txtConfirmPassword.setHint("<Vui lòng nhập mật khẩu xác nhận>");
			lblMessage.setVisible(false);
			IconMessage.setVisible(false);
			return false;
		}

		if (!passwordConfirm.matches(password_pattern)) {
			txtConfirmPassword.setText("");
			txtConfirmPassword.setForeground(new Color(220, 20, 20));
			txtConfirmPassword.setColor(new Color(250, 110, 110));
			txtConfirmPassword.setFont(new Font("Tahoma", Font.ITALIC, 15));
			txtConfirmPassword.setHint("<Vui lòng nhập mật khẩu xác nhận khớp với mật khẩu>");
			lblMessage.setVisible(false);
			IconMessage.setVisible(false);
			return false;
		}

		return true;
	}

	public void action() {
		txtEmail.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if (txtEmail.getText().equals("")) {
					txtEmail.setForeground(new Color(220, 20, 20));
					txtEmail.setColor(new Color(250, 110, 110));
					txtEmail.setFont(new Font("SansSerif", Font.ITALIC, 15));
					lblMessage.setVisible(false);
					IconMessage.setVisible(false);
				}
				if (txtEmail.getText().length() > 0) {
					txtEmail.setColor(new Color(191, 191, 191));
					txtEmail.setForeground(new Color(191, 191, 191));
					txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblMessage.setVisible(false);
					IconMessage.setVisible(false);
				}

			}
		});

		txtPhoneNumber.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if (txtPhoneNumber.getText().equals("")) {
					txtPhoneNumber.setForeground(new Color(220, 20, 20));
					txtPhoneNumber.setColor(new Color(250, 110, 110));
					txtPhoneNumber.setFont(new Font("SansSerif", Font.ITALIC, 15));
					lblMessage.setVisible(false);
					IconMessage.setVisible(false);
				}
				if (txtPhoneNumber.getText().length() > 0) {
					txtPhoneNumber.setColor(new Color(191, 191, 191));
					txtPhoneNumber.setForeground(new Color(191, 191, 191));
					txtPhoneNumber.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblMessage.setVisible(false);
					IconMessage.setVisible(false);
				}

			}
		});

		txtNewPassword.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if (txtNewPassword.getText().equals("")) {
					txtNewPassword.setForeground(new Color(220, 20, 20));
					txtNewPassword.setColor(new Color(250, 110, 110));
					txtNewPassword.setFont(new Font("Tahoma", Font.ITALIC, 15));
					lblMessage.setVisible(false);
					IconMessage.setVisible(false);
				}
				if (txtNewPassword.getText().length() > 0) {
					txtNewPassword.setColor(new Color(191, 191, 191));
					txtNewPassword.setForeground(new Color(191, 191, 191));
					txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblMessage.setVisible(false);
					IconMessage.setVisible(false);
				}

			}
		});

		txtConfirmPassword.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if (txtConfirmPassword.getText().equals("")) {
					txtConfirmPassword.setForeground(new Color(220, 20, 20));
					txtConfirmPassword.setColor(new Color(250, 110, 110));
					txtConfirmPassword.setFont(new Font("Tahoma", Font.ITALIC, 15));
					lblMessage.setVisible(false);
					IconMessage.setVisible(false);
				}
				if (txtConfirmPassword.getText().length() > 0) {
					txtConfirmPassword.setColor(new Color(191, 191, 191));
					txtConfirmPassword.setForeground(new Color(191, 191, 191));
					txtConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblMessage.setVisible(false);
					IconMessage.setVisible(false);
				}

			}
		});

		btnExitForgot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExitForgot.setOpaque(true);
				btnExitForgot.setBackground(new Color(220, 20, 20));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExitForgot.setOpaque(false);
			}
		});
		btnExitForgot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Validate()) {
					String email = txtEmail.getText();
					String phone = txtPhoneNumber.getText();
					String pass = txtConfirmPassword.getText();
					datas = dao.SelectALL(email);
					if (datas.isEmpty()) {
						txtEmail.setText("");
						txtEmail.setForeground(new Color(220, 20, 20));
						txtEmail.setColor(new Color(250, 110, 110));
						txtEmail.setFont(new Font("SansSerif", Font.ITALIC, 15));
						txtEmail.setHint("<Không tìm thấy tài khoản email của bạn>");
						lblMessage.setVisible(false);
						IconMessage.setVisible(false);

					} else {
						if (!datas.get(0).getPhoneNumber().equals(phone)) {
							txtPhoneNumber.setText("");
							txtPhoneNumber.setForeground(new Color(220, 20, 20));
							txtPhoneNumber.setColor(new Color(250, 110, 110));
							txtPhoneNumber.setFont(new Font("SansSerif", Font.ITALIC, 15));
							txtPhoneNumber.setHint("<Số điện thoại đăng kí email không chính xác>");
							lblMessage.setVisible(false);
							IconMessage.setVisible(false);
						} else {
							dao.ChangePassword(email, pass);
							lblMessage.setVisible(true);
							IconMessage.setVisible(true);
						}
					}
				}

			}
		});

		show.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNewPassword.setEchoChar((char) 8226);
				disable.setVisible(true);
				disable.setEnabled(true);
				show.setVisible(false);
				show.setEnabled(false);
			}
		});

		showConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtConfirmPassword.setEchoChar((char) 8226);
				disableConfirm.setVisible(true);
				disableConfirm.setEnabled(true);
				showConfirm.setVisible(false);
				showConfirm.setEnabled(false);
			}
		});

		disable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNewPassword.setEchoChar((char) 0);
				disable.setVisible(false);
				disable.setEnabled(false);
				show.setVisible(true);
				show.setEnabled(true);
			}
		});

		disableConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtConfirmPassword.setEchoChar((char) 0);
				disableConfirm.setVisible(false);
				disableConfirm.setEnabled(false);
				showConfirm.setVisible(true);
				showConfirm.setEnabled(true);
			}
		});
	}
}
