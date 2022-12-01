package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import components.ChatBox;
import components.PanelChat;
import img.img;
import inteface.ChatEvent;
import model.ModelMessage;
import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;

public class ChatForm extends JFrame {
	private JPanel panel;
	private PanelChat chatArea;
	private img img = new img();

	public ChatForm() {

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(450, 500));

		chatArea = new PanelChat();
		chatArea.setSize(getWidth(), getHeight());

		panel.setLayout(new MigLayout("fill"));

		panel.add(chatArea, "push, grow");

		getContentPane().add(panel);

		pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		init();
	}

	public void init() {
		chatArea.setTitle("Client Chat");
		chatArea.addChatEvent(new ChatEvent() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy, hh:mmaa");

			@Override
			public void mousePressedSendButton(ActionEvent event) {
				String date = sdf.format(new Date());
				String name = "You";
				String message = chatArea.getText().trim();
				
				chatArea.addChatBox(new ModelMessage(img.iconSend(), name, date, message), ChatBox.BoxType.RIGHT);
				
				chatArea.clearTextAndGrabFocus();
			}

			@Override
			public void mousePressedFileButton(ActionEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent event) {
				// TODO Auto-generated method stub

			}
		});

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			ChatForm chat = new ChatForm();
			chat.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
