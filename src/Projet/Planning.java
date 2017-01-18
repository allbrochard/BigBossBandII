package Projet;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Planning extends JFrame {

	public Planning(){

		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);

		Color col = new Color(180,0,0);
		
		JPanel pan2 = new JPanel();
	
		
	
		pan2.setLayout(new GridLayout(5,4));
		pan2.setBorder(null);
		JPanel logo = new JPanel();
		JLabel logo1 = new JLabel(new ImageIcon("C:/Users/Flo/Downloads/umbrella.jpg"));
	
		logo.setBackground(Color.white);
		logo.add(logo1);
		pan2.add(logo);
		
		JPanel lundi = new JPanel();
		JLabel lundi1 = new JLabel("Lundi");
		lundi.setBackground(Color.white);
		lundi.add(lundi1);
		pan2.add(lundi);
		
		JPanel mardi = new JPanel();
		JLabel mardi1= new JLabel("Mardi");
		mardi.setBackground(Color.white);
		mardi.add(mardi1);
		pan2.add(mardi);
		
		JPanel mercredi = new JPanel();
		JLabel mercredi1= new JLabel("Mercredi");
		mercredi.setBackground(Color.white);
		mercredi.add(mercredi1);
		pan2.add(mercredi);
		
		JPanel jeudi = new JPanel();
		JLabel jeudi1= new JLabel("Jeudi");
		jeudi.setBackground(Color.white);
		jeudi.add(jeudi1);
		pan2.add(jeudi);
		
		JPanel vendredi = new JPanel();
		JLabel vendredi1= new JLabel("Vendredi");
		vendredi.setBackground(Color.white);
		vendredi.add(vendredi1);
		pan2.add(vendredi);
		
		JPanel salle = new JPanel();	
		JLabel salle1= new JLabel("Salle");
		salle.setBackground(col);
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
		matiere.setBackground(col);
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
		formateur.setBackground(col);
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
		promotion.setBackground(col);
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
	//	pan.add(pan2);
	/*	pan.setLayout(new BorderLayout());
		pan.add(pan2,BorderLayout.NORTH);
		pan.add(pan2,BorderLayout.WEST);
		pan.add(pan4,BorderLayout.EAST);
	*/this.setContentPane(pan2);
		this.setVisible(true);
	}
}
