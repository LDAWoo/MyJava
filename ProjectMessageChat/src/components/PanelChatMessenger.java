package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import img.img;
import net.miginfocom.swing.MigLayout;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelChatMessenger extends JPanel {
	private MigLayout layout;
	private MigLayout layoutMain;
	
	private JPanel panel;
	private JPanel header;
	private JPanel body;
	private JPanel bottom;
	
	private JScrollPane scrollPaneBody;
	
	private img img = new img();
	private TextFieldSearch search;
	private MainFormChat main;
	public PanelChatMessenger() {
		setOpaque(false);
		panel = new JPanel();
		panel.setOpaque(false);
		
		layoutMain = new MigLayout("fill");
		
		layout = new MigLayout("fill,wrap, inset 1", "[fill]", "[90!,fill][fill,100%][::60%,shrink 0]");
		
		panel.setLayout(layout);
		
		header = createHeader();

		body = createBody();
		
		bottom = createBottom();
		
		scrollPaneBody = new JScrollPane();
		scrollPaneBody.getViewport().setOpaque(false);
		scrollPaneBody.setViewportView(body);
		scrollPaneBody.setVerticalScrollBar(new ScrollBarMessenger());
		
		scrollPaneBody.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		
		this.setLayout(layoutMain);
		
		panel.add(header);
		panel.add(scrollPaneBody,"push, grow");
		panel.add(bottom);
		
		add(panel,"push,grow");
	}

	public JPanel createHeader() {
		JPanel panelHeader = new JPanel();
		panelHeader.setOpaque(false);
		panelHeader.setLayout(new MigLayout("fill, inset 2"));

		JLabel lblChat = new JLabel("Chat");
		lblChat.setForeground(Color.WHITE);
		lblChat.setFont(new Font("SansSerif", Font.BOLD, 30));

		JLabel lblIconFind = new JLabel("");
		lblIconFind.setBackground(Color.WHITE);
		lblIconFind.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconFind.setIcon(img.iconSearch());

		search = new TextFieldSearch();

		panelHeader.add(lblChat, "wrap");
		panelHeader.add(lblIconFind, "w 40!, split 2");
		panelHeader.add(search, "w 270!, h 35!, wrap");
		
		return panelHeader;
	}
	
	public JPanel createBody() {
		RoundPanelMessenger panelBody = new RoundPanelMessenger();
		panelBody.setLayout(new MigLayout("wrap, fillx"));
		
		
		return panelBody;
	}
	

	TextFieldSearch textMessage;
	
	public JPanel createBottom() {
		JPanel panelBottom= new JPanel();
		panelBottom.setOpaque(false);
		panelBottom.setLayout(new MigLayout("fill, inset 2", "[fill, 34!]2[fill]2[fill, 34!]", "[top]"));
		
		ButtonChatHeader cmdFile = new ButtonChatHeader();
		ButtonChatHeader cmdSend = new ButtonChatHeader();

		cmdFile.setIcon(img.iconImg());
		cmdSend.setIcon(img.iconSend());

		cmdFile.setFocusable(false);
		cmdSend.setFocusable(false);

		textMessage = new TextFieldSearch();

		textMessage.setFont(new Font("SanSerif", Font.PLAIN, 13));
		
		JScrollPane scroll = createScroll();
		scroll.setViewportView(textMessage);
		scroll.getViewport().setOpaque(false);
		scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		scroll.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		panelBottom.add(cmdFile, "height 34!");
		panelBottom.add(scroll);
		panelBottom.add(cmdSend, "height 34!");
		
		return panelBottom;
	}
	

	private JScrollPane createScroll() {
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(null);
		scroll.setViewportBorder(null);
		return scroll;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, Color.decode("#0072ff"), 250, 0, Color.decode("#0072ff"));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);

	}
}
