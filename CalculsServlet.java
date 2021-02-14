package controller;



import core.entity.Toiture;
import core.entity.TotalVersants;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author user
 */
@WebServlet(name = "CalculsServlet", urlPatterns = {"/calculs"})
public class CalculsServlet extends HttpServlet {

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      RequestDispatcher disp = request.getRequestDispatcher("/resultats.jsp");
      HttpSession session=request.getSession();
      Toiture toiture=new Toiture();  
      
      
      
      float rampant=Float.parseFloat(request.getParameter("rampant"));
      float facade=Float.parseFloat(request.getParameter("facade"));
      float faitage=Float.parseFloat(request.getParameter("faitage"));   
      String nomVersant=request.getParameter("nomVersant");
      String forme=request.getParameter("forme");
      String volige=request.getParameter("volige");
      float hauteurArdoise=Float.parseFloat(request.getParameter("hauteurArdoise")); 
      float largeurArdoise=Float.parseFloat(request.getParameter("largeurArdoise")); 
      float longueurCrochet=Float.parseFloat(request.getParameter("longueurCrochet")); 
      float diametreCrochet=Float.parseFloat(request.getParameter("diametreCrochet")); 
      int nbVelux=Integer.parseInt(request.getParameter("nbVelux"));
      String hauteurVeluxEnString=request.getParameter("hauteurVelux");
      String largeurVeluxEnString=request.getParameter("largeurVelux");
      
      toiture.setLargeurToiture(rampant);
      toiture.setLongueurToiture(facade);
      toiture.setForme(forme);
      toiture.setVolige(volige);
      toiture.setLongueurFaitage(faitage);
      toiture.setHauteurArdoise(hauteurArdoise);
      toiture.setLargeurArdoise(largeurArdoise);
      toiture.setLongueurCrochet(longueurCrochet);
      toiture.setDiametreCrochet(diametreCrochet);
      toiture.setNbVelux(nbVelux);
      toiture.setHauteurVeluxEnString(hauteurVeluxEnString);
      toiture.setLargeurVeluxEnString(largeurVeluxEnString);
      
      float surface=toiture.getSurfaceToiture();
      float pureau=toiture.getPureau();
      float nbLiteau=toiture.getNbLiteau();
      float nbArdoiseAuM2=toiture.getArdoiseAuM2();
      float nbTotalArdoise=toiture.getTotalArdoise();
      float jourDeChantier=toiture.getJourDeTravail();
      float metreLiteau=toiture.getMetreLiteau();
      float longueurVolige=toiture.getLongueurVolige();
      
      
      request.setAttribute("nomVersant", nomVersant);
      request.setAttribute("surface", surface);
      request.setAttribute("pureau", pureau);
      request.setAttribute("nbLiteau",nbLiteau );
      request.setAttribute("nbArdoiseAuM2",nbArdoiseAuM2 );
      request.setAttribute("nbTotalArdoise",nbTotalArdoise );
      request.setAttribute("jourDeChantier",jourDeChantier );
      request.setAttribute("metreLiteau",metreLiteau );
      request.setAttribute("longueurVolige", longueurVolige);
      request.setAttribute("volige", volige);
      
      TotalVersants versants=(TotalVersants)request.getSession().getAttribute("versants");
      
      if(versants==null){
          versants = new TotalVersants();
          session.setAttribute("versants", versants);
      }
          versants.getVersants().add(toiture);
   
      disp.forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  

}
