package components;

import java.awt.Dialog;

import javax.swing.JFrame;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import net.miginfocom.swing.MigLayout;

public class OptionMenu extends Dialog{
	private PanelOpion panel;
	private Animator animator;
	private boolean show = true;
	
	public OptionMenu(JFrame parent,int index, String... option) {
		super(parent,false);
		init();
		setOpacity(0f);
		panel.setLayout(new MigLayout("fill, wrap", "8[fill, 120]0", "0[35, fill]0[35, fill]0"));
		
		ButtonChatHeader btnOn = new ButtonChatHeader();
		btnOn.setText("Chế độ tối");
		
		ButtonChatHeader btnOff = new ButtonChatHeader();
		btnOff.setText("Chế độ sáng");
		
		panel.add(btnOn);
		panel.add(btnOff);
		
		TimingTargetAdapter target = new TimingTargetAdapter() {
			@Override
			public void timingEvent(float fraction) {
				if (show) {
					setOpacity(fraction);
				} else {
					setOpacity(1f - fraction);
				}
			}

			@Override
			public void end() {
				if (show == false) {
					setVisible(false);
				}
			}
		};
		animator = new Animator(200, target);
		animator.setResolution(0);
		animator.setAcceleration(0.5f);
		
	}
	
	public void init() {
		panel = new PanelOpion();
		setUndecorated(true);
		
	}
	
	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if(show) {
			animator.start();
		}
	}
	
	public void closeMenu() {
		if (animator.isRunning()) {
			animator.stop();
		}
		show = false;
		animator.start();
	}

}
