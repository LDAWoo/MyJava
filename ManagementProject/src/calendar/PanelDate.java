package calendar;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.Calendar;

public class PanelDate extends JPanel {
	Cell mon;
	private Cell sat;
	private Cell thu;
	private Cell wed;
	private Cell tue;
	private Cell fri;
	private Cell sun;
	private int month;
	private int year;
	
	public PanelDate(int month , int year) {
		this.month = month;
		this.year = year;
		
		setLayout(new GridLayout(7, 7, 0, 0));
		
		 sun = new Cell();
		sun.setText("Sun");
		add(sun);

		
		mon = new Cell();
		mon.setText("Mon");
		
		add(mon);
		
		tue = new Cell();
		tue.setText("Tue");
		add(tue);
		
		 wed = new Cell();
		wed.setText("Wed");
		add(wed);
		
		 thu = new Cell();
		thu.setText("Thu");
		add(thu);
		
		fri = new Cell();
		fri.setText("Fri");
		add(fri);
		
		 sat = new Cell();
		sat.setText("Sat");
		add(sat);
		
		Cell cell1 = new Cell();
		add(cell1);
		
		Cell cell2 = new Cell();
		add(cell2);
		
		Cell cell3 = new Cell();
		add(cell3);
		
		Cell cell4 = new Cell();
		add(cell4);
		
		Cell cell5 = new Cell();
		add(cell5);
		
		Cell cell6 = new Cell();
		add(cell6);
		
		Cell cell7 = new Cell();
		add(cell7);
		
		Cell cell8 = new Cell();
		add(cell8);
		
		Cell cell9 = new Cell();
		add(cell9);
		
		Cell cell10 = new Cell();
		add(cell10);
		
		Cell cell11 = new Cell();
		add(cell11);
		
		Cell cell12 = new Cell();
		add(cell12);
		
		Cell cell13 = new Cell();
		add(cell13);
		
		Cell cell14 = new Cell();
		add(cell14);
		
		Cell cell15 = new Cell();
		add(cell15);
		
		Cell cell16 = new Cell();
		add(cell16);
		
		Cell cell17 = new Cell();
		add(cell17);
		
		Cell cell18 = new Cell();
		add(cell18);
		
		Cell cell19 = new Cell();
		add(cell19);
		
		Cell cell20 = new Cell();
		add(cell20);
		
		Cell cell21 = new Cell();
		add(cell21);
		
		Cell cell22 = new Cell();
		add(cell22);
		
		Cell cell23 = new Cell();
		add(cell23);
		
		Cell cell24 = new Cell();
		add(cell24);
		
		Cell cell25 = new Cell();
		add(cell25);
		
		Cell cell26 = new Cell();
		add(cell26);
		
		Cell cell28 = new Cell();
		add(cell28);
		
		Cell cell29 = new Cell();
		add(cell29);
		
		Cell cell30 = new Cell();
		add(cell30);
		
		Cell cell31 = new Cell();
		add(cell31);
		
		Cell cell32 = new Cell();
		add(cell32);
		
		Cell cell33 = new Cell();
		add(cell33);
		
		Cell cell27 = new Cell();
		add(cell27);
		
		Cell cell34 = new Cell();
		add(cell34);
		
		Cell cell35 = new Cell();
		add(cell35);
		
		Cell cell36 = new Cell();
		add(cell36);
		
		Cell cell37 = new Cell();
		add(cell37);
		
		Cell cell38 = new Cell();
		add(cell38);
		
		Cell cell39 = new Cell();
		add(cell39);
		
		Cell cell40 = new Cell();
		add(cell40);
		
		Cell cell41 = new Cell();
		add(cell41);
		
		Cell cell42 = new Cell();
		add(cell42);
		
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

	private void setDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DATE, 1);
		
		int starDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		calendar.add(Calendar.DATE, -starDay);
		
		for (Component com : getComponents()) {
			Cell cell = (Cell)com;
			if(!cell.isTitle()) {
				cell.setText(calendar.get(Calendar.DATE) + "");
				cell.setDate(calendar.getTime());
				cell.currenMonth(calendar.get(Calendar.MONTH) == month - 1);
				calendar.add(Calendar.DATE, 1);
			}
		}
	}
	
}
