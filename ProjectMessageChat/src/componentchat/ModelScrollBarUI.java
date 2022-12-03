package componentchat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;


public class ModelScrollBarUI extends BasicScrollBarUI {

	private int THUMB_SIZE = 100;

	@Override
	protected Dimension getMaximumThumbSize() {
		if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			return new Dimension(0, THUMB_SIZE);
		} else {
			return new Dimension(THUMB_SIZE, 0);
		}
	}

	@Override
	protected Dimension getMinimumThumbSize() {
		if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			return new Dimension(0, THUMB_SIZE);
		} else {
			return new Dimension(THUMB_SIZE, 0);
		}
	}

	@Override
	protected JButton createIncreaseButton(int i) {
		return new ScrollBarButton();
	}

	@Override
	protected JButton createDecreaseButton(int i) {
		return new ScrollBarButton();
	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle rectangle) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = rectangle.x;
		int y = rectangle.y;
		int width = rectangle.width;
		int height = rectangle.height;
		if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			y += 8;
			height -= 16;

		} else {
			x += 8;
			width -= 16;
		}
		g2.setColor(scrollbar.getForeground());
		g2.fillRoundRect(x, y, width, height, 5, 5);
	}

	private class ScrollBarButton extends JButton {

		public ScrollBarButton() {
			setBorder(BorderFactory.createEmptyBorder());
		}

		@Override
		public void paint(Graphics grphcs) {
		}
	}
}
