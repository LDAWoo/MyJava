package componentsClient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import imgClient.*;
import intefaceClient.*;
import modelClient.*;
import net.miginfocom.swing.MigLayout;

import componentsClient.*;


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

		layout = new MigLayout("fill, wrap, inset 0", "[fill]", "[fill,40!][fill,100%][shrink 0,::30%]");

		header = createHeader();

		body = createBody();

		bottom = createButton();
		
		layeredPane = createLayeredPane();
		scrollBody = createScroll();

		scrollBody.setViewportView(body);
		scrollBody.setVerticalScrollBar(new JScrollBar());
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

		setLayout(layout);
		add(header);
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
		button.setIcon(img.iconSend());
		button.setRound(40);
		button.setBackground(new Color(100, 100, 100, 100));
		button.setBackground(new Color(255, 0, 0));
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
		RoundPanel panel = new RoundPanel();
		panel.setLayout(new MigLayout("fill, inset 2"));
		panel.setBackground(new Color(255, 255, 255, 20));
		labelTitle = new JLabel();
		labelTitle.setFont(labelTitle.getFont().deriveFont(14f));
		labelTitle.setBorder(new EmptyBorder(2, 10, 2, 2));
		labelTitle.setForeground(new Color(240, 240, 240));
		panel.add(labelTitle);
		return panel;
	}

	private JPanel createBody() {
		RoundPanel panel = new RoundPanel();
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setLayout(new MigLayout("wrap,fillx"));
		return panel;
	}

	private JScrollPane createScroll() {
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(null);
		scroll.setViewportBorder(null);
		return scroll;
	}

	private JPanel createButton() {
		RoundPanel panel = new RoundPanel();
		panel.setBackground(new Color(255, 255, 255, 20));
		panel.setLayout(new MigLayout("fill, inset 2", "[fill, 34!]2[fill]2[fill, 34!]", "[bottom]"));

		Button cmdFile = new Button();
		Button cmdSend = new Button();

		cmdFile.setIcon(img.iconImg());
		cmdSend.setIcon(img.iconSend());

		cmdFile.setFocusable(false);
		cmdSend.setFocusable(false);

		textMessage = new TextField();
		textMessage.setHint("Aa");

		textMessage.setFont(new Font("SanSerif", Font.PLAIN, 13));
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
		panel.add(cmdFile, "height 34!");
		panel.add(scroll);
		panel.add(cmdSend, "height 34!");

		return panel;
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

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint gra = new GradientPaint(0, 0, new Color(58, 72, 85), getWidth(), 0, new Color(28, 38, 50));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
