package core.entity;

/**
 *
 * @author user
 */
public class Toiture {
    
    	final static float LARGEUR_VOLIGE = 0.3f; //0.3m donc 30 cm
	final static float M2_POSE_PAR_JOUR = 50.0f;
	final static int REDRESSAGE = 2;
	final static int MONTAGE_DEMONTAGE = 1;
	final static String CUT=" ";
        
	private float surfaceToiture;	
	private float pureau;
	private float nbLiteau;
	private float metreLiteau;
	private float largeurToiture;
	private float longueurToiture;
	private float longueurFaitage;
	private float surfaceTotalVelux;
	private float largeurArdoise;
	private float diametreCrochet;
	private String forme="rectangle";
	private String volige;
	private float ardoiseAuM2;
	private float totalArdoise;
	private float jourDeTravail; 
	private float hauteurArdoise;
	private float longueurCrochet;
	private float longueurVolige;
        int nbVelux=0;
	String hauteurVeluxEnString="";
	String largeurVeluxEnString="";
        
    
	
	//CONSTRUCTEUR
	public Toiture() {
		
	}
	
	
	//GETTERS
	
	public float getSurfaceToiture() {
		surfaceToiture=calculSurfaceToit();
		return surfaceToiture;
	}
       
	public float getPureau() {
		pureau=calculPureau();
		return pureau;
	}

	public float getNbLiteau() {
		nbLiteau=calculNbLiteau();
		return nbLiteau;
	}
	
	public float getMetreLiteau() {
		metreLiteau=calculMetreLiteau();
		return metreLiteau;
	}
	
	public float getArdoiseAuM2() {
		ardoiseAuM2=nbArdoiseAuM2(); 
		return ardoiseAuM2;
	}

	public float getTotalArdoise() {
		totalArdoise=nbTotalArdoise();
		return totalArdoise;
	}
	
	public float getJourDeTravail() {
		jourDeTravail=jourDeChantier();
		return jourDeTravail;
	}
	
	public float getLongueurVolige() {
		longueurVolige=calculVolige();
		return longueurVolige;
	}
	
        public float getSurfaceTotalVelux() {
		surfaceTotalVelux=calculSurfaceVelux();
		return surfaceTotalVelux;
	}
	
	//SETTERS

        public void setSurfaceToiture(float surfaceToiture){
                this.surfaceToiture=surfaceToiture;
        }
        
	public void setLargeurToiture(float largeurToiture) {
		this.largeurToiture = largeurToiture;
	}

	public void setLongueurToiture(float longueurToiture) {
		this.longueurToiture = longueurToiture;
	}

	public void setLongueurFaitage(float longueurFaitage) {
		this.longueurFaitage = longueurFaitage;
	}

	public void setSurfaceTotalVelux(float surfaceTotalVelux) {
		this.surfaceTotalVelux = surfaceTotalVelux;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public void setHauteurArdoise(float hauteurArdoise) {
		this.hauteurArdoise = hauteurArdoise;
	}

	public void setLongueurCrochet(float longueurCrochet) {
		this.longueurCrochet = longueurCrochet;
	}
	
	public void setLargeurArdoise(float largeurArdoise) {
		this.largeurArdoise = largeurArdoise;
	}

	public void setDiametreCrochet(float diametreCrochet) {
		this.diametreCrochet = diametreCrochet;
	}

	public void setVolige(String volige) {
		this.volige = volige;
	}
        
	public void setNbVelux(int nbVelux) {
		this.nbVelux = nbVelux;
	}
        
        public void setHauteurVeluxEnString(String hauteurVeluxEnString) {
		this.hauteurVeluxEnString = hauteurVeluxEnString;
	}

	public void setLargeurVeluxEnString(String largeurVeluxEnString) {
		this.largeurVeluxEnString = largeurVeluxEnString;
	}
        
        public void setPureau(float pureau) {
		this.pureau=pureau;
	}
	public void setArdoiseAuM2(float ardoiseAuM2) {
		this.ardoiseAuM2=ardoiseAuM2;
	}

	//METHODES//	
	public float calculSurfaceToit() {
		
		if(surfaceToiture==0) {
			if(forme.equals("triangle")) {
				surfaceToiture = (longueurToiture/2) * largeurToiture - getSurfaceTotalVelux();
			}
			else if(forme.equals("quatreVersants")) {
				surfaceToiture = ((largeurToiture*longueurFaitage) + ((longueurToiture-longueurFaitage)/2) * largeurToiture) - getSurfaceTotalVelux(); 
			}
			else {
				surfaceToiture = largeurToiture*longueurToiture - getSurfaceTotalVelux();
			}
			 surfaceToiture =(float) Math.ceil(surfaceToiture);
		}
		
		return surfaceToiture;
	}
	
	
	public float calculPureau() {
		
		return pureau = (float) ((hauteurArdoise - longueurCrochet + 0.5)/2);
	}
	
	
	public float calculNbLiteau() {
		
		float pureauEnCm = pureau/100;
		
		if(volige.equals("oui")) {
			nbLiteau = (float) Math.ceil((largeurToiture - (LARGEUR_VOLIGE+pureauEnCm))/pureauEnCm);}
		
		else {
			nbLiteau = (float) Math.ceil(largeurToiture/pureauEnCm);
		}
		
		return nbLiteau;
	}
	
	
	public float calculMetreLiteau() {
		
		if(forme.equals("quatreVersants")) {
			metreLiteau = (float) Math.ceil(nbLiteau*(longueurToiture - ((longueurToiture-longueurFaitage)/2)));
		}
		else if(forme.equals("triangle")) {
			metreLiteau= (float) Math.ceil(nbLiteau*(longueurToiture/2));
		}
		else{
			metreLiteau =  (float) Math.ceil(nbLiteau*longueurToiture);
			}
		return metreLiteau;
	}
	
	
	public float nbArdoiseAuM2() {
		
		return ardoiseAuM2 = (float) Math.ceil(10_000/(pureau*(largeurArdoise + diametreCrochet)));
	}
	
	
	public float nbTotalArdoise() {
		
		return totalArdoise = (float) Math.ceil(surfaceToiture * ardoiseAuM2);
	}
	
	
	public float jourDeChantier() {
		
		return jourDeTravail = (float) Math.ceil(surfaceToiture/M2_POSE_PAR_JOUR)+REDRESSAGE+MONTAGE_DEMONTAGE;
	}
	
	public float calculVolige() {
		if(volige.equals("non")){
                    longueurVolige=0f;
                }else{
                    longueurVolige = (float) Math.ceil(longueurToiture);
                }
		return longueurVolige;
	}
        
        	public float calculSurfaceVelux() {
		
		String [] hauteurVelux = hauteurVeluxEnString.split(CUT);
		String [] largeurVelux = largeurVeluxEnString.split(CUT);
		
		float [] hauteurVeluxEnFloat = new float[nbVelux];
		float [] largeurVeluxEnFloat = new float[nbVelux];
		
		for (int i = 0; i < nbVelux; i++) {
			
			hauteurVeluxEnFloat[i]=Float.parseFloat(hauteurVelux[i]);
			largeurVeluxEnFloat[i]=Float.parseFloat(largeurVelux[i]);
		}
		
		for(int i = 0; i <nbVelux; i ++) {
			float surfaceVelux=hauteurVeluxEnFloat[i]*largeurVeluxEnFloat[i];
			
			surfaceTotalVelux+=surfaceVelux;
		}
		
		return surfaceTotalVelux;
	}
}
