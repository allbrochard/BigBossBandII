package Projet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FenetreAdmin extends JFrame implements MouseListener{

	public FenetreAdmin(){
		
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(this);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel pan1= new JPanel();

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JButton planning = new JButton("Planning");
		bar.add(planning);
		
		JMenu Compte = new JMenu ("Compte");
		bar.add(Compte);
		JMenuItem CreerCompte = new JMenuItem("Creer Compte");
		Compte.add(CreerCompte);
		JMenuItem ModifCompte = new JMenuItem("Modifier Compte");
		Compte.add(ModifCompte);
		JMenuItem SuppCompte = new JMenuItem("Supprimer Compte");
		Compte.add(SuppCompte);
		
		JMenu Salle = new JMenu ("Salle");
		bar.add(Salle);
		JMenuItem CreerSalle = new JMenuItem("Creer Salle");
		Salle.add(CreerSalle);
		JMenu SuppSalle = new JMenu("Supprimer Salle");
		Salle.add(SuppSalle);
		JMenuItem BurnSalle = new JMenuItem("Bruler Salle");
		SuppSalle.add(BurnSalle);
		JMenuItem DematSalle = new JMenuItem("Dematerialiser Salle");
		SuppSalle.add(DematSalle);
		JMenuItem Dim = new JMenuItem("Changer de Dimension");
		SuppSalle.add(Dim);
		
		
		this.setContentPane(pan1);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
