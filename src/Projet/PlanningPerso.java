package Projet;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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


	String jour, infoPlan = "";
	JPanel pan = new JPanel();
	JPanel semaine = new JPanel();
	JPanel pan3 = new JPanel();
	JPanel pan4 = new JPanel();
	JPanel pan5 = new JPanel();
	JPanel pan6 = new JPanel();
	JPanel pan7 = new JPanel();
	JPanel pan8 = new JPanel();
	JLabel lab = new JLabel();
	JPanel lundi;
	JPanel mardi;
	JPanel mercredi;
	JPanel jeudi;
	JPanel vendredi;

	public PlanningPerso(){

		setSize(800,600);
		//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(" Planning ");
		setResizable(true);
		setLocationRelativeTo(null);

		Color rouge = new Color(200,0,0);
		Color white = new Color(219,219,219);
		Color bleu = new Color(0,110,212);
		Color vert = new Color(0,150,20);

		semaine.setLayout(new BoxLayout(semaine,BoxLayout.LINE_AXIS));
		lundi.setLayout(new BoxLayout(pan3,BoxLayout.PAGE_AXIS));
		mardi.setLayout(new BoxLayout(pan4,BoxLayout.PAGE_AXIS));
		mercredi.setLayout(new BoxLayout(pan5,BoxLayout.PAGE_AXIS));
		jeudi.setLayout(new BoxLayout(pan6,BoxLayout.PAGE_AXIS));
		vendredi.setLayout(new BoxLayout(pan7,BoxLayout.PAGE_AXIS));
		pan8.setLayout(new BoxLayout(pan8,BoxLayout.LINE_AXIS));

		semaine.setSize(new Dimension(800,100));
		pan8.setSize(new Dimension(800,500));
		pan.setLayout(new BoxLayout(pan,BoxLayout.PAGE_AXIS));
		/**
//		JOptionPane jop = new JOptionPane("boom");
//		jop.showMessageDialog(null,"Bienvenu numero 2","haut + bas + gauche + droite + bas + start",JOptionPane.INFORMATION_MESSAGE);
//		JOptionPane jop3 = new JOptionPane("boom");
//		jop3.showMessageDialog(null,"Votre planning du mois arrive ","Carré, Carré, rond , bas, haut",JOptionPane.INFORMATION_MESSAGE);
//		JOptionPane jop4 = new JOptionPane("boom");
//		jop4.showMessageDialog(null,"Passez une bonne journée "," on ne m'a pas éffacé",JOptionPane.INFORMATION_MESSAGE);
//		JOptionPane jop5 = new JOptionPane("boom");
//		JOptionPane.showMessageDialog(null,"","La Fiesta",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("C:/Users/Flo/Downloads/patoche.jpg"));
//		
//		JMenuBar bar = new JMenuBar();
//		setJMenuBar(bar);
//		bar.setBackground(bleu);
//		JLabel sem = new JLabel(" Semaine ");
//		bar.add(sem);
//	
//		JButton but = new JButton(" Precédente");
//		bar.add(but);
//		JButton but2 = new JButton(" Suivante");
//		bar.add(but2);
//		
//		bar.setLayout(new FlowLayout());

		 **/

		semaine.setBorder(null);
		JPanel logo = new JPanel();
		JLabel logo1 = new JLabel(new ImageIcon("C:/Users/Flo/Downloads/umbrella.jpg"));
		semaine.add(logo);
		logo.setBackground(white);
		logo.add(logo1);
		semaine.add(logo);

		lundi = new JPanel();
		JLabel lundi1 = new JLabel("Lundi");
		//lundi.setBackground(white);
		lundi.add(lundi1);
		semaine.add(lundi);


		mardi = new JPanel();
		JLabel mardi1= new JLabel("Mardi");
		mardi.setBackground(white);
		mardi.add(mardi1);
		semaine.add(mardi);



		mercredi = new JPanel();
		JLabel mercredi1= new JLabel("Mercredi");
		//mercredi.setBackground(white);
		mercredi.add(mercredi1);
		semaine.add(mercredi);


		jeudi = new JPanel();
		JLabel jeudi1= new JLabel("Jeudi");
		jeudi.setBackground(white);
		jeudi.add(jeudi1);
		semaine.add(jeudi);


		vendredi = new JPanel();
		JLabel vendredi1= new JLabel("Vendredi");
		//vendredi.setBackground(white);
		vendredi.add(vendredi1);
		semaine.add(vendredi);

		checkPlan();

		pan.add(semaine);
		
//		pan8.add(pan3);
//		pan8.add(pan4);
//		pan8.add(pan5);
//		pan8.add(pan6);
//		pan8.add(pan7);
		pan.add(pan8);
		pan.setVisible(true);
		this.setContentPane(pan);
		this.setVisible(true);
	}


	public void checkPlan(){
		String query;

		//pour les ETUDIANT!!!!!
		
		if(Graphique.typeCompte.equals("etudiant")){
			query = "SELECT DISTINCT dateresa, nomcompte, nommatiere, nompromo, idsallefk "
					+ "FROM public.reservation, public.compte, public.matiere, public.promo, public.salles "
					+ "WHERE reservation.idcomptefk = compte.idcompte "
					+ "AND reservation.idmatierefk = matiere.idmatiere "
					+ "AND reservation.idpromofk = promo.idpromo "
					+ "AND nompromo = ?;";
	}
		//Pour les prof !!!!
		//(Graphique.typeCompte.equals("formateur"))
		else{
			query = "SELECT DISTINCT dateresa, nomcompte, nommatiere, nompromo, idsallefk "
					+ "FROM public.reservation, public.compte, public.matiere, public.promo, public.salles "
					+ "WHERE reservation.idcomptefk = compte.idcompte "
					+ "AND reservation.idmatierefk = matiere.idmatiere "
					+ "AND reservation.idpromofk = promo.idpromo "
					+ "AND logcompte = ?;";
	}
		
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


			//Pour les prof !!!!
			
			if(Graphique.typeCompte.equals("formateur")){
			prepare.setString(1, Graphique.loginCompte);
		}
			//pour les ETUDIANT!!!!!
			if(Graphique.typeCompte.equals("etudiant")){
			prepare.setString(1, Graphique.nomPromo);
		}
			
			
			prepare.execute();

			ResultSet result = prepare.getResultSet();
			System.out.println("first");

			while(result.next()){
			System.out.println("bonjour");
			//if(result.first()){
				jour = result.getString(1);
				//System.out.println(jour);
			//}
			//jour = result.getString(1);
			/**
			 * permet de placer la reservation sur le bon jour dans le planning
			 */
				switch(jour){
				case "Lundi":
					
					lab = new JLabel("");  
						for(int i = 2; i <= 5; i++){
							infoPlan = infoPlan + result.getObject(i).toString() + " ";
						lab = new JLabel(infoPlan);
						System.out.println(infoPlan);
						infoPlan = "";
						
						System.out.println("test");

						lundi.add(lab);

						}
					break;

				case "Mardi":
					lab = new JLabel("");      
						for(int i = 2; i <= 5; i++){
							infoPlan = infoPlan + result.getObject(i).toString() + " ";
						lab = new JLabel(infoPlan);
						System.out.println(infoPlan);
						infoPlan = "";

						System.out.println("test");
						
						mardi.add(lab);
						}
					
					break;

				case "Mercredi":
					lab = new JLabel("");        
						for(int i = 2; i <= 5; i++){
							infoPlan = infoPlan + result.getObject(i).toString() + " ";
						lab = new JLabel(infoPlan);
						System.out.println(infoPlan);
						infoPlan = "";

						System.out.println("test");

						mercredi.add(lab);

					}
					break;

				case "Jeudi":
					lab = new JLabel("");       

						for(int i = 2; i <= 5; i++){
							infoPlan = infoPlan + result.getObject(i).toString() + " ";
						lab = new JLabel(infoPlan);
						System.out.println(infoPlan);
						infoPlan = "";

						System.out.println("test");

						jeudi.add(lab);

					}
					break;

				case "Vendredi":
					lab = new JLabel("");       

						for(int i = 2; i <= 5; i++){
							infoPlan = infoPlan + result.getObject(i).toString() + " ";
						lab = new JLabel(infoPlan);
						System.out.println(infoPlan);
						infoPlan = "";

						System.out.println("test");

						vendredi.add(lab);

					}
					break;
				default:{	JOptionPane pope = new JOptionPane("attention");
				pope.showMessageDialog(null,"ERREUR 404","",JOptionPane.ERROR_MESSAGE);}
				jour="";
				}
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

 
	//	public void parcourirTable(PreparedStatement prepare, JLabel lab, JPanel pan){
	//		
	//		ResultSet result = prepare.getResultSet();
	//		while(result.next()){         
	//			for(int i = 1; i <= 5; i++)
	//				infoPlan = infoPlan + result.getObject(i).toString() + " ";
	//				lab = new JLabel(infoPlan);
	//				System.out.println(infoPlan);
	//				infoPlan = "";
	//				System.out.println("test");
	//
	//				pan.add(lab);
	//
	//		}
	//	}

	//	public void selectionDay(String a, PreparedStatement prepare){
	//		switch(a){
	//		case "Lundi":
	//			ResultSet result = prepare.getResultSet();
	//			while(result.next()){         
	//				for(int i = 1; i <= 5; i++)
	//					infoPlan = infoPlan + result.getObject(i).toString() + " ";
	//					lab = new JLabel(infoPlan);
	//					System.out.println(infoPlan);
	//					infoPlan = "";
	//
	//					System.out.println("test");
	//
	//					pan.add(lab);
	//
	//			}
	//			break;
	//		case "Mardi":
	//			ResultSet result = prepare.getResultSet();
	//			while(result.next()){         
	//				for(int i = 1; i <= 5; i++)
	//					infoPlan = infoPlan + result.getObject(i).toString() + " ";
	//					lab = new JLabel(infoPlan);
	//					System.out.println(infoPlan);
	//					infoPlan = "";
	//
	//					System.out.println("test");
	//
	//					pan.add(lab);
	//
	//			}
	//			break;
	//		case "Mercredi":
	//			ResultSet result = prepare.getResultSet();
	//			while(result.next()){         
	//				for(int i = 1; i <= 5; i++)
	//					infoPlan = infoPlan + result.getObject(i).toString() + " ";
	//					lab = new JLabel(infoPlan);
	//					System.out.println(infoPlan);
	//					infoPlan = "";
	//
	//					System.out.println("test");
	//
	//					pan.add(lab);
	//
	//			}
	//			break;
	//		case "Jeudi":
	//			ResultSet result = prepare.getResultSet();
	//			while(result.next()){         
	//				for(int i = 1; i <= 5; i++)
	//					infoPlan = infoPlan + result.getObject(i).toString() + " ";
	//					lab = new JLabel(infoPlan);
	//					System.out.println(infoPlan);
	//					infoPlan = "";
	//
	//					System.out.println("test");
	//
	//					pan.add(lab);
	//
	//			}
	//			break;
	//		case "Vendredi":
	//			ResultSet result = prepare.getResultSet();
	//			while(result.next()){         
	//				for(int i = 1; i <= 5; i++)
	//					infoPlan = infoPlan + result.getObject(i).toString() + " ";
	//					lab = new JLabel(infoPlan);
	//					System.out.println(infoPlan);
	//					infoPlan = "";
	//
	//					System.out.println("test");
	//
	//					pan.add(lab);
	//
	//			}
	//			break;
	//			default:{	JOptionPane pope = new JOptionPane("attention");
	//			pope.showMessageDialog(null,"ERREUR 404","",JOptionPane.ERROR_MESSAGE);}
	//	}
	//	}

}
