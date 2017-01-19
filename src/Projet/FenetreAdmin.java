package Projet;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import Projet.Graphique;

public class FenetreAdmin extends JFrame implements MouseListener{
	Promo prom = new Promo();
	Admin adm = new Admin();
	Reserver res = new Reserver();
	
	public FenetreAdmin(){
		
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(this);
		setResizable(false);
		setLocationRelativeTo(null);

		//CardLayout C1 = new CardLayout();
		//setLayout(C1);

		setTitle("Application Planning " + Graphique.loginCompte);
		
		JPanel pan1= new JPanel();
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JButton planning = new JButton("Planning");
		bar.add(planning);
		
		//****************MENU COMPTE*****************
		
		JMenu Compte = new JMenu ("Compte");
		bar.add(Compte);
		JMenuItem CreerCompte = new JMenuItem("Creer Compte");
		Compte.add(CreerCompte);	
	
		
		CreerCompte.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				adm.creeCompte();		
				
			}
		});
		
		JMenuItem ModifCompte = new JMenuItem("Modifier Compte");
		Compte.add(ModifCompte);
		ModifCompte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				adm.modifCompte();
				
			}
		});
		JMenuItem SuppCompte = new JMenuItem("Supprimer Compte");
		Compte.add(SuppCompte);
		SuppCompte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				adm.supprCompte();
				
			}
		});
		
		//***************MENU RESERVATION*********************
		
		JMenu Reservation = new JMenu("Reservation");
		bar.add(Reservation, BorderLayout.CENTER);
		JMenuItem CreerResa = new JMenuItem("Creer une Reservation");
		Reservation.add(CreerResa);
		CreerResa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				res.reserverSalle();
			}
		});
		JMenuItem ModifResa = new JMenuItem("Modifier une Reservation");
		Reservation.add(ModifResa);
		ModifResa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				res.modifResa();
			}
		});
		JMenuItem SuppResa = new JMenuItem("Supprimer une Reservation");
		Reservation.add(SuppResa);
		SuppResa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				res.supprRes();
				
			}
		});
		
		//*******************MENU SALLE********************
		
		JMenu Salle = new JMenu ("Salle");
		bar.add(Salle);
		JMenuItem Checker = new JMenuItem("Liste des Salles");
		Salle.add(Checker);
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
		
		//****************MENU ETUDIANT************************
		
		JMenu etudiant = new JMenu("Etudiant");
		bar.add(etudiant);
		JMenuItem integerApromo = new JMenuItem("Integrer a promo");
		integerApromo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prom.integrerEtudiant();
				
			}
		});
		etudiant.add(integerApromo);
		JMenuItem listeEtudiant = new JMenuItem("Liste des etudiant");
		listeEtudiant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				prom.afficheListeEtud();
				
			}
		});
		etudiant.add(listeEtudiant);
		
		//*****************MENU PROMO***************************
		
//		JMenu promo = new JMenu("Promo");
//		bar.add(promo);
//		do{
//			
//			JMenuItem afficherListe = new JMenuItem("salut"); 
//		}while(false);
//		
		
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
