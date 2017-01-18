package Projet;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Promo {
	String nomPromo, description, text;

	int nbEtud;
	public Promo(){


	}

	public void integrerEtudiant(){
		//************AJOUTER ETUDIANT***********
		Scanner sc = new Scanner(System.in);

		String query = "INSERT INTO public.etudiant (idcomptefk, idpromofk) "
				+ "VALUES ((SELECT idcompte FROM public.compte WHERE idcompte = ?),"
				+ "(SELECT idpromo FROM public.promo WHERE idpromo = ?))"
				+ " RETURNING idetudiant;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			System.out.print("Rentrez le numéro du compte : ");
			prepare.setInt(1, sc.nextInt());
			System.out.print("Rentrez le numéro de la promo : ");
			prepare.setInt(2, sc.nextInt());
			//sc.nextLine();


			prepare.execute();
		}
		catch (SQLException d) {
			d.printStackTrace();
		}
	}

	public void afficheListeEtud(){
		//***********NOMBRE ETUDIANT************	
		// a décommenter text = txuser.gettext();
		String query = "SELECT COUNT(*) AS nbetudiant "
				+ "FROM public.etudiant, public.promo "
				+ "WHERE etudiant.idpromofk = promo.idpromo "
				+ "AND nompromo = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			System.out.print("Rentrez le nom de la promo : ");
			prepare.setString(1, text);
			//sc.nextLine();


			prepare.execute();
		}
		catch (SQLException d) {
			d.printStackTrace();
		}

		//***********LISTE ETUDIANT*************
		// a décommenter text = txuser.getText();
		String query2 = "SELECT nomcompte, prenomcompte "
				+ "FROM public.etudiant, public.compte, public.promo "
				+ "WHERE etudiant.idpromofk = promo.idpromo "
				+ "AND etudiant.idcomptefk = compte.idcompte "
				+ "AND nompromo = ?";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			System.out.print("Rentrez le nom de la promo : ");
			prepare.setString(1, text);
			//sc.nextLine();


			prepare.execute();
		}
		catch (SQLException d) {
			d.printStackTrace();
		}

	}
}
