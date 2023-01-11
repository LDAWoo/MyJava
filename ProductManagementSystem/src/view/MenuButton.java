package view;

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

public class MenuButton extends JButton {
	private int index;
	private Animator animator;
	private int targetSize;
	private float animatSize;
	private Point pressedPoint;
	private float alpha;
	private Color effectColor = new Color(26, 29, 31,255);

	private Color color = new Color(200, 200, 200);

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public MenuButton(Icon icon, String text) {
		super(text);
		setIcon(icon);
		init();
		setBorder(new EmptyBorder(1, 20, 1, 1));
	}

	public MenuButton(String text) {
		super(text);
		init();
		setBorder(null);
	}

	public MenuButton(String text, boolean subMenu) {
		super(text);
		init();
	}

	public void init() {
		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setForeground(color);
		setFont(new Font("Roboto", Font.PLAIN, 15));
		setHorizontalAlignment(JButton.LEFT);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				effectColor = new Color(70,70,70);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				effectColor = new Color(26, 29, 31);
			}

		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(effectColor);

		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

}
