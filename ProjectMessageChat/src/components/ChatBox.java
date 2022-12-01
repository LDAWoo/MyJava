package components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import img.img;
import model.ModelMessage;
import net.miginfocom.swing.MigLayout;



public class ChatBox extends JComponent {
	private img img = new img();
	private final ModelMessage message;
	private final BoxType boxType;

	public ChatBox(BoxType boxType, ModelMessage message) {
        this.boxType = boxType;
        this.message = message;
        init();
    }

	public void init() {
		initBox();
	}

	public void initBox() {
		String rightToLeft = boxType == BoxType.RIGHT ? ",rtl" : "";
        setLayout(new MigLayout("inset 5" + rightToLeft, "[40!]5[]", "[top]"));
        JTextPane text = new JTextPane();
        text.setText(message.getMessage());
        text.setBackground(new Color(0, 0, 0, 0));
        text.setForeground(new Color(242, 242, 242));
        text.setSelectionColor(new Color(200, 200, 200, 100));
        text.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        text.setOpaque(false);
        text.setEditable(false);
        JLabel labelDate = new JLabel(message.getName() + " | " + message.getDate());
        labelDate.setForeground(new Color(127, 127, 127));
        JLabel lblImg = new JLabel();
        lblImg.setIcon(img.iconImg());
        add(lblImg, "height 40,width 40");
       
        add(text, "gapy 20, wrap");
        add(labelDate, "gapx 20,span 2");

	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
		int height = getHeight();

		if (boxType == BoxType.LEFT) {
			Area area = new Area(new RoundRectangle2D.Double(25, 25, width - 25, height - 25 - 16 - 10, 5, 5));
			area.subtract(new Area(new Ellipse2D.Double(5, 5, 45, 45)));
			GradientPaint gra = new GradientPaint(0, 0, new Color(255, 94, 98, 240), width, 0,
					new Color(255, 153, 102, 240));
			g2.setPaint(gra);
			g2.fill(area);
		} else {
			Area area = new Area(new RoundRectangle2D.Double(0, 25, width - 25, height - 25 - 16 - 10, 5, 5));
			area.subtract(new Area(new Ellipse2D.Double(width - 50, 5, 45, 45)));
			g2.setColor(new Color(127, 127, 127));
			g2.fill(area);
		}
		g2.dispose();
		super.paintComponent(g);
	}

	public ModelMessage getMessage() {
		return message;
	}

	public BoxType getBoxType() {
		return boxType;
	}

	public static enum BoxType {
		LEFT, RIGHT
	}
}
