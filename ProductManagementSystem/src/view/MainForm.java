package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import interfaces.EventMenuSelected;
import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JPanel panelBody;
	private Menu panelMenu;

	private Menu menu;
	private Animator animator;



	public MainForm() {
		setUndecorated(true);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
		);
		
		JPanel panelNorth = new JPanel();
		
		panelMenu = new Menu();
		
		JPanel panelHeader = new JPanel();
		
		panelBody = new JPanel();
		panelBody.setOpaque(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panelNorth, GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBody, GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
						.addComponent(panelHeader, GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelBody, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
						.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)))
		);
		GroupLayout gl_panelBody = new GroupLayout(panelBody);
		gl_panelBody.setHorizontalGroup(
			gl_panelBody.createParallelGroup(Alignment.LEADING)
				.addGap(0, 929, Short.MAX_VALUE)
		);
		gl_panelBody.setVerticalGroup(
			gl_panelBody.createParallelGroup(Alignment.LEADING)
				.addGap(0, 533, Short.MAX_VALUE)
		);
		panelBody.setLayout(gl_panelBody);
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(MainForm.class.getResource("/icon/close.png")));
		btnExit.setOpaque(false);
		btnExit.setForeground(SystemColor.scrollbar);
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnExit.setFocusPainted(false);
		btnExit.setBorder(null);
		
		JButton btnMinimize = new JButton("");
		btnMinimize.setIcon(new ImageIcon(MainForm.class.getResource("/icon/minus.png")));
		btnMinimize.setOpaque(false);
		btnMinimize.setForeground(SystemColor.scrollbar);
		btnMinimize.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnMinimize.setFocusPainted(false);
		btnMinimize.setBorder(null);
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addContainerGap(1104, Short.MAX_VALUE)
					.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelNorth.setLayout(gl_panelNorth);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		pack();
		init();
	}
	public void init() {
		
		
		panelMenu.addEvent(new EventMenuSelected() {
			
			@Override
			public void menuSelected(int menuIndex, int subMenuIndex) {
				
				
			}
		});
		
		panelMenu.initMenuItem();
		
		

	
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainForm frame = new MainForm();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
