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

public class Menu extends JPanel{
	img img = new img(this);

	public Menu() {
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
		
		
		Object[] items = new Object[]{"Home","Manager Student","Manager Grade","Exit","Welcome","Data Table","Setting","Logout"};
		
		
		g2D.drawString("Application", 60, 40);
		g2D.drawImage(this.img.ImageLogo(), 5, 5, null);
		
		g2D.setFont(new Font("SanSerif",Font.PLAIN,15));
		
		g2D.drawImage(this.img.ImageSys(), 24, 73, null);
		g2D.drawString(items[0]+"", 60, 90);
		
		g2D.drawImage(this.img.ImageMana(), 25, 120, null); 
		g2D.drawString(items[1]+"", 60, 135);                 
		
		g2D.drawImage(this.img.ImageGradee(), 25, 165, null); 
		g2D.drawString(items[2]+"", 60, 180); 
		
		g2D.drawImage(this.img.ImageExit(), 23, 208, null); 
		g2D.drawString(items[3]+"", 60, 225);
		
		g2D.setFont(new Font("Segoe UI",Font.BOLD,17));
		
		g2D.drawString("More", 20, 300);
	
		g2D.setFont(new Font("SanSerif",Font.PLAIN,15));
		
		g2D.drawImage(this.img.ImageWel(), 24, 358, null); 
		g2D.drawString(items[4]+"", 60, 375);
		
		g2D.drawImage(this.img.ImageTable(), 25, 405, null); //
		g2D.drawString(items[5]+"", 60, 420);
		
		g2D.drawImage(this.img.ImageSetting(), 25, 450, null); 
		g2D.drawString(items[6]+"", 60, 465);
		
		g2D.drawImage(this.img.ImageLogout(), 25, 495, null); 
		g2D.drawString(items[7]+"", 60, 510);
		

		
		
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
				
				if(y>=78 && y<=89 && x>=60 && x<=108 || y >=122 && y <=134 && x>=60 && x<=174 
					|| y>=166 && y<=178 && x>=60 && x<=160  || y >=211 && y<=224  && x>=60 && x<=87 
					|| y>=361 && y<=373 && x>=60 && x<=123  || y >=407 && y<=423 && x>=60 && x<=130 
					|| y>=452 && y<=465 && x>=60 && x<=108  || y >=498 && y<=510 && x>=60 && x<=108 ) {
					jframe.setCursor(Cursor.HAND_CURSOR);
					
				}else {
					jframe.setCursor(Cursor.DEFAULT_CURSOR);
				}
				
			}
			
		});
	}
}
