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
		JLabel nomresa = new JLabel("Rentrez le nom de la réservation : ");
		JLabel nummatiere = new JLabel("Rentrez le numero de la matiere : ");
		JLabel numpromo = new JLabel("Rentrez le numero de la promo : ");
		JLabel numsalle = new JLabel("Rentrez le numéro de la salle : ");
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
		
		resaSalle.add(valider);
		
		this.setTitle("Reservation");
		setLocationRelativeTo(null);
		setSize(new Dimension(250, 500));
		setContentPane(resaSalle);
		setResizable(false);

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
					System.out.print("Rentrez le nom de la réservation : ");
					prepare.setString(6, tnomresa.getText());
					System.out.print("Rentrez le numero de la matiere : ");
					prepare.setInt(2, Integer.parseInt(tnummatiere.getText()));
					System.out.print("Rentrez le numero de la promo : ");
					prepare.setInt(4, Integer.parseInt(tnumpromo.getText()));
					System.out.print("Rentrez le numero du formateur : ");
					prepare.setInt(3, Integer.parseInt(tnumsalle.getText()));
					System.out.print("Rentrez le numéro de la salle : ");
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
				tnomresa.setText("");
				tdate.setText("");
				tnumformateur.setText("");
				tnummatiere.setText("");
				tnumpromo.setText("");
				tnumsalle.setText("");
				
			}
		});
		this.setVisible(true);
		resaSalle.setVisible(true);
	}

	public void modifResa(){
		Scanner sc = new Scanner(System.in);
		JPanel modifResa = new JPanel();
		
		JLabel nomresa = new JLabel("Rentrez le nom de la réservation à modifier : ");
		JLabel dateresa = new JLabel("Rentrez la nouvelle date : ");
		JLabel nummatiere = new JLabel("Rentrez le nouveau numéro de la matière : ");
		JLabel  numformateur = new JLabel("Rentrez le nouveau numéro du formateur : ");
		JLabel numpromo = new JLabel("Rentrez le nouveau numéro de la promo : ");
		JLabel  numsalle = new JLabel("Rentrez le nouveau numéro de la salle : ");

		JTextField tnomresa = new JTextField(15);
		JTextField tdateresa = new JTextField(15);
		JTextField tnummatiere = new JTextField(15);
		JTextField tnumformateur = new JTextField(15);
		JTextField tnumpromo = new JTextField(15);
		JTextField tnumsalle = new JTextField(15);

		JButton valider = new JButton("Valider");
		
		modifResa.add(nomresa);
		modifResa.add(tnomresa);
		modifResa.add(dateresa);
		modifResa.add(tdateresa);
		modifResa.add(nummatiere);
		modifResa.add(tnummatiere);
		modifResa.add(numformateur);
		modifResa.add(tnumformateur);
		modifResa.add(numpromo);
		modifResa.add(tnumpromo);
		modifResa.add(numsalle);
		modifResa.add(tnumsalle);
		modifResa.add(valider);
		
		this.setTitle("Fenetre Modification Reservation");
		setLocationRelativeTo(null);
		setSize(new Dimension(268, 500));
		setContentPane(modifResa);
		setResizable(false);
		
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE public.reservation SET dateresa = ?, idmatierefk = ?, idcomptefk = ?, idpromofk = ?, idsallefk = ? WHERE nomresa = ?;";
				try {
					PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


					System.out.print("Rentrez le nom de la réservation à modifier : ");
					prepare.setString(6, tnomresa.getText());
					System.out.print("Rentrez la nouvelle date : ");
					prepare.setString(1, tdateresa.getText());
					System.out.print("Rentrez le nouveau numéro de la matière : ");
					prepare.setInt(2, Integer.parseInt(tnummatiere.getText()));
					System.out.print("Rentrez le nouveau numéro du formateur : ");
					prepare.setInt(3, Integer.parseInt(tnumformateur.getText()));
					System.out.print("Rentrez le nouveau numéro de la promo : ");
					prepare.setInt(4, Integer.parseInt(tnumpromo.getText()));
					System.out.print("Rentrez le nouveau numéro de la salle : ");
					prepare.setInt(5, Integer.parseInt(tnumsalle.getText()));

					
					prepare.execute();
				}
				catch (SQLException d) {
					d.printStackTrace();
				}

				System.out.println("Le compte a bien été mis à jour !");
				tnomresa.setText("");
				tdateresa.setText("");
				tnumformateur.setText("");
				tnummatiere.setText("");
				tnumpromo.setText("");
				tnumsalle.setText("");
			}
		});
		  
		this.setVisible(true);
		modifResa.setVisible(true);
	}

	public void supprRes(){
		Scanner sc = new Scanner(System.in);
		JPanel suppResa = new JPanel();
		this.setTitle("Reservation");
		setLocationRelativeTo(null);
		setSize(new Dimension(300, 500));
		setContentPane(suppResa);
		setResizable(false);
		
		JLabel nomResa = new JLabel("Rentrez le nom de la réservation à supprimer : ");
		
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

					System.out.print("Rentrez le nom de la réservation à supprimer : ");
					prepare.setString(1, tnomResa.getText());

					prepare.execute();
				}
				catch (SQLException d) {
					d.printStackTrace();
				}
				tnomResa.setText("");
			}
		});

		this.setVisible(true);
		suppResa.setVisible(true);
		System.out.println("La réservation a bien été supprimée");
	}

}
