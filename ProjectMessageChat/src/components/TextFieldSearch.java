package components;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class TextFieldSearch extends JTextField {

    

    private final String hint = "Tìm kiếm trên Messenger";

    public TextFieldSearch() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setSelectionColor(new Color(220, 204, 182));
	}
    
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (getText().length() == 0) {
			int h = getHeight();
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Insets ins = getInsets();
			FontMetrics fm = g2.getFontMetrics();
			int c0 = getBackground().getRGB();
			int c1 = getForeground().getRGB();
			int m = 0xfefefefe;
			int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
			g2.setColor(new Color(c2, true));
			g2.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
		}
		
	}
}
