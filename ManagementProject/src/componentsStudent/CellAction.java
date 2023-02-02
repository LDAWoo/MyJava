package componentsStudent;

import javax.swing.JPanel;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

import animation.AnimationButtonAction;
import componentsForgot.DialogQuestion;
import componetsDialogConfirm.DialogConfirm;
import dao.ManagerLearnerCourseDAO;
import event.EventHandler;
import img.img;
import interfaces.IEvent;
import view.DialogConfirmMessage;
import view.DialogMessage;
import view.Main;
import view.MainEmployee;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;

public class CellAction extends TableCustomCell {
	private img img = new img();

	public AnimationButtonAction btnDelete;
	public AnimationButtonAction btnEdit;
	public AnimationButtonAction btnSave;

	private DialogConfirm confirm;
	private ManagerLearnerCourseDAO dao = new ManagerLearnerCourseDAO();
	private DialogQuestion question;
	private String role;

	public CellAction(String role) {
		this.role = role;
		setOpaque(false);
		setLayout(null);

		btnEdit = new AnimationButtonAction(img.iconEdit(), "");
		btnEdit.setBackground(getBackground());
		btnEdit.setBorder(null);
		btnEdit.setBounds(0, 0, 39, 39);
		add(btnEdit);

		btnDelete = new AnimationButtonAction(img.iconDelete(), "");
		btnDelete.setBorder(null);
		btnDelete.setBackground(getBackground());
		btnDelete.setBounds(40, 0, 39, 39);

		if (role == "Employee") {
			btnDelete.setVisible(false);
		}
		add(btnDelete);

	}

	public static int rowSelected = -1;

	public void addEvent(TableCustom table, TableRowData data, int row) {
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (data.isEditing()) {
					table.cancelEditRowAt(row);
					btnEdit.setIcon(img.iconEdit());
					rowSelected = -1;

				} else {
					table.editRowAt(row);
					btnEdit.setIcon(img.iconCancel());
					rowSelected = row;
				}

			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirm = new DialogConfirm(null);
				confirm.setLocation(Main.xScreen, Main.yScreen);
				confirm.setModalityType(ModalityType.APPLICATION_MODAL);
				confirm.setVisible(true);
				if (confirm.option == 1) {
					String learnerCode = table.getValueAt(getRow(), 2).toString();
					dao.Delete(learnerCode);
					table.deleteRowAt(getRow(), true);
					PanelTableStudents.cbbModelLearner.removeAllElements();
					PanelTableStudents.initCombobox();

					question = new DialogQuestion(null);
					question.setLocation(Main.xScreen, Main.yScreen);
					question.setVisible(true);
					question.lblQuestion.setText("Xóa học viên");
					question.lblTextMessage.setText("\"Thành công\"");
				}

			}
		});
	}

	public void checkIcon(TableRowData data) {
		if (data.isEditing()) {
			btnEdit.setIcon(img.iconCancel());

		} else {
			btnEdit.setIcon(img.iconEdit());
		}
	}

	@Override
	public Component createComponentCellRenderOnEditor(TableCustom table, TableRowData data, int row, int column) {

		return null;
	}

	@Override
	public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
		CellAction cell = new CellAction(role);
		cell.checkIcon(data);
		cell.addEvent(table, data, row);
		return cell;
	}

	@Override
	public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int col) {
		CellAction cell = new CellAction(role);
		cell.checkIcon(data);
		cell.addEvent(table, data, row);

		return cell;
	}

	@Override
	public Object getData() {
		return null;
	}

	@Override
	public void setData(Object arg0) {
		// TODO Auto-generated method stub

	}
}
