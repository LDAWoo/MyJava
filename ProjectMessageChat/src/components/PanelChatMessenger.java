package components;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import componentchat.ChatBox;
import img.img;
import model.ModelMessage;
import net.miginfocom.swing.MigLayout;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class PanelChatMessenger extends JPanel {
	private MigLayout layout;
	private MigLayout layoutMain;

	private JPanel panel;
	private JPanel header;
	private JPanel body;
	private JPanel bottom;

	private JPanel panelFind;

	private JScrollPane scrollPaneBody;

	private img img = new img();
	private TextFieldSearch search;

	private TextFieldSearch textMessage;
	private ButtonChatHeader cmdMess;
	private ButtonChatHeader cmdMessBook;
	private ButtonChatHeader cmdUser;
	private ButtonChatHeader cmdVideo;

	private boolean selected;
	private boolean over;

	private ArrayList<Component> button = new ArrayList<Component>();

	private ButtonChatHeader btnOption;
	private JPanel panelBody;
	private ButtonChatHeader btnVideoEdit;
	private ButtonChatHeader btnPerson1;
	private ButtonChatHeader btnPerson2;
	private ButtonChatHeader btnPerson3;
	private ButtonChatHeader btnPerson4;
	private ButtonChatHeader btnPerson5;
	private ButtonChatHeader btnPerson6;
	private ButtonChatHeader btnPerson7;
	private ButtonChatHeader btnPerson8;

	public PanelChatMessenger() {
		setOpaque(false);
		setBackground(Color.WHITE);
		panel = new JPanel();
		panel.setOpaque(false);

		layoutMain = new MigLayout("fill");

		layout = new MigLayout("fill,wrap, inset 1", "[fill]", "[90!,fill][fill,100%][::60%,shrink 0]");

		panel.setLayout(layout);

		header = createHeader();

		body = createBody();

		bottom = createBottom();

		scrollPaneBody = new JScrollPane(body);
		scrollPaneBody.setOpaque(false);
		scrollPaneBody.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneBody.setBorder(null);

		scrollPaneBody.getViewport().setOpaque(false);
		scrollPaneBody.setVerticalScrollBar(new ScrollBarMessenger());
		scrollPaneBody.setViewportBorder(null);

		ScrollBarMessenger barCustom = new ScrollBarMessenger();
		barCustom.setOrientation(JScrollBar.HORIZONTAL);

		scrollPaneBody.setHorizontalScrollBar(barCustom);

		this.setLayout(layoutMain);

		panel.add(header);
		panel.add(scrollPaneBody, "push, grow");
		panel.add(bottom);

		add(panel, "push,grow");

	}

	public JPanel createHeader() {
		JPanel panelHeader = new JPanel();
		panelHeader.setOpaque(false);
		panelHeader.setLayout(new MigLayout("fill", "[315.00][][][]", "[][][]"));

		JLabel lblChat = new JLabel("Chat");
		lblChat.setForeground(Color.WHITE);
		lblChat.setFont(new Font("SansSerif", Font.BOLD, 30));

		JLabel lblIconFind = new JLabel("");
		lblIconFind.setBackground(Color.WHITE);
		lblIconFind.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconFind.setIcon(img.iconSearch());

		search = new TextFieldSearch();
		search.setFont(new Font("Sanserif", Font.PLAIN, 15));

		panelHeader.add(lblChat, "flowx,cell 0 0,grow");

		panelHeader.add(lblIconFind, "cell 0 1,width 40!");
		panelHeader.add(search, "cell 0 1,width 295!,height 35!");

		btnOption = new ButtonChatHeader();

		btnOption.setIcon(img.iconOption());

		panelHeader.add(btnOption, "cell 0 0,grow,h 40!, w 40!");

		btnVideoEdit = new ButtonChatHeader();
		btnVideoEdit.setIcon(img.iconVideoPlus());
		panelHeader.add(btnVideoEdit, "cell 0 0,grow, h 40!, w 40!");
		ButtonChatHeader btnNote = new ButtonChatHeader();
		btnNote.setIcon(img.iconNote());
		panelHeader.add(btnNote, "cell 0 0");

		return panelHeader;
	}

	public JPanel createBody() {
		panelBody = new JPanel();
		panelBody.setBackground(Color.decode("#0072ff"));
		panelBody.setBorder(null);
		panelBody.setLayout(new MigLayout("wrap, fillx"));

		return panelBody;
	}

	public JPanel createPanelFind() {
		panelFind = new JPanel();
		panelFind.setBackground(new Color(255, 255, 255));
		panelFind.setBorder(null);

		panelBody.setLayout(new MigLayout("wrap, fillx"));
		return panelBody;
	}

	public JPanel createBottom() {
		JPanel panelBottom = new JPanel();
		panelBottom.setOpaque(false);
		panelBottom.setLayout(new MigLayout("fill, inset 2", "[fill]", "[bottom]"));

		Font font = new Font("Sanserif", getFont().PLAIN, 15);
		Color color = new Color(255, 255, 255);

		cmdMess = new ButtonChatHeader();
		cmdMess.setText("Đoạn chat");
		cmdMess.setFont(font);
		cmdMess.setForeground(color);

		cmdVideo = new ButtonChatHeader();
		cmdVideo.setText("Cuộc gọi");
		cmdVideo.setFont(font);
		cmdVideo.setForeground(color);

		cmdUser = new ButtonChatHeader();
		cmdUser.setText("Danh bạ");
		cmdUser.setFont(font);
		cmdUser.setForeground(color);

		cmdMessBook = new ButtonChatHeader();
		cmdMessBook.setText("Tin");
		cmdMessBook.setFont(font);
		cmdMessBook.setForeground(color);

		cmdMess.setIcon(img.iconMessWhite());
		cmdVideo.setIcon(img.iconVideo());
		cmdUser.setIcon(img.iconUser());
		cmdMessBook.setIcon(img.iconMessageBook());

		panelBottom.add(cmdMess, "height 34!");

		panelBottom.add(cmdVideo, "height 34!");

		panelBottom.add(cmdUser, "height 34!");

		panelBottom.add(cmdMessBook, "height 34!");
		addChatbox();
		ActionButton();
		listMessenger();
		return panelBottom;
	}

	public void ActionButton() {
		cmdMess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listMessenger();
			}
		});

		btnVideoEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public void addOptionAction(ActionListener event) {
		btnOption.addActionListener(event);
	}

	public JPanel getBody() {
		return body;
	}

	public void setBody(JPanel body) {
		this.body = body;
	}

	String name1 = "Vũ Lee";
	String name2 = "Vy Thị Tĩnh";
	String name3 = "Lê.Đ.A.Tuấn";
	String name4 = "Nguyễn Anh Khôi";
	String name5 = "Tí Shop - Quần Áo Nam Cao Cấp";
	String name6 = "Babeee";
	String name7 = "7M MEN";
	String name8 = "Big Phone Quận 9";

	Icon icon1 = img.iconVulee();
	Icon icon2 = img.iconVythiTinh();
	Icon icon3 = img.iconLedatuan();
	Icon icon4 = img.iconKhoi();
	Icon icon5 = img.iconTiShop();
	Icon icon6 = img.iconFaceWhite();
	Icon icon7 = img.icon7Men();
	Icon icon8 = img.iconBigPhone();

	public void addChatbox() {
		btnPerson1 = new ButtonChatHeader();
		btnPerson2 = new ButtonChatHeader();
		btnPerson3 = new ButtonChatHeader();
		btnPerson4 = new ButtonChatHeader();
		btnPerson5 = new ButtonChatHeader();
		btnPerson6 = new ButtonChatHeader();
		btnPerson7 = new ButtonChatHeader();
		btnPerson8 = new ButtonChatHeader();

		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		String data = sdf.format(new Date());

		String message = "Xin chào bạn rất vui được gặp bạn!";
		btnPerson1.add(new ChatBoxMessenger(new ModelMessage(icon1, name1, data, message)));
		btnPerson2.add(new ChatBoxMessenger(new ModelMessage(icon2, name2, data, message)));
		btnPerson3.add(new ChatBoxMessenger(new ModelMessage(icon3, name3, data, message)));
		btnPerson4.add(new ChatBoxMessenger(new ModelMessage(icon4, name4, data, message)));
		btnPerson5.add(new ChatBoxMessenger(new ModelMessage(icon5, name5, data, message)));
		btnPerson6.add(new ChatBoxMessenger(new ModelMessage(icon6, name6, data, message)));
		btnPerson7.add(new ChatBoxMessenger(new ModelMessage(icon7, name7, data, message)));
		btnPerson8.add(new ChatBoxMessenger(new ModelMessage(icon8, name8, data, message)));

		button.add(btnPerson1);
		button.add(btnPerson2);
		button.add(btnPerson3);
		button.add(btnPerson4);
		button.add(btnPerson5);
		button.add(btnPerson6);
		button.add(btnPerson7);
		button.add(btnPerson8);

	}

	public void listMessenger() {
		for (Component component : button) {
			body.add(component, "wrap");
		}
		body.repaint();
		body.revalidate();
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public String getName5() {
		return name5;
	}

	public void setName5(String name5) {
		this.name5 = name5;
	}

	public String getName6() {
		return name6;
	}

	public void setName6(String name6) {
		this.name6 = name6;
	}

	public String getName7() {
		return name7;
	}

	public void setName7(String name7) {
		this.name7 = name7;
	}

	public String getName8() {
		return name8;
	}

	public void setName8(String name8) {
		this.name8 = name8;
	}

	public void setButton(ArrayList<Component> button) {
		this.button = button;
	}

	public void addActionBtnPerson1(ActionListener event) {
		btnPerson1.addActionListener(event);
	}

	public void addActionBtnPerson2(ActionListener event) {
		btnPerson2.addActionListener(event);
	}

	public void addActionBtnPerson3(ActionListener event) {
		btnPerson3.addActionListener(event);
	}

	public void addActionBtnPerson4(ActionListener event) {
		btnPerson4.addActionListener(event);
	}

	public void addActionBtnPerson5(ActionListener event) {
		btnPerson5.addActionListener(event);
	}

	public void addActionBtnPerson6(ActionListener event) {
		btnPerson6.addActionListener(event);
	}

	public void addActionBtnPerson7(ActionListener event) {
		btnPerson7.addActionListener(event);
	}

	public void addActionBtnPerson8(ActionListener event) {
		btnPerson8.addActionListener(event);
	}

	public Icon getIcon1() {
		return icon1;
	}

	public void setIcon1(Icon icon1) {
		this.icon1 = icon1;
	}

	public Icon getIcon2() {
		return icon2;
	}

	public void setIcon2(Icon icon2) {
		this.icon2 = icon2;
	}

	public Icon getIcon3() {
		return icon3;
	}

	public void setIcon3(Icon icon3) {
		this.icon3 = icon3;
	}

	public Icon getIcon4() {
		return icon4;
	}

	public void setIcon4(Icon icon4) {
		this.icon4 = icon4;
	}

	public Icon getIcon5() {
		return icon5;
	}

	public void setIcon5(Icon icon5) {
		this.icon5 = icon5;
	}

	public Icon getIcon6() {
		return icon6;
	}

	public void setIcon6(Icon icon6) {
		this.icon6 = icon6;
	}

	public Icon getIcon7() {
		return icon7;
	}

	public void setIcon7(Icon icon7) {
		this.icon7 = icon7;
	}

	public Icon getIcon8() {
		return icon8;
	}

	public void setIcon8(Icon icon8) {
		this.icon8 = icon8;
	}

	public ButtonChatHeader getBtnPerson1() {
		return btnPerson1;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		repaint();
	}

	public void setOver(boolean over) {
		this.over = over;
		repaint();
	}

	private JScrollPane createScroll() {
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(null);
		scroll.setViewportBorder(null);
		return scroll;
	}

	public TextFieldSearch getSearch() {
		return search;
	}

	public void setSearch(TextFieldSearch search) {
		this.search = search;
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
