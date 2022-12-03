package components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class ButtonChatHeader extends JButton{
	private Animator animator;
	private float animatSize;
	private Point pressedPoint;
	private float alpha;
	private int round;
	private int targetSize;
	private Color effectColor = new Color(255, 255, 255);
	private boolean paintBackground;
	
	public boolean isPaintBackground() {
        return paintBackground;
    }

    public void setPaintBackground(boolean paintBackground) {
        this.paintBackground = paintBackground;
        repaint();
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    public Color getEffectColor() {
        return effectColor;
    }

    public void setEffectColor(Color effectColor) {
        this.effectColor = effectColor;
        repaint();
    }
	
	
	public ButtonChatHeader() {
		init();
	}
	
	public void init() {
		setContentAreaFilled(false);
		setBorder(new EmptyBorder(5,5,5,5));
		setBackground(null);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
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
		
		if(paintBackground) {
			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth(), getHeight(), round, round);
		}
		if(pressedPoint !=null) {
			Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), round, round));
			g2.setColor(effectColor);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
			area.intersect(new Area(new Ellipse2D.Double((pressedPoint.x - animatSize / 2), (pressedPoint.y - animatSize  / 2), animatSize, animatSize)));
			g2.fill(area);
		}
		g2.dispose();
		super.paintComponent(g);
	}
}
