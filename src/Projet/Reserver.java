package Projet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Reserver {
	int id ;
	
	public boolean reserverSalle (){
		
		Scanner sc = new Scanner(System.in);
		boolean res = false;
		String query = "INSERT INTO public.reservation (dateresa, idmatierefk, idcomptefk, idpromofk, idsallefk, nomresa)"
				+ " VALUES (?,"
				+ "(SELECT idmatiere FROM public.matiere WHERE idmatiere = ?),"
				+ "(SELECT idcompte FROM public.compte WHERE idcompte = ?),"
				+ "(SELECT idpromo FROM public.promo WHERE idpromo = ?),"
				+ "(SELECT idsalle FROM public.salles WHERE idsalle = ?),"
				+ "?)"
				+ " RETURNING idresa;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			JPanel resasalle = new JPanel();
			JLabel date = new JLabel("Rentrez la date");
			System.out.print("Rentrez la date : ");
			//prepare.setString(1, sc.nextLine());
			JLabel nomresa = new JLabel("Rentrez le nom de la r�servation : ");
			System.out.print("Rentrez le nom de la r�servation : ");
			//prepare.setString(6, sc.nextLine());
			JLabel nummatiere = new JLabel("Rentrez le numero de la matiere : ");
			System.out.print("Rentrez le numero de la matiere : ");
			//prepare.setInt(2, sc.nextInt());
			JLabel numpromo = new JLabel("Rentrez le numero de la promo : ");
			System.out.print("Rentrez le numero de la promo : ");
			//prepare.setInt(4, sc.nextInt());
			JLabel numformateur = new JLabel("Rentrez le numero du formateur : ");
			System.out.print("Rentrez le numero du formateur : ");
			//prepare.setInt(3, sc.nextInt());
			JLabel numsalle = new JLabel("Rentrez le num�ro de la salle : ");
			System.out.print("Rentrez le num�ro de la salle : ");
			//prepare.setInt(5, sc.nextInt());
			resasalle.setVisible(true);
			
			//On execute la requete
			prepare.execute();
				
			//Si la requete s'est bien passee, on recupere le id_user qui a ete genere
			ResultSet result = prepare.getResultSet();
			if(result.first())
			{
				id = result.getInt(1);
				res = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public void modifResa(){
		Scanner sc = new Scanner(System.in);
		

		String query = "UPDATE public.reservation SET dateresa = ?, idmatierefk = ?, idcomptefk = ?, idpromofk = ?, idsallefk = ? WHERE nomresa = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			System.out.print("Rentrez le nom de la r�servation � modifier : ");
			prepare.setString(6, sc.nextLine());
			System.out.print("Rentrez la nouvelle date : ");
			prepare.setString(1, sc.nextLine());
			System.out.print("Rentrez le nouveau num�ro de la mati�re : ");
			prepare.setInt(2, sc.nextInt());
			System.out.print("Rentrez le nouveau num�ro du formateur : ");
			prepare.setInt(3, sc.nextInt());
			System.out.print("Rentrez le nouveau num�ro de la promo : ");
			prepare.setInt(4, sc.nextInt());
			System.out.print("Rentrez le nouveau num�ro de la salle : ");
			prepare.setInt(5, sc.nextInt());
			
			
			prepare.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Le compte a bien �t� mis � jour !");
	}

	public void supprRes(){
		Scanner sc = new Scanner(System.in);
		
		String query = "DELETE FROM public.reservation WHERE nomresa = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			System.out.print("Rentrez le nom de la r�servation � supprimer : ");
			prepare.setString(1, sc.nextLine());
			
			prepare.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("La r�servation a bien �t� supprim�e");
	}

}
