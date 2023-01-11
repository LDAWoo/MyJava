package componentCalender;

import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;

public class PanelCalendar extends JPanel {
	private int month;
	private int year;
	
	private ButtonCalender btnSun;
	private ButtonCalender btnMon;
	private ButtonCalender btnTue;
	private ButtonCalender btnWed;
	private ButtonCalender btnFri;
	private ButtonCalender btnThu;
	private ButtonCalender btnSat;
	private ButtonCalender btnNewButton_8;
	private ButtonCalender btnNewButton;
	private ButtonCalender btnNewButton_10;
	private ButtonCalender btnNewButton_9;
	private ButtonCalender btnNewButton_12;
	private ButtonCalender btnNewButton_11;
	private ButtonCalender btnNewButton_15;
	private ButtonCalender btnNewButton_14;
	private ButtonCalender btnNewButton_13;
	private ButtonCalender btnNewButton_18;
	private ButtonCalender btnNewButton_16;
	private ButtonCalender btnNewButton_17;
	private ButtonCalender btnNewButton_19;
	private ButtonCalender btnNewButton_21;
	private ButtonCalender btnNewButton_20;
	private ButtonCalender btnNewButton_22;
	private ButtonCalender btnNewButton_24;
	private ButtonCalender btnNewButton_23;
	private ButtonCalender btnNewButton_25;
	private ButtonCalender btnNewButton_26;
	private ButtonCalender btnNewButton_28;
	private ButtonCalender btnNewButton_27;
	private ButtonCalender btnNewButton_30;
	private ButtonCalender btnNewButton_29;
	private ButtonCalender btnNewButton_31;
	private ButtonCalender btnNewButton_32;
	private ButtonCalender btnNewButton_33;
	private ButtonCalender btnNewButton_36;
	private ButtonCalender btnNewButton_35;
	private ButtonCalender btnNewButton_34;
	private ButtonCalender btnNewButton_37;
	private ButtonCalender btnNewButton_38;
	private ButtonCalender btnNewButton_39;
	private ButtonCalender btnNewButton_40;
	private ButtonCalender btnNewButton_41;
	private ButtonCalender btnNewButton_42;
	private ButtonCalender btnNewButton_43;
	private ButtonCalender btnNewButton_44;
	private ButtonCalender btnNewButton_45;
	private ButtonCalender btnNewButton_46;
	private ButtonCalender btnNewButton_47;
	private ButtonCalender btnNewButton_48;

