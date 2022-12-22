package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import components.Menu;
import components.MenuEvent;
import componentsCourse.Course;
import componentsEmployee.Employee;
import componentsLearner.Learner;
import componentsStudent.PanelTableStudents;
import componentsTopic.Topic;
import date.CurrendarCustom;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Main extends JFrame {
	private static javax.swing.JPanel body;
	private javax.swing.JPanel jPanelCenter;
	private components.Menu menu ;
	private LoginUserView login;
	private ForgotPasswordView forgot;
	
	public static String email;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Main frame = new Main("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Main(String email) {
		this.email = email;
		
		setUndecorated(true);
		getContentPane().setBackground(new Color(63, 109, 217));
		jPanelCenter = new JPanel();

		menu = new Menu();
		
		body = new JPanel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanelCenter.setBackground(new java.awt.Color(50, 50, 50));

		body.setOpaque(false);
		body.setLayout(new java.awt.BorderLayout());

		javax.swing.GroupLayout gl_jPanelCenter = new javax.swing.GroupLayout(jPanelCenter);
		jPanelCenter.setLayout(gl_jPanelCenter);
		gl_jPanelCenter
				.setHorizontalGroup(gl_jPanelCenter.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(gl_jPanelCenter.createSequentialGroup()
								.addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 210,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
								.addContainerGap()));
		gl_jPanelCenter.setVerticalGroup(gl_jPanelCenter.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_jPanelCenter.createSequentialGroup().addContainerGap()
						.addGroup(gl_jPanelCenter.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
								.addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(jPanelCenter,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(3, 3, 3)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(jPanelCenter,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(3, 3, 3)));

		pack();
		setLocationRelativeTo(null);

		MenuEvent event = new MenuEvent() {
			@Override
			public void menuSelected(int index) {
				if (index == 1) {
					showForm(new Employee());
				}

				if (index == 2) {
					showForm(new Learner());
				}

				if (index == 3) {
					showForm(new Topic());
				}	

				if (index == 4) {
					showForm(new Course());
				}

				if (index == 5) {
					
				}

				if (index == 6) {

				}

				if (index == 7) {
					showForm(new CurrendarCustom());
				}

				if (index == 8) {

				}

				if (index == 9) {

				}

				if (index == 10) {
					LoginForm();
				}
				
				if (index == 11) {
					
				}
				
				if (index == 12) {
					ForgotFassword();
				}
				
				if (index == 13) {
					Exit();
				}

			}
		};

		menu.initMenu(event);
	}
	
	public void LoginForm() {
		this.setVisible(false);
		login = new LoginUserView();
		login.setVisible(true);
		login.setLocationRelativeTo(null);

	}
	
	public void ForgotFassword() {
		this.setVisible(false);
		forgot = new ForgotPasswordView();
		forgot.setVisible(true);
		forgot.setLocationRelativeTo(null);
	}
	
	public void Exit() {
		int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Chắn Muốn Thoát Không :(","Exit",JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void showForm(Component com) {
		body.removeAll();
		body.add(com);
		body.revalidate();
		body.repaint();
	}

}
