package Servlets;

import Proiect.Produs;
import crud.CrudProdus;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProduseServlet", urlPatterns = {"/ProduseServlet"})
public class AddProdus extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String codProdusAsString = request.getParameter("codProdus");
        String pretAsString = request.getParameter("pret");
        String anFabricatieAsString = request.getParameter("anFabricatie");
        String garantieAsString = request.getParameter("garantie");
        String stocAsString = request.getParameter("stoc");

        Integer codProdus = 0;
        Integer pret = 0;
        Integer anFabricatie = 0;
        Integer stoc = 0;
        Integer garantie = 0;

        if (!codProdusAsString.equals("")) {
            codProdus = Integer.parseInt(codProdusAsString);
        }
        if (!pretAsString.equals("")) {
            pret = Integer.parseInt(pretAsString);
        }
        if (!anFabricatieAsString.equals("")) {
            anFabricatie = Integer.parseInt(anFabricatieAsString);
        }
        if (!garantieAsString.equals("")) {
            stoc = Integer.parseInt(garantieAsString);
        }
        if (!stocAsString.equals("")) {
            garantie = Integer.parseInt(stocAsString);
        }
        Produs produs = new Produs(codProdus, pret, anFabricatie, garantie, stoc, request.getParameter("marca"),
                request.getParameter("producator"), request.getParameter("taraProvenienta"));
        System.out.println(produs);
        CrudProdus crudProd = new CrudProdus();
        System.out.println("urmeaza inserare produs.....");
        crudProd.insert(produs);
        System.out.println("Produs inserat.");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Produse.jsp");
        requestDispatcher.forward(request, response);
    }

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddProdus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddProdus.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddProdus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddProdus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
