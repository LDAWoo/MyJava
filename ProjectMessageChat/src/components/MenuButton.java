package components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MenuButton extends JButton{
	private int index;
	private Animator animator;
	private int targetSize;
	private float animatSize;
	private Point pressedPoint;
	private float alpha;
	private Color effectColor = new Color(255, 255, 255,150);
	
	
	public MenuButton(Icon icon) {
		setIcon(icon);
		init();
		setBorder(new EmptyBorder(1, 20, 1, 1));
	}

	public MenuButton(String text) {
		super(text);
		init();
		setBorder(null);
	}
	
	public int getIndex() {
		return index;
	}
	
	private void init() {
		setContentAreaFilled(false);
		setForeground(Color.white);
		setHorizontalAlignment(JButton.LEFT);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				targetSize = Math.max(getWidth(), getHeight()) * 2; // width 250 heigth 730
				animatSize = 0;
				pressedPoint = e.getPoint();
				alpha = 0.5f;
				if(animator.isRunning()) {
					animator.stop();
				}
				animator.start();
			}
		});
		TimingTarget target = new TimingTargetAdapter() {
			
			@Override
			public void timingEvent(float fraction) {
				if(fraction >0.5f) {
					alpha = 1 - fraction;
				}
				animatSize = fraction * targetSize;
				repaint();
				
			}
		};
		animator = new Animator(500, target);
		animator.setResolution(0);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (pressedPoint != null) {
            g2.setColor(effectColor);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2.fillOval((int) (pressedPoint.x - animatSize / 2), (int) (pressedPoint.y - animatSize / 2), (int) animatSize, (int) animatSize);
        }
        g2.setComposite(AlphaComposite.SrcOver);
        super.paintComponent(g);
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
	
}

