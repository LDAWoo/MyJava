package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import img.img;

public class MainFormChat extends JPanel {


	public MainFormChat() {

	
	}

	public void ShowForm(Component com) {
		removeAll();
		add(com);
		repaint();
		revalidate();
	}
}
