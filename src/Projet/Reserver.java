package Projet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Reserver {
	int id ;
	
	public boolean reserverSalle (){
		
		Scanner sc = new Scanner(System.in);
		boolean res = false;
		String query = "INSERT INTO public.reservation (dateresa, idmatierefk, idformateurfk, idpromofk, idsallefk, nomresa) VALUES (?,(SELECT idmatiere FROM public.matiere WHERE idmatiere = ?),(SELECT idpromo FROM public.promo WHERE idpromo = ?),(SELECT idsalle FROM public.salles WHERE idsalle = ?),(SELECT idformateur FROM public.formateur WHERE idformateur = ?),?) RETURNING idresa;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			System.out.print("Rentrez la date : ");
			prepare.setString(1, sc.nextLine());
			System.out.println("Rentrez le nom de la réservation : ");
			prepare.setString(6, sc.nextLine());
			System.out.print("Rentrez le numero de la matiere : ");
			prepare.setInt(2, sc.nextInt());
			System.out.print("Rentrez le numero de la promo : ");
			prepare.setInt(4, sc.nextInt());
			System.out.print("Rentrez le numero du formateur : ");
			prepare.setInt(3, sc.nextInt());
			System.out.print("Rentrez le numéro de la salle : ");
			prepare.setInt(5, sc.nextInt());

			
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
		
		String query = "UPDATE public.reservation SET dateresa = ?, idmatierefk = ?, idformateurfk = ?, idpromofk = ?, idsallefk = ?, WHERE nomresa = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			System.out.print("Rentrez le nom de la réservation à modifier : ");
			prepare.setString(6, sc.nextLine());
			System.out.print("Rentrez la nouvelle date : ");
			prepare.setString(1, sc.nextLine());
			System.out.print("Rentrez le nouveau numéro de la matière : ");
			prepare.setInt(2, sc.nextInt());
			System.out.print("Rentrez le nouveau numéro du formateur : ");
			prepare.setInt(3, sc.nextInt());
			System.out.print("Rentrez le nouveau numéro de la promo : ");
			prepare.setInt(4, sc.nextInt());
			System.out.print("Rentrez le nouveau numéro de la salle : ");
			prepare.setInt(5, sc.nextInt());
			
			
			prepare.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Le compte a bien été mis à jour !");
	}

	public void supprRes(){
		Scanner sc = new Scanner(System.in);
		boolean res = false;
		
		String query = "DELETE FROM public.reservation WHERE idresa = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			System.out.print("Rentrez le numero de la réservation à supprimer : ");
			prepare.setInt(1, sc.nextInt());
			
			prepare.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("La réservation a bien été supprimée");
	}

}
