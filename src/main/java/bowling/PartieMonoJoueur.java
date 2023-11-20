package bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancers successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class PartieMonoJoueur {
	
	public List<Tour> lesTours;
	public static final int nbTours=10;
	

	/**
	 * Constructeur
	 */
	public PartieMonoJoueur() {
		for(int i=1; i<nbTours; i++){
			lesTours.add(new Tour());
		}
	}

	/**
	 * Cette méthode doit être appelée à chaque lancer de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de ce lancer
	 * @throws IllegalStateException si la partie est terminée
	 * @return vrai si le joueur doit lancer à nouveau pour continuer son tour, faux sinon	
	 */
	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if(estTerminee()) throw new IllegalStateException("La partie est terminée");
		boolean res=true;
		int index = lesTours.size()-1;
		Tour tourCourant = lesTours.get(index);
		tourCourant.enregistreLancer(nombreDeQuillesAbattues);
		if(tourCourant.estTerminee()){
			tourCourant=tourCourant.getSuivant();
		}
		if(this.estTerminee()||tourCourant.getBoule()==2){
			res=false;
		}
		return res;
	}

	/**
	 * Cette méthode donne le score du joueur.
	 * Si la partie n'est pas terminée, on considère que les lancers restants
	 * abattent 0 quille.
	 * @return Le score du joueur
	 */
	public int score() {
		int scorePartie=0;
		for(Tour t : lesTours){
			scorePartie+=t.score();
		}
		return scorePartie;
		
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		boolean res = false;
		if(numeroTourCourant()==10){
			res= true;
		}
		return res;
	}


	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		int index = lesTours.size()-1;
		Tour tourCourant = lesTours.get(index);
		return tourCourant.getNumeroTour();
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 *         est fini
	 */
	public int numeroProchainLancer() {
		int index = lesTours.size()-1;
		Tour tourCourant = lesTours.get(index);
		return tourCourant.getBoule()+1;
	}

}
