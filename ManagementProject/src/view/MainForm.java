package view;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import date.CurrendarCustom;
import date.PanelDate;

import javax.swing.JLabel;

public class MainForm extends JPanel {
	CurrendarCustom date;

	public MainForm() {
		initComponents();
		setOpaque(false);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	public void showForm(Component form) {
		removeAll();
		add(form);
		repaint();
		revalidate();
	}

	private void initComponents() {

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, new Color(0, 0, 0), 250, 0, new Color(0, 0, 0));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

}
