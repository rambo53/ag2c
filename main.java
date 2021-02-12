import core.entity.Toiture;
import core.entity.TotalVersants;

class Start {
    public static void main(String[] args) {


        /*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */

/**
 *
 * @author user
 */


                Toiture toiture=new Toiture();
                toiture.setLargeurToiture(5);
                toiture.setLongueurToiture(5);
                toiture.setDiametreCrochet(0.9f);
                toiture.setHauteurArdoise(32);
                toiture.setLargeurArdoise(22);
                toiture.setLongueurCrochet(9);
                toiture.setPureau(11.75f);
                toiture.setArdoiseAuM2(35f);

                Toiture toiture1=new Toiture();
                toiture1.setLargeurToiture(2);
                toiture1.setLongueurToiture(2);
                toiture1.setDiametreCrochet(0.9f);
                toiture1.setHauteurArdoise(32);
                toiture1.setLargeurArdoise(22);
                toiture1.setLongueurCrochet(9);
                toiture1.setPureau(11.75f);
                toiture1.setArdoiseAuM2(35f);

                Toiture toiture2=new Toiture();
                toiture2.setLargeurToiture(2);
                toiture2.setLongueurToiture(10);toiture.setDiametreCrochet(0.9f);
                toiture2.setHauteurArdoise(32);
                toiture2.setLargeurArdoise(22);
                toiture2.setLongueurCrochet(9);
                toiture2.setPureau(11.75f);
                toiture2.setArdoiseAuM2(35f);



                TotalVersants versants = new TotalVersants();
                versants.getVersants().add(toiture);
                versants.getVersants().add(toiture1);
                versants.getVersants().add(toiture2);

                float surfaceTotale = versants.getTotalSurfaceChantier();
                float totalArdoise=versants.getTotalArdoisesChantier();
                float totaleArdoiseChantier=versants.getCoutTotalArdoises();


                System.out.println(surfaceTotale);
                System.out.println(totaleArdoiseChantier);
                System.out.println(totalArdoise);



            }
        }
