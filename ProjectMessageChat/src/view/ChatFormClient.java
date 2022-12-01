package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import componentsClient.*;

import imgClient.*;
import intefaceClient.*;
import modelClient.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatFormClient extends JFrame implements Runnable{
	private JPanel panel;
	private PanelChat chatArea;
	private img img = new img();
	
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	private Socket socket;
	
	public ChatFormClient() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Start();
			}
		});

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
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy, hh:mmaa");
	String message;
	public void init() {
		chatArea.setTitle("Client Chat");
		chatArea.addChatEvent(new ChatEvent() {
			

			@Override
			public void mousePressedSendButton(ActionEvent event) {
				String date = sdf.format(new Date());
				String name = "You";
				message = chatArea.getText().trim();
				Send();
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

	public void Start() {
		try {
			socket = new Socket("localhost", 7676);
			Thread t1 = new Thread(ChatFormClient.this);
			t1.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Send() {
		try {
			outputStream = new DataOutputStream(socket.getOutputStream());
			outputStream.writeUTF(message);
			outputStream.flush();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			inputStream = new DataInputStream(socket.getInputStream());
			while(true) {
				if(socket !=null) {
					String date = sdf.format(new Date());
					String name = "Server";
					String message = inputStream.readUTF();
					chatArea.addChatBox(new ModelMessage(img.iconSend(), name, date, message), ChatBox.BoxType.LEFT);
				}
			}
			
		}catch(Exception e) {
			
		}
		
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			ChatFormClient chat = new ChatFormClient();
			chat.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
