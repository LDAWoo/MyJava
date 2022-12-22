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
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JPasswordField;

public class PanelTopicUpdate extends JPanel {
	private img img = new img();
	private TopicDAO dao = new TopicDAO();
	private ArrayList<ModelTopic> datas = new ArrayList<ModelTopic>();
	ImageHelper image = new ImageHelper();
	private Topic topic;
	public int indexSelectedTopic = -1;

	private byte[] personalImage;
	private String CodeTopic;
	private String NameTopic;
	private double Tuition;
	private int Timer;
	private String Describer;
	private JPanel panel;
	private JTextField txtNameTopic;
	private JTextField txtTuition;
	private JLayeredPane layeredPane;
	private AnimationButton btnFirst;
	private AnimationButton btnPrev;
	private AnimationButton btnNext;
	private AnimationButton btnLast;
	private AnimationButton btnNew;
	private AnimationButton btnAdd;
	private AnimationButton btnUpdate;
	private AnimationButton btnDelete;
	private JPanel panelNote;
	private JScrollPane scrollPane;
	private JPanel panelImg;
	private JLabel lblimg;
	private JLabel lblImg;
	private JLabel lblDesriberTopic;
	private JLabel lblThiLng;
	private JLabel lblTnChuyn;
	private JLabel lblMChuyn;
	private JLabel lblHcPh;
	private JTextField txtCodeTopic;
	private JPasswordField txtTime;
	private JTextArea textAreaDescriber;

	private Color colorTextForeground = new Color(191, 191, 191);
	private Color colorTextBackground = new Color(50, 50, 50);
	private Color colorLabel = new Color(200, 200, 200);
	private Color colorCaret = new Color(255, 255, 255);
	private Font fontText13 = new Font("SansSerif", Font.PLAIN, 13);
	private Font fontText15 = new Font("SansSerif", Font.BOLD, 15);
	private Font fontText18 = new Font("SansSerif", Font.BOLD, 18);

