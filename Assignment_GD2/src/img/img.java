package img;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import view.ChangePasswordView;
import view.ForgotPasswordView;
import view.GradeStudentView;
import view.LoginUserView;
import view.ManagerStudentView;
import view.ManagerUserAndGradeView;
import view.SignUpView;
import view2.Action;
import view2.Action2;
import view2.Card;
import view2.Card2;
import view2.Card3;
import view2.FrameView;
import view2.Menu;
import view2.Menu2;
import view2.PanelGrade;
import view2.PanelStudent;
import view2.TableStudent;

public class img {
	private ForgotPasswordView viewForgot;
	private GradeStudentView View;
	private ManagerStudentView ViewStudent;
	private LoginUserView ViewLogin;
	private SignUpView ViewUp;
	private ManagerUserAndGradeView view;
	private ChangePasswordView viewChange;
	private Menu menu;
	private Menu2 menu2;
	private Card card;
	private Card2 card2;
	private Card3 card3;
	private Action action;
	private Action2 action2;
	private TableStudent table;
	private PanelStudent student;
	private PanelGrade grade;
	private FrameView frameView;
	
	public img(FrameView frameView) {
		this.frameView = frameView;
	}
	
	public img(PanelGrade grade) {
		this.grade = grade;
	}
	
	public img(PanelStudent student) {
		this.student = student;
	}
	
	public img(TableStudent table) {
		this.table = table;
	}
	
	public img(Action action) {
		this.action = action;
	}
	
	public img(Action2 action2) {
		this.action2 = action2;
	}
	
	public img(Card card) {
		this.card = card;
	}
	
	public img(Card2 card2) {
		this.card2 = card2;
	}

	public img(Card3 card3) {
		this.card3 = card3;
	}
	
	public img(Menu menu) {
		this.menu = menu;
	}
	
	public img(Menu2 menu2) {
		this.menu2 = menu2;
	}

	public img(ChangePasswordView viewChange) {
		this.viewChange = viewChange;
	}

	public img(GradeStudentView view) {
		View = view;
	}

	public img(ManagerStudentView view) {
		ViewStudent = view;
	}

	public img(LoginUserView viewLogin) {
		ViewLogin = viewLogin;
	}
	
	public img(SignUpView viewUp) {
		ViewUp = viewUp;
	}
	
	public img(ManagerUserAndGradeView view) {
		this.view = view;
	}

