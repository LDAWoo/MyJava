package date;

import javax.swing.JPanel;

import java.awt.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import img.img;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import animation.AnimationButtonList;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
public class CurrendarCustom extends JLayeredPane{
  
	SlideDate slide;

	
	int month;
	int year;
	private JLabel lblMonthAndYear;
	private JLabel lblToday;
	private JLabel lblClock;
	
	public CurrendarCustom() {	
		slide = new SlideDate();
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60,60,60));
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
						.addComponent(slide, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(slide, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		
		AnimationButtonList btnNext = new AnimationButtonList(img.iconNext(),"");
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.setBackground(SystemColor.window);
		btnNext.setBorder(null);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(month==12) {
					month=1;
					year++;
				}else {
					month++;
				}
				
				slide.show(new PanelDate(month, year), SlideDate.AnimateType.TO_LEFT);
				showMonthYear();
			}
		});
		
		AnimationButtonList btnPrev = new AnimationButtonList(img.iconPrev(),"");
		btnPrev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPrev.setBorder(null);
		btnPrev.setBackground(SystemColor.window);
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(month==1) {
					month=12;
					year--;
				}else {
					month--;
				}
				slide.show(new PanelDate(month, year), SlideDate.AnimateType.TO_RIGHT);
				showMonthYear();
			}
		});
		
		lblMonthAndYear = new JLabel("Month - Year");
		lblMonthAndYear.setForeground(new Color(200,200,200));
		lblMonthAndYear.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblMonthAndYear.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_layeredPane.createSequentialGroup()
					.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMonthAndYear, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblMonthAndYear, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPrev, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(btnNext, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		layeredPane.setLayout(gl_layeredPane);
		
		JPanel panelWest = new JPanel();
		panelWest.setBorder(null);
		panelWest.setBackground(new Color(50,50,50));
		
		lblClock = new JLabel("00:00:00 AM");
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);
		lblClock.setFont(new Font("SansSerif", Font.PLAIN, 40));
		lblClock.setForeground(new Color(200,200,200));
		
		lblToday = new JLabel("Monday, November 11, 2022");
		lblToday.setForeground(new Color(200,200,200));
		lblToday.setHorizontalAlignment(SwingConstants.CENTER);
		lblToday.setFont(new Font("SansSerif", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panelWest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClock, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
						.addComponent(lblToday, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panelWest, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblClock, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblToday)
					.addGap(308))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		thisMonth();
		init();
	}
	
	private void thisMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		month = calendar.get(Calendar.MONTH) +1;
		year = calendar.get(Calendar.YEAR);
		
	}
	
	private void showMonthYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH,month-1);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DATE,1);
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
		lblMonthAndYear.setText(sdf.format(calendar.getTime()));
	}
	
	public void init() {
		slide.show(new PanelDate(month, year), SlideDate.AnimateType.TO_RIGHT);
		showMonthYear();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
						SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss aa");

						SimpleDateFormat sdfDay = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
						Date now = new Date();

						
						lblClock.setText(sdfTime.format(now));
						lblToday.setText(sdfDay.format(now));
						
					} catch (Exception e) {
						System.out.println("Error: "+e.toString());
					}
				}
				
			}
		}).start();
	}
}
