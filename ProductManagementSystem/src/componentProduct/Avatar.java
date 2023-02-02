package componentProduct;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.lang.Math;

public class Avatar extends JComponent {

	private Icon image;
	private int borderSize = 0;
	private int borderSpace = 0;

	public Avatar() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (image != null) {
			int width = getWidth();
			int height = getHeight();

			int diameter = Math.min(width, height) - (borderSize * 2 + borderSpace * 2);
			int x = (width - diameter) / 2;
			int y = (height - diameter) / 2;
			Rectangle size = getAutoSize(image, diameter);
			BufferedImage img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2Img = img.createGraphics();
			g2Img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2Img.fillRoundRect(0, 0, diameter, diameter,15,15);
			Composite composite = g2Img.getComposite();
			g2Img.setComposite(AlphaComposite.SrcIn);
			g2Img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2Img.drawImage(toImage(image), size.x, size.y, size.width, size.height, null);
			g2Img.setComposite(composite);
			g2.drawImage(img, x, y, null);
		}
		g2.dispose();
		super.paintComponent(g);
	}

	private Image toImage(Icon icon) {
		return ((ImageIcon) icon).getImage();
	}


	public Rectangle getAutoSize(Icon image, int size) {
		int w = size;
		int h = size;
		int iw = image.getIconWidth();
		int ih = image.getIconHeight();
		double xScale = (double) w / iw;
		double yScale = (double) w / ih;
		double scale = Math.max(xScale, yScale);
		int width = (int) (scale * iw);
		int height = (int) (scale * ih);
		if (width < 1) {
			width = 1;
		}
		if (height < 1) {
			height = 1;
		}

		int cw = size;
		int ch = size;
		int x = (cw - width) / 2;
		int y = (ch - height) / 2;
		return new Rectangle(new Point(x, y), new Dimension(width, height));

	}

	public Icon getImage() {
		return image;
	}

	public void setImage(Icon image) {
		this.image = image;
		repaint();
	}

	public int getBorderSize() {
		return borderSize;
	}

	public void setBorderSize(int borderSize) {
		this.borderSize = borderSize;
		repaint();
	}

	public int getBorderSpace() {
		return borderSpace;
	}

	public void setBorderSpace(int borderSpace) {
		this.borderSpace = borderSpace;
		repaint();
	}

}
