package imgClient;

import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class img {
	
	public img() {
		// TODO Auto-generated constructor stub
	}
	
	public Icon iconSend() {
		Icon iconSend = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("send.png")));
		return iconSend;
	}
	
	public Icon iconImg() {
		Icon iconImg = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("image.png")));
		return iconImg;
	}
}
