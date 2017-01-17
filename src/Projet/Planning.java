package Projet;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Planning extends JFrame {

	public Planning(){

		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);

		JPanel pan = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
		
		pan2.add(new JLabel("Lundi "));
		pan2.add(new JLabel("Mardi "));
		pan2.add(new JLabel("Mercredi "));
		pan2.add(new JLabel("Jeudi "));
		pan2.add(new JLabel("Vendredi"));
		pan2.setLayout(new BoxLayout(pan2, BoxLayout.LINE_AXIS));
		
		pan3.setLayout( new GridLayout());
		pan3.add(new JLabel("Salle"));
		pan3.add(new JLabel("Matière"));
		pan3.add(new JLabel("Formation"));
		pan3.add(new JLabel("Promotion"));
		
		pan4.add(new JRadioButton());
		
		pan.add(pan2,BorderLayout.NORTH);
		pan.add(pan3,BorderLayout.WEST);
		pan.add(pan4,BorderLayout.EAST);
	this.setContentPane(pan);
		this.setVisible(true);
	}
}
