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

public class Reserver extends JFrame{
	int id ;

	public void reserverSalle(){

		Scanner sc = new Scanner(System.in);

		JPanel resaSalle = new JPanel();

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
		
		JButton valider = new JButton("valider");
		
		resaSalle.add(date);
		resaSalle.add(tdate);
		
		resaSalle.add(nomresa);
		resaSalle.add(tnomresa);
		
		resaSalle.add(nummatiere);
		resaSalle.add(tnummatiere);
		
		resaSalle.add(numpromo);
		resaSalle.add(tnumpromo);
		
		resaSalle.add(numsalle);
		resaSalle.add(tnumsalle);
		
		resaSalle.add(numformateur);
		resaSalle.add(tnumformateur);
		
		this.setTitle("Reservation");
		setLocationRelativeTo(null);
		setSize(new Dimension(200, 500));
		setContentPane(resaSalle);

		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
					prepare.setString(1, tdate.getText());
					System.out.print("Rentrez le nom de la r�servation : ");
					prepare.setString(6, tnomresa.getText());
					System.out.print("Rentrez le numero de la matiere : ");
					prepare.setInt(2, Integer.parseInt(tnummatiere.getText()));
					System.out.print("Rentrez le numero de la promo : ");
					prepare.setInt(4, Integer.parseInt(tnumpromo.getText()));
					System.out.print("Rentrez le numero du formateur : ");
					prepare.setInt(3, Integer.parseInt(tnumsalle.getText()));
					System.out.print("Rentrez le num�ro de la salle : ");
					prepare.setInt(5, Integer.parseInt(tnumformateur.getText()));
					

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
				
			}
		});
		
		resaSalle.setVisible(true);
	}

	public void modifResa(){
		Scanner sc = new Scanner(System.in);

		JPanel modifResa = new JPanel();
		
		JLabel nomresa = new JLabel();
		JLabel dateresa = new JLabel();
		JLabel nummatiere = new JLabel();
		JLabel  numformateur = new JLabel();
		JLabel numpromo = new JLabel();
		JLabel  numsalle = new JLabel();

		JTextField tnomresa = new JTextField();
		JTextField tdateresa = new JTextField();
		JTextField tnummatiere = new JTextField();
		JTextField tnumformateur = new JTextField();
		JTextField tnumpromo = new JTextField();
		JTextField tnumsalle = new JTextField();
		
		JButton valier = new JButton("valider");
		

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
		JPanel suppResa = new JPanel();
		this.setTitle("Reservation");
		setLocationRelativeTo(null);
		setSize(new Dimension(200, 500));
		setContentPane(suppResa);
		
		JLabel nomResa = new JLabel("Rentrez le nom de la r�servation � supprimer : ");
		
		JTextField tnomResa = new JTextField(15);
		
		JButton valider = new JButton("valider");
		
		suppResa.add(nomResa);
		suppResa.add(tnomResa);
		suppResa.add(valider);
		
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String query = "DELETE FROM public.reservation WHERE nomresa = ?;";
				try {
					PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

					System.out.print("Rentrez le nom de la r�servation � supprimer : ");
					prepare.setString(1, tnomResa.getText());

					prepare.execute();
				}
				catch (SQLException d) {
					d.printStackTrace();
				}
			}
		});


		suppResa.setVisible(true);
		System.out.println("La r�servation a bien �t� supprim�e");
	}

}
