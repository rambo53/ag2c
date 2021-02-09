package core.entity;

import Service.MateriauxService;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class TotalVersants {
    
    	public ArrayList<Toiture> versants = new ArrayList<>();
	
        final static int NB_HEURES_TRAVAILLE_JOURNALIERE = 8;
        final int ALLER_RETOUR_PAR_JOUR = 2;
        final float TVA = 0.8f;
        
	private float totalArdoisesChantier;
        private float coutTotalArdoises;
	private float totalJoursChantier;
        private float coutTotalHoraire;
        private float coutTotalRepas;
	private float totalVoligeChantier;
        private float coutTotalvolige;
	private float totalMetresLiteauChantier;
        private float coutTotalLiteau;
	private float totalSurfaceChantier;
        private float coutTotalCarburant;
        private float coutArdoiseMarge;
        private float coutVoligeMarge;
        private float coutLiteauMarge;
        
	private float coutTotalChantier;
    
      
	public float getTotalArdoisesChantier() {
		
		totalArdoisesChantier=calculArdoisesTotal();
                
		return totalArdoisesChantier;
	}

        public float getCoutTotalArdoises() {
            
                coutTotalArdoises=calculCoutArdoise();
                return coutTotalArdoises;
        }

	public float getTotalJoursChantier() {
		totalJoursChantier=calculJoursChantierTotal();
		return totalJoursChantier;
	}

	public float getTotalVoligeChantier() {
		totalVoligeChantier=calculVoligeTotal();
		return totalVoligeChantier;
	}

        public float getCoutTotalvolige() {
                coutTotalvolige=calculCoutVolige();
                return coutTotalvolige;
        }
        
	public float getTotalMetresLiteauChantier() {
		totalMetresLiteauChantier=calculMetresLiteauTotal();
		return totalMetresLiteauChantier;
	}
        
        public float getCoutTotalLiteau() {
            
                coutTotalLiteau=calculCoutArdoise();
                return coutTotalLiteau;
        }

	public float getTotalSurfaceChantier() {
		totalSurfaceChantier=calculSurfaceTotal();
		return totalSurfaceChantier;
	}

	public ArrayList<Toiture> getVersants() {
		return versants;
	}

        public float getCoutTotalHoraire() {
                coutTotalHoraire=calculCoutHoraire();
                return coutTotalHoraire;
        }

        public float getCoutTotalRepas() {
                coutTotalRepas=calculCoutRepas();
                return coutTotalRepas;
        }

        public float getCoutTotalCarburant() {
                coutTotalCarburant=calculCoutCarburant();
                return coutTotalCarburant;
        }

        public float getCoutTotalChantier() {
                coutTotalChantier=coutTotalChantier();
                return coutTotalChantier;
        }

        public float getCoutArdoiseMarge() {
                coutArdoiseMarge=calculCoutArdoiseMarge();
                return coutArdoiseMarge;
        }

        public float getCoutVoligeMarge() {
                coutVoligeMarge=calculCoutVoligeMarge();
                return coutVoligeMarge;
        }   

        public float getCoutLiteauMarge() {
                coutLiteauMarge=calculCoutLiteauMarge();
                return coutLiteauMarge;
        }        
    
	//SETTERS
	
	public void setVersants(ArrayList<Toiture> versants) {
		this.versants = versants;
	}

        
	//METHODES
	
	public float calculArdoisesTotal() {
		
		for (Toiture toiture : versants) {
			
			totalArdoisesChantier+=toiture.getTotalArdoise();
		}
		
		return totalArdoisesChantier;
	}
	
        public float calculCoutArdoise(){
            MateriauxService materiauxService=new MateriauxService();
            Materiaux materiaux = materiauxService.getMateriaux("ardoise");
            float prix =materiaux.getPrix();
            coutTotalArdoises=totalArdoisesChantier*prix;
            
            return coutTotalArdoises;
        }
        
	
	public float calculJoursChantierTotal() {
		
		for (Toiture toiture : versants) {
			
			totalJoursChantier+=toiture.getJourDeTravail();
		}
		
		return totalJoursChantier;
	}
        
        public float calculCoutHoraire(){
            MateriauxService materiauxService=new MateriauxService();
            coutTotalHoraire=(totalJoursChantier*NB_HEURES_TRAVAILLE_JOURNALIERE)*materiauxService.getMateriaux("main d'oeuvre").getPrix();
            
            return coutTotalHoraire;
        }
	
        public float calculCoutRepas(){
            MateriauxService materiauxService=new MateriauxService();
            coutTotalRepas=totalJoursChantier*materiauxService.getMateriaux("repas").getPrix();
            
            return coutTotalRepas;
        }
	
	public float calculVoligeTotal() {
		
		for (Toiture toiture : versants) {
			
			totalVoligeChantier+=toiture.getLongueurVolige();
		}
		
		return totalVoligeChantier;
	}
        
        public float calculCoutVolige(){
            MateriauxService materiauxService=new MateriauxService();
            coutTotalvolige=totalVoligeChantier*materiauxService.getMateriaux("volige").getPrix();
            
            return coutTotalvolige;
        }
	
	public float calculMetresLiteauTotal() {
		
		for (Toiture toiture : versants) {
			
			totalMetresLiteauChantier+=toiture.getMetreLiteau();
		}
		
		return totalMetresLiteauChantier;
	}
        
        public float calculCoutLiteau(){
                MateriauxService materiauxService=new MateriauxService();
                coutTotalLiteau=totalMetresLiteauChantier*materiauxService.getMateriaux("liteau").getPrix();
            
                return coutTotalLiteau;
        }
	
	public float calculSurfaceTotal() {
		
		for (Toiture toiture : versants) {
			
			totalSurfaceChantier+=toiture.getSurfaceToiture();
		}
		
		return totalSurfaceChantier;
	}
        
        public float calculCoutCarburant(){
                MateriauxService materiauxService=new MateriauxService();
                coutTotalCarburant=(totalJoursChantier*ALLER_RETOUR_PAR_JOUR)*materiauxService.getMateriaux("carburant").getPrix()*TVA;
            
                return coutTotalCarburant;
        }
        
        public float coutTotalChantier(){
            
            coutTotalChantier=coutTotalArdoises+coutTotalCarburant+coutTotalHoraire+coutTotalLiteau+coutTotalRepas+coutTotalvolige;
            
            return coutTotalChantier;
        }
        
        public float calculCoutArdoiseMarge(){
            MateriauxService materiauxService=new MateriauxService();
            coutArdoiseMarge=materiauxService.getMateriaux("ardoise").getPrix()*materiauxService.getMateriaux("taux marge").getPrix();
            
            return coutArdoiseMarge;
        }
        
        public float calculCoutVoligeMarge(){
            MateriauxService materiauxService=new MateriauxService();
            coutArdoiseMarge=materiauxService.getMateriaux("volige").getPrix()*materiauxService.getMateriaux("taux marge").getPrix();
            return coutVoligeMarge;
        }
        
        public float calculCoutLiteauMarge(){
            MateriauxService materiauxService=new MateriauxService();
            coutArdoiseMarge=materiauxService.getMateriaux("liteau").getPrix()*materiauxService.getMateriaux("taux marge").getPrix();
            return coutLiteauMarge;
        }
}
