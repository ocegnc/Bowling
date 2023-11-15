package bowling;

public class Tour {
	private static int globalNum=0;
	private int numeroTour;
	private int nbQuillesAbattuesLancer1;
	private int nbQuillesAbattuesLancer2;
	private Tour suivant;
	
	public Tour(int nbQuillesAbattuesLancer1, int nbQuillesAbattuesLancer2){
		globalNum++;
		this.numeroTour=globalNum;
		this.nbQuillesAbattuesLancer1=nbQuillesAbattuesLancer1;
		this.nbQuillesAbattuesLancer2=nbQuillesAbattuesLancer2;
		
	}
	
	public Tour(){
		this.nbQuillesAbattuesLancer1=10;
		this.nbQuillesAbattuesLancer2= Integer.parseInt(null);
	}

	public int getNumeroTour() {
		return numeroTour;
	}

	public int getNbQuillesAbattuesLancer1() {
		return nbQuillesAbattuesLancer1;
	}

	public int getNbQuillesAbattuesLancer2() {
		return nbQuillesAbattuesLancer2;
	}

	public boolean estUnStrike(){
		if(nbQuillesAbattuesLancer1!=10){
			return false;
		}
		return true;
	}
	
	public boolean estUnSpare(){
		if(nbQuillesAbattuesLancer1+nbQuillesAbattuesLancer2!=10){
			return false;
		}
		return true;
	}
	
	public int bonusPourStrike(){
		return getNbQuillesAbattuesLancer1();
	}
	
	public int bonusPourSpare(){
		return suivant.getNbQuillesAbattuesLancer1();
	}
	
	public int score(){
		int scoreTour=0;
		if(estUnSpare()){
			scoreTour = 10 + suivant.bonusPourStrike();
		} else if(estUnSpare()){
			scoreTour = 10 + suivant.bonusPourSpare();
		} else {
			scoreTour = nbQuillesAbattuesLancer1 + nbQuillesAbattuesLancer2;
		}
		return scoreTour + suivant.score();
	}
}
