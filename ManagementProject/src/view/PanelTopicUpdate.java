package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import img.img;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Cursor;

public class PanelTopicUpdate extends JPanel {
	private JTextField txtTuition;
	private JTextField txtNameTopic;
	private JTextField txtCodeTopic;
	private JTextArea textAreaDescriber;
	private JTextField textField;
	private img img = new img();
	public PanelTopicUpdate() {
		setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(93, 58, 196));
		
		JLabel lbldescribe = new JLabel("Mô tả chuyên đề\r\n");
		lbldescribe.setBounds(494, 82, 126, 22);
		lbldescribe.setForeground(SystemColor.menu);
		lbldescribe.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel lblTime = new JLabel("Thời lượng:");
		lblTime.setBounds(494, 8, 96, 22);
		lblTime.setForeground(SystemColor.menu);
		lblTime.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel lblCodeTopic = new JLabel("Mã chuyên đề:\r\n");
		lblCodeTopic.setBounds(20, 8, 140, 22);
		lblCodeTopic.setForeground(SystemColor.menu);
		lblCodeTopic.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel lblTnChuyn = new JLabel("Tên chuyên đề:");
		lblTnChuyn.setBounds(20, 82, 109, 22);
		lblTnChuyn.setForeground(SystemColor.menu);
		lblTnChuyn.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel lblTuition = new JLabel("Học phí:");
		lblTuition.setBounds(20, 156, 58, 22);
		lblTuition.setForeground(SystemColor.menu);
		lblTuition.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel lblHnhLogo = new JLabel("Hình logo:");
		lblHnhLogo.setBounds(20, 410, 72, 22);
		lblHnhLogo.setForeground(SystemColor.menu);
		lblHnhLogo.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		txtTuition = new JTextField();
		txtTuition.setBounds(53, 176, 357, 28);
		txtTuition.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtTuition.setColumns(10);
		
		txtNameTopic = new JTextField();
		txtNameTopic.setBounds(53, 104, 357, 28);
		txtNameTopic.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtNameTopic.setColumns(10);
		
		txtCodeTopic = new JTextField();
		txtCodeTopic.setBounds(53, 31, 357, 28);
		txtCodeTopic.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtCodeTopic.setColumns(10);
		
		textAreaDescriber = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(textAreaDescriber);
		scrollPane.setBounds(546, 106, 357, 56);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(-10008, -10054, 0, 0);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBackground(SystemColor.menu);
		
		JButton btnFirst = new JButton("", img.iconFisrt());
		btnFirst.setForeground(SystemColor.menu);
		btnFirst.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnFirst.setBorder(null);
		btnFirst.setBackground(new Color(60, 22, 173));
		
		JButton btnPrev = new JButton("", img.iconPrev1());
		btnPrev.setForeground(SystemColor.menu);
		btnPrev.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnPrev.setBorder(null);
		btnPrev.setBackground(new Color(60, 22, 173));
		
		JButton btnNext = new JButton("", img.iconNext1());
		btnNext.setForeground(SystemColor.menu);
		btnNext.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNext.setBorder(null);
		btnNext.setBackground(new Color(60, 22, 173));
		
		JButton btnLast = new JButton("", img.iconLast());
		btnLast.setForeground(SystemColor.menu);
		btnLast.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnLast.setBorder(null);
		btnLast.setBackground(new Color(60, 22, 173));
		
		JButton btnNew = new JButton("New");
		btnNew.setForeground(SystemColor.menu);
		btnNew.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNew.setBorder(null);
		btnNew.setBackground(new Color(60, 22, 173));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(SystemColor.menu);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(60, 22, 173));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(SystemColor.menu);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(60, 22, 173));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(SystemColor.menu);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(60, 22, 173));
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 900, Short.MAX_VALUE)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(158)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))))
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 103, Short.MAX_VALUE)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		layeredPane.setLayout(gl_layeredPane);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 913, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		panel.add(scrollPane);
		panel.add(txtTuition);
		panel.add(txtNameTopic);
		panel.add(txtCodeTopic);
		panel.add(lblHnhLogo);
		panel.add(lbldescribe);
		panel.add(lblCodeTopic);
		panel.add(lblTnChuyn);
		panel.add(lblTuition);
		panel.add(lblTime);
		panel.add(lblLogo);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(546, 31, 357, 28);
		panel.add(textField);
		
		JLabel lblImg = new JLabel("Hình:\r\n\r\n");
		lblImg.setForeground(SystemColor.menu);
		lblImg.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblImg.setBounds(494, 184, 49, 22);
		panel.add(lblImg);
		
		JPanel panelImg = new JPanel();
		panelImg.setLayout(null);
		panelImg.setBounds(546, 190, 130, 162);
		panel.add(panelImg);
		
		JLabel lblimg = new JLabel("");
		lblimg.setIcon(img.ImageWhite());
		lblimg.setBounds(0, 0, 130, 162);
		panelImg.add(lblimg);
		
		
		
	
		setLayout(groupLayout);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new Color(93,58,196));
		g2.fillRect(0, 20, getSize().width, getSize().height - 20);
		
		g2.fillRect(45, 1, 142, 19);
		
		super.paintComponent(g);
	}
}
