package img;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class img {

	public img() {
		
	}

	public static Icon iconArr() {
		Icon iconArr = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("arrow32x32.png")));
		return iconArr;
	}

	public static Icon iconHome() {
		Icon iconHome = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-home.png")));
		return iconHome;
	}

	public static Icon iconManager() {
		Icon iconManager = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("bookmark.png")));
		return iconManager;
	}

	public static Icon iconCalendar() {
		Icon iconCalendar = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-calendar.png")));
		return iconCalendar;
	}

	public static Icon iconHelp() {
		Icon iconHelp = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("help.png")));
		return iconHelp;
	}

	public static Icon iconLibrary() {
		Icon iconLibrary = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("library.png")));
		return iconLibrary;
	}

	public static Icon iconSystem() {
		Icon iconSystem = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("system.png")));
		return iconSystem;
	}

	public static Icon iconMenu() {
		Icon iconMenu = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("menu.png")));
		return iconMenu;
	}

	public static Icon iconProfile() {
		Icon iconProfile = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("logo.png")));
		return iconProfile;
	}

	public static Icon iconSearch() {
		Icon iconSearch = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("search.png")));
		return iconSearch;
	}

	public static Icon iconPrev() {
		Icon iconPrev = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("back.png")));
		return iconPrev;
	}

	public static Icon iconNext() {
		Icon iconNext = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("next.png")));
		return iconNext;
	}
	
	public Icon ImageLogin() {
		ImageIcon imageLogin = new ImageIcon(new ImageIcon(getClass().getResource("bg-login.png")).getImage()
				.getScaledInstance(565, 374, Image.SCALE_SMOOTH));
		return imageLogin;
	}
	
	public static Icon IconUser() {
		Icon iconUser = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8_user_20px_1.png")));
		return iconUser;
	}
	
	public static Icon IconEyesInvisible() {
		Icon iconEyesInvisible = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8_invisible_20px_1.png")));
		return iconEyesInvisible;
	}
	
	public static Icon IconEyes() {
		Icon iconEyes = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8_eye_20px_1.png")));
		return iconEyes;
	}
	
	public static Icon IconWarning() {
		Icon iconWarning= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8-error-30.png")));
		return iconWarning;
	}
	
	public  ImageIcon ImageSignUp() {
		ImageIcon imageSignUp = new ImageIcon(new ImageIcon(getClass().getResource("signup_bg.png")).getImage()
				.getScaledInstance(565, 374, Image.SCALE_SMOOTH));
		return imageSignUp;
	}
	
	public static Icon IconUserSignUp() {
		Icon iconUserSignUp= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon_usersignup.png")));
		return iconUserSignUp;
	}
	
	public static Icon IconEmail() {
		Icon iconEmail= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("email_icon.png")));
		return iconEmail;
	}
	
	public static Icon IconLock() {
		Icon iconLock= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("lock_icon.png")));
		return iconLock;
	}
	
	public static Icon iconFisrt() {
		Icon iconFisrt= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-first.png")));
		return iconFisrt;
	}
	
	public static Icon iconPrev1() {
		Icon iconPrev1= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-prev.png")));
		return iconPrev1;
	}
	
	public static Icon iconNext1() {
		Icon iconNext1= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-next.png")));
		return iconNext1;
	}
	
	public static Icon iconLast() {
		Icon iconLast= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-last.png")));
		return iconLast;
	}
	
	public static Icon iconEdit() {
		Icon iconEdit= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("edit.png")));
		return iconEdit;
	}
	
	public static Icon iconDelete() {
		Icon iconDelete= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("delete.png")));
		return iconDelete;
	}
	
	public static Icon iconRefresh() {
		Icon iconRefresh= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-refresh.png")));
		return iconRefresh;
	}
	
	public ImageIcon ImageWhite() {
		ImageIcon ImageWhite = new ImageIcon(new ImageIcon(getClass().getResource("white.png")).getImage()
				.getScaledInstance(217, 257, Image.SCALE_SMOOTH));
		return ImageWhite;
	}
	
	public ImageIcon ImageUser() {
		ImageIcon ImageUser = new ImageIcon(new ImageIcon(getClass().getResource("default-user.png")).getImage()
				.getScaledInstance(130, 162, Image.SCALE_SMOOTH));
		return ImageUser;
	}
	
	public static Icon iconNew() {
		Icon iconNew= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("folder-plus.png")));
		return iconNew;
	}
	
	public static Icon iconAdd() {
		Icon iconAdd= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("account-plus.png")));
		return iconAdd;
	}
	
	public static Icon iconEditWhite() {
		Icon iconEditWhite= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("text-box-edit.png")));
		return iconEditWhite;
	}
	
	public static Icon iconDeleteWhite() {
		Icon iconDeleteWhite= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("delete-white.png")));
		return iconDeleteWhite;
	}
	
	public static Icon iconDelete64x64() {
		Icon iconDelete64x64= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("delete64x64.png")));
		return iconDelete64x64;
	}
	
	public static Icon iconDelete32x32() {
		Icon iconDelete32x32= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("delete32x32.png")));
		return iconDelete32x32;
	}
	
	public static Icon iconEdit32x32() {
		Icon iconEdit32x32= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("edit32x32.png")));
		return iconEdit32x32;
	}
	
	public static Icon iconAdd32x32() {
		Icon iconAdd32x32= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("add32x32.png")));
		return iconAdd32x32;
	}
	
	public static Icon iconCancel() {
		Icon iconCancel= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("cancel.png")));
		return iconCancel;
	}
	

	public static Icon iconStudent2() {
		Icon iconStudent2= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-student2.png")));
		return iconStudent2;
	}
	
	public static Icon iconHome2() {
		Icon iconHome2= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-home.png")));
		return iconHome2;
	}
	
	public static Icon iconEmployee() {
		Icon iconEmployee= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-employee.png")));
		return iconEmployee;
	}
	
	public static Icon iconTopic() {
		Icon iconTopic= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-topic.png")));
		return iconTopic;
	}
	
	public static Icon iconCourse() {
		Icon iconCourse= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-course.png")));
		return iconCourse;
	}
	
	public static Icon iconLogin() {
		Icon iconLogin= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-login.png")));
		return iconLogin;
	}
	
	public static Icon iconFoget() {
		Icon iconFoget= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-forget.png")));
		return iconFoget;
	}
	
	public static Icon iconLogout() {
		Icon iconLogout= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-logout.png")));
		return iconLogout;
	}
	
	public static Icon iconExit() {
		Icon iconExit= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-exit.png")));
		return iconExit;
	}
	
	public static Icon iconSetting() {
		Icon iconSetting= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-setting.png")));
		return iconSetting;
	}
	
	public static Icon avatarMale() {
		Icon avatarMale= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("avatar-male.png")));
		return avatarMale;
	}
	
	public static Icon avatarFemale() {
		Icon avatarFemale= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("avatar-female.png")));
		return avatarFemale;
	}
	
	public static Icon iconWallet1() {
		Icon iconWallet1= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("wallet1.png")));
		return iconWallet1;
	}
	
	public static Icon iconWallet2() {
		Icon iconWallet2= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("wallet2.png")));
		return iconWallet2;
	}
	
	public static Icon iconWallet3() {
		Icon iconWallet3= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("wallet3.png")));
		return iconWallet3;
	}
	
	public static Icon iconWallet4() {
		Icon iconWallet4= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("wallet4.png")));
		return iconWallet4;
	}
	
	public static Icon iconQuestion() {
		Icon iconQuestion= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-question.png")));
		return iconQuestion;
	}
	
	public static Icon iconMessageCheck() {
		Icon iconMessageCheck= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-message-check.png")));
		return iconMessageCheck;
	}
	
	public static Icon iconPhone() {
		Icon iconPhone= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-phone-classic.png")));
		return iconPhone;
	}
	
	public static Icon iconAttendance() {
		Icon iconAttendance= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-attendance.png")));
		return iconAttendance;
	}
	
	public static Icon iconPoint() {
		Icon iconPoint= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-point.png")));
		return iconPoint;
	}
	
	public static Icon iconTuition() {
		Icon iconTuition= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-wallet-tuition.png")));
		return iconTuition;
	}
	
	public static Icon iconCalendarStudent() {
		Icon iconCalendarStudent= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon-calendarStudent.png")));
		return iconCalendarStudent;
	}
	
}
