package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.ScoreStudentDAO;
import model.ModelScoreStudent;
import view.ScrollBarCustom;

public class TableScoreStudent extends JTable {
	public static DefaultTableModel tableModel;
	
	private ArrayList<ModelScoreStudent> datas = new ArrayList<ModelScoreStudent>();
	private ScoreStudentDAO dao = new ScoreStudentDAO();
	private String email;
	
	public String subject;
	
	public TableScoreStudent(String email) {
		this.email = email;
		setOpaque(false);
		
		setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"#","Kỳ","Học kỳ","Môn","Mã môn","Mã chuyển đổi","Số tín chỉ","Điểm","Trạng thái"
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
        
        
        getColumnModel().getColumn(0).setPreferredWidth(20);
        getColumnModel().getColumn(1).setPreferredWidth(20);
        getColumnModel().getColumn(2).setPreferredWidth(30);
        getColumnModel().getColumn(3).setPreferredWidth(200);
        getColumnModel().getColumn(4).setPreferredWidth(50);
        getColumnModel().getColumn(5).setPreferredWidth(50);
        getColumnModel().getColumn(6).setPreferredWidth(20);
        getColumnModel().getColumn(7).setPreferredWidth(20);
        getColumnModel().getColumn(8).setPreferredWidth(20);
	}
	
	public void initData() {
		tableModel.setRowCount(0);
		datas =dao.SelectScoreStudents(email);

		for (ModelScoreStudent data : datas) {
			Object[] rows = new Object[10];
			rows[0] = data.getId();
			rows[1] = data.getPeriod();
			rows[2] = data.getSemester();
			rows[3] = data.getSubject();
			rows[4] = data.getSubjectCode();
			rows[5] = data.getConversionCode();
			rows[6] = data.getNumberOfCredits();
			rows[7] = data.getScores();
			rows[8] = data.getStatus();	
			tableModel.addRow(rows);
			
			subject = rows[3].toString();
		}
	}
	
}
