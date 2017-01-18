package Projet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Graphique extends JFrame{

	static JTextField txuser = new JTextField(15);
	JTextField txuser2 = new JTextField(15);  

	JPanel pan1= new JPanel();
	JPanel pan2 = new JPanel();

	JLabel login = new JLabel("LOGIN");
	JLabel password = new JLabel("Password");

	JButton connecte = new JButton ("Connection");

	static String typeCompte;

	String mdpCompte;
	public static String loginCompte;
	String mp, log;

	boolean test = false;
	/**
	 * affichage de la fenetre de logIn, et permet d'acceder au fenetre des différent type de compte
	 */
	public Graphique (){

		login = new JLabel("LOGIN");

		password = new JLabel("Password");

		txuser = new JTextField(15);

		txuser2 = new JTextField(15); 

		Connexion co = new Connexion();



		setSize(250,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);


		pan1.add(login);
		pan1.add(txuser);	
		pan1.add(password);
		pan1.add(txuser2);
		pan1.add(connecte);
		do{
			connecte.addActionListener(new ActionListener() {
				//connection avec boite de dialogue pour indiquer ce qui ce passe;
				@Override
				public void actionPerformed(ActionEvent arg0) {
					boolean connect = false;
					log = txuser.getText();

					mp = txuser2.getText();

					if(log.equals(testLogin())){
						if(mp.equals(recupeMP())){

							connexionLog();
							affichageAppli();
							test=true;		

						}
						else{
							JOptionPane.showMessageDialog(pan1, "Mot de passe invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(pan1, "Login non reconnu", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}while(test);


		this.setContentPane(pan2);
		pan2.setVisible(true);

		this.setContentPane(pan1);
		pan1.setVisible(true);

		this.setVisible(true); 

	}
	/**
	 * switch pour savoir qu'elle type de compte c'est conneceter
	 */
	public void affichageAppli(){
		switch(typeCompte){
		case "admin":
			FenetreAdmin adminFrame = new FenetreAdmin();
			break;
		case "responsable":
			FenetreResponsable responsableFrame = new FenetreResponsable();
			break;
		case "formateur":
			FenetreEtudiantFormateur  formateurFrame = new FenetreEtudiantFormateur();
			break;
		case "etudiant":
			FenetreEtudiantFormateur  etudiantFrame = new FenetreEtudiantFormateur();
			break;
		default : System.out.println("perdu");


		}

	}
	/**
	 * 
	 * @return le type de compte pour le réutiliser;
	 */
	public String connexionLog(){
		Scanner sc = new Scanner(System.in);

		String query = "SELECT typecompte FROM public.compte WHERE logcompte = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			prepare.setString(1, log);

			prepare.execute();
			ResultSet result = prepare.getResultSet();
			if(result.first())
			{
				typeCompte = result.getString(1);

			}
			result.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return typeCompte;
	}
	/**
	 * 
	 * @return le mot de passe pour le tester avec le mdp;
	 */
	public String recupeMP(){

		String query = "SELECT pswdcompte FROM public.compte WHERE logcompte = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			prepare.setString(1, log);

			prepare.execute();
			ResultSet result = prepare.getResultSet();
			if(result.first())
			{
				mdpCompte = result.getString(1);

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return mdpCompte;
	}
	/**
	 * 
	 * @return le login, si il n'existe pas return null;
	 */
	public String testLogin(){
		String query = "SELECT logcompte FROM public.compte WHERE logcompte = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			prepare.setString(1, log);

			prepare.execute();
			ResultSet result = prepare.getResultSet();
			if(result.first())
			{
				loginCompte = result.getString(1);

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return loginCompte;
	}
	public void mouseClicked(MouseEvent arg0) {


	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}