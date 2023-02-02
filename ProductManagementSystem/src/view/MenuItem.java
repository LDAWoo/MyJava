package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import color.ColorBackground;
import interfaces.EventMenu;
import interfaces.EventMenuSelected;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;

public class MenuItem extends JPanel {
	private ModelMenu menu;
	private float alpha;
	private boolean open;
	private EventMenuSelected eventMenuSelected;
	private int index;
	private Color colorMenuItem = ColorBackground.colorDark;
	private Color colorArrow= new Color(100, 100, 100);


	public MenuItem(ModelMenu menu, EventMenu event, EventMenuSelected eventMenuSelected, int index) {
		this.menu = menu;
		this.eventMenuSelected = eventMenuSelected;
		this.index = index;
		setOpaque(false);
		setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[fill, 40!]0[fill, 50!]"));
		MenuButton item = new MenuButton(menu.getIcon(), "   " + menu.getMenuName());
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (menu.getSubMenu().length > 0) {
					if (event.menuPressed(MenuItem.this, !open)) {
						open = !open;
					}
				}
				eventMenuSelected.menuSelected(index, -1);
			}
		});

		add(item);
		int subMenuIndex = -1;
		for (String st : menu.getSubMenu()) {

			MenuButtonItem buttonItem = new MenuButtonItem(st);
			buttonItem.setIndex(++subMenuIndex);
			buttonItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					eventMenuSelected.menuSelected(index, buttonItem.getIndex());
				}
			});
			add(buttonItem, "al right,width ::85%");
		}
		actionButtonMode();
	}
	
	public void actionButtonMode() {
		PanelMode.actionButonModeDark(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorMenuItem = ColorBackground.colorDark;
				repaint();
				
			}
		});
		
		PanelMode.actionButonModeLight(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorMenuItem = ColorBackground.colorLight;
				colorArrow = ColorBackground.colorGRB239239239;
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int width = getWidth();
		int heigth = getPreferredSize().height;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorMenuItem);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2.fillRect(0, 2, width, 38);
		g2.setComposite(AlphaComposite.SrcOver);
		g2.fillRect(0, 40, width, heigth - 40);
		g2.setColor(colorArrow);
		g2.drawLine(31, 40, 31, heigth - 25);
		for (int i = 0; i < menu.getSubMenu().length; i++) {
			int y = ((i + 1) * 50 + 32) - 17;
			g2.drawLine(31, y, 40, y);
		}
		if (menu.getSubMenu().length > 0) {
			createArrowButton(g2);
		}

		super.paintComponent(g);
	}

	private void createArrowButton(Graphics2D g2) {
		int size = 4;
		int y = 19;
		int x = 205;
		g2.setColor(new Color(230, 230, 230));
		float ay = alpha * size;
		float ay1 = (1f - alpha) * size;
		g2.drawLine(x, (int) (y + ay), x + 4, (int) (y + ay1));
		g2.drawLine(x + 4, (int) (y + ay1), x + 8, (int) (y + ay));

	}

	public ModelMenu getMenu() {
		return menu;
	}

	public void setMenu(ModelMenu menu) {
		this.menu = menu;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public EventMenuSelected getEventMenuSelected() {
		return eventMenuSelected;
	}

	public void setEventMenuSelected(EventMenuSelected eventMenuSelected) {
		this.eventMenuSelected = eventMenuSelected;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Color getColorMenuItem() {
		return colorMenuItem;
	}

}
