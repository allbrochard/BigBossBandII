package Projet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class PlanningPerso {
	public void ckeckPlan(){
		
		String query = "SELECT DISTINCT dateresa AS Date, nomcompte AS Professeur, nommatiere as Matiere, nompromo AS Promo, idsallefk AS Salle "
				+ "FROM public.reservation, public.compte, public.matiere, public.promo, public.salles "
				+ "WHERE reservation.idcomptefk = compte.idcompte "
				+ "AND reservation.idmatierefk = matiere.idmatiere "
				+ "AND reservation.idpromofk = promo.idpromo "
				+ "AND logcompte = ?;";
		try {
			PreparedStatement prepare = Connexion.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			prepare.setString(1, Graphique.loginCompte);
			
			prepare.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
