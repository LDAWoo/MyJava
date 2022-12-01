package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.ManagerStudentAndGradeController;
import img.img;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JLabel;

public class ManagerUserAndGradeView extends JFrame {
	private JPanel contentPane;
	private JMenuBar menuBar_1;
	private img img = new img(this);
	private JMenuItem mnItExit;
	private JMenuItem mnItLogOut;
	private JMenu mnSystem;
	private JMenuItem mnItWelcom;
	private JMenuItem mnItContent;
	private ManagerStudentAndGradeController controller = new ManagerStudentAndGradeController(this);
	private JPanel panel;
	private JLabel lblRole;
	private JLabel lblImg;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ManagerUserAndGradeView frame = new ManagerUserAndGradeView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManagerUserAndGradeView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 625);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSystem = new JMenu("System");
		menuBar.add(mnSystem);
		
		mnItLogOut = new JMenuItem("Log Out");
		mnItLogOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnItLogOut.setMnemonic(KeyEvent.VK_L);
		mnSystem.add(mnItLogOut);
		mnItLogOut.addActionListener(controller);
		
		mnItExit = new JMenuItem("Exit");
		mnItExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		mnItExit.setMnemonic(KeyEvent.VK_E);
		mnSystem.add(mnItExit);
		mnItExit.addActionListener(controller);
		
		JMenu mnManager = new JMenu("Manager");
		menuBar.add(mnManager);
		
		JMenuItem mnItManagerStudent = new JMenuItem("ManagerStudent");
		mnItManagerStudent.setMnemonic(KeyEvent.VK_M);
		mnItManagerStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnManager.add(mnItManagerStudent);
		mnItManagerStudent.addActionListener(controller);
		
		JMenuItem mntItManagerGrade = new JMenuItem("ManagerGrade");
		mntItManagerGrade.setMnemonic(KeyEvent.VK_M);
		mntItManagerGrade.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		mnManager.add(mntItManagerGrade);
		mntItManagerGrade.addActionListener(controller);
		
		JMenu mnHepl = new JMenu("Help");
		menuBar.add(mnHepl);
		
		mnItWelcom = new JMenuItem("Welcom");
		mnItWelcom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
		mnItWelcom.setMnemonic(KeyEvent.VK_W);
		mnHepl.add(mnItWelcom);
		
		mnItContent = new JMenuItem("Content");
		mnItContent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		mnHepl.add(mnItContent);
		contentPane = new JPanel();
		contentPane.setEnabled(false);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar_1 = new JMenuBar();
		menuBar_1.setEnabled(false);
		menuBar_1.setAlignmentX(0.0f);
		menuBar_1.setBackground(Color.WHITE);
		menuBar_1.setBounds(0, 0, 948, 35);
		contentPane.add(menuBar_1);   
		
		JButton btnLogOut = new JButton("");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUserView loginUserView = new LoginUserView();
				loginUserView.setVisible(true);
				loginUserView.setLocationRelativeTo(null);
				setVisible(false);
				
			}
		});
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnLogOut.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar_1.add(btnLogOut);
		btnLogOut.setIcon(this.img.IconLogOut());
		
		JButton btnManagerStudent = new JButton("");
		btnManagerStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerStudentView view = new ManagerStudentView();
				view.setVisible(true);
				view.setLocationRelativeTo(null);
				view.getLblRole().setText(getLblRole().getText());
				if(lblRole.getText().equals("Admin")) {
					view.getBtnNew().setEnabled(true);
					view.getBtnDelete().setEnabled(true);
					view.getBtnUpdate().setEnabled(true);
				}else if(lblRole.getText().equals("User")) {
					view.getBtnNew().setEnabled(false);
					view.getBtnSave().setEnabled(false);
					view.getBtnDelete().setEnabled(false);
					view.getBtnUpdate().setEnabled(false);
				}
			}
		});
		btnManagerStudent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnManagerStudent.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar_1.add(btnManagerStudent);
		btnManagerStudent.setIcon(this.img.IconStu());
		
		JButton btnManagerGrade = new JButton("");
		btnManagerGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GradeStudentView view = new GradeStudentView();
				view.setVisible(true);
				view.setLocationRelativeTo(null);
				view.getLblRole().setText(getLblRole().getText());
				if(lblRole.getText().equals("Admin")) {
					view.getTextFieldEnglish().setEnabled(false);
					view.getTextFieldTechnology().setEnabled(false);
					view.getTextFieldPysical().setEnabled(false);
					view.getBtnNew().setEnabled(true);
				}else if(lblRole.getText().equals("User")) {
					view.getTextFieldEnglish().setEnabled(true);
					view.getTextFieldTechnology().setEnabled(true);
					view.getTextFieldPysical().setEnabled(true);
					view.getBtnNew().setEnabled(false);
				}
			}
		});
		btnManagerGrade.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnManagerGrade.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar_1.add(btnManagerGrade);
		btnManagerGrade.setIcon(this.img.IconStuGrade());
		
		JButton btnWelcom = new JButton("");
		btnWelcom.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnWelcom.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar_1.add(btnWelcom);
		btnWelcom.setIcon(this.img.IconNotification());
		
		panel = new JPanel();
		panel.setBounds(0, 34, 949, 530);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblRole = new JLabel("");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRole.setBounds(10, 505, 46, 14);
		panel.add(lblRole);
		
		lblImg = new JLabel("");
		lblImg.setBounds(187, 0, 577, 320);
		panel.add(lblImg);
		lblRole.setVisible(false);
		lblImg.setIcon(this.img.ImageBgFpt());
		
		JLabel lblImgLeft = new JLabel("");
		lblImgLeft.setBounds(0, 0, 185, 530);
		panel.add(lblImgLeft);
		lblImgLeft.setIcon(this.img.ImageLeft());
		
		JLabel lblImgRight = new JLabel("");
		lblImgRight.setBounds(764, 0, 185, 530);
		panel.add(lblImgRight);
		lblImgRight.setIcon(this.img.ImageRigth());
		
		JLabel lblCenter = new JLabel("");
		lblCenter.setBounds(182, 321, 583, 209);
		panel.add(lblCenter);
		lblCenter.setIcon(this.img.ImageFpoly());
		
	}
	
	public void LogOut() {
		LoginUserView loginUserView = new LoginUserView();
		loginUserView.setVisible(true);
		loginUserView.setLocationRelativeTo(null);
		this.setVisible(false);
		
	}
	
	public void Exit() {
		System.exit(0);
	}
	
	public void ManagerStudent() {
		ManagerStudentView view = new ManagerStudentView();
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		view.getLblRole().setText(getLblRole().getText());
		if(lblRole.getText().equals("Admin")) {
			view.getBtnNew().setEnabled(true);
			view.getBtnDelete().setEnabled(true);
			view.getBtnUpdate().setEnabled(true);
		}else if(lblRole.getText().equals("User")) {
			view.getBtnNew().setEnabled(false);
			view.getBtnSave().setEnabled(false);
			view.getBtnDelete().setEnabled(false);
			view.getBtnUpdate().setEnabled(false);
		}
	}
	
	public void ManagerGrade() {
		GradeStudentView view = new GradeStudentView();
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		view.getLblRole().setText(getLblRole().getText());
		if(lblRole.getText().equals("Admin")) {
			view.getTextFieldEnglish().setEnabled(false);
			view.getTextFieldTechnology().setEnabled(false);
			view.getTextFieldPysical().setEnabled(false);
			view.getBtnNew().setEnabled(true);
		}else if(lblRole.getText().equals("User")) {
			view.getTextFieldEnglish().setEnabled(true);
			view.getTextFieldTechnology().setEnabled(true);
			view.getTextFieldPysical().setEnabled(true);
			view.getBtnNew().setEnabled(false);
		}
		
	}

	public JLabel getLblRole() {
		return lblRole;
	}

	public void setLblRole(JLabel lblRole) {
		this.lblRole = lblRole;
	}
}
