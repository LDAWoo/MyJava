package componentStatistical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import componentsStudent.TableHeaderCustom;
import dao.StaticalTotalScoreDAO;
import model.ModelStaticalTotalScore;
import view.ScrollBarCustom;

public class TableStaticalTableTotalScore extends JTable {
	public static DefaultTableModel tableModel;
	private ArrayList<ModelStaticalTotalScore> datas = new ArrayList<ModelStaticalTotalScore>();
	private StaticalTotalScoreDAO dao = new StaticalTotalScoreDAO();
	
	public TableStaticalTableTotalScore() {
		setOpaque(false);
		
		setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"CHUYÊN ĐỀ","TỔNG SỐ HỌC VIÊN","CAO NHẤT","THẤP NHẤT","ĐIỂM TRUNG BÌNH "
		}));
		
		tableModel = (DefaultTableModel) getModel();
		initData();
	}
	
	public void addTableStyle(JScrollPane scroll) {
		scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        setBorder(null);
        scroll.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(60, 60, 60));
        setForeground(new Color(214, 214, 214));
        setSelectionForeground(new Color(214, 214, 214));
        setSelectionBackground(new Color(50, 50, 50));
        getTableHeader().setDefaultRenderer(new TableHeaderCustom());
        setRowHeight(45);
     
        getTableHeader().setReorderingAllowed(false);
		getTableHeader().setFont(new Font("SanSerif", Font.PLAIN, 15));
		getTableHeader().setForeground(Color.decode("#84817a"));

		setIntercellSpacing(new Dimension(0, 0));
		setBackground(new Color(60,60,60));
		setFocusable(false);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
       
	}
	
	public void initData() {
		tableModel.setRowCount(0);
		datas = dao.SelectAll();
		for (ModelStaticalTotalScore data : datas) {
			Object[] rows = new Object[5];
			rows[0] = data.getNameTopic();
			rows[1] = data.getCountLearner();
			rows[2] = data.getLowestScore();
			rows[3] = data.getHighestScore();
			rows[4] = data.getMediumScore();
			tableModel.addRow(rows);
		}
	}
	
}
