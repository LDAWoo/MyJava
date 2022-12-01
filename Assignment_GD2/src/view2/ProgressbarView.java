package view2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class ProgressbarView extends JFrame implements Runnable{

	CardProgress card;
	private JProgressBar progressBar;
	private JLabel lblPleasewait;
	String User;
	String Role;
	public ProgressbarView(String User,String Role) {
		this.User = User;
		this.Role = Role;
		
		this.setBackground(SystemColor.window);
		this.setUndecorated(true);
		this.setForeground(new Color(0, 0, 128));
		this.setBackground(SystemColor.window);
		this.setPreferredSize(new Dimension(900,500));
		this.getContentPane().setLayout(null);	
		
		card = new CardProgress();
		card.setBounds(0, 0, 900, 500);
		this.getContentPane().add(card);
		
		lblPleasewait = new JLabel("Please Wait");
		lblPleasewait.setForeground(Color.WHITE);
		lblPleasewait.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblPleasewait.setBounds(42, 383, 152, 22);
		card.add(lblPleasewait);
		
		progressBar = new JProgressBar();
		progressBar.setBorder(new LineBorder(SystemColor.window, 3));
		progressBar.setForeground(SystemColor.scrollbar);
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(42, 454, 820, 35);
		card.add(progressBar);
		
		
		progressBar.setFont(new Font("SansSerif", Font.BOLD, 18));
		progressBar.setStringPainted(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		
		Thread t1 = new Thread(this);
		t1.start();
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			try {
				Thread.sleep(20);
				if(i%2==0) {
					lblPleasewait.setText("Please Wait..");
				}else {
					lblPleasewait.setText("Please Wait...");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			progressBar.setValue(i + 1);
		}
		
		FrameView view = new FrameView(this.Role);
		view.setVisible(true);
		view.getLblUser().setText(this.User);
		view.getLblRole().setText(this.Role);
		dispose();	
	}

	public static void main(String[] args) {
		new ProgressbarView("","");
	
	}
}
