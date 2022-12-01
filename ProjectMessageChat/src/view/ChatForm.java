package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import components.PanelChat;
import img.img;

import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;

public class ChatForm extends JFrame {
	private JPanel panel;
	private PanelChat chatArea;

	public ChatForm() {

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(450, 500));

		chatArea = new PanelChat();
		chatArea.setSize(getWidth(), getHeight());
			
		panel.setLayout(new MigLayout("fill"));

		
		panel.add(chatArea,"push, grow");
	
		getContentPane().add(panel);
		
		pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		init();
	}

	img img = new img();

	public void init() {
		chatArea.setTitle("Client Chat");
		

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			ChatForm chat = new ChatForm();
			chat.setVisible(true);
		} catch (Exception e) {
		}
	}
}
