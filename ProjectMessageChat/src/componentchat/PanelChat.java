package componentchat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import img.*;
import inteface.*;
import model.*;
import net.miginfocom.swing.MigLayout;

import components.*;


public class PanelChat extends JPanel {
	private MigLayout layout;
	private JPanel header;
	private JPanel body;
	private JPanel bottom;
	private JScrollPane scrollBody;
	private JLabel labelTitle;
	private img img = new img();

	private Button floatingButton;
	private JLayeredPane layeredPane;
	private MigLayout layoutLayered;
	private TextField textMessage;

	private AnimationFloatingButton animationFloatingButton;
	private AnimationScroll animationScroll;

	private List<ChatEvent> events = new ArrayList<>();

	public PanelChat() {
		setOpaque(false);

		layout = new MigLayout("fill, wrap, inset 0", "[fill]", "[fill,80!][fill,100%][shrink 0,::30%]");

		header = createHeader();
		
		body = createBody();

		bottom = createBottom();
		
		layeredPane = createLayeredPane();
		
		scrollBody = new JScrollPane();
		scrollBody.setBorder(null);
		scrollBody.setViewportView(body);
		scrollBody.setVerticalScrollBar(new ScrollBarMessenger());
		scrollBody.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBody.getViewport().setOpaque(false);
		
		scrollBody.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			private int oldValues;

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int value = scrollBody.getVerticalScrollBar().getValue();
				int extent = scrollBody.getVerticalScrollBar().getModel().getExtent();

				if ((value + extent) >= scrollBody.getVerticalScrollBar().getMaximum() - 300) {
					animationFloatingButton.hide();

				} else if (oldValues <= e.getValue()) {

					if (!animationScroll.isRunning()) {
						animationFloatingButton.show();
					}
				}
			}
		});

		floatingButton = createFloatingButton();
		layeredPane.setLayer(floatingButton, JLayeredPane.POPUP_LAYER);
		layeredPane.add(floatingButton, "pos 100%-50 100%,h 40,w 40");
		layeredPane.add(scrollBody);

		add(header);
		setLayout(layout);
		add(layeredPane);
		add(bottom);
		initAnimator();
	}

	private void initAnimator() {
		animationScroll = new AnimationScroll(body);
		animationFloatingButton = new AnimationFloatingButton(layoutLayered, floatingButton);
	}

	public Button createFloatingButton() {
		Button button = new Button();
		button.setBorder(null);
		button.setIcon(img.iconArrow());
		button.setRound(40);
		button.setBackground(new Color(242,242,242));
		button.setPaintBackground(true);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				animationScroll.scrollVertical(scrollBody, scrollBody.getVerticalScrollBar().getMaximum());

			}
		});
		return button;
	}

	public void addChatEvent(ChatEvent event) {
		events.add(event);
	}

	public void addChatBox(ModelMessage message, ChatBox.BoxType type) {

		int values = scrollBody.getVerticalScrollBar().getValue();
        if (type == ChatBox.BoxType.LEFT) {
            body.add(new ChatBox(type, message), "width ::80%");
        } else {
            body.add(new ChatBox(type, message), "al right,width ::80%");
        }
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				body.revalidate();
				scrollBody.getVerticalScrollBar().setValue(values);
				bottom.revalidate();
			}
		});
		body.repaint();
		body.revalidate();
		scrollBody.revalidate();
		scrollToBottom();
	}

	private void scrollToBottom() {
		animationScroll.scrollVertical(scrollBody, scrollBody.getVerticalScrollBar().getMaximum());
	}

	public JPanel createHeader() {
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(0,150,255));

		panelHeader.setLayout(new MigLayout("fill","0[]0[]0[right]"));
		
		String name = "Vũ Lee"; 
		Icon icon = img.iconFaceWhite();
		String Status = "Đang hoạt động";
		
		ButtonChatHeader btnUser2 = new ButtonChatHeader();	
		btnUser2.add(new MessengerButtonUser(new ModelMessage(icon, name, Status)));			
		ButtonChatHeader btnPhone = new ButtonChatHeader();
		ButtonChatHeader btnVideo = new ButtonChatHeader();
		ButtonChatHeader btnAlertCircle = new ButtonChatHeader();
		btnPhone.setIcon(img.iconPhone());
		btnVideo.setIcon(img.iconVideo());
		btnAlertCircle.setIcon(img.iconAlert());

		panelHeader.add(btnUser2,"h 70!");
		panelHeader.add(btnPhone,"skip,h 40!, w 40! , split");
		panelHeader.add(btnVideo,"h 40!, w 40!");
		panelHeader.add(btnAlertCircle,"h 40!, w 40!");
		
		return panelHeader;
	}
	
	
	private JPanel createBody() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(new MigLayout("wrap,fillx"));
		return panel;
	}

	private JScrollPane createScroll() {
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(null);
		scroll.setViewportBorder(null);
		return scroll;
	}

	private JPanel createBottom() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240,242,245));
		panel.setLayout(new MigLayout("fill, inset 2", "[fill]", "[bottom]"));
		
		Button cmdPlus = new Button();
		Button cmdImg = new Button();
		Button cmdSticker = new Button();
		Button cmdGif = new Button();
		Button cmdSend = new Button();
		
		
		cmdPlus.setIcon(img.iconPlus());
		cmdImg.setIcon(img.iconImg());
		cmdSticker.setIcon(img.iconSticker());
		cmdGif.setIcon(img.iconGif());
		
		cmdSend.setIcon(img.iconHeart());

		cmdImg.setFocusable(false);
		cmdSend.setFocusable(false);

		textMessage = new TextField();
		textMessage.setHint("Aa");

		textMessage.setFont(new Font("SanSerif", Font.PLAIN, 13));
		
		textMessage.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if(!textMessage.getText().trim().equals("")) {
					cmdSend.setIcon(img.iconSend());
				}else {
					cmdSend.setIcon(img.iconHeart());
				}
				
			}
		});
		
		textMessage.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				revalidate();
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

		});

		cmdSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				runEventMousePressedSendButton(e);

			}
		});

		JScrollPane scroll = createScroll();
		scroll.setViewportView(textMessage);
		scroll.getViewport().setOpaque(false);
		scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		scroll.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		
		panel.add(cmdPlus,"h 34");
		panel.add(cmdImg,"h 34");
		panel.add(cmdSticker,"h 34");
		panel.add(cmdGif,"h 34");
		panel.add(scroll,"skip,w 100%");
		panel.add(cmdSend, "height 34!");

		return panel;
	}

	public JPanel getHeader() {
		return header;
	}

	public void setHeader(JPanel header) {
		this.header = header;
	}

	public JPanel getBody() {
		return body;
	}

	public void setBody(JPanel body) {
		this.body = body;
	}

	public JPanel getBottom() {
		return bottom;
	}

	public void setBottom(JPanel bottom) {
		this.bottom = bottom;
	}
	
	public TextField getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(TextField textMessage) {
		this.textMessage = textMessage;
	}

	public void runEventMousePressedSendButton(ActionEvent evt) {
		for (ChatEvent event : events) {
			event.mousePressedSendButton(evt);
		}
	}

	public String getText() {
		return textMessage.getText();
	}

	public void setTitle(String title) {
		labelTitle.setText(title);
	}

	public String getTitle() {
		return labelTitle.getText();
	}

	public void setText(String text) {
		textMessage.setText(text);
	}

	public void textGrabFocus() {
		textMessage.grabFocus();
	}

	public void clearTextAndGrabFocus() {
		textMessage.setText("");
		textMessage.grabFocus();
	}

	private JLayeredPane createLayeredPane() {
		JLayeredPane layer = new JLayeredPane();
		layoutLayered = new MigLayout("fill,inset 0", "[fill]", "[fill]");
		layer.setLayout(layoutLayered);
		return layer;
	}

}
