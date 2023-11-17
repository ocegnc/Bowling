package bowling;

public class Tour {
	private static int globalNum=0;
	private int numeroTour;
	private int nbQuillesAbattuesl1;
	private int nbQuillesAbattuesl2;

	//private ArrayList lesLances;
	
	private Tour suivant;
	
	public Tour(int nbQuillesAbattuesl1, int nbQuillesAbattuesl2, Tour suivant){
		globalNum++;
		this.numeroTour=globalNum;
		this.nbQuillesAbattuesl1=nbQuillesAbattuesl1;
		this.nbQuillesAbattuesl2=nbQuillesAbattuesl2;
		this.suivant = suivant;
	}
	
	public Tour(){
		this.nbQuillesAbattuesl1=10;
		this.nbQuillesAbattuesl2= Integer.parseInt(null);
	}
	
	public int getNumeroTour() {
		return numeroTour;
	}

	public int getNbQuillesAbattuesl1() {
		return nbQuillesAbattuesl1;
	}

	public int getNbQuillesAbattuesl2() {
		return nbQuillesAbattuesl2;
	}

	public boolean estUnStrike(){
		if(getNbQuillesAbattuesl1()!=10){
			return false;
		}
		return true;
	}
	
	public boolean estUnSpare(){
		if(getNbQuillesAbattuesl1()+getNbQuillesAbattuesl2()!=10){
			return false;
		}
		return true;
	}
	
	public int bonusPourStrike(){
		return getNbQuillesAbattuesl1()+getNbQuillesAbattuesl2();
	}
	
	public int bonusPourSpare(){
		return getNbQuillesAbattuesl1();
	}
	
	public int score(){
		int scoreTour=0;
		suivant.getNumeroTour()+=1;
		if(estUnStrike()){
			scoreTour = 10 + suivant.bonusPourStrike();
		} else if(estUnSpare()){
			scoreTour = 10 + suivant.bonusPourSpare();
		} else {
			scoreTour = getNbQuillesAbattuesl1() + getNbQuillesAbattuesl2();
		}
		return scoreTour;
	}
}
