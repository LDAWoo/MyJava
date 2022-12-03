package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import date.CurrendarCustom;
import event.EventMenuSelected;
import net.miginfocom.swing.MigLayout;

import interfaces.ShowPopup;

import java.awt.Color;
import java.awt.Component;

public class FrameView extends JFrame {

	private MigLayout layout;
	private Menu menu;
	private Header header;
	private MainForm main;
	private JPanel panel;
	private Animator animator;
	private LoginUserView login;
	private ForgotPasswordView forgot;
	
	public FrameView() {
//		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(SystemColor.window);
		getContentPane().setLayout(new BorderLayout());

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1200, 700));
		panel.setOpaque(false);

		getContentPane().add(panel);
		this.pack();
		this.setLocationRelativeTo(null);

		Init();
	}

	public void Init() {
		layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
		panel.setLayout(layout);

		menu = new Menu();

		header = new Header();
		
		
		main = new MainForm();

		menu.addEvent(new EventMenuSelected() {

			@Override
			public void menuSelected(int menuIndex, int subMenuIndex) {
				System.out.println("Menu index: "+menuIndex+"SudMenu Index: "+subMenuIndex);
				if(menuIndex==0) {
					if(subMenuIndex==-1) {
						main.showForm(new FormHome());
					}
				}else if(menuIndex==1) {
					if(subMenuIndex==0) {
						main.showForm(new Employee());
					}else if(subMenuIndex==1) {
						main.showForm(new Learner());
					}else if(subMenuIndex==2) {
						main.showForm(new Topic());
					}else if(subMenuIndex==3) {
						main.showForm(new Course());
					}
				}else if(menuIndex==2) {
					if(subMenuIndex==0) {
						main.showForm(new StudentTableScore());
					}
				}else if(menuIndex==3) {
					if(subMenuIndex==0) {
						main.showForm(new CurrendarCustom());
					}
				}else if(menuIndex==4) {
					
				}else if(menuIndex==5) {
					if(subMenuIndex==0) {
						LoginForm();
					}else if(subMenuIndex==1) {
						
					}else if(subMenuIndex==2) {
						ForgotFassword();
					}else if(subMenuIndex==3) {
						Exit();
					}
				}

			}
		});
		
		String distance = "                 ";
		
		menu.addShowPopup(new ShowPopup() {			
			@Override
			public void showPopup(Component com) {
				MenuItem item = (MenuItem) com;
				
				PopupMenu popupMenu = new PopupMenu(FrameView.this, item.getIndex(), item.getEventMenuSelected(),item.getMenu().getSudMenu());
				int x = FrameView.this.getX() + 52;
				int y = FrameView.this.getY() + com.getY() + 126;
				
				popupMenu.setLocation(x, y);
				popupMenu.setVisible(true);
			}
		});		
		menu.initMenuItem();
		panel.add(menu, "w 230!, spany 2");
		panel.add(header, "h 50!, wrap");
		panel.add(main, "w 100%, h 100%");
			
		TimingTarget target = new TimingTargetAdapter() {
			@Override
			public void timingEvent(float fraction) {
				double width;
				if (menu.isShowMenu()) {
					width = 62 + (170 * (1f - fraction));
				} else {
					width = 62 + (170 * fraction);
				}
				layout.setComponentConstraints(menu, "w " +width + "!, spany 2");
				menu.revalidate();
			}

			@Override
			public void end() {
				menu.setShowMenu(!menu.isShowMenu());
				menu.setEnableMenu(true);
			}
		};
		animator = new Animator(500, target);
		animator.setResolution(0);
		animator.setDeceleration(0.5f);
		animator.setAcceleration(0.5f);
		
		header.AddMenuEvent(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!animator.isRunning()) {
					animator.start();
				}
				menu.setEnableMenu(false);
				if(menu.isShowMenu()) {
					menu.hideallMenu();
				}
				
			}
		});		
		main.showForm(new FormHome());
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
		System.exit(0);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			FrameView frame = new FrameView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
