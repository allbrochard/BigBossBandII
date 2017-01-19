package Projet;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
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
		pan2.setLayout(new BoxLayout(pan2,BoxLayout.LINE_AXIS));
		JPanel pan3 = new JPanel();
		pan3.setLayout(new BoxLayout(pan3,BoxLayout.LINE_AXIS));
		JLabel ui = new JLabel("ui ui");
		pan3.add(ui);
		JPanel pan4 = new JPanel();
		pan4.setLayout(new BoxLayout(pan4,BoxLayout.LINE_AXIS));
		JPanel pan5 = new JPanel();
		pan5.setLayout(new BoxLayout(pan5,BoxLayout.LINE_AXIS));
		JPanel pan6 = new JPanel();
		pan6.setLayout(new BoxLayout(pan6,BoxLayout.LINE_AXIS));
		JPanel pan7 = new JPanel();
		pan7.setLayout(new BoxLayout(pan7,BoxLayout.LINE_AXIS));
		JPanel pan8 = new JPanel();
		pan8.setLayout(new BoxLayout(pan8,BoxLayout.LINE_AXIS));
		
		
		pan.setLayout(new BoxLayout(pan,BoxLayout.PAGE_AXIS));
	
		JOptionPane jop = new JOptionPane("boom");
		jop.showMessageDialog(null,"Bienvenu numero 2","haut + bas + gauche + droite + bas + start",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane jop3 = new JOptionPane("boom");
		jop3.showMessageDialog(null,"Votre planning du mois arrive ","Carré, Carré, rond , bas, haut",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane jop4 = new JOptionPane("boom");
		jop4.showMessageDialog(null,"Passez une bonne journée "," on ne m'a pas éffacé",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane jop5 = new JOptionPane("boom");
		JOptionPane.showMessageDialog(null,"","La Fiesta",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("C:/Users/Flo/Downloads/patoche.jpg"));
		
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

		
	
		pan2.setBorder(null);
		JPanel logo = new JPanel();
		JLabel logo1 = new JLabel(new ImageIcon("C:/Users/Flo/Downloads/umbrella.jpg"));
		pan2.add(logo);
		logo.setBackground(white);
		logo.add(logo1);
		pan2.add(logo);
	
		JPanel lundi = new JPanel();
		JLabel lundi1 = new JLabel("Lundi");
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
		
	
		pan.add(pan2, BorderLayout.NORTH);
		pan.add(pan8,BorderLayout.SOUTH);
		pan8.add(pan3);
		pan8.add(pan4);
		pan8.add(pan5);
		pan8.add(pan6);
		pan8.add(pan7);
		this.setContentPane(pan);
		this.setVisible(true);
	}


	public void ckeckPlan(){

		String query = "SELECT DISTINCT dateresa, nomcompte, nommatiere, nompromo, idsallefk "
				+ "FROM public.reservation, public.compte, public.matiere, public.promo, public.salles "
				+ "WHERE reservation.idcomptefk = compte.idcompte "
				+ "AND reservation.idmatierefk = matiere.idmatiere "
				+ "AND reservation.idpromofk = promo.idpromo "
				+ "AND logcompte = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			

			prepare.setString(1, Graphique.loginCompte);
			prepare.execute();
			
			ResultSet result = prepare.getResultSet();
			while(result.next()){         
				for(int i = 1; i <= 5; i++)
					infoEtude = infoEtude + result.getObject(i).toString() + " ";
					listeEtude = new JLabel(infoEtude);
					System.out.println(infoEtude);
					infoEtude = "";

					System.out.println("test");

					resultat.add(listeEtude);

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
