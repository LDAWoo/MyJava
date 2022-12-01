package img;

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
	
	public Icon iconArrow() {
		Icon iconArrow = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("arrow-down.png")));
		return iconArrow;
	}
	
	public Icon iconMess() {
		Icon iconMess = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-messengerr.png")));
		return iconMess;
	}
	
	public Icon iconFace() {
		Icon iconFace = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("facebook.png")));
		return iconFace;
	}
}
