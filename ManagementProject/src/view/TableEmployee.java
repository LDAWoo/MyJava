package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import dao.EmployeeDAO;
import interfaces.IEvent;
import model.ModelEmployee;
import view.ScrollBarCustom;


public class TableEmployee extends JTable {
	public static DefaultTableModel tableModel;
	private EmployeeDAO dao = new EmployeeDAO();

	
	
	private ArrayList<ModelEmployee> datas = new ArrayList<ModelEmployee>();

	public TableEmployee(Employee employee) {
		setOpaque(false);
		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MÃ NV", "HỌ VÀ TÊN", "NGÀY SINH", "GIỚI TÍNH","EMAIL",
				"VAI TRÒ", "MẬT KHẨU", "NGÀY T GIA","GHI CHÚ"

		}));
		tableModel = (DefaultTableModel) getModel();
	
		


		IEvent<ArrayList<ModelEmployee>> a = this::OnModelEmployeeChanged;
		employee.ModelEmployeeChanged.subscribe(a);
	}

	public void OnModelEmployeeChanged(Object source, ArrayList<ModelEmployee> eventArgs) {
		datas = eventArgs;
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
		
        
        getColumnModel().getColumn(0).setPreferredWidth(10);
        getColumnModel().getColumn(1).setPreferredWidth(100);
        getColumnModel().getColumn(2).setPreferredWidth(30);
        getColumnModel().getColumn(3).setPreferredWidth(10);
        getColumnModel().getColumn(4).setPreferredWidth(150);
        getColumnModel().getColumn(5).setPreferredWidth(50);
        getColumnModel().getColumn(6).setPreferredWidth(30);
        getColumnModel().getColumn(7).setPreferredWidth(50);
	}
	
	public void addRow(Object[] row) {
		tableModel.addRow(row);
	}
	
	private void initData() {
		tableModel.getDataVector().removeAllElements();
		for (ModelEmployee data : datas) {
			Object[] rows = new Object[10];
			rows[0] = data.getCodeEmployee();
			rows[1] = data.getName();	
			rows[2] = data.getDate();	
			if(data.isSex()) {
				rows[3] = "Nam";
			}else {
				rows[3] = "Nữ";
			}
			rows[4] = data.getEmail();
			rows[5] = data.getRole();
			rows[6] = data.getPassword();
			rows[7] = data.getDateOpening();
			rows[8] = data.getNote();	
			addRow(rows);
		}
		
		
		
		
	}

	
	public ArrayList<ModelEmployee> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<ModelEmployee> datas) {
		this.datas = datas;
	}
	
	
}
