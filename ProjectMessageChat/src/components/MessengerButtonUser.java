package components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import components.ImageAvatar;

import img.img;
import model.ModelMessage;
import net.miginfocom.swing.MigLayout;

public class MessengerButtonUser extends JComponent {
	private img img = new img();
	private final ModelMessage message;
	private JTextPane text;
	private Animator animator;
	private float animatSize;
	private Point pressedPoint;
	private float alpha;
	private int round;
	private int targetSize;
	private Color effectColor = new Color(255, 255, 255);
	private boolean paintBackground;
	


	public MessengerButtonUser(ModelMessage message) {
        this.message = message;
        init();
    }
	
	public void init() {
		initBox();
	}
	
	public void initBox() {
		String rightToLeft = "";
        setLayout(new MigLayout("inset 5" + rightToLeft, "[40!]5[]", "[center]"));
        ImageAvatar avatar = new ImageAvatar();
        avatar.setBorderSize(1);
        avatar.setBorderSpace(1);
        avatar.setImage(message.getIcon());
        
        text = new JTextPane();
        text.setFont(new Font("SanSerif",Font.PLAIN,15));
        Font font = new Font("Sanserif",Font.BOLD,15);
        JLabel name = new JLabel(); 
        name.setText(message.getName());
        name.setFont(font);
        
        text.setText(name.getText()+ "\n"+ message.getStatus());
        text.setBackground(new Color(0, 0, 0, 0));
       
        text.setSelectionColor(new Color(200, 200, 200, 100));
        text.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        text.setOpaque(false);
        text.setEditable(false);
        
       
        JLabel lblImg = new JLabel();
        lblImg.setIcon(img.iconImg());
        add(avatar, "height 40, width 40");
       
        add(text, "wrap");
        
        Action();
	}

	public void Action() {
		text.setCursor(new Cursor(Cursor.HAND_CURSOR));
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e)) {
					targetSize = Math.max(getWidth(), getHeight()) * 2;
					animatSize = 0;
					pressedPoint = e.getPoint();
					alpha = 0.5f;
					if(animator.isRunning()) {
						animator.stop();
					}
					animator.start();
				}
			}
			
		});
		TimingTarget target = new TimingTargetAdapter() {
			
			@Override
			public void timingEvent(float fraction) {
				if(fraction > 0.5f) {
					alpha = 1 - fraction;
				}
				animatSize = fraction * targetSize;
				repaint();
				
			}
		};
		animator = new Animator(500,target);
		animator.setResolution(0);
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
		int height = getHeight();

		GradientPaint gra = new GradientPaint(0, 0, Color.decode("#0072ff"), width, 0, Color.decode("#0072ff"));
		text.setForeground(new Color(255, 255, 255));
		g2.setPaint(gra);

		if(paintBackground) {
			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		}
		if(pressedPoint !=null) {
			Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 0, 0));
			g2.setColor(effectColor);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
			area.intersect(new Area(new Ellipse2D.Double((pressedPoint.x - animatSize / 2), (pressedPoint.y - animatSize  / 2), animatSize, animatSize)));
			g2.fill(area);
		}
		
		g2.dispose();
		super.paintComponent(g);
	}

}
