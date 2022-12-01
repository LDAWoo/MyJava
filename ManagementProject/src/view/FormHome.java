package view;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

import model.ModelCard;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class FormHome extends JPanel {

	private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;
	ModelCard modelCard1;
	ModelCard modelCard2;
	ModelCard modelCard3;
	ModelCard modelCard4;
	
	public FormHome() {
		setOpaque(false);

		card1 = new Card();

		card2 = new Card();

		card3 = new Card();

		card4 = new Card();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(card1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(card2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(card3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(card4, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(card4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(card1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(card2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(card3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(289, Short.MAX_VALUE))
		);

		this.setLayout(layout);

		initData();
	}
	
	public void initData() {
		initCardData();
	}
	
	public void initCardData() {
		card1.setData(new ModelCard("Employee", 10, 20, null));
		card2.setData(new ModelCard("Student", 500, 50, null));
		card3.setData(new ModelCard("Topic", 5, 80, null));
		card4.setData(new ModelCard("Course", 21, 100, null));
	}
	
	
	
	
	
	
}
