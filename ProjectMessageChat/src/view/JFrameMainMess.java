package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import componentchat.ChatBox;
import componentchat.PanelChat;
import components.ButtonChatHeader;
import components.MessengerButtonUser;
import components.PanelChatMessenger;
import components.PanelMenu;
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

		bottomChat = new PanelChat();

		panel.add(Menu, "cell 0 0 1 2,, width 64!");
		panel.add(panelMessenger, "cell 1 0 1 2,width 380!");
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
				panelMessenger.getSearch().setBackground(new Color(200, 200, 200));
				panelMessenger.getSearch().setForeground(new Color(255, 255, 255));
				panelMessenger.getBody().setBackground(new Color(0, 0, 0));
				bottomChat.getHeader().setBackground(new Color(0, 0, 0));
				bottomChat.setOpaque(true);
				bottomChat.setBackground(new Color(0, 0, 0));
				bottomChat.getTextMessage().setBackground(new Color(200,200,200));
				bottomChat.getBody().setOpaque(true);
				bottomChat.getBody().setBackground(new Color(0, 0, 0));
				bottomChat.getBottom().setBackground(new Color(0, 0, 0));

			}
		});

		Menu.addActionButtonBlue(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Menu.setOpaque(true);
				Menu.setBackground(new Color(0, 150, 255));
				panelMessenger.setOpaque(true);
				panelMessenger.setBackground(Color.decode("#0072ff"));
				panelMessenger.getSearch().setBackground(new Color(255, 255, 255));
				panelMessenger.getSearch().setForeground(new Color(0, 0, 0));
				panelMessenger.getBody().setBackground(Color.decode("#0072ff"));
				bottomChat.setOpaque(true);
				bottomChat.setBackground(new Color(255, 255, 255));
				bottomChat.getHeader().setBackground(new Color(0, 150, 255));
				bottomChat.getBody().setOpaque(true);
				bottomChat.getBody().setBackground(new Color(255, 255, 255));
				bottomChat.getBottom().setBackground(new Color(240, 242, 245));

			}
		});
		
		panelMessenger.addActionBtnPerson1(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bottomChat.getHeader().removeAll();
				String name = panelMessenger.getName1(); 
				Icon icon = panelMessenger.getIcon1();
				String Status = "Đang hoạt động";
				ButtonChatHeader btnUser1 = new ButtonChatHeader();	
				btnUser1.add(new MessengerButtonUser(new ModelMessage(icon, name, Status)));			
				ButtonChatHeader btnPhone = new ButtonChatHeader();
				ButtonChatHeader btnVideo = new ButtonChatHeader();
				ButtonChatHeader btnAlertCircle = new ButtonChatHeader();
				btnPhone.setIcon(img.iconPhone());
				btnVideo.setIcon(img.iconVideo());
				btnAlertCircle.setIcon(img.iconAlert());

				bottomChat.getHeader().add(btnUser1,"h 70!");
				bottomChat.getHeader().add(btnPhone,"skip,h 40!, w 40! , split");
				bottomChat.getHeader().add(btnVideo,"h 40!, w 40!");
				bottomChat.getHeader().add(btnAlertCircle,"h 40!, w 40!");
	
				bottomChat.getHeader().repaint();
				bottomChat.getHeader().revalidate();
				
				
			}
		});
		
		panelMessenger.addActionBtnPerson1(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bottomChat.getHeader().removeAll();
				String name = panelMessenger.getName1(); 
				Icon icon = panelMessenger.getIcon1();
				String Status = "Đang hoạt động";
				ButtonChatHeader btnUser1 = new ButtonChatHeader();	
				btnUser1.add(new MessengerButtonUser(new ModelMessage(icon, name, Status)));			
				ButtonChatHeader btnPhone = new ButtonChatHeader();
				ButtonChatHeader btnVideo = new ButtonChatHeader();
				ButtonChatHeader btnAlertCircle = new ButtonChatHeader();
				btnPhone.setIcon(img.iconPhone());
				btnVideo.setIcon(img.iconVideo());
				btnAlertCircle.setIcon(img.iconAlert());

				bottomChat.getHeader().add(btnUser1,"h 70!");
				bottomChat.getHeader().add(btnPhone,"skip,h 40!, w 40! , split");
				bottomChat.getHeader().add(btnVideo,"h 40!, w 40!");
				bottomChat.getHeader().add(btnAlertCircle,"h 40!, w 40!");
	
				bottomChat.getHeader().repaint();
				bottomChat.getHeader().revalidate();
				
				
			}
		});
		
		panelMessenger.addActionBtnPerson2(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bottomChat.getHeader().removeAll();
				String name = panelMessenger.getName2(); 
				Icon icon = panelMessenger.getIcon2();
				String Status = "Hoạt động 2 giờ trước";
				ButtonChatHeader btnUser2 = new ButtonChatHeader();	
				btnUser2.add(new MessengerButtonUser(new ModelMessage(icon, name, Status)));			
				ButtonChatHeader btnPhone = new ButtonChatHeader();
				ButtonChatHeader btnVideo = new ButtonChatHeader();
				ButtonChatHeader btnAlertCircle = new ButtonChatHeader();
				btnPhone.setIcon(img.iconPhone());
				btnVideo.setIcon(img.iconVideo());
				btnAlertCircle.setIcon(img.iconAlert());

				bottomChat.getHeader().add(btnUser2,"h 70!");
				bottomChat.getHeader().add(btnPhone,"skip,h 40!, w 40! , split");
				bottomChat.getHeader().add(btnVideo,"h 40!, w 40!");
				bottomChat.getHeader().add(btnAlertCircle,"h 40!, w 40!");
	
				bottomChat.getHeader().repaint();
				bottomChat.getHeader().revalidate();
				
				
			}
		});
		
		panelMessenger.addActionBtnPerson3(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bottomChat.getHeader().removeAll();
				String name = panelMessenger.getName3(); 
				Icon icon = panelMessenger.getIcon3();
				String Status = "Đang hoạt động";
				ButtonChatHeader btnUser3 = new ButtonChatHeader();	
				btnUser3.add(new MessengerButtonUser(new ModelMessage(icon, name, Status)));			
				ButtonChatHeader btnPhone = new ButtonChatHeader();
				ButtonChatHeader btnVideo = new ButtonChatHeader();
				ButtonChatHeader btnAlertCircle = new ButtonChatHeader();
				btnPhone.setIcon(img.iconPhone());
				btnVideo.setIcon(img.iconVideo());
				btnAlertCircle.setIcon(img.iconAlert());

				bottomChat.getHeader().add(btnUser3,"h 70!");
				bottomChat.getHeader().add(btnPhone,"skip,h 40!, w 40! , split");
				bottomChat.getHeader().add(btnVideo,"h 40!, w 40!");
				bottomChat.getHeader().add(btnAlertCircle,"h 40!, w 40!");
	
				bottomChat.getHeader().repaint();
				bottomChat.getHeader().revalidate();
				
				
			}
		});
		
		
		panelMessenger.addActionBtnPerson4(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bottomChat.getHeader().removeAll();
				String name = panelMessenger.getName4(); 
				Icon icon = panelMessenger.getIcon4();
				String Status = "Hoạt động 24 giờ trước";
				ButtonChatHeader btnUser4 = new ButtonChatHeader();	
				btnUser4.add(new MessengerButtonUser(new ModelMessage(icon, name, Status)));			
				ButtonChatHeader btnPhone = new ButtonChatHeader();
				ButtonChatHeader btnVideo = new ButtonChatHeader();
				ButtonChatHeader btnAlertCircle = new ButtonChatHeader();
				btnPhone.setIcon(img.iconPhone());
				btnVideo.setIcon(img.iconVideo());
				btnAlertCircle.setIcon(img.iconAlert());

				bottomChat.getHeader().add(btnUser4,"h 70!");
				bottomChat.getHeader().add(btnPhone,"skip,h 40!, w 40! , split");
				bottomChat.getHeader().add(btnVideo,"h 40!, w 40!");
				bottomChat.getHeader().add(btnAlertCircle,"h 40!, w 40!");
	
				bottomChat.getHeader().repaint();
				bottomChat.getHeader().revalidate();
				
				
			}
		});
		
		
		panelMessenger.addActionBtnPerson5(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bottomChat.getHeader().removeAll();
				String name = panelMessenger.getName5(); 
				Icon icon = panelMessenger.getIcon5();
				String Status = "Đang hoạt động";
				ButtonChatHeader btnUser5 = new ButtonChatHeader();	
				btnUser5.add(new MessengerButtonUser(new ModelMessage(icon, name, Status)));			
				ButtonChatHeader btnPhone = new ButtonChatHeader();
				ButtonChatHeader btnVideo = new ButtonChatHeader();
				ButtonChatHeader btnAlertCircle = new ButtonChatHeader();
				btnPhone.setIcon(img.iconPhone());
				btnVideo.setIcon(img.iconVideo());
				btnAlertCircle.setIcon(img.iconAlert());

				bottomChat.getHeader().add(btnUser5,"h 70!");
				bottomChat.getHeader().add(btnPhone,"skip,h 40!, w 40! , split");
				bottomChat.getHeader().add(btnVideo,"h 40!, w 40!");
				bottomChat.getHeader().add(btnAlertCircle,"h 40!, w 40!");
	
				bottomChat.getHeader().repaint();
				bottomChat.getHeader().revalidate();
				
				
			}
		});
		
		
		panelMessenger.addActionBtnPerson6(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bottomChat.getHeader().removeAll();
				String name = panelMessenger.getName6(); 
				Icon icon = panelMessenger.getIcon6();
				String Status = "Đang hoạt động";
				ButtonChatHeader btnUser6 = new ButtonChatHeader();	
				btnUser6.add(new MessengerButtonUser(new ModelMessage(icon, name, Status)));			
				ButtonChatHeader btnPhone = new ButtonChatHeader();
				ButtonChatHeader btnVideo = new ButtonChatHeader();
				ButtonChatHeader btnAlertCircle = new ButtonChatHeader();
				btnPhone.setIcon(img.iconPhone());
				btnVideo.setIcon(img.iconVideo());
				btnAlertCircle.setIcon(img.iconAlert());

				bottomChat.getHeader().add(btnUser6,"h 70!");
				bottomChat.getHeader().add(btnPhone,"skip,h 40!, w 40! , split");
				bottomChat.getHeader().add(btnVideo,"h 40!, w 40!");
				bottomChat.getHeader().add(btnAlertCircle,"h 40!, w 40!");
	
				bottomChat.getHeader().repaint();
				bottomChat.getHeader().revalidate();
				
				
			}
		});
		
		panelMessenger.addActionBtnPerson7(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bottomChat.getHeader().removeAll();
				String name = panelMessenger.getName7(); 
				Icon icon = panelMessenger.getIcon7();
				String Status = "Hoạt động 1 ngày trước";
				ButtonChatHeader btnUser7 = new ButtonChatHeader();	
				btnUser7.add(new MessengerButtonUser(new ModelMessage(icon, name, Status)));			
				ButtonChatHeader btnPhone = new ButtonChatHeader();
				ButtonChatHeader btnVideo = new ButtonChatHeader();
				ButtonChatHeader btnAlertCircle = new ButtonChatHeader();
				btnPhone.setIcon(img.iconPhone());
				btnVideo.setIcon(img.iconVideo());
				btnAlertCircle.setIcon(img.iconAlert());

				bottomChat.getHeader().add(btnUser7,"h 70!");
				bottomChat.getHeader().add(btnPhone,"skip,h 40!, w 40! , split");
				bottomChat.getHeader().add(btnVideo,"h 40!, w 40!");
				bottomChat.getHeader().add(btnAlertCircle,"h 40!, w 40!");
	
				bottomChat.getHeader().repaint();
				bottomChat.getHeader().revalidate();
				
				
			}
		});
		
		panelMessenger.addActionBtnPerson8(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bottomChat.getHeader().removeAll();
				String name = panelMessenger.getName8(); 
				Icon icon = panelMessenger.getIcon8();
				String Status = "Hoạt động 1 giờ trước";
				ButtonChatHeader btnUser8 = new ButtonChatHeader();	
				btnUser8.add(new MessengerButtonUser(new ModelMessage(icon, name, Status)));			
				ButtonChatHeader btnPhone = new ButtonChatHeader();
				ButtonChatHeader btnVideo = new ButtonChatHeader();
				ButtonChatHeader btnAlertCircle = new ButtonChatHeader();
				btnPhone.setIcon(img.iconPhone());
				btnVideo.setIcon(img.iconVideo());
				btnAlertCircle.setIcon(img.iconAlert());

				bottomChat.getHeader().add(btnUser8,"h 70!");
				bottomChat.getHeader().add(btnPhone,"skip,h 40!, w 40! , split");
				bottomChat.getHeader().add(btnVideo,"h 40!, w 40!");
				bottomChat.getHeader().add(btnAlertCircle,"h 40!, w 40!");
	
				bottomChat.getHeader().repaint();
				bottomChat.getHeader().revalidate();
				
				
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
				Send();		
				if (message.equals("")) {
					return;
				}
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
