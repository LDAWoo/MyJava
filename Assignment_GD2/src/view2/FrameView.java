package view2;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import img.img;
import view.LoginUserView;

import java.awt.geom.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
public class FrameView extends JFrame implements Runnable{
	Menu menu;
	Menu2 menu2;
	PanelGrade panelGrade;
	PanelStudent panelStudent;
	FormHome home;
	PanelTableStudent student;
	PanelTableManager manager;
	img img = new img(this);
	FPTHome FPThome;
	
	LoginUserView login;
	private JPanel jPanel;
	private JLabel lblUser;
	private JLabel lblRole;
	private JLabel lblTimer;
	
	
	public FrameView(String role) {
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setUndecorated(true);
		this.setForeground(new Color(0, 0, 128));
		this.setBackground(SystemColor.window);
		this.setPreferredSize(new Dimension(1200,730));
		getContentPane().setLayout(null);	

		menu = new Menu();
		menu.setOpaque(false);
		menu.setBounds(0, 0, 215, 730);
		getContentPane().add(menu);
		menu.setLayout(null);
		
		menu2 = new Menu2();
		menu2.setOpaque(false);
		menu2.setBounds(0, 0, 215, 730);
		getContentPane().add(menu2);
		menu2.setVisible(false);
		
		panelGrade = new PanelGrade(role);
		panelGrade.setBounds(215,55, 984, 668);
		getContentPane().add(panelGrade);
		
		panelStudent = new PanelStudent(role);
		panelStudent.setBounds(215, 55, 984, 668);
		getContentPane().add(panelStudent);
		panelStudent.setVisible(false);
		
		manager = new PanelTableManager(role);
		manager.setBounds(235, 276, 929, 447);
		getContentPane().add(manager);
		manager.setVisible(false);
		
		JLabel Exit = new JLabel("X");
		Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Exit.setForeground(SystemColor.scrollbar);
		Exit.setHorizontalAlignment(SwingConstants.CENTER);
		Exit.setFont(new Font("Segoe UI", Font.BOLD, 22));
		
		Exit.setBounds(1170, 0, 30, 30);
		getContentPane().add(Exit);
		
		
		home = new FormHome();
		home.setSize(920, 200);
		home.setLocation(244, 60);
		getContentPane().add(home);
		
		FPThome = new FPTHome();
		FPThome.setSize(920, 430);
		FPThome.setLocation(243, 290);
		getContentPane().add(FPThome);
		
		lblRole = new JLabel();
		lblRole.setForeground(Color.RED);
		lblRole.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblRole.setBounds(298, 30, 248, 23);
		getContentPane().add(lblRole);
		
		student = new PanelTableStudent(role);
		student.setBounds(235, 276, 929, 447);
		getContentPane().add(student);
		student.setVisible(false);
		
		JLabel lblUser1 = new JLabel("User:");
		lblUser1.setForeground(SystemColor.controlShadow);
		lblUser1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblUser1.setBounds(245, 5, 43, 21);
		getContentPane().add(lblUser1);
		
		JLabel lblRole1 = new JLabel("Role:");
		lblRole1.setForeground(SystemColor.controlShadow);
		lblRole1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblRole1.setBounds(245, 30, 43, 21);
		getContentPane().add(lblRole1);
		
		lblUser = new JLabel("");
		lblUser.setForeground(SystemColor.textHighlight);
		lblUser.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblUser.setBounds(298, 5, 248, 23);
		getContentPane().add(lblUser);
		
		JLabel lblClockTime = new JLabel("");
		lblClockTime.setBounds(1038, 8, 48, 40);
		getContentPane().add(lblClockTime);
		lblClockTime.setIcon(this.img.IconClockTime());
		
		lblTimer = new JLabel("");
		lblTimer.setForeground(SystemColor.controlShadow);
		lblTimer.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTimer.setBounds(1092, 14, 68, 30);
		getContentPane().add(lblTimer);
		
		menu.initMoving(this);
		menu2.initMoving(this);
		
		Move();
		Move2();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		Thread t1 = new Thread(this);
		t1.start();
	}

	@Override
	public void run() {
		while(true) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		lblTimer.setText(sdf.format(now));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	
	
	int x ;
	int y;
	
	
	public void Move() {
	menu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			
			public void mouseClicked(MouseEvent e) {
				if(y>=166 && y<=178 && x>=60 && x<=160) {
					panelGrade.setVisible(true);
					panelStudent.setVisible(false);
					FPThome.setVisible(false);
					home.setVisible(false);
					manager.setVisible(false);
					student.setVisible(false);
				}
				
				if(y >=122 && y <=134 && x>=60 && x<=174) {
					panelGrade.setVisible(false);
					FPThome.setVisible(false);
					home.setVisible(false);
					manager.setVisible(false);
					student.setVisible(false);
					panelStudent.setVisible(true);
				}
				
				if(y>=78 && y<=89 && x>=60 && x<=108) {	
					panelStudent.setVisible(false);
					FPThome.setVisible(false);
					panelGrade.setVisible(false);
					manager.setVisible(false);
					student.setVisible(false);
					FPThome.setVisible(true);
					home.setVisible(true);
					
				}
				if(y >=407 && y<=423 && x>=60 && x<=130) {
					menu.setVisible(false);
					panelGrade.setVisible(false);
					panelStudent.setVisible(false);
					FPThome.setVisible(false);
					menu2.setVisible(true);
					home.setVisible(true);
				}
				
				if(y >=498 && y<=510 && x>=60 && x<=108) {
					login = new LoginUserView();
					login.setVisible(true);
					login.setLocationRelativeTo(null);
					dispose();
				}
				
				if(y >=211 && y<=224 && x>=60 && x<=87) {
					System.exit(0);
				}	
			}
		});
	}
	
	public void Move2() {
		menu2.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				
				public void mouseClicked(MouseEvent e) {
					
					if(y>=75 && y<=92 && x>=25 && x<=45) {
						menu2.setVisible(false);
						FPThome.setVisible(true);
						menu.setVisible(true);
					}
					
					if(y>=166 && y<=178 && x>=60 && x<=160) {
						manager.setVisible(false);
						FPThome.setVisible(false);
						student.setVisible(true);
					}
					
					if(y >=122 && y <=134 && x>=60 && x<=174 ) {
						student.setVisible(false);
						FPThome.setVisible(false);
						manager.setVisible(true);
					}
				}
				
				
			});
		}
	public JLabel getLblUser() {
		return lblUser;
	}

	public void setLblUser(JLabel lblUser) {
		this.lblUser = lblUser;
	}

	public JLabel getLblRole() {
		return lblRole;
	}

	public void setLblRole(JLabel lblRole) {
		this.lblRole = lblRole;
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new FrameView("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
