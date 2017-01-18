package Projet;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Admin extends JFrame implements MouseListener{
	int id;

	public Admin() {
	}
	
	//Méthode pour créer un compte (utilisable uniquement en mode admin)
	public boolean creeCompte(){
		Scanner sc = new Scanner(System.in);
		boolean res = false;
		String query = "INSERT INTO public.compte (nomcompte, prenomcompte, logcompte, pswdcompte, typecompte, agecompte) VALUES (?,?,?,?,?,?) RETURNING idcompte;";
//		try {
			//PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			JPanel crcompte = new JPanel();
			JLabel nom = new JLabel("Rentrez le nom"); 
			System.out.print("Rentrez le nom : ");
			//prepare.setString(1, sc.nextLine());
			JLabel prenom = new JLabel("Rentrez le prenom"); 
			System.out.print("Rentrez le prenom : ");
			//prepare.setString(2, sc.nextLine());
			JLabel login = new JLabel("Rentrez le login"); 
			System.out.print("Rentrez le login : ");
			//prepare.setString(3, sc.nextLine());
			JLabel mdp = new JLabel("Rentrez le mot de passe"); 
			System.out.print("Rentrez le mot de passe : ");
			//prepare.setString(4, sc.nextLine());
			JLabel typecompte = new JLabel("Rentrez le type de compte"); 
			System.out.print("Rentrez le type de compte : ");
			//prepare.setString(5, sc.nextLine());
			JLabel age = new JLabel("Rentrez l'age"); 
			System.out.print("Rentrez l'age : ");
			//prepare.setInt(6, sc.nextInt());
			
			crcompte.setVisible(true);
			//On execute la requete
			//prepare.execute();
				
			//Si la requete s'est bien passee, on recupere le id_user qui a ete genere
			//ResultSet result = prepare.getResultSet();
//			if(result.first())
//			{
//				id = result.getInt(1);
//				res = true;
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		return res;
			
	}
	
	//Méthode pour modifier un compte (utilisable uniquement en mode admin)
	public void modifCompte(){
		Scanner sc = new Scanner(System.in);
		
		String query = "UPDATE public.compte SET nomcompte = ?, prenomcompte = ?, logcompte = ?, pswdcompte = ?, typecompte = ?, agecompte = ? WHERE logcompte = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			System.out.print("Rentrez le login du compte à modifier : ");
			prepare.setString(7, sc.nextLine());
			System.out.print("Rentrez le nouveau nom : ");
			prepare.setString(1, sc.nextLine());
			System.out.print("Rentrez le nouveau prénom : ");
			prepare.setString(2, sc.nextLine());
			System.out.print("Rentrez le nouveau login : ");
			prepare.setString(3, sc.nextLine());
			System.out.print("Rentrez le nouveau mot de passe : ");
			prepare.setString(4, sc.nextLine());
			System.out.print("Rentrez le nouveau type de compte : ");
			prepare.setString(5, sc.nextLine());
			System.out.print("Rentrez le nouvel age : ");
			prepare.setInt(6, sc.nextInt());
			//sc.nextLine();
			
			
			prepare.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Le compte a bien été mis à jour !");
	}
		
	//Méthode pour supprimer un compte (utilisable uniquement en mode admin)
	public void supprCompte(){
		Scanner sc = new Scanner(System.in);
		
		String query = "DELETE FROM public.compte WHERE logcompte = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			System.out.print("Rentrez le login du compte à supprimer : ");
			prepare.setString(1, sc.nextLine());
			
			prepare.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Le compte a bien été supprimé");
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

