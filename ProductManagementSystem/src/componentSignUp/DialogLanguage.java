package componentSignUp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import componentButton.Button;
import javax.swing.border.LineBorder;

public class DialogLanguage extends JDialog {

	public static JButton btnEnglish;
	public static JButton btnVietnamese;
	
	public DialogLanguage(JFrame parent) {
		super(parent, false);
		
		setUndecorated(true);
		init();
		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension(450, 240));
	}

	public void init() {
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setOpaque(false);

		btnEnglish = new JButton("");
		btnEnglish.setFocusPainted(false);
		btnEnglish.setBorder(null);
		btnEnglish.setText("America - English");
		btnEnglish.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnEnglish.setBackground(new Color(230, 230, 230));
		btnEnglish.setBounds(1, 1, 230, 30);

		btnVietnamese = new JButton("");
		btnVietnamese.setFocusPainted(false);
		btnVietnamese.setBorder(null);
		btnVietnamese.setText("Việt Nam - Tiếng Việt");
		btnVietnamese.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnVietnamese.setBackground(new Color(230, 230, 230));
		btnVietnamese.setBounds(1, 33, 230, 30);
		panel.setLayout(null);
		panel.add(btnEnglish);
		panel.add(btnVietnamese);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);

		pack();
		actionButton();
	}

	public void actionButton() {
		btnEnglish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnglish.setBackground(new Color(0, 140, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEnglish.setBackground(new Color(230, 230, 230));		
			}
		});
				
		btnVietnamese.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVietnamese.setBackground(new Color(0, 140, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnVietnamese.setBackground(new Color(230, 230, 230));		
			}
		});
	}
	
	public void addActionButtonEnglish(ActionListener event) {
		btnEnglish.addActionListener(event);
	}
	
	public void addActionButtonVietnamese(ActionListener event) {
		btnVietnamese.addActionListener(event);
	}

}
