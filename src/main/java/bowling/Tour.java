package bowling;

public class Tour {
	private static int globalNum=0;
	private int numeroTour;
	private int nbQuillesAbattuesl1;
	private int nbQuillesAbattuesl2;
	private Tour suivant;
	private int boule=0;
	
	public Tour(Tour suivant){
		globalNum++;
		this.numeroTour=globalNum;
		this.nbQuillesAbattuesl1=0;
		this.nbQuillesAbattuesl2=0;
		this.suivant = suivant;
	}
	
	public Tour(){
	}
	
	public void enregistreLancer(int nbQuillesAbattues){
		boule++;
		if(boule==1){
			nbQuillesAbattuesl1=nbQuillesAbattues;
		} else if(boule==2){
			nbQuillesAbattuesl2=nbQuillesAbattues;
		}
		
	}
	
	public boolean estTerminee(){
		boolean res=true;
		if(boule!=2){
			res=false;
		}
		if(estUnStrike()){
			res=true;
		}
		return res;
	}
	
	public int getBoule(){
		return boule;
	}
	
	public Tour getSuivant(){
		return suivant;
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
		if(this.estUnStrike()){
			return getNbQuillesAbattuesl1()+ suivant.bonusPourSpare();
		} else {
			return getNbQuillesAbattuesl1() + getNbQuillesAbattuesl2();
		}
	}
	
	public int bonusPourSpare(){
		return getNbQuillesAbattuesl1();
	}
	
	public int score(){ 
		int scoreTour=0;
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
