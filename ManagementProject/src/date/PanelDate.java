package date;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.awt.Component;
import java.awt.Font;

public class PanelDate extends JPanel {

	private Cell sun;
	private Cell mon;
	private Cell tue;
	private Cell wed;
	private Cell thu;
	private Cell fri;
	private Cell sat;
	private Cell cell8;
	private Cell cell9;
	private Cell cell10;
	private Cell cell11;
	private Cell cell12;
	private Cell cell13;
	private Cell cell14;
	private Cell cell15;
	private Cell cell16;
	private Cell cell17;
	private Cell cell18;
	private Cell cell19;
	private Cell cell20;
	private Cell cell21;
	private Cell cell22;
	private Cell cell23;
	private Cell cell24;
	private Cell cell25;
	private Cell cell26;
	private Cell cell27;
	private Cell cell28;
	private Cell cell29;
	private Cell cell30;
	private Cell cell31;
	private Cell cell32;
	private Cell cell33;
	private Cell cell34;
	private Cell cell35;
	private Cell cell36;
	private Cell cell37;
	private Cell cell38;
	private Cell cell39;
	private Cell cell40;
	private Cell cell41;
	private Cell cell42;
	private Cell cell43;
	private Cell cell44;
	private Cell cell45;
	private Cell cell46;
	private Cell cell47;
	private Cell cell48;
	private Cell cell49;
	
	private int month;
	private int year;

	public PanelDate(int month , int year) {
		this.month = month;
		this.year = year;
		
		setLayout(new GridLayout(7, 7, 0, 0));
		sun = new Cell();
		sun.setText("Su");
		add(sun);
		sun.setFont(new Font("SansSerif", Font.PLAIN, 14));

		mon = new Cell();
		mon.setText("Mo");
		add(mon);
		mon.setFont(new Font("SansSerif", Font.PLAIN, 14));

		tue = new Cell();
		tue.setText("Tu");
		add(tue);
		tue.setFont(new Font("SansSerif", Font.PLAIN, 14));

		wed = new Cell();
		wed.setText("We");
		add(wed);
		wed.setFont(new Font("SansSerif", Font.PLAIN, 14));

		thu = new Cell();
		thu.setText("Th");
		add(thu);
		thu.setFont(new Font("SansSerif", Font.PLAIN, 14));

		fri = new Cell();
		fri.setText("Fr");
		add(fri);
		fri.setFont(new Font("SansSerif", Font.PLAIN, 14));

		sat = new Cell();
		sat.setText("Sa");
		add(sat);
		sat.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell8 = new Cell();
		add(cell8);
		cell8.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell9 = new Cell();
		add(cell9);
		cell9.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell10 = new Cell();
		add(cell10);
		cell10.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell11 = new Cell();
		add(cell11);
		cell11.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell12 = new Cell();
		add(cell12);
		cell12.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell13 = new Cell();
		add(cell13);
		cell13.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell14 = new Cell();
		add(cell14);
		cell14.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell15 = new Cell();
		add(cell15);
		cell15.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell16 = new Cell();
		add(cell16);
		cell16.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell17 = new Cell();
		add(cell17);
		cell17.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell18 = new Cell();
		add(cell18);
		cell18.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell19 = new Cell();
		add(cell19);
		cell19.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell20 = new Cell();
		add(cell20);
		cell20.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell21 = new Cell();
		add(cell21);
		cell21.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell22 = new Cell();
		add(cell22);
		cell22.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell23 = new Cell();
		add(cell23);
		cell23.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell24 = new Cell();
		add(cell24);
		cell24.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell25 = new Cell();
		add(cell25);
		cell25.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell26 = new Cell();
		add(cell26);
		cell26.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell27 = new Cell();
		add(cell27);
		cell27.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell28 = new Cell();
		add(cell28);
		cell28.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell29 = new Cell();
		add(cell29);
		cell29.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell30 = new Cell();
		add(cell30);
		cell30.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell31 = new Cell();
		add(cell31);
		cell31.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell32 = new Cell();
		add(cell32);
		cell32.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell33 = new Cell();
		add(cell33);
		cell33.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell34 = new Cell();
		add(cell34);
		cell34.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell35 = new Cell();
		add(cell35);
		cell35.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell36 = new Cell();
		add(cell36);
		cell36.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell37 = new Cell();
		add(cell37);
		cell37.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell38 = new Cell();
		add(cell38);
		cell38.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell39 = new Cell();
		add(cell39);
		cell39.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell40 = new Cell();
		add(cell40);
		cell40.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell41 = new Cell();
		add(cell41);
		cell41.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell42 = new Cell();
		add(cell42);
		cell42.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell43 = new Cell();
		add(cell43);
		cell43.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell44 = new Cell();
		add(cell44);
		cell44.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell45 = new Cell();
		add(cell45);
		cell45.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell46 = new Cell();
		add(cell46);
		cell46.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell47 = new Cell();
		add(cell47);
		cell47.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell48 = new Cell();
		add(cell48);
		cell48.setFont(new Font("SansSerif", Font.PLAIN, 14));

		cell49 = new Cell();
		add(cell49);
		cell49.setFont(new Font("SansSerif", Font.PLAIN, 14));

		init();
	}

	public void init() {
		mon.asTitle();
		tue.asTitle();
		wed.asTitle();
		thu.asTitle();
		fri.asTitle();
		sat.asTitle();
		sun.asTitle();
		setDate();
	}
	
	public void setDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.YEAR,year);
		calendar.set(calendar.MONTH, month - 1); // mon jan as 0 so start from 0
		calendar.set(calendar.DATE, 1);
		int startDay = calendar.get(calendar.DAY_OF_WEEK) - 1; //  get day of week -1 to index	
		calendar.add(calendar.DATE, - startDay);
		Today today = getToday();
		for(Component com : getComponents()) {
			Cell cell = (Cell) com;
			if(!cell.isTitle()) {
				cell.setText(calendar.get(calendar.DATE) + "");
				cell.setDateTime(calendar.getTime());	
				cell.currenMonth(calendar.get(calendar.MONTH) == month -1);
				
				if(today.isToday(new Today(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)))) {
					cell.setAsDay();
				}
				calendar.add(Calendar.DATE, 1); // up 1 day
			}
		}
	}
	
	private Today getToday() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return new Today(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
	}
}
