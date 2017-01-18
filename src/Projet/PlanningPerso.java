package Projet;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PlanningPerso extends JFrame {

	public PlanningPerso(){

		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(" Planning ");
		setResizable(true);
		setLocationRelativeTo(null);

		Color rouge = new Color(200,0,0);
		Color white = new Color(219,219,219);
		Color bleu = new Color(0,110,212);
		Color vert = new Color(0,150,20);
		
		JPanel pan = new JPanel();
		JPanel pan2 = new JPanel();
		/*
		JOptionPane jop = new JOptionPane("boom");
		jop.showMessageDialog(null,"Bienvenu numero 2","haut + bas + gauche + droite + bas + start",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane jop3 = new JOptionPane("boom");
		jop3.showMessageDialog(null,"Votre planning du mois arrive ","Carré, Carré, rond , bas, haut",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane jop4 = new JOptionPane("boom");
		jop4.showMessageDialog(null,"Passez une bonne journée "," on ne m'a pas éffacé",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane jop5 = new JOptionPane("boom");
		JOptionPane.showMessageDialog(null,"","La Fiesta",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("C:/Users/Flo/Downloads/patoche.jpg"));
		*/
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.setBackground(bleu);
		JLabel sem = new JLabel(" Semaine ");
		bar.add(sem);
	
		JButton but = new JButton(" Precédente");
		bar.add(but);
		JButton but2 = new JButton(" Suivante");
		bar.add(but2);
		
		bar.setLayout(new FlowLayout());
		
		
		
		pan2.setLayout(new GridLayout(6,4));
		pan2.setBorder(null);
		JPanel logo = new JPanel();
		JLabel logo1 = new JLabel(new ImageIcon("C:/Users/Flo/Downloads/umbrella.jpg"));
	
		logo.setBackground(white);
		logo.add(logo1);
		pan2.add(logo);
		
		JPanel lundi = new JPanel();
		JLabel lundi1 = new JLabel("Lundi");
		lundi.setBackground(white);
		lundi.add(lundi1);
		pan2.add(lundi);
		
		JPanel mardi = new JPanel();
		JLabel mardi1= new JLabel("Mardi");
		mardi.setBackground(white);
		mardi.add(mardi1);
		pan2.add(mardi);
		
		JPanel mercredi = new JPanel();
		JLabel mercredi1= new JLabel("Mercredi");
		mercredi.setBackground(white);
		mercredi.add(mercredi1);
		pan2.add(mercredi);
		
		JPanel jeudi = new JPanel();
		JLabel jeudi1= new JLabel("Jeudi");
		jeudi.setBackground(white);
		jeudi.add(jeudi1);
		pan2.add(jeudi);
		
		JPanel vendredi = new JPanel();
		JLabel vendredi1= new JLabel("Vendredi");
		vendredi.setBackground(white);
		vendredi.add(vendredi1);
		pan2.add(vendredi);
		
		JPanel salle = new JPanel();	
		JLabel salle1= new JLabel("Salle");
		salle1.setForeground(white);
		salle.setBackground(vert);
		salle.add(salle1);
		pan2.add(salle);
		
		JPanel b1 = new JPanel();
		pan2.add(b1);
		JPanel b2 = new JPanel();
		pan2.add(b2);
		JPanel b3 = new JPanel();
		pan2.add(b3);
		JPanel b4 = new JPanel();
		pan2.add(b4);
		JPanel b5 = new JPanel();
		pan2.add(b5);
		
		JPanel matiere = new JPanel();
		JLabel matiere1= new JLabel("Matière");
		matiere1.setForeground(white);
		matiere.setBackground(vert);
		matiere.add(matiere1);
		pan2.add(matiere);
		
		JPanel v1 = new JPanel();
		pan2.add(v1);
		JPanel v2 = new JPanel();
		pan2.add(v2);
		JPanel v3 = new JPanel();
		pan2.add(v3);
		JPanel v4 = new JPanel();
		pan2.add(v4);	
		JPanel v5 = new JPanel();
		pan2.add(v5);
		
		JPanel formateur = new JPanel();
		JLabel formateur1= new JLabel("Formateur");
		formateur1.setForeground(white);
		formateur.setBackground(vert);
		formateur.add(formateur1);
		pan2.add(formateur);
		
		JPanel d1 = new JPanel();
		pan2.add(d1);
		JPanel d2 = new JPanel();
		pan2.add(d2);
		JPanel d3 = new JPanel();
		pan2.add(d3);
		JPanel d4 = new JPanel();
		pan2.add(d4);	
		JPanel d5 = new JPanel();
		pan2.add(d5);
		
		JPanel promotion = new JPanel();
		JLabel promotion1= new JLabel("Promotion");
		promotion1.setForeground(white);
		promotion.setBackground(vert);
		promotion.add(promotion1);
		pan2.add(promotion);
		JPanel s1 = new JPanel();
		pan2.add(s1);
		JPanel s2 = new JPanel();
		pan2.add(s2);
		JPanel s3 = new JPanel();
		pan2.add(s3);
		JPanel s4 = new JPanel();
		pan2.add(s4);	
		JPanel s5 = new JPanel();
		pan2.add(s5);
	
		pan2.add(pan);
	/*	pan.setLayout(new BorderLayout());
		pan.add(pan2,BorderLayout.NORTH);
		pan.add(pan2,BorderLayout.WEST);
		pan.add(pan4,BorderLayout.EAST);
	*/this.setContentPane(pan2);
		this.setVisible(true);
	}


	public void ckeckPlan(){

		String query = "SELECT DISTINCT dateresa AS Date, nomcompte AS Professeur, nommatiere as Matiere, nompromo AS Promo, idsallefk AS Salle "
				+ "FROM public.reservation, public.compte, public.matiere, public.promo, public.salles "
				+ "WHERE reservation.idcomptefk = compte.idcompte "
				+ "AND reservation.idmatierefk = matiere.idmatiere "
				+ "AND reservation.idpromofk = promo.idpromo "
				+ "AND logcompte = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			prepare.setString(1, Graphique.loginCompte);

			prepare.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
