package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import org.jdesktop.animation.timing.Animator;

import color.ColorBackground;

public class MenuButton extends JButton {
	private int index;
	private static Color effectColor = ColorBackground.colorDark;

	Icon iconHomeBlue = new ImageIcon(Menu.class.getResource("/icon/home-blue.png"));
	Icon iconProductBlue = new ImageIcon(Menu.class.getResource("/icon/diamond-blue.png"));
	Icon iconCustomerBlue = new ImageIcon(Menu.class.getResource("/icon/user-blue.png"));
	Icon iconStoreBlue = new ImageIcon(Menu.class.getResource("/icon/store-blue.png"));
	Icon iconIncomeBlue = new ImageIcon(Menu.class.getResource("/icon/income-blue.png"));
	Icon iconCalendarBlue = new ImageIcon(Menu.class.getResource("/icon/calendar-blue.png"));
	Icon iconHelpBlue = new ImageIcon(Menu.class.getResource("/icon/help-blue.png"));

	Icon iconHomeWhite = new ImageIcon(Menu.class.getResource("/icon/home-white.png"));
	Icon iconProductWhite = new ImageIcon(Menu.class.getResource("/icon/diamond-white.png"));
	Icon iconCustomerWhite = new ImageIcon(Menu.class.getResource("/icon/user-white.png"));
	Icon iconStoreWhite = new ImageIcon(Menu.class.getResource("/icon/store-white.png"));
	Icon iconIncomeWhite = new ImageIcon(Menu.class.getResource("/icon/income-white.png"));
	Icon iconCaledarWhite = new ImageIcon(Menu.class.getResource("/icon/calendar-white.png"));
	Icon iconHelpWhite = new ImageIcon(Menu.class.getResource("/icon/help-white.png"));

	Icon iconHomeGray = new ImageIcon(Menu.class.getResource("/icon/home-gray.png"));
	Icon iconProductGray = new ImageIcon(Menu.class.getResource("/icon/diamond-gray.png"));
	Icon iconCustomerGray = new ImageIcon(Menu.class.getResource("/icon/user-gray.png"));
	Icon iconStoreGray = new ImageIcon(Menu.class.getResource("/icon/store-gray.png"));
	Icon iconIncomeGray = new ImageIcon(Menu.class.getResource("/icon/income-gray.png"));
	Icon iconCaledarGray = new ImageIcon(Menu.class.getResource("/icon/calendar-gray.png"));
	Icon iconHelpGray = new ImageIcon(Menu.class.getResource("/icon/help-gray.png"));

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public MenuButton(Icon icon, String text, Color color, int index) {
		this.index = index;
		setIcon(icon);
		init(text, color);
		setBorder(new EmptyBorder(1, 20, 1, 1));
	}

	public MenuButton(String text, Color color) {
		init(text, color);
		setBorder(new EmptyBorder(1, 20, 1, 1));
	}

	public MenuButton(String text, boolean subMenu, Color color) {
		init(text, color);
	}

	public void init(String text, Color color) {
		setText(text);
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
				
				if (effectColor == ColorBackground.colorDark) {
					setOpaque(true);
					setBackground(ColorBackground.colorGRB707070);
				}
				if (effectColor == ColorBackground.colorLight) {
					setOpaque(true);
					setBackground(ColorBackground.colorGRB239239239);
				}

				if (index == 0) {
					setIcon(iconHomeBlue);
				}
				if (index == 1) {
					setIcon(iconProductBlue);
				}
				if (index == 2) {
					setIcon(iconCustomerBlue);
				}
				if (index == 3) {
					setIcon(iconStoreBlue);
				}
				if (index == 4) {
					setIcon(iconIncomeBlue);
				}
				if (index == 5) {
					setIcon(iconCalendarBlue);
				}
				if (index == 7) {
					setIcon(iconHelpBlue);
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				setOpaque(false);
				if (MainForm.mode == "Dark") {
					if (index == 0) {
						setIcon(iconHomeWhite);
					}
					if (index == 1) {
						setIcon(iconProductWhite);
					}
					if (index == 2) {
						setIcon(iconCustomerWhite);
					}
					if (index == 3) {
						setIcon(iconStoreWhite);
					}
					if (index == 4) {
						setIcon(iconIncomeWhite);
					}
					if (index == 5) {
						setIcon(iconCaledarWhite);
					}
					if (index == 7) {
						setIcon(iconHelpWhite);
					}
				} else {

					if (index == 0) {
						setIcon(iconHomeGray);
					}
					if (index == 1) {
						setIcon(iconProductGray);
					}
					if (index == 2) {
						setIcon(iconCustomerGray);
					}
					if (index == 3) {
						setIcon(iconStoreGray);
					}
					if (index == 4) {
						setIcon(iconIncomeGray);
					}
					if (index == 5) {
						setIcon(iconCaledarGray);
					}
					if (index == 7) {
						setIcon(iconHelpGray);
					}
				}

			}

		});
		actionButtonMode();
	}

	public void actionButtonMode() {
		PanelMode.actionButonModeDark(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				effectColor = ColorBackground.colorDark;

				repaint();

			}
		});

		PanelMode.actionButonModeLight(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				effectColor = ColorBackground.colorLight;

				repaint();

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

	public Color getEffectColor() {
		return effectColor;
	}

}
