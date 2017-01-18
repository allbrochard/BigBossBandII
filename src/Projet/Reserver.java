package Projet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Reserver {
	int id ;

	public boolean reserverSalle (){

		Scanner sc = new Scanner(System.in);

		JPanel resasalle = new JPanel();

		JLabel date  =	new JLabel("Rentrez la date");
		JLabel nomresa = new JLabel("Rentrez le nom de la r�servation : ");
		JLabel nummatiere = new JLabel("Rentrez le numero de la matiere : ");
		JLabel numpromo = new JLabel("Rentrez le numero de la promo : ");
		JLabel numsalle = new JLabel("Rentrez le num�ro de la salle : ");
		JLabel numformateur = new JLabel("Rentrez le numero du formateur : ");

		JTextField tdate  =	new JTextField(15);
		JTextField tnomresa = new JTextField(15);
		JTextField tnummatiere = new JTextField(15);
		JTextField tnumpromo = new JTextField(15);
		JTextField tnumsalle = new JTextField(15);
		JTextField tnumformateur = new JTextField(15);

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

			System.out.print("Rentrez la date : ");
			//prepare.setString(1, sc.nextLine());
			System.out.print("Rentrez le nom de la r�servation : ");
			//prepare.setString(6, sc.nextLine());
			System.out.print("Rentrez le numero de la matiere : ");
			//prepare.setInt(2, sc.nextInt());
			System.out.print("Rentrez le numero de la promo : ");
			//prepare.setInt(4, sc.nextInt());
			System.out.print("Rentrez le numero du formateur : ");
			//prepare.setInt(3, sc.nextInt());
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

		JPanel nomresa = new JPanel();
		JPanel dateresa = new JPanel();
		JPanel nummatiere = new JPanel();
		JPanel  numformateur = new JPanel();
		JPanel numpromo = new JPanel();
		JPanel  numsalle = new JPanel();

		JTextField tnomresa = new JTextField();
		JTextField tdateresa = new JTextField();
		JTextField tnummatiere = new JTextField();
		JTextField tnumformateur = new JTextField();
		JTextField tnumpromo = new JTextField();
		JTextField tnumsalle = new JTextField();

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
