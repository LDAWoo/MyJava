package componentsTopic;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileFilter;

import animation.AnimationButton;
import dao.TopicDAO;
import img.ImageHelper;
import img.img;
import interfaces.IEvent;
import model.ModelTopic;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Cursor;

public class PanelTopicUpdate extends JPanel {
	private JTextField txtTuition;
	private JTextField txtNameTopic;
	private JTextField txtCodeTopic;
	private JTextArea textAreaDescriber;
	private JTextField txtTime;
	private img img = new img();

	private TopicDAO dao = new TopicDAO();
	private ArrayList<ModelTopic> datas = new ArrayList<ModelTopic>();
	private JLabel lblimg;

	ImageHelper image = new ImageHelper();
	private AnimationButton btnFirst;
	private AnimationButton btnPrev;
	private AnimationButton btnNext;
	private AnimationButton btnLast;
	private AnimationButton btnDelete;
	private AnimationButton btnUpdate;
	private AnimationButton btnAdd;
	private AnimationButton btnNew;

	private Topic topic;

	public int indexSelectedTopic = -1;

	private byte[] personalImage;
	private String CodeTopic;
	private String NameTopic;
	private double Tuition;
	private int Timer;
	private String Describer;

	public PanelTopicUpdate(Topic topic) {
		this.topic = topic;
		setOpaque(false);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(93, 58, 196));

		JLabel lbldescribe = new JLabel("Mô tả chuyên đề\r\n");
		lbldescribe.setBounds(420, 215, 126, 22);
		lbldescribe.setForeground(SystemColor.menu);
		lbldescribe.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblTime = new JLabel("Thời lượng:");
		lblTime.setBounds(24, 280, 96, 22);
		lblTime.setForeground(SystemColor.menu);
		lblTime.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblCodeTopic = new JLabel("Mã chuyên đề:\r\n");
		lblCodeTopic.setBounds(420, 11, 140, 22);
		lblCodeTopic.setForeground(SystemColor.menu);
		lblCodeTopic.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblTnChuyn = new JLabel("Tên chuyên đề:");
		lblTnChuyn.setBounds(420, 82, 109, 22);
		lblTnChuyn.setForeground(SystemColor.menu);
		lblTnChuyn.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lblTuition = new JLabel("Học phí:");
		lblTuition.setBounds(420, 143, 58, 22);
		lblTuition.setForeground(SystemColor.menu);
		lblTuition.setFont(new Font("SansSerif", Font.BOLD, 15));

		txtTuition = new JTextField();
		txtTuition.setBounds(485, 167, 392, 28);
		txtTuition.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtTuition.setColumns(10);

		txtNameTopic = new JTextField();
		txtNameTopic.setBounds(485, 105, 392, 28);
		txtNameTopic.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtNameTopic.setColumns(10);

		txtCodeTopic = new JTextField();
		txtCodeTopic.setBounds(485, 35, 392, 28);
		txtCodeTopic.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtCodeTopic.setColumns(10);

		textAreaDescriber = new JTextArea();
		textAreaDescriber.setFont(new Font("SansSerif", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane(textAreaDescriber);
		scrollPane.setBounds(485, 241, 392, 97);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(-10008, -10054, 0, 0);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBackground(SystemColor.menu);

		btnFirst = new AnimationButton(img.iconFisrt(),"");
		btnFirst.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFirst.setForeground(SystemColor.menu);
		btnFirst.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnFirst.setBorder(null);
		btnFirst.setBackground(new Color(60, 22, 173));

		btnPrev = new AnimationButton(img.iconPrev1(),"");
		btnPrev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPrev.setForeground(SystemColor.menu);
		btnPrev.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnPrev.setBorder(null);
		btnPrev.setBackground(new Color(60, 22, 173));

		btnNext = new AnimationButton(img.iconNext1(),"");
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.setForeground(SystemColor.menu);
		btnNext.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNext.setBorder(null);
		btnNext.setBackground(new Color(60, 22, 173));

		btnLast = new AnimationButton(img.iconLast(),"");
		btnLast.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLast.setForeground(SystemColor.menu);
		btnLast.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnLast.setBorder(null);
		btnLast.setBackground(new Color(60, 22, 173));

		btnNew = new AnimationButton(img.iconNew(),"New");
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNew.setForeground(SystemColor.menu);
		btnNew.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNew.setBorder(null);
		btnNew.setBackground(new Color(60, 22, 173));

		btnAdd = new AnimationButton(img.iconAdd(),"Add");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setForeground(SystemColor.menu);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(60, 22, 173));

		btnUpdate = new AnimationButton(img.iconEditWhite(),"Update");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setForeground(SystemColor.menu);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(60, 22, 173));

