package controller;


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
@WebServlet(name = "TotalChantierServlet", urlPatterns = {"/total"})
public class TotalChantierServlet extends HttpServlet {



    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher disp = request.getRequestDispatcher("/total.jsp");
        TotalVersants versants=(TotalVersants)request.getSession().getAttribute("versants");
        
        if(versants!=null){
            System.out.println(versants);
            float surfaceTotal=versants.getTotalSurfaceChantier();
            float nbArdoisesTotal=versants.getTotalArdoisesChantier();
            float metreLiteauTotal=versants.getTotalMetresLiteauChantier();
            float metreVoligeTotal=versants.getTotalVoligeChantier();
            float joursDeChantierTotal=versants.getTotalJoursChantier();
            float coutTotalArdoises=versants.getCoutTotalArdoises();
            float coutTotalVolige=versants.getCoutTotalvolige();
            float coutTotalLiteau=versants.getCoutTotalLiteau();
            float coutTotalHoraire=versants.getCoutTotalHoraire();
            float coutTotalRepas=versants.getCoutTotalRepas();
            float coutTotalCarburant=versants.getCoutTotalCarburant();
            float coutTotalChantier=versants.getCoutTotalChantier();
            float coutArdoiseMarge=versants.getCoutArdoiseMarge();
            float coutVoligeMarge=versants.getCoutVoligeMarge();
            float coutLiteauMarge=versants.getCoutLiteauMarge();
            
            request.setAttribute("coutArdoiseMarge", coutArdoiseMarge);
            request.setAttribute("coutVoligeMarge", coutVoligeMarge);
            request.setAttribute("coutLiteauMarge", coutLiteauMarge);
            request.setAttribute("coutTotalChantier", coutTotalChantier);
            request.setAttribute("coutTotalCarburant", coutTotalCarburant);
            request.setAttribute("coutTotalRepas", coutTotalRepas);
            request.setAttribute("coutTotalHoraire", coutTotalHoraire);
            request.setAttribute("coutTotalLiteau", coutTotalLiteau);
            request.setAttribute("coutTotalVolige", coutTotalVolige);
            request.setAttribute("coutTotalArdoises", coutTotalArdoises);
            request.setAttribute("surfaceTotal", surfaceTotal);
            request.setAttribute("nbArdoisesTotal", nbArdoisesTotal);
            request.setAttribute("metreLiteauTotal", metreLiteauTotal);
            request.setAttribute("metreVoligeTotal", metreVoligeTotal);
            request.setAttribute("joursDeChantierTotal", joursDeChantierTotal);
        
            HttpSession session=request.getSession();
            versants=null;
            session.setAttribute("versants", versants);
        
            disp.forward(request, response);
        }
        else{
           disp.forward(request, response); 
        }
       
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
