package components;

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

import inteface.ChatEvent;
import net.miginfocom.swing.MigLayout;

public class PanelChat extends JPanel {
	private MigLayout layout;
	private JPanel header;
    private JPanel body;
    private JPanel bottom;
    private JScrollPane scrollBody;
    private JLabel labelTitle;


    private Button floatingButton;
    private JLayeredPane layeredPane;
    private MigLayout layoutLayered;
	private TextField textMessage;

	private List<ChatEvent> events = new ArrayList<>();

	public PanelChat() {
		setOpaque(false);
	
		layout = new MigLayout("fill, wrap, inset 0", "[fill]", "[fill,40!][fill,100%][shrink 0,::30%]");
		
		header = createHeader();
		
		body = createBody();
		
		bottom = createButton();

        setLayout(layout); 
		add(header);

		add(bottom);
	

	}
	
	public JPanel createHeader() {
		RoundPanel panel = new RoundPanel();
		panel.setLayout(new MigLayout("fill, inset 2"));
		panel.setBackground(new Color(255,255,255,20));
		labelTitle = new JLabel();
		labelTitle.setFont(labelTitle.getFont().deriveFont(14f));
		labelTitle.setBorder(new EmptyBorder(2, 10, 2, 2));
		labelTitle.setForeground(new Color(240,240,240));
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
    

	
    private JPanel createButton(){
        RoundPanel panel = new RoundPanel();
        panel.setBackground(new Color(255, 255, 255, 20));
        panel.setLayout(new MigLayout("fill, inset 2", "[fill, 34!]2[fill]2[fill, 34!]", "[bottom]"));
       
        
        Button cmdFile = new Button();
        Button cmdSend = new Button();
        
        
        cmdFile.setFocusable(false);
        cmdSend.setFocusable(false);

        textMessage = new TextField();
        textMessage.setHint("Aa");
        
        textMessage.setFont(new Font("SanSerif",Font.PLAIN,13));
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

    
    
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		GradientPaint gra = new GradientPaint(0, 0, new Color(58,72,85), getWidth(), 0, new Color(28,38,50));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
