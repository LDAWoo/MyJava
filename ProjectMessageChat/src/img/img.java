package img;

import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;





public class img {
	
	public img() {
		// TODO Auto-generated constructor stub
	}
	
	public Icon iconSend() {
		Icon iconSend = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("send-message.png")));
		return iconSend;
	}
	
	public Icon iconImg() {
		Icon iconImg = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("images.png")));
		return iconImg;
	}
	
	public Icon iconArrow() {
		Icon iconArrow = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("down-arrow.png")));
		return iconArrow;
	}
	
	public Icon iconMess() {
		Icon iconMess = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("messenger-blue.png")));
		return iconMess;
	}
	
	public Icon iconMessWhite() {
		Icon iconMess = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-messenger.png")));
		return iconMess;
	}
	
	public Icon iconFace() {
		Icon iconFace = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("facebook-blue.png")));
		return iconFace;
	}
	
	public Icon iconFaceWhite() {
		Icon iconFace = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-facebook-white.png")));
		return iconFace;
	}
	
	public Icon iconListFriends() {
		Icon iconListFriends = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-list-friends.png")));
		return iconListFriends;
	}
	
	public Icon iconStar() {
		Icon iconStar = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("star.png")));
		return iconStar;
	}
	
	public Icon iconSetting() {
		Icon iconSetting = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("setting.png")));
		return iconSetting;
	}
	
	public Icon iconPhone() {
		Icon iconPhone = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-phone.png")));
		return iconPhone;
	}
	
	public Icon iconVideo() {
		Icon iconVideo = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("video.png")));
		return iconVideo;
	}
	
	public Icon iconAlert() {
		Icon iconAlert = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("alert.png")));
		return iconAlert;
	}
	
	public Icon iconSearch() {
		Icon iconSearch = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-search.png")));
		return iconSearch;
	}
	
	public Icon iconPlus() {
		Icon iconPlus = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("plus.png")));
		return iconPlus;
	}
	
	public Icon iconGif() {
		Icon iconGif = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("gif.png")));
		return iconGif;
	}
	
	public Icon iconSticker() {
		Icon iconSticker = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("stickers.png")));
		return iconSticker;
	}

}