		btnDelete = new AnimationButton(img.iconDeleteWhite(),"Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setForeground(SystemColor.menu);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(60, 22, 173));
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 900, Short.MAX_VALUE)
				.addGroup(gl_layeredPane.createSequentialGroup().addGap(158).addGroup(gl_layeredPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
								.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 125,
										GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_layeredPane.createSequentialGroup()
								.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(28).addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 125,
										GroupLayout.PREFERRED_SIZE)))));
		gl_layeredPane.setVerticalGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 103, Short.MAX_VALUE)
				.addGroup(gl_layeredPane.createSequentialGroup().addGap(11).addGroup(gl_layeredPane
						.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)).addGap(11)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))));
		layeredPane.setLayout(gl_layeredPane);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 913, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(40, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(23)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(54, Short.MAX_VALUE)));
		panel.setLayout(null);
		panel.add(scrollPane);
		panel.add(txtTuition);
		panel.add(txtNameTopic);
		panel.add(txtCodeTopic);
		panel.add(lbldescribe);
		panel.add(lblCodeTopic);
		panel.add(lblTnChuyn);
		panel.add(lblTuition);
		panel.add(lblTime);
		panel.add(lblLogo);

		txtTime = new JTextField();
		txtTime.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtTime.setColumns(10);
		txtTime.setBounds(54, 305, 357, 28);
		panel.add(txtTime);

		JLabel lblImg = new JLabel("Logo:");
		lblImg.setForeground(SystemColor.menu);
		lblImg.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblImg.setBounds(10, 11, 49, 22);
		panel.add(lblImg);

		JPanel panelImg = new JPanel();
		panelImg.setLayout(null);
		panelImg.setBounds(54, 11, 217, 257);
		panel.add(panelImg);

		lblimg = new JLabel("");
		lblimg.setIcon(img.ImageWhite());
		lblimg.setBounds(0, 0, 217, 257);
		panelImg.add(lblimg);
		setLayout(groupLayout);

		Action();

		IEvent<ArrayList<ModelTopic>> event = this::OnModelTopicChanged;
		topic.ModelTopicChanged.subscribe(event);

	}

	public void OnModelTopicChanged(Object sourse, ArrayList<ModelTopic> eventArgs) {
		datas = eventArgs;
	}

	public void ClearForm() {
		txtCodeTopic.setText("");
		txtNameTopic.setText("");
		txtTuition.setText("");
		txtTime.setText("");
		textAreaDescriber.setText("");
		lblimg.setIcon(img.ImageWhite());
	}

	public void Display(int index) {
		String CodeTopic = datas.get(index).getCodeTopic();
		String NameTopic = datas.get(index).getNameTopic();
		double Tuition = datas.get(index).getTuition();
		int Timer = datas.get(index).getTime();
		String Describer = datas.get(index).getDescriber();
		byte[] imageTopic = datas.get(index).getLogo();

		txtCodeTopic.setText(CodeTopic);
		txtNameTopic.setText(NameTopic);
		txtTuition.setText(Tuition + "");
		txtTime.setText(Timer + "");
		textAreaDescriber.setText(Describer);

		try {
			Image icon = image.createImageFromByteArray(imageTopic, "jpg");

			lblimg.setIcon(new ImageIcon(icon));
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}

	public void getTextField() {
		CodeTopic = txtCodeTopic.getText();
		NameTopic = txtNameTopic.getText();
		Tuition = Double.parseDouble(txtTuition.getText());
		Timer = Integer.parseInt(txtTime.getText());
		Describer = textAreaDescriber.getText();
	}

	public void Add() {
		getTextField();
		if (dao.Insert(new ModelTopic(CodeTopic, NameTopic, Tuition, Timer, Describer, personalImage)) > 0) {
			JOptionPane.showMessageDialog(topic, "Insert Successfully", "Insert", JOptionPane.INFORMATION_MESSAGE,
					img.iconAdd32x32());
		} else {
			JOptionPane.showMessageDialog(topic, "Insert Failed", "Insert", JOptionPane.INFORMATION_MESSAGE,
					img.iconAdd32x32());
		}
		topic.getModelTopic();
	}

	public void Update() {
		String CodeTopic = txtCodeTopic.getText();
		String NameTopic = txtNameTopic.getText();
		double Tuition = Double.parseDouble(txtTuition.getText());
		int Timer = Integer.parseInt(txtTime.getText());
		String Describer = textAreaDescriber.getText();
		byte[] image = personalImage;

		if (dao.Update(new ModelTopic(CodeTopic, NameTopic, Tuition, Timer, Describer, image)) > 0) {
			JOptionPane.showMessageDialog(topic, "Update Successfully", "Update", JOptionPane.INFORMATION_MESSAGE,
					img.iconEdit32x32());
		} else {
			JOptionPane.showMessageDialog(topic, "Update Failed", "Update", JOptionPane.WARNING_MESSAGE,
					img.iconEdit32x32());
		}
		topic.getModelTopic();
	}

	public void Delete() {
		String CodeTopic = txtCodeTopic.getText();
		if (CodeTopic.equals("")) {
			JOptionPane.showMessageDialog(topic, "Chưa Nhập Mã Nhân Viên Để Xóa !", "Message",
					JOptionPane.WARNING_MESSAGE, img.iconDelete32x32());
			return;
		}

		int choice = JOptionPane.showConfirmDialog(topic, "Bạn Có Chắc Chắn Muốn Xóa Không ?", "Delete", 0,
				JOptionPane.YES_NO_OPTION, img.iconDelete32x32());
		if (choice == JOptionPane.YES_OPTION) {
			if (dao.Delete(CodeTopic) > 0) {
				JOptionPane.showMessageDialog(topic, "Delete Successfully", "Delete", JOptionPane.INFORMATION_MESSAGE,
						img.iconDelete32x32());
				ClearForm();
			} else {
				JOptionPane.showMessageDialog(topic, "Delete Failed", "Delete", JOptionPane.WARNING_MESSAGE,
						img.iconDelete32x32());
			}
		}
		topic.getModelTopic();
	}

	public void Action() {

		lblimg.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileFilter(new FileFilter() {

						@Override
						public String getDescription() {
							return "Image File (*.jpg)";
						}

						@Override
						public boolean accept(File f) {
							if (f.isDirectory()) {
								return true;
							} else {
								return f.getName().toLowerCase().endsWith(".jpg");
							}
						}
					});
					if (fileChooser.showOpenDialog(topic) == JFileChooser.CANCEL_OPTION) {
						return;
					}

					File file = fileChooser.getSelectedFile();
					try {
						ImageIcon icon = new ImageIcon(file.getPath());
						Image img = image.resize(icon.getImage(), 217, 257);

						ImageIcon resizedIcon = new ImageIcon(img);
						lblimg.setIcon(resizedIcon);

						personalImage = image.toByteArray(img, "jpg");
					} catch (Exception e2) {
						System.out.println("Error: " + e2.toString());
					}
				}
			}
		});

		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClearForm();

			}
		});

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Add();

			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Update();

			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Delete();

			}
		});

		btnFirst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				First();

			}
		});

		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Prev();

			}
		});

		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Next();

			}
		});

		btnLast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Last();

			}
		});

	}

	public void First() {
		btnPrev.setEnabled(false);
		btnNext.setEnabled(true);
		indexSelectedTopic = 0;
		Display(indexSelectedTopic);
	}

	public void Prev() {
		if (indexSelectedTopic > 0) {
			indexSelectedTopic--;
			if (indexSelectedTopic == 0) {
				btnPrev.setEnabled(false);
				btnNext.setEnabled(true);
			} else {
				btnPrev.setEnabled(true);
				btnNext.setEnabled(true);
			}
		}

		Display(indexSelectedTopic);
	}

	public void Next() {
		if (indexSelectedTopic < datas.size() - 1) {
			indexSelectedTopic++;
			if (indexSelectedTopic == datas.size() - 1) {
				btnNext.setEnabled(false);
				btnPrev.setEnabled(true);
			} else {
				btnNext.setEnabled(true);
				btnPrev.setEnabled(true);
			}
		}

		Display(indexSelectedTopic);

	}

	public void Last() {
		btnNext.setEnabled(false);
		btnPrev.setEnabled(true);
		indexSelectedTopic = datas.size() - 1;
		Display(indexSelectedTopic);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new Color(93, 58, 196));
		g2.fillRect(0, 20, getSize().width, getSize().height - 20);

		g2.fillRect(45, 1, 142, 19);

		super.paintComponent(g);
	}
}