	public PanelTopicUpdate(Topic topic) {
		this.topic = topic;
		setOpaque(false);

		panel = new JPanel();
		panel.setBackground(new Color(60, 60, 60));

		txtNameTopic = new JTextField();
		txtNameTopic.setForeground(colorTextForeground);
		txtNameTopic.setFont(fontText13);
		txtNameTopic.setCaretColor(colorCaret);
		txtNameTopic.setBorder(null);
		txtNameTopic.setBackground(colorTextBackground);

		txtTuition = new JTextField();
		txtTuition.setForeground(colorTextForeground);
		txtTuition.setFont(fontText13);
		txtTuition.setCaretColor(colorCaret);
		txtTuition.setBorder(null);
		txtTuition.setBackground(colorTextBackground);

		layeredPane = new JLayeredPane();
		layeredPane.setOpaque(false);

		btnFirst = new AnimationButton(img.iconFisrt(), "");
		btnFirst.setForeground(SystemColor.menu);
		btnFirst.setFont(fontText18);
		btnFirst.setBorder(null);

		btnPrev = new AnimationButton(img.iconPrev1(), "");
		btnPrev.setForeground(SystemColor.menu);
		btnPrev.setFont(fontText18);
		btnPrev.setBorder(null);

		btnNext = new AnimationButton(img.iconNext1(), "");
		btnNext.setForeground(SystemColor.menu);
		btnNext.setFont(fontText18);
		btnNext.setBorder(null);

		btnLast = new AnimationButton(img.iconLast(), "");
		btnLast.setForeground(SystemColor.menu);
		btnLast.setFont(fontText18);
		btnLast.setBorder(null);

		btnNew = new AnimationButton((Icon) null, "New");
		btnNew.setForeground(SystemColor.menu);
		btnNew.setFont(fontText18);
		btnNew.setBorder(null);

		btnAdd = new AnimationButton((Icon) null, "Add");
		btnAdd.setForeground(SystemColor.menu);
		btnAdd.setFont(fontText18);
		btnAdd.setBorder(null);

		btnUpdate = new AnimationButton((Icon) null, "Update");
		btnUpdate.setForeground(SystemColor.menu);
		btnUpdate.setFont(fontText18);
		btnUpdate.setBorder(null);

		btnDelete = new AnimationButton((Icon) null, "Delete");
		btnDelete.setForeground(SystemColor.menu);
		btnDelete.setFont(fontText18);
		btnDelete.setBorder(null);
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING).addGroup(gl_layeredPane
				.createSequentialGroup().addGap(213)
				.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_layeredPane.createSequentialGroup()
								.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(37)
								.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_layeredPane.createSequentialGroup()
								.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
				.addGap(37)
				.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_layeredPane.createSequentialGroup()
								.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(37)
								.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_layeredPane.createSequentialGroup()
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(214, Short.MAX_VALUE)));
		gl_layeredPane.setVerticalGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup().addGap(11)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPrev, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(16, Short.MAX_VALUE)));
		layeredPane.setLayout(gl_layeredPane);

		panelNote = new JPanel();
		panelNote.setBorder(null);

		textAreaDescriber = new JTextArea();
		textAreaDescriber.setBackground(colorTextBackground);
		textAreaDescriber.setCaretColor(colorCaret);
		textAreaDescriber.setFont(fontText13);
		textAreaDescriber.setForeground(colorTextForeground);

		scrollPane = new JScrollPane(textAreaDescriber);
		scrollPane.setViewportBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		GroupLayout gl_panelNote = new GroupLayout(panelNote);
		gl_panelNote
				.setHorizontalGroup(gl_panelNote.createParallelGroup(Alignment.LEADING).addGap(0, 359, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE));
		gl_panelNote.setVerticalGroup(gl_panelNote.createParallelGroup(Alignment.LEADING).addGap(0, 67, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE));
		panelNote.setLayout(gl_panelNote);

		panelImg = new JPanel();
		panelImg.setLayout(null);

		lblimg = new JLabel("");
		lblimg.setOpaque(true);
		lblimg.setBackground(colorTextBackground);
		lblimg.setBounds(0, 0, 217, 257);
		panelImg.add(lblimg);

		lblImg = new JLabel("Hình:");
		lblImg.setForeground(colorLabel);
		lblImg.setFont(fontText15);

		lblDesriberTopic = new JLabel("Mô tả chuyên đề:");
		lblDesriberTopic.setForeground(new Color(200, 200, 200));
		lblDesriberTopic.setFont(fontText15);

		lblThiLng = new JLabel("Thời lượng:");
		lblThiLng.setForeground(colorLabel);
		lblThiLng.setFont(fontText15);

		lblTnChuyn = new JLabel("Tên chuyên đề:");
		lblTnChuyn.setForeground(colorLabel);
		lblTnChuyn.setFont(fontText15);

		lblMChuyn = new JLabel("Mã chuyên đề:");
		lblMChuyn.setForeground(colorLabel);
		lblMChuyn.setFont(fontText15);

		lblHcPh = new JLabel("Học phí:");
		lblHcPh.setForeground(colorLabel);
		lblHcPh.setFont(fontText15);

		txtCodeTopic = new JTextField();
		txtCodeTopic.setForeground(colorTextForeground);
		txtCodeTopic.setFont(fontText13);
		txtCodeTopic.setCaretColor(colorCaret);
		txtCodeTopic.setBorder(null);
		txtCodeTopic.setBackground(colorTextBackground);

		txtTime = new JPasswordField();
		txtTime.setForeground(colorTextForeground);
		txtTime.setFont(fontText13);
		txtTime.setCaretColor(colorCaret);
		txtTime.setBorder(null);
		txtTime.setBackground(colorTextBackground);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(10)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblImg)
										.addGroup(gl_panel.createSequentialGroup().addGap(10)
												.addComponent(panelImg, GroupLayout.PREFERRED_SIZE, 216,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(18).addGroup(
										gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblMChuyn, GroupLayout.PREFERRED_SIZE, 118,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTnChuyn).addComponent(lblHcPh).addComponent(lblThiLng)
												.addGroup(gl_panel.createSequentialGroup().addGap(18)
														.addComponent(txtTime, GroupLayout.DEFAULT_SIZE, 756,
																Short.MAX_VALUE)
														.addContainerGap())
												.addGroup(gl_panel.createSequentialGroup().addGap(18)
														.addComponent(txtTuition, GroupLayout.DEFAULT_SIZE, 756,
																Short.MAX_VALUE)
														.addContainerGap())
												.addGroup(gl_panel.createSequentialGroup().addGap(18)
														.addComponent(txtNameTopic, GroupLayout.DEFAULT_SIZE, 756,
																Short.MAX_VALUE)
														.addContainerGap())
												.addGroup(gl_panel.createSequentialGroup().addGap(18)
														.addComponent(txtCodeTopic, GroupLayout.DEFAULT_SIZE, 756,
																Short.MAX_VALUE)
														.addContainerGap())))
						.addGroup(gl_panel.createSequentialGroup().addGap(10).addComponent(lblDesriberTopic))
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addComponent(panelNote, GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
								.addContainerGap())
						.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(7)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(1)
								.addComponent(lblImg, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGap(1).addComponent(panelImg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblMChuyn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGap(9)
								.addComponent(txtCodeTopic, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGap(9)
								.addComponent(lblTnChuyn, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGap(11)
								.addComponent(txtNameTopic, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGap(11)
								.addComponent(lblHcPh, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGap(11)
								.addComponent(txtTuition, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGap(11)
								.addComponent(lblThiLng, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGap(11)
								.addComponent(txtTime, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
				.addGap(42).addComponent(lblDesriberTopic, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
				.addGap(11)
				.addComponent(panelNote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(37).addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)));
		panel.setLayout(gl_panel);
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

		byte[] Img = personalImage;

		if (dao.Insert(new ModelTopic(CodeTopic, NameTopic, Tuition, Timer, Describer, Img)) > 0) {
			JOptionPane.showMessageDialog(null, "Insert Successfully", "Insert", JOptionPane.INFORMATION_MESSAGE,
					img.iconAdd32x32());
		} else {
			JOptionPane.showMessageDialog(null, "Insert Successfully", "Insert", JOptionPane.WARNING_MESSAGE,
					img.iconAdd32x32());
		}
		topic.getModelTopic();
	}

	public void Update() {
		getTextField();
		byte[] Img = personalImage;
		
		if(personalImage == null) {
			Img = datas.get(indexSelectedTopic).getLogo();
		}

		if (dao.Update(new ModelTopic(CodeTopic, NameTopic, Tuition, Timer, Describer, Img)) > 0) {
			JOptionPane.showMessageDialog(null, "Update Successfully", "Insert", JOptionPane.INFORMATION_MESSAGE,
					img.iconEdit32x32());
		} else {
			JOptionPane.showMessageDialog(null, "Update Failed", "Insert", JOptionPane.WARNING_MESSAGE,
					img.iconEdit32x32());
		}
		topic.getModelTopic();
	}

	public void Delete() {
		CodeTopic = txtCodeTopic.getText();

		if (CodeTopic.equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa Nhập Mã Chuyên Đề Để Xóa !", "Message",
					JOptionPane.WARNING_MESSAGE, img.iconDelete32x32());
			return;
		}

		int choice = JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Chắn Muốn Xóa Không?", "Choose Option",
				JOptionPane.YES_NO_OPTION, 0, img.iconDelete32x32());

		if (choice == JOptionPane.YES_OPTION) {
			if (dao.Delete(CodeTopic) > 0) {
				JOptionPane.showMessageDialog(null, "Delete Successfully", "Delete", JOptionPane.INFORMATION_MESSAGE,
						img.iconDelete32x32());
				ClearForm();
			} else {
				JOptionPane.showMessageDialog(null, "Delete Failed", "Delete", JOptionPane.WARNING_MESSAGE,
						img.iconDelete32x32());
			}
			topic.getModelTopic();
		}

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
							}
							return f.getName().toLowerCase().endsWith(".jpg");
						}
					});

					if (fileChooser.showOpenDialog(topic) == JFileChooser.CANCEL_OPTION) {
						return;
					}

					File file = fileChooser.getSelectedFile();
					try {
						ImageIcon icon = new ImageIcon(file.getPath());
						Image img = image.resize(icon.getImage(), 217, 257);

						ImageIcon reziedIcon = new ImageIcon(img);
						lblimg.setIcon(reziedIcon);

						personalImage = image.toByteArray(img, "jpg");

					} catch (Exception e2) {
						System.out.println(e2.toString());
					}

				}
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
		g2.setPaint(new Color(60, 60, 60));
		g2.fillRect(0, 20, getSize().width, getSize().height - 20);

		g2.fillRect(45, 1, 142, 19);

		super.paintComponent(g);
	}
}
