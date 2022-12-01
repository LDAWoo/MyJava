package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.InsetsUIResource;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import event.EventMenuSelected;
import net.miginfocom.swing.MigLayout;
import java.awt.event.WindowFocusListener;

public class PopupMenu extends JDialog {
	PanelPopup panel;

//	JPanel panel;
	private Animator animator;
	private boolean show = true;

	public PopupMenu(JFrame parent, int index, EventMenuSelected eventMenuSelected, String... subMenu) {
		super(parent, false);
		initComponents();
		setOpacity(0f);
		setBackground(new Color(0, 0, 0, 0));
		panel.setLayout(new MigLayout("fill, wrap", "8[fill, 120]0", "0[35, fill]0[35, fill]0"));
		int subMenuIndex = -1;

		for (String st : subMenu) {
			MenuButton item = new MenuButton(st.trim(), true);

			item.setIndex(++subMenuIndex);
			
			item.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					eventMenuSelected.menuSelected(index, item.getIndex());
					closeMenu();
				}
			});

			panel.add(item);
			
			
			this.setSize(new Dimension(160, 35 * subMenu.length));
		}

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

	public void initComponents() {
		panel = new PanelPopup();

		setUndecorated(true);
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent evt) {
			}

			public void windowLostFocus(WindowEvent evt) {
				closeMenu();
			}
		});

		GroupLayout panelLayout = new GroupLayout(panel);
		panel.setLayout(panelLayout);
		panelLayout.setHorizontalGroup(
				panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 200, Short.MAX_VALUE));
		panelLayout.setVerticalGroup(
				panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if (show) {
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