	public PanelCalendar() {
		setOpaque(false);

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));
		panel.setLayout(new GridLayout(7, 7, 0, 0));

		btnSun = new ButtonCalender();
		btnSun.setText("Sun");
		panel.add(btnSun);

		btnMon = new ButtonCalender();
		btnMon.setText("Mon");
		panel.add(btnMon);

		btnTue = new ButtonCalender();
		btnTue.setText("Tue");
		panel.add(btnTue);

		btnWed = new ButtonCalender();
		btnWed.setText("Wed");
		panel.add(btnWed);

		btnThu = new ButtonCalender();
		btnThu.setText("Thu");
		panel.add(btnThu);

		btnFri = new ButtonCalender();
		btnFri.setText("Fri");
		panel.add(btnFri);

		btnSat = new ButtonCalender();
		btnSat.setText("Sat");
		panel.add(btnSat);

		btnNewButton_8 = new ButtonCalender();
		panel.add(btnNewButton_8);

		btnNewButton = new ButtonCalender();
		panel.add(btnNewButton);

		btnNewButton_10 = new ButtonCalender();
		panel.add(btnNewButton_10);

		btnNewButton_9 = new ButtonCalender();
		panel.add(btnNewButton_9);

		btnNewButton_12 = new ButtonCalender();
		panel.add(btnNewButton_12);

		btnNewButton_11 = new ButtonCalender();
		panel.add(btnNewButton_11);

		btnNewButton_15 = new ButtonCalender();
		panel.add(btnNewButton_15);

		btnNewButton_14 = new ButtonCalender();
		panel.add(btnNewButton_14);

		btnNewButton_13 = new ButtonCalender();
		panel.add(btnNewButton_13);

		btnNewButton_18 = new ButtonCalender();
		panel.add(btnNewButton_18);

		btnNewButton_16 = new ButtonCalender();
		panel.add(btnNewButton_16);

		btnNewButton_17 = new ButtonCalender();
		panel.add(btnNewButton_17);

		btnNewButton_19 = new ButtonCalender();
		panel.add(btnNewButton_19);

		btnNewButton_21 = new ButtonCalender();
		panel.add(btnNewButton_21);

		btnNewButton_20 = new ButtonCalender();
		panel.add(btnNewButton_20);

		btnNewButton_22 = new ButtonCalender();
		panel.add(btnNewButton_22);

		btnNewButton_24 = new ButtonCalender();
		panel.add(btnNewButton_24);

		btnNewButton_23 = new ButtonCalender();
		panel.add(btnNewButton_23);

		btnNewButton_25 = new ButtonCalender();
		panel.add(btnNewButton_25);

		btnNewButton_26 = new ButtonCalender();
		panel.add(btnNewButton_26);

		btnNewButton_28 = new ButtonCalender();
		panel.add(btnNewButton_28);

		btnNewButton_27 = new ButtonCalender();
		panel.add(btnNewButton_27);

		btnNewButton_30 = new ButtonCalender();
		panel.add(btnNewButton_30);

		btnNewButton_29 = new ButtonCalender();
		panel.add(btnNewButton_29);

		btnNewButton_31 = new ButtonCalender();
		panel.add(btnNewButton_31);

		btnNewButton_32 = new ButtonCalender();
		panel.add(btnNewButton_32);

		btnNewButton_33 = new ButtonCalender();
		panel.add(btnNewButton_33);

		btnNewButton_36 = new ButtonCalender();
		panel.add(btnNewButton_36);

		btnNewButton_35 = new ButtonCalender();
		panel.add(btnNewButton_35);

		btnNewButton_34 = new ButtonCalender();
		panel.add(btnNewButton_34);

		btnNewButton_37 = new ButtonCalender();
		panel.add(btnNewButton_37);

		btnNewButton_38 = new ButtonCalender();
		panel.add(btnNewButton_38);

		btnNewButton_39 = new ButtonCalender();
		panel.add(btnNewButton_39);

		btnNewButton_40 = new ButtonCalender();
		panel.add(btnNewButton_40);

		btnNewButton_41 = new ButtonCalender();
		panel.add(btnNewButton_41);

		btnNewButton_42 = new ButtonCalender();
		panel.add(btnNewButton_42);

		btnNewButton_43 = new ButtonCalender();
		panel.add(btnNewButton_43);

		btnNewButton_44 = new ButtonCalender();
		panel.add(btnNewButton_44);

		btnNewButton_45 = new ButtonCalender();
		panel.add(btnNewButton_45);

		btnNewButton_46 = new ButtonCalender();
		panel.add(btnNewButton_46);

		btnNewButton_47 = new ButtonCalender();
		panel.add(btnNewButton_47);

		btnNewButton_48 = new ButtonCalender();
		panel.add(btnNewButton_48);
		setLayout(groupLayout);
		init();
	}
	
	public void init() {
		btnSun.isTitle();
		btnMon.isTitle();
		btnTue.isTitle();
		btnWed.isTitle();
		btnThu.isTitle();
		btnFri.isTitle();
		btnSat.isTitle();
	}
	
	public void setDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.YEAR, year);
		calendar.set(calendar.MONTH, month);
		calendar.set(calendar.DATE,1);
		int startDay = calendar.get(calendar.DAY_OF_WEEK);
		calendar.add(calendar.DATE, - startDay);
		Today today = getToday();
		for (Component com : getComponents()) {
			ButtonCalender cell = (ButtonCalender) com;
			if(!cell.isTitle()) {
				cell.setText(calendar.get(calendar.DATE)+"");
				cell.setDate(calendar.getTime());
				cell.currenMonth(calendar.get(calendar.MONTH) == month - 1);
				
			}
		}
	}
	
	
	
	private Today getToday() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return new Today(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
	}
}