	public img(ForgotPasswordView view) {
		this.viewForgot = view;
	}
	public Icon ImageNew() {
		Icon iconNew = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("new_icon.png")));
		return iconNew;
	}

	public Icon ImageSave() {
		Icon iconSave = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("save_icon.png")));
		return iconSave;
	}

	public Icon ImageDelete() {
		Icon iconDelete = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("delete_icon.png")));
		return iconDelete;
	}

	public Icon ImageUpdate() {
		Icon iconUpdate = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("update_icon.png")));
		return iconUpdate;
	}

	public Icon ImageFirst() {
		Icon iconFirst = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("page-first.png")));
		return iconFirst;
	}

	public Icon ImagePrev() {
		Icon iconPrev = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("skip-previous.png")));
		return iconPrev;
	}

	public Icon ImageNext() {
		Icon iconNext = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("skip-next.png")));
		return iconNext;
	}

	public Icon ImageLast() {
		Icon iconLast = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("page-last.png")));
		return iconLast;
	}

	public Icon ImageFind() {
		Icon iconFind = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("find_icon.png")));
		return iconFind;
	}

	public Icon ImageAll() {
		Icon iconAll = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("add_icon.png")));
		return iconAll;
	}

	public Icon ImageTop() {
		Icon iconTop = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("top3_icon.png")));
		return iconTop;
	}

	public ImageIcon ImageLinh() {
		ImageIcon imageLinh = new ImageIcon(new ImageIcon(getClass().getResource("linh.png")).getImage()
				.getScaledInstance(135, 189, Image.SCALE_SMOOTH));
		return imageLinh;
	}
	
	public ImageIcon ImageHieu() {
		ImageIcon imageHieu = new ImageIcon(new ImageIcon(getClass().getResource("hieu.png")).getImage()
				.getScaledInstance(135, 189, Image.SCALE_SMOOTH));
		return imageHieu;
	}
	
	public ImageIcon ImageHa() {
		ImageIcon imageHa = new ImageIcon(new ImageIcon(getClass().getResource("ha.png")).getImage()
				.getScaledInstance(135, 189, Image.SCALE_SMOOTH));
		return imageHa;
	}
	
	public ImageIcon ImageNhan() {
		ImageIcon imageNhan = new ImageIcon(new ImageIcon(getClass().getResource("hoang.png")).getImage()
				.getScaledInstance(135, 189, Image.SCALE_SMOOTH));
		return imageNhan;
	}
	
	public ImageIcon ImageHoang() {
		ImageIcon imageHoang = new ImageIcon(new ImageIcon(getClass().getResource("nhan.png")).getImage()
				.getScaledInstance(135, 189, Image.SCALE_SMOOTH));
		return imageHoang;
	}
	
	public ImageIcon ImageWhite() {
		ImageIcon imageWhite = new ImageIcon(new ImageIcon(getClass().getResource("white.png")).getImage()
				.getScaledInstance(135, 189, Image.SCALE_SMOOTH));
		return imageWhite;
	}
	
	public ImageIcon ImageUser() {
		ImageIcon imageUser = new ImageIcon(new ImageIcon(getClass().getResource("user.png")).getImage()
				.getScaledInstance(135, 189, Image.SCALE_SMOOTH));
		return imageUser;
	}
	
	public ImageIcon ImageLogin() {
		ImageIcon imageLogin = new ImageIcon(new ImageIcon(getClass().getResource("bg-login.png")).getImage()
				.getScaledInstance(565, 374, Image.SCALE_SMOOTH));
		return imageLogin;
	}
	
	public Icon IconUser() {
		Icon iconUser = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8_user_20px_1.png")));
		return iconUser;
	}
	
	public Icon IconEyes() {
		Icon iconEyes = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8_eye_20px_1.png")));
		return iconEyes;
	}
	
	public Icon IconEyesInvisible() {
		Icon iconEyesInvisible = new ImageIcon(Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8_invisible_20px_1.png")));
		return iconEyesInvisible;
	}
	
	public Icon IconExit() {
		Icon iconExit = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("exit.png")));
		return iconExit;
	}
	
	public Icon IconEmail() {
		Icon iconEmail= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("email_icon.png")));
		return iconEmail;
	}
	
	public Icon IconUserSignUp() {
		Icon iconUserSignUp= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon_usersignup.png")));
		return iconUserSignUp;
	}
	
	public Icon IconLock() {
		Icon iconLock= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("lock_icon.png")));
		return iconLock;
	}
	
	public ImageIcon ImageSignUp() {
		ImageIcon imageSignUp = new ImageIcon(new ImageIcon(getClass().getResource("signup_bg.png")).getImage()
				.getScaledInstance(565, 374, Image.SCALE_SMOOTH));
		return imageSignUp;
	}
	
	public Icon IconLogOut() {
		Icon iconLogOut= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon_logout.png")));
		return iconLogOut;
	}
	
	public Icon IconStu() {
		Icon iconStu= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon_studenthat.png")));
		return iconStu;
	}
	
	public Icon IconStuGrade() {
		Icon iconGrade= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon_keys.png")));
		return iconGrade;
	}
	
	public Icon IconNotification() {
		Icon iconNoti= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icon_notification.png")));
		return iconNoti;
	}
	
	public Icon IconWarning() {
		Icon iconWarning= new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("icons8-error-30.png")));
		return iconWarning;
	}
	
	public ImageIcon ImageBgFpt() {
		ImageIcon imageBg = new ImageIcon(new ImageIcon(getClass().getResource("image-fpt.png")).getImage()
				.getScaledInstance(577, 320, Image.SCALE_SMOOTH));
		return imageBg;
	}
	
	public ImageIcon ImageFpoly() {
		ImageIcon imageFpoly = new ImageIcon(new ImageIcon(getClass().getResource("poly-img.jpg")).getImage()
				.getScaledInstance(583, 209, Image.SCALE_SMOOTH));
		return imageFpoly;
	}
	
	public ImageIcon ImageLeft() {
		ImageIcon imageLeft = new ImageIcon(new ImageIcon(getClass().getResource("logo-left.png")).getImage()
				.getScaledInstance(185, 530, Image.SCALE_SMOOTH));
		return imageLeft;
	}
	
	public ImageIcon ImageRigth() {
		ImageIcon imageRigth = new ImageIcon(new ImageIcon(getClass().getResource("logo-rigth.png")).getImage()
				.getScaledInstance(185, 530, Image.SCALE_SMOOTH));
		return imageRigth;
	}
	
	public Icon ImageStrok() {
		Icon mageStrok = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("strock.png")));
		return mageStrok;
	}
	
	public Image ImageLogo() {
		Image mageLogo = new ImageIcon(img.class.getResource("logo.png")).getImage();
		return mageLogo;
	}
	
	public Image ImageSys() {
		Image mageSys = new ImageIcon(img.class.getResource("home.png")).getImage();
		return mageSys;
	}
	
	public Image ImageMana() {
		Image mageSys = new ImageIcon(img.class.getResource("2.png")).getImage();
		return mageSys;
	}
	
	public Image ImageTable() {
		Image mageSys = new ImageIcon(img.class.getResource("1.png")).getImage();
		return mageSys;
	}
	
	public Image ImageGradee() {
		Image mageSys = new ImageIcon(img.class.getResource("imagegrade.png")).getImage();
		return mageSys;
	}
	
	public Image ImageExit() {
		Image mageSys = new ImageIcon(img.class.getResource("exit32x32.png")).getImage();
		return mageSys;
	}
	
	public Image ImageSetting() {
		Image mageSys = new ImageIcon(img.class.getResource("9.png")).getImage();
		return mageSys;
	}
	
	public Image ImageLogout() {
		Image mageSys = new ImageIcon(img.class.getResource("10.png")).getImage();
		return mageSys;
	}
	
	public Image ImageWel() {
		Image mageSys = new ImageIcon(img.class.getResource("earth.png")).getImage();
		return mageSys;
	}
	
	public Image ImageExtra() {
		Image mageSys = new ImageIcon(img.class.getResource("8.png")).getImage();
		return mageSys;
	}
	
	public Image ImageStu() {
		Image mageStrok = new ImageIcon(img.class.getResource("iconstudent.png")).getImage();
		return mageStrok;
	}
	
	public Icon ImageStu2() {
		Icon mageStrok = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("iconstudent.png")));
		return mageStrok;
	}
	
	public Image ImageArr() {
		Image mageStrok = new ImageIcon(img.class.getResource("arrow32x32.png")).getImage();
		return mageStrok;
	}
	
	public Icon ImageTea() {
		Icon mageStrok = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("iconteacher.png")));
		return mageStrok;
	}
	
	public Image ImageGrade() {
		Image mageStrok = new ImageIcon(img.class.getResource("icongrade.png")).getImage();
		return mageStrok;
	}
	
	public Icon ImageEdit() {
		Icon mageStrok = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("edit.png")));
		return mageStrok;
	}
	
	public Icon ImageDelet() {
		Icon mageStrok = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("delete.png")));
		return mageStrok;
	}
	
	public Icon IconClockTime() {
		Icon iconTimer = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(img.class.getResource("Clock-icon.png")));
		return iconTimer;
	}
	
}
