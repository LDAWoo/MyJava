package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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

public class ChatForm extends JFrame implements Runnable{
	private JPanel panel;
	private PanelChat chatArea;
	private img img = new img();
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	private Socket socket;

	public ChatForm() {
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
	private String message;
	private ServerSocket serverSocket;
	public void init() {
		chatArea.setTitle("Server Chat");
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
			serverSocket = new ServerSocket(7676);
			socket = serverSocket.accept();
			Thread t1 = new Thread(ChatForm.this);
			t1.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		try {
			inputStream = new DataInputStream(socket.getInputStream());
		while(true) {
			if(socket !=null) {
				String date = sdf.format(new Date());
				String name = "Client";
				String message = inputStream.readUTF();
				chatArea.addChatBox(new ModelMessage(img.iconSend(), name, date, message), ChatBox.BoxType.LEFT);
			}
			Thread.sleep(1000);
		}
		
		}catch(Exception e) {}
	}
	
	
	public void Send() {
		try {
			outputStream = new DataOutputStream(socket.getOutputStream());
			outputStream.writeUTF(message);
			outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
