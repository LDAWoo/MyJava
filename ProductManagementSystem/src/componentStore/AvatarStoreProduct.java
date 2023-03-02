package componentStore;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import color.ColorBackground;
import componentProduct.ButtonProductList;
import componentProduct.IconEditProduct;

import java.lang.Math;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;

public class AvatarStoreProduct extends JComponent {
	private IconEditProduct btnEdit;
	private IconEditProduct btnDelete;

	private Icon iconEdit = new ImageIcon(ButtonProductList.class.getResource("/icon/pencil-ModeDark.png"));
	private Icon iconEditBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/pencil-Blue.png"));

	private Icon iconMore = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right.png"));
	private Icon iconMoreBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/arrow-right-blue.png"));

	private Icon iconDelete = new ImageIcon(ButtonProductList.class.getResource("/icon/delete-ModeDark.png"));
	private Icon iconDeleteBlue = new ImageIcon(ButtonProductList.class.getResource("/icon/delete-Blue.png"));

	private Icon image;

	private IconEditProduct btnMoreProduct;

	private float alpha = 1f;
	private Graphics2D g2Img;

	public AvatarStoreProduct() {

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		JPanel panelButton = new JPanel();
		panelButton.setOpaque(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(panelButton, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(54)
						.addComponent(panelButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(75, Short.MAX_VALUE)));

		btnEdit = new IconEditProduct(iconEdit);
		btnEdit.setColor(ColorBackground.colorLight);
		btnEdit.setVisible(false);

		btnDelete = new IconEditProduct(iconDelete);
		btnDelete.setColor(ColorBackground.colorLight);
		btnDelete.setVisible(false);

		btnMoreProduct = new IconEditProduct(iconMore);
		btnMoreProduct.setColor(ColorBackground.colorLight);
		btnMoreProduct.setVisible(false);

		GroupLayout gl_panelButton = new GroupLayout(panelButton);
		gl_panelButton.setHorizontalGroup(gl_panelButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButton.createSequentialGroup().addGap(62)
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnMoreProduct, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(139, Short.MAX_VALUE)));
		gl_panelButton.setVerticalGroup(gl_panelButton.createParallelGroup(Alignment.LEADING).addGroup(gl_panelButton
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panelButton.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMoreProduct, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(14, Short.MAX_VALUE)));
		panelButton.setLayout(gl_panelButton);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(110, Short.MAX_VALUE)));
		setLayout(groupLayout);
		setOpaque(false);
		action();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (image != null) {
			int width = getWidth();
			int height = getHeight();
			int diameter = Math.min(width, height);
			Rectangle size = getAutoSize(image, diameter);
			BufferedImage img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
			g2Img = img.createGraphics();
			g2Img.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
			g2Img.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
			Composite composite = g2Img.getComposite();

			if (alpha == 1f) {
				g2Img.setComposite(AlphaComposite.SrcIn);
			} else {
				g2Img.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, alpha));
			}
			g2Img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2Img.drawImage(toImage(image), 0, 0, getWidth(), getHeight(), null);
	
			
			g2Img.setComposite(composite);

			g2.drawImage(img, 0, 0, null);

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
		return new Rectangle(new Point(x, y), new Dimension(getWidth(), getHeight()));

	}

	public void action() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				btnMoreProduct.setVisible(true);
				alpha = 0.3f;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEdit.setVisible(false);
				btnDelete.setVisible(false);
				btnMoreProduct.setVisible(false);

				alpha = 1f;
				repaint();
			}
		});

		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEdit.setIcon(iconEditBlue);
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				btnMoreProduct.setVisible(true);
				alpha = 0.3f;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEdit.setIcon(iconEdit);
			}

		});

		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDelete.setIcon(iconDeleteBlue);
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				btnMoreProduct.setVisible(true);
				alpha = 0.3f;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDelete.setIcon(iconDelete);
			}
		});

		btnMoreProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMoreProduct.setIcon(iconMoreBlue);
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				btnMoreProduct.setVisible(true);
				alpha = 0.3f;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMoreProduct.setIcon(iconMore);
			}
		});

	}
	
	

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
		repaint();
	}

	public Icon getImage() {
		return image;
	}

	public void setImage(Icon image) {
		this.image = image;
		repaint();
	}

	public IconEditProduct getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(IconEditProduct btnEdit) {
		this.btnEdit = btnEdit;
	}

	public IconEditProduct getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(IconEditProduct btnDelete) {
		this.btnDelete = btnDelete;
	}

	public IconEditProduct getBtnMoreProduct() {
		return btnMoreProduct;
	}

	public void setBtnMoreProduct(IconEditProduct btnMoreProduct) {
		this.btnMoreProduct = btnMoreProduct;
	}
	
	
}
