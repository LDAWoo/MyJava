package img;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import date.CurrendarCustom;
import view.ChangePasswordView;
import view.ForgotPasswordView;
import view.Header;
import view.LoginUserView;
import view.Menu;
import view.PanelFind;
import view.PanelLearnerList;
import view.Profile;
import view.SignUpView;

public class img {

	public img() {
		
	}

	public Icon iconArr() {
		Icon iconArr = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("arrow32x32.png")));
		return iconArr;
	}

	public Icon iconHome() {
		Icon iconHome = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("home.png")));
		return iconHome;
	}

	public Icon iconManager() {
		Icon iconManager = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("bookmark.png")));
		return iconManager;
	}

	public Icon iconCalendar() {
		Icon iconCalendar = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("calendar.png")));
		return iconCalendar;
	}

	public Icon iconHelp() {
		Icon iconHelp = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("help.png")));
		return iconHelp;
	}

	public Icon iconLibrary() {
		Icon iconLibrary = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("library.png")));
		return iconLibrary;
	}

	public Icon iconSystem() {
		Icon iconSystem = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("system.png")));
		return iconSystem;
	}

	public Icon iconMenu() {
		Icon iconMenu = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("menu.png")));
		return iconMenu;
	}

	public Icon iconProfile() {
		Icon iconProfile = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("logo.png")));
		return iconProfile;
	}

	public Icon iconSearch() {
		Icon iconSearch = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("search.png")));
		return iconSearch;
	}

	public Icon iconPrev() {
		Icon iconPrev = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("back.png")));
		return iconPrev;
	}

	public Icon iconNext() {
		Icon iconNext = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("next.png")));
		return iconNext;
	}
	
	public Icon ImageLogin() {
		ImageIcon imageLogin = new ImageIcon(new ImageIcon(getClass().getResource("bg-login.png")).getImage()
				.getScaledInstance(565, 374, Image.SCALE_SMOOTH));
		return imageLogin;
	}
	
	public Icon IconUser() {
		Icon iconUser = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8_user_20px_1.png")));
		return iconUser;
	}
	
	public Icon IconEyesInvisible() {
		Icon iconEyesInvisible = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8_invisible_20px_1.png")));
		return iconEyesInvisible;
	}
	
	public Icon IconEyes() {
		Icon iconEyes = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8_eye_20px_1.png")));
		return iconEyes;
	}
	
	public Icon IconWarning() {
		Icon iconWarning= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8-error-30.png")));
		return iconWarning;
	}
	
	public ImageIcon ImageSignUp() {
		ImageIcon imageSignUp = new ImageIcon(new ImageIcon(getClass().getResource("signup_bg.png")).getImage()
				.getScaledInstance(565, 374, Image.SCALE_SMOOTH));
		return imageSignUp;
	}
	
	public Icon IconUserSignUp() {
		Icon iconUserSignUp= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon_usersignup.png")));
		return iconUserSignUp;
	}
	
	public Icon IconEmail() {
		Icon iconEmail= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("email_icon.png")));
		return iconEmail;
	}
	
	public Icon IconLock() {
		Icon iconLock= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("lock_icon.png")));
		return iconLock;
	}
	
	public Icon iconFisrt() {
		Icon iconFisrt= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-first.png")));
		return iconFisrt;
	}
	
	public Icon iconPrev1() {
		Icon iconPrev1= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-prev.png")));
		return iconPrev1;
	}
	
	public Icon iconNext1() {
		Icon iconNext1= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-next.png")));
		return iconNext1;
	}
	
	public Icon iconLast() {
		Icon iconLast= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-last.png")));
		return iconLast;
	}
	
	public Icon iconEdit() {
		Icon iconEdit= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("edit.png")));
		return iconEdit;
	}
	
	public Icon iconDelete() {
		Icon iconDelete= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("delete.png")));
		return iconDelete;
	}
	
	public Icon iconRefresh() {
		Icon iconRefresh= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-refresh.png")));
		return iconRefresh;
	}
	
	public ImageIcon ImageWhite() {
		ImageIcon ImageWhite = new ImageIcon(new ImageIcon(getClass().getResource("white.png")).getImage()
				.getScaledInstance(130, 162, Image.SCALE_SMOOTH));
		return ImageWhite;
	}
	
}
