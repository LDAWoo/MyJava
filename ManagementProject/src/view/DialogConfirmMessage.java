package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class DialogConfirmMessage extends JDialog {
	private PanelConfirmMessage panel;
	private ButtonConfirm btnYes;
	private ButtonConfirm btnNo;
	public JLabel lblTextMessage;
	public int option = -1;
	public JLabel lblTitle;
	
	public DialogConfirmMessage(JFrame parent) {
		super(parent , false);
		init();
		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension(450, 240));
		
		
	}
	
	public void init() {
		setUndecorated(true);
		panel = new PanelConfirmMessage();
		panel.setBorder(new LineBorder(new Color(150, 150,150),4));
		
		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
					.addGap(44)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		lblTitle = new JLabel("THOÁT NGAY?");
		lblTitle.setBounds(2, 2, 401, 40);
		lblTitle.setFont(new Font("Noto Serif", Font.BOLD, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblTitle.setForeground(new Color(230,230,230));
		
		lblTextMessage = new JLabel("Bạn có chắc chắn muốn thoát không?");
		lblTextMessage.setBounds(2, 40, 401, 29);
		lblTextMessage.setFont(new Font("Noto Serif", Font.PLAIN, 13));
		lblTextMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMessage.setForeground(new Color(200,200,200));
		
		btnYes = new ButtonConfirm();
		btnYes.setBounds(117, 101, 66, 30);
		btnYes.setHorizontalAlignment(SwingConstants.CENTER);
		btnYes.setText("CÓ");
		btnYes.setBorder(new LineBorder(new Color(249, 182, 182),1));
		btnYes.setFont(new Font("Noto Serif", Font.BOLD, 15));
		btnYes.setOpaque(true);
		btnYes.setBackground(new Color(60,60,60));
		
		btnNo = new ButtonConfirm();
		btnNo.setBounds(185, 101, 89, 30);
		btnNo.setHorizontalAlignment(SwingConstants.CENTER);
		btnNo.setText("KHÔNG");
		btnNo.setBorder(new LineBorder(new Color(249, 182, 182),1));
		btnNo.setFont(new Font("Noto Serif", Font.BOLD, 15));
		btnNo.setOpaque(true);
		btnNo.setBackground(new Color(70,70,70));
		
		panel.setLayout(null);
		panel.add(lblTitle);
		panel.add(lblTextMessage);
		panel.add(btnYes);
		panel.add(btnNo);
		getContentPane().setLayout(layout);
		pack();
		action();
	}
	
	public void action() {
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
				setVisible(false);	
			}
		});
	}

}
