package date;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
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
	public Cell cell8;
	public Cell cell9;
	public Cell cell10;
	public Cell cell11;
	public Cell cell12;
	public Cell cell13;
	public Cell cell14;
	public Cell cell15;
	public Cell cell16;
	public Cell cell17;
	public Cell cell18;
	public Cell cell19;
	public Cell cell20;
	public Cell cell21;
	public Cell cell22;
	public Cell cell23;
	public Cell cell24;
	public Cell cell25;
	public Cell cell26;
	public Cell cell27;
	public Cell cell28;
	public Cell cell29;
	public Cell cell30;
	public Cell cell31;
	public Cell cell32;
	public Cell cell33;
	public Cell cell34;
	public Cell cell35;
	public Cell cell36;
	public Cell cell37;
	public Cell cell38;
	public Cell cell39;
	public Cell cell40;
	public Cell cell41;
	public Cell cell42;
	public Cell cell43;
	public Cell cell44;
	public Cell cell45;
	public Cell cell46;
	public Cell cell47;
	public Cell cell48;
	public Cell cell49;
	
	private int month;
	private int year;

	public PanelDate(int month , int year) {
		this.month = month;
		this.year = year;
		
		setLayout(new GridLayout(7, 7, 0, 0));
		sun = new Cell();
		sun.setText("Su");
		add(sun);


		mon = new Cell();
		mon.setText("Mo");
		add(mon);


		tue = new Cell();
		tue.setText("Tu");
		add(tue);

		wed = new Cell();
		wed.setText("We");
		add(wed);


		thu = new Cell();
		thu.setText("Th");
		add(thu);


		fri = new Cell();
		fri.setText("Fr");
		add(fri);


		sat = new Cell();
		sat.setText("Sa");
		add(sat);


		cell8 = new Cell();
		add(cell8);
	

		cell9 = new Cell();
		add(cell9);
		

		cell10 = new Cell();
		add(cell10);
		

		cell11 = new Cell();
		add(cell11);
		

		cell12 = new Cell();
		add(cell12);
		

		cell13 = new Cell();
		add(cell13);
	

		cell14 = new Cell();
		add(cell14);
		

		cell15 = new Cell();
		add(cell15);
		

		cell16 = new Cell();
		add(cell16);
		

		cell17 = new Cell();
		add(cell17);
		

		cell18 = new Cell();
		add(cell18);
		

		cell19 = new Cell();
		add(cell19);
		

		cell20 = new Cell();
		add(cell20);
		

		cell21 = new Cell();
		add(cell21);
		

		cell22 = new Cell();
		add(cell22);
		

		cell23 = new Cell();
		add(cell23);
		

		cell24 = new Cell();
		add(cell24);
		

		cell25 = new Cell();
		add(cell25);
		

		cell26 = new Cell();
		add(cell26);
		

		cell27 = new Cell();
		add(cell27);
		

		cell28 = new Cell();
		add(cell28);
		

		cell29 = new Cell();
		add(cell29);
		

		cell30 = new Cell();
		add(cell30);
		

		cell31 = new Cell();
		add(cell31);
		

		cell32 = new Cell();
		add(cell32);
		

		cell33 = new Cell();
		add(cell33);
		

		cell34 = new Cell();
		add(cell34);
		

		cell35 = new Cell();
		add(cell35);
		

		cell36 = new Cell();
		add(cell36);
		

		cell37 = new Cell();
		add(cell37);
		

		cell38 = new Cell();
		add(cell38);
		

		cell39 = new Cell();
		add(cell39);
		

		cell40 = new Cell();
		add(cell40);
		

		cell41 = new Cell();
		add(cell41);
		

		cell42 = new Cell();
		add(cell42);
		

		cell43 = new Cell();
		add(cell43);
		

		cell44 = new Cell();
		add(cell44);
		

		cell45 = new Cell();
		add(cell45);
	

		cell46 = new Cell();
		add(cell46);
		

		cell47 = new Cell();
		add(cell47);
	

		cell48 = new Cell();
		add(cell48);
	

		cell49 = new Cell();
		add(cell49);

		
		
		setBackground(new Color(60,60,60));
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
