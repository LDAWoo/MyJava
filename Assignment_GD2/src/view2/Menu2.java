package view2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import img.img;




public class Menu2 extends JPanel{
	img img = new img(this);

	public Menu2() {
		this.setOpaque(false);
		setLayout(null);
		
	}
	
	public void paintChildren(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gp = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, 730, Color.decode("#000046"));
		g2D.setPaint(gp);
		g2D.fillRoundRect(0, 0,215, 730, 0, 0);
		
		g2D.setPaint(Color.WHITE);
		g2D.setFont(new Font("Segoe UI",Font.BOLD,18));
		
		
		Object[] items = new Object[]{"Data Student","Data Grade"};
		
		
		g2D.drawString("Application", 60, 40);
		g2D.drawImage(this.img.ImageLogo(), 5, 5, null);
		
		g2D.setFont(new Font("SanSerif",Font.PLAIN,15));
		
		g2D.drawImage(this.img.ImageArr(), 25, 75, null);

		
		g2D.drawImage(this.img.ImageStu(), 25, 120, null); 
		g2D.drawString(items[0]+"", 60, 135);                 
		
		g2D.drawImage(this.img.ImageGrade(), 25, 165, null); 
		g2D.drawString(items[1]+"", 60, 180); 
		
	}
	public int x;
	public int y;
	
	
	public void initMoving(JFrame jframe) {
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {	
			@Override
			public void mouseDragged(MouseEvent e) {
				jframe.setLocation(e.getXOnScreen()-x, e.getYOnScreen()-y);
				
			}
			
			@Override
			public void mouseMoved(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				
				if(y>=75 && y<=92 && x>=25 && x<=45 || y >=122 && y <=134 && x>=60 && x<=174 
					|| y>=166 && y<=178 && x>=60 && x<=160) {
					jframe.setCursor(Cursor.HAND_CURSOR);
					
				}else {
					jframe.setCursor(Cursor.DEFAULT_CURSOR);
				}
				
			}
			
		});
	}
}
