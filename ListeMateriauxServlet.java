package controller;

import Service.MateriauxService;
import core.entity.Materiaux;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author user
 */
@WebServlet(name = "ListeMateriauxServlet", urlPatterns = {"/liste"})
public class ListeMateriauxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher disp = request.getRequestDispatcher("/prix-materiaux.jsp");
        MateriauxService materiauxService=new MateriauxService();
        
        List<Materiaux> liste=materiauxService.getListMateriaux();
        
        request.setAttribute("liste", liste);
        disp.forward(request, response); 
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
  

}
