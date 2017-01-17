package Projet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

	public class  FenetreEtudiantFormateur extends JFrame implements MouseListener{
		
		public FenetreEtudiantFormateur(){
			
			setSize(800, 600);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			addMouseListener(this);
			setResizable(false);
			setLocationRelativeTo(null);
			
			JPanel pan1= new JPanel();

			JMenuBar bar = new JMenuBar();
			setJMenuBar(bar);
			JMenu Planning = new JMenu( "Planning" );
			bar.add(Planning);
			JMenuItem PlanningGeneral = new JMenuItem(" Planning General ");
			Planning.add(PlanningGeneral);
			JMenu PlanningPerso = new JMenu(" Planning Personnelle ");
			Planning.add(PlanningPerso);
			JMenuItem Planningsemaine = new JMenuItem(" Planning semaine");
			PlanningPerso.add(Planningsemaine);
			JMenuItem PlanningMois = new JMenuItem("Planning Mois");
			PlanningPerso.add(PlanningMois);
			
			this.setContentPane(pan1);
			this.setVisible(true);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
}