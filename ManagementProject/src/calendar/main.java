package calendar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class main extends JFrame {

	private JPanel contentPane;

	SlideDate date;
	
	private int month;
	private int year;

	private JLabel lblMonthYear;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					main frame = new main();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public main() {
		
		lblMonthYear = new JLabel("Month - Year");
		thisMonth();
		date = new SlideDate();
		
		date.show(new PanelDate(month,year), SlideDate.AnimateType.TO_RIGHT);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(date, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(date, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnPrev = new JButton("Prev");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(month ==1) {
					month = 12;
					year --;
				}else {
					month --;
				}
				
				
				
				date.show(new PanelDate(month,year), SlideDate.AnimateType.TO_RIGHT);
				showMonthYear();
			}
		});
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(month==12) {
					month = 1;
					year++;
				}else {
					month++;
				}
				System.out.println(month);
				
				date.show(new PanelDate(month,year), SlideDate.AnimateType.TO_LEFT);
				showMonthYear();
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		 
		 showMonthYear();
		lblMonthYear.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMonthYear.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMonthYear, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNext, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(btnPrev, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(lblMonthYear, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void thisMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		month = calendar.get(Calendar.MONTH) +1;
		System.out.println(month);
		year = calendar.get((Calendar.YEAR));
		
		
	}
	
	private void showMonthYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month -1);
		calendar.set(Calendar.DATE, 1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
		
		lblMonthYear.setText(sdf.format(calendar.getTime()));
	}
}
