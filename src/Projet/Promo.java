package Projet;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Promo extends JFrame{
	String nomPromo, description, text;
	JLabel nbEtude2;
	JLabel listeEtude;
	int nbEtud;
	public Promo(){


	}

	public void integrerEtudiant(){
		//************AJOUTER ETUDIANT***********
		Scanner sc = new Scanner(System.in);
		JPanel panRes = new JPanel();
		
		JLabel numCompte = new JLabel("Rentrez le numéro du compte : ");
		JLabel numPromo = new JLabel("Rentrez le numéro de la promo : ");
		
		JTextField tNumCompte = new JTextField(15);
		JTextField tNumPromo = new JTextField(15);
		
		JButton valider = new JButton("valider");
		
		
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(200, 300));
		
		//setSize(new Dimension(800, 800));
		setContentPane(panRes);
		
		panRes.add(numCompte);
		panRes.add(tNumCompte);
		panRes.add(numPromo);
		panRes.add(tNumPromo);
		panRes.add(valider);
		
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String query = "INSERT INTO public.etudiant (idcomptefk, idpromofk) "
						+ "VALUES ((SELECT idcompte FROM public.compte WHERE idcompte = ?),"
						+ "(SELECT idpromo FROM public.promo WHERE idpromo = ?))"
						+ " RETURNING idetudiant;";
				try {
					PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

					System.out.print("Rentrez le numéro du compte : ");
					prepare.setInt(1, Integer.parseInt(tNumCompte.getText()));
					System.out.print("Rentrez le numéro de la promo : ");
					prepare.setInt(2,Integer.parseInt(tNumPromo.getText()));
					//sc.nextLine();


					prepare.execute();
				}
				catch (SQLException d) {
					d.printStackTrace();
				}
			}
		});
		
		panRes.setVisible(true);
		setVisible(true);
	}

	public void afficheListeEtud(){
		//***********NOMBRE ETUDIANT************	
		JPanel panRes = new JPanel();
		setLocationRelativeTo(null);
		setSize(new Dimension(200, 300));
		setContentPane(panRes);
		
		JLabel promo = new JLabel("Rentrez le nom de la promo : ");
		JTextField tPromo = new JTextField(15);
		JButton valider = new JButton("valider");
		
		panRes.add(promo);
		panRes.add(tPromo);
		panRes.add(valider);
		
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				text = tPromo.getText();
				String query = "SELECT COUNT(*) AS nbetudiant "
						+ "FROM public.etudiant, public.promo "
						+ "WHERE etudiant.idpromofk = promo.idpromo "
						+ "AND nompromo = ?;";
				try {
					PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

					System.out.print("Rentrez le nom de la promo : ");
					prepare.setString(1, text);
					
				
					prepare.execute();
					ResultSet result = prepare.getResultSet();
					if(result.first())
					{
						nbEtud = result.getInt(1);
						nbEtude2 = new JLabel("" + nbEtud + " etudiant dans la promo");
					}
					result.close();
					
				}
				catch (SQLException d) {
					d.printStackTrace();
				}
				
				//***********LISTE ETUDIANT*************
				
				String query2 = "SELECT nomcompte, prenomcompte "
						+ "FROM public.etudiant, public.compte, public.promo "
						+ "WHERE etudiant.idpromofk = promo.idpromo "
						+ "AND etudiant.idcomptefk = compte.idcompte "
						+ "AND nompromo = ?";
				try {
					PreparedStatement prepare = Connexion.getInstance().prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

					System.out.print("Rentrez le nom de la promo : ");
					prepare.setString(1, text);

					prepare.execute();
					ResultSet result = prepare.getResultSet();
					  //on cherche avec cette boucle a afficher le nom et prenom des personne de la promo
					if(result.first())
					{
					    while(result.next()){         
					          for(int i = 2; i <= 3; i++)
					            System.out.print(result.getObject(i).toString());
					              
					          System.out.println("\n---------------------------------");

					        }
					}
					result.close();
					
				}
				catch (SQLException d) {
					d.printStackTrace();
				}
				
			}
		});
		
		panRes.setVisible(true);
		setVisible(true);

	}
}
