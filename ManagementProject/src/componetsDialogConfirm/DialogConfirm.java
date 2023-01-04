package componetsDialogConfirm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import componentsEmployee.PanelEmployeeUpdate;

import java.awt.Cursor;

public class DialogConfirm extends JDialog{
	private JLabel lblTitle;
	private JLabel lblMessage;
	public JButton btnYes;
	private JButton btnNo;
	
	public int option = -1;
	

	public DialogConfirm(JFrame parent) {
		super(parent,false);
		
		init();
		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension(450, 200));
		
		
	}
	
	public void init() {
		setUndecorated(true);
		
		PanelConfirm panel = new PanelConfirm();
		panel.setBorder(new LineBorder(new Color(150, 150,150),4));
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		lblTitle = new JLabel("XÁC NHẬN");
		lblTitle.setForeground(new Color(200,200,200));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Noto Serif", Font.BOLD, 16));
		
		lblMessage = new JLabel("Bạn có chắc chắn muốn xóa không ?");
		lblMessage.setFont(new Font("Noto Serif", Font.PLAIN, 14));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(new Color(200,200,200));
		
		btnYes = new JButton("CÓ");
		btnYes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnYes.setOpaque(true);
		btnYes.setBorder(null);
		btnYes.setFont(new Font("Noto Serif", Font.BOLD, 18));
		btnYes.setForeground(new Color(200,200,200));
		btnYes.setBackground(new Color(70,70,70));
		btnYes.setFocusPainted(false);
		
		btnNo = new JButton("KHÔNG");
		btnNo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNo.setForeground(SystemColor.scrollbar);
		btnNo.setFont(new Font("Noto Serif", Font.BOLD, 18));
		btnNo.setFocusPainted(false);
		btnNo.setBorder(null);
		btnNo.setForeground(new Color(200,200,200));
		btnNo.setBackground(new Color(70, 70, 70));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
				.addComponent(lblMessage, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(112)
					.addComponent(btnYes, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(120, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnYes, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		pack();
		action();
	}
	
	public void action() {
		
		btnYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnYes.setBackground(new Color(100,100,100));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnYes.setBackground(new Color(70,70,70));
			}
		});
		
		btnNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNo.setBackground(new Color(100,100,100));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnNo.setBackground(new Color(70,70,70));
			}
		});
		
		btnYes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				option = 1;
				setVisible(false);
			}
		});
	
		
		btnNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				option = 0;
				setVisible(false);
			}
		});
	}
	
	

	

	
	
}
