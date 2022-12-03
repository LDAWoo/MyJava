package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.EmptyBorder;

import componentchat.ChatBox;
import componentchat.PanelChat;
import components.OptionMenu;
import components.PanelChatMessenger;
import components.PanelMenu;
import components.PanelMessengerHeader;
import img.img;
import inteface.ChatEvent;
import model.ModelMessage;
import net.miginfocom.swing.MigLayout;

public class JFrameMainMess extends JFrame implements Runnable {

	private JPanel panel;
	private MigLayout layout;
	private img img = new img();
	private PanelMenu Menu;
	private PanelChatMessenger panelMessenger;
	private PanelMessengerHeader header;

	private PanelChat bottomChat;

	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	private Socket socket;

	public JFrameMainMess() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
//				Start();
			}
		});

		panel = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(SystemColor.window);
		getContentPane().setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(1300, 600));
		panel.setOpaque(false);
		getContentPane().add(panel);
		pack();

		setLocationRelativeTo(null);
		init();
	}

	public void init() {

		layout = new MigLayout("fill, inset 0", "[]0[]0[fill][]", "[top,fill]0[] ");
		panel.setLayout(layout);

		Menu = new PanelMenu();

		panelMessenger = new PanelChatMessenger();

		header = new PanelMessengerHeader();

		bottomChat = new PanelChat();

		panel.add(Menu, "cell 0 0 1 2,, width 64!");
		panel.add(panelMessenger, "cell 1 0 1 2,width 380!");
		panel.add(header, "cell 2 0,height 70!,w 100%");
		panel.add(bottomChat, "cell 2 1,width 100%,height 100%");

		initData();
		initAction();
	}

	public void initAction() {
		Menu.addActionButtonDark(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Menu.setOpaque(true);
				Menu.setBackground(new Color(0, 0, 0));
				panelMessenger.setOpaque(true);
				panelMessenger.setBackground(new Color(0, 0, 0));
				panelMessenger.getSearch().setBackground(new Color(127,127,127));
				panelMessenger.getSearch().setForeground(new Color(255,255,255));
				panelMessenger.getBody().setBackground(new Color(0,0,0));
				header.setOpaque(true);
				header.setBackground(new Color(0,0,0));
				bottomChat.getBody().setOpaque(true);
				bottomChat.getBody().setBackground(new Color(0,0,0));
				bottomChat.getBottom().setBackground(new Color(0,0,0));
		
	
			}
		});
		
		Menu.addActionButtonBlue(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu.setOpaque(true);
				Menu.setBackground(new Color(0, 150, 255));
				panelMessenger.setOpaque(true);
				panelMessenger.setBackground(Color.decode("#0072ff"));
				panelMessenger.getSearch().setBackground(new Color(255,255,255));
				panelMessenger.getSearch().setForeground(new Color(0,0,0));
				panelMessenger.getBody().setBackground(Color.decode("#0072ff"));
				header.setOpaque(true);
				header.setBackground(new Color(0,150,255));
				bottomChat.getBody().setOpaque(true);
				bottomChat.getBody().setBackground(new Color(255,255,255));
				bottomChat.getBottom().setBackground(new Color(240,242,245));
				
			}
		});

	}

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy, hh:mmaa");
	private String message;
	private ServerSocket serverSocket;

	public void initData() {
		bottomChat.addChatEvent(new ChatEvent() {

			@Override
			public void mousePressedSendButton(ActionEvent event) {
				String date = sdf.format(new Date());
				String name = "You";
				message = bottomChat.getText().trim();
//				Send();
				bottomChat.addChatBox(new ModelMessage(img.iconMess(), name, date, message), ChatBox.BoxType.RIGHT);
				bottomChat.clearTextAndGrabFocus();

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
			Thread t1 = new Thread(JFrameMainMess.this);
			t1.start();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		try {
			inputStream = new DataInputStream(socket.getInputStream());
			while (true) {
				if (socket != null) {
					String date = sdf.format(new Date());
					String name = "Client";
					String message = inputStream.readUTF();
					bottomChat.addChatBox(new ModelMessage(img.iconFace(), name, date, message), ChatBox.BoxType.LEFT);
				}
				Thread.sleep(1000);
			}

		} catch (Exception e) {
		}
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
			JFrameMainMess frame = new JFrameMainMess();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
