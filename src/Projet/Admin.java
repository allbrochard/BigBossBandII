package Projet;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Admin extends JFrame implements MouseListener{
	int id;
	String text;
	String lastName, name, logIn, pw, acount, old;
	
	Scanner sc = new Scanner(System.in);
	public Admin() {

	}

	//Méthode pour créer un compte (utilisable uniquement en mode admin)
	public void creeCompte(){


		JPanel adminPan = new JPanel();
		
		JLabel nom = new JLabel("Rentrez le nom"); 
		JLabel prenom = new JLabel("Rentrez le prenom");
		JLabel login = new JLabel("Rentrez le login");
		JLabel mdp = new JLabel("Rentrez le mot de passe");
		JLabel typecompte = new JLabel("Rentrez le type de compte");
		JLabel age = new JLabel("Rentrez l'age");
		
		JTextField tNom = new JTextField(15);
		JTextField tPrenom = new JTextField(15);
		JTextField tLogin = new JTextField(15);
		JTextField tMdp = new JTextField(15);
		JTextField tTypeCompte = new JTextField(15);
		JTextField tAge = new JTextField(15);
		
		JButton valider = new JButton("Valider");
		
		
		
		adminPan.add(nom);
		adminPan.add(tNom);
		adminPan.add(prenom);
		adminPan.add(tPrenom);
		adminPan.add(login);
		adminPan.add(tLogin);
		adminPan.add(mdp);
		adminPan.add(tMdp);
		adminPan.add(typecompte);
		adminPan.add(tTypeCompte);
		adminPan.add(age);
		adminPan.add(tAge);
		adminPan.add(valider);
		this.setTitle("Fenetre Admin");
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(200, 500));
		
		//setSize(new Dimension(800, 800));
		setContentPane(adminPan);

		
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lastName = tNom.getText();
				name = tPrenom.getText(); 
				logIn = tLogin.getText(); 
				pw = tMdp.getText(); 
				acount = tTypeCompte.getText(); 
				old = tAge.getText();
				
				
				String query = "INSERT INTO public.compte (nomcompte, prenomcompte, logcompte, pswdcompte, typecompte, agecompte) VALUES (?,?,?,?,?,?) RETURNING idcompte;";
				try {
					PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

					System.out.print("Rentrez le nom : ");
					prepare.setString(1, lastName);

					System.out.print("Rentrez le prenom : ");
					prepare.setString(2, name);

					System.out.print("Rentrez le login : ");
					prepare.setString(3, logIn);

					System.out.print("Rentrez le mot de passe : ");
					prepare.setString(4, pw);

					System.out.print("Rentrez le type de compte : ");
					prepare.setString(5, acount);

					System.out.print("Rentrez l'age : ");
					prepare.setInt(6, Integer.parseInt(old));

					adminPan.setVisible(true);
					//On execute la requete
					prepare.execute();

					//Si la requete s'est bien passee, on recupere le id_user qui a ete genere
					ResultSet result = prepare.getResultSet();
					if(result.first())
					{
						id = result.getInt(1);

					}
				}
				catch (SQLException d) {
					d.printStackTrace();
				}
				tNom.setText("");
				tPrenom.setText(""); 
				tLogin.setText(""); 
				tMdp.setText(""); 
				tTypeCompte.setText(""); 
				tAge.setText("");
			}
		});



		this.setVisible(true);
		adminPan.setVisible(true);

	}

	//Méthode pour modifier un compte (utilisable uniquement en mode admin)
	public void modifCompte(){
		JPanel adminPan = new JPanel();
		this.setTitle("Fenetre Admin");
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		adminPan.setSize(new Dimension(200,500));
		setSize(new Dimension(250, 500));
		
		setContentPane(adminPan);
		JLabel log = new JLabel("Rentrez le login du compte à modifier : "); 
		JLabel nom = new JLabel("Rentrez le nouveau nom : ");
		JLabel prenom = new JLabel("Rentrez le nouveau prénom : ");
		JLabel login = new JLabel("Rentrez le nouveau login : ");
		JLabel mdp = new JLabel("Rentrez le nouveau mot de passe : ");
		JLabel typecompte = new JLabel("Rentrez le nouveau type de compte : ");
		JLabel age = new JLabel("Rentrez le nouvel age : ");
		JTextField tLog = new JTextField(15);
		JTextField tNom = new JTextField(15);
		JTextField tPrenom = new JTextField(15);
		JTextField tLogin = new JTextField(15);
		JTextField tMdp = new JTextField(15);
		JTextField tTypeCompte = new JTextField(15);
		JTextField tAge = new JTextField(15);
		JButton valider = new JButton("Valider");
		
		
		adminPan.add(log);
		adminPan.add(tLog);
		adminPan.add(nom);
		adminPan.add(tNom);
		adminPan.add(prenom);
		adminPan.add(tPrenom);
		adminPan.add(login);
		adminPan.add(tLogin);
		adminPan.add(mdp);
		adminPan.add(tMdp);
		adminPan.add(typecompte);
		adminPan.add(tTypeCompte);
		adminPan.add(age);
		adminPan.add(tAge);
		adminPan.add(valider);

		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String query = "UPDATE public.compte SET nomcompte = ?, prenomcompte = ?, logcompte = ?, pswdcompte = ?, typecompte = ?, agecompte = ? WHERE logcompte = ?;";

				try {
					PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

					
					prepare.setString(7, tLog.getText());
					
					prepare.setString(1, tNom.getText());
					
					prepare.setString(2, tPrenom.getText());
					
					prepare.setString(3, tLogin.getText());
					
					prepare.setString(4, tMdp.getText());
					
					prepare.setString(5, tTypeCompte.getText());
					
					prepare.setInt(6, Integer.parseInt(tAge.getText()));
					//sc.nextLine();
					

					prepare.execute();
				}
				catch (SQLException d) {
					d.printStackTrace();
				}

				System.out.println("Le compte a bien été mis à jour !");
				tLog.setText("");
				tNom.setText("");
				tPrenom.setText("");
				tLogin.setText("");
				tMdp.setText("");
				tTypeCompte.setText("");
				tAge.setText("");
				
			}
		});




	

		this.setVisible(true);
		adminPan.setVisible(true);
	}

	//Méthode pour supprimer un compte (utilisable uniquement en mode admin)
	public void supprCompte(){
		JPanel suppCompte = new JPanel();
		this.setTitle("Fenetre Admin");
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		suppCompte.setSize(new Dimension(250, 150));
		setSize(new Dimension(250, 150));
		setContentPane(suppCompte);
		Scanner sc = new Scanner(System.in);

		JLabel login = new JLabel("LOGIN");

		JTextField txuser = new JTextField(15);

		JButton accepter = new JButton("Supprimer");

		suppCompte.add(login);
		suppCompte.add(txuser);
		suppCompte.add(accepter);

		accepter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text = txuser.getText();

				String query = "DELETE FROM public.compte WHERE logcompte = ?;";
				try {
					PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

					System.out.print("Rentrez le login du compte à supprimer : ");
					prepare.setString(1, text);

					prepare.execute();
				}
				catch (SQLException d) {
					d.printStackTrace();
				}
				System.out.println("Le compte a bien été supprimé");
				txuser.setText("");
			}
		});

		this.setVisible(true);
		suppCompte.setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}

