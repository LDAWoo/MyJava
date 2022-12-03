package components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import img.img;
import net.miginfocom.swing.MigLayout;

public class PanelMessengerHeader extends JPanel {
	private MigLayout layout;
	private img img = new img();
	
	private JPanel header;
	private JPanel body;
	private JPanel bottom;

	public PanelMessengerHeader() {
		setOpaque(false);
		layout = new MigLayout("fill, inset 1", "[fill]", "[70!,fill]");

		header = createHeader();

		body = createBody();
		
		bottom = createBottom();
		
		setLayout(layout);
		add(header);
		add(body);
		add(bottom);
	}

	public JPanel createHeader() {
		JPanel panelHeader = new JPanel();
		panelHeader.setOpaque(false);

		return panelHeader;
	}

	public JPanel createBody() {
		JPanel panelBody = new JPanel();
		panelBody.setOpaque(false);

		
		return panelBody;
	}

	public JPanel createBottom() {
		JPanel panelBottom = new JPanel();
		panelBottom.setOpaque(false);

		panelBottom.setLayout(new MigLayout("fill","[right]"));

		ButtonChatHeader btnPhone = new ButtonChatHeader();
		ButtonChatHeader btnVideo = new ButtonChatHeader();
		ButtonChatHeader btnAlertCircle = new ButtonChatHeader();

		btnPhone.setIcon(img.iconPhone());
		btnVideo.setIcon(img.iconVideo());
		btnAlertCircle.setIcon(img.iconAlert());

		panelBottom.add(btnPhone,"skip, h 40!, w 40! , split");
		panelBottom.add(btnVideo,"h 40!, w 40!");
		panelBottom.add(btnAlertCircle,"h 40!, w 40!");

		return panelBottom;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, new Color(0, 150, 255), 250, 0, new Color(0, 150, 255));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

}
