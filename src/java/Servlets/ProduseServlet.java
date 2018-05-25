package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProduseServlet", urlPatterns = {"/ProduseServlet"})
public class ProduseServlet extends HttpServlet {

    public static String selectCategorie;

    public static String getSelectCategorie() {
        return selectCategorie;
    }

    public static void setSelectCategorie(String selectCategorie) {
        ProduseServlet.selectCategorie = selectCategorie;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/css/main.css' />");
            out.println("<meta name=\"description\" content=\"website description\" />");
            out.println("<meta name=\"keywords\" content=\"website keywords, website keywords\" />");
            out.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />");

            out.println("<body>");

            out.println("<div id=\"header\">");
            out.println("MAGAZIN COMPONENTE PC");
            out.println("</div>");

            out.println("<form action = 'AfisareProcesoare' method = 'post' >");
            out.println("<button type = 'submit'> Afisare procesoare </button>");
            out.println("</form>");

            out.println("<form action = 'AfisarePlaciVideo' method = 'post' >");
            out.println("<button type = 'submit'> Afisare placi video </button>");
            out.println("</form>");

            out.println("<form action = 'AfisarePlaciDeBaza' method = 'post' >");
            out.println("<button type = 'submit'> Afisare placi de baza </button>");
            out.println("</form>");

            out.println("<form action = 'AfisareHardDisk' method = 'post' >");
            out.println("<button type = 'submit'> Afisare hard disk-uri </button>");
            out.println("</form>");

            out.println("<form action = 'AfisarePlaciDeSunet' method = 'post' >");
            out.println("<button type = 'submit'> Afisare placi de sunet </button>");
            out.println("</form>");

            out.println("<form action = 'AfisareRAM' method = 'post' >");
            out.println("<button type = 'submit'> Afisare memorii RAM </button>");
            out.println("</form>");

            out.println("<form action = 'AfisareCarcase' method = 'post' >");
            out.println("<button type = 'submit'> Afisare carcase </button>");
            out.println("</form>");

            out.println("<form action = 'AfisareSurse' method = 'post' >");
            out.println("<button type = 'submit'> Afisare surse </button>");
            out.println("</form>");

            out.println("</div>");
            out.println("</body>");

            out.println("<title>Adauga produs</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action = 'AddProdus' method = 'post' >");

            out.println("<br>");
            out.println("<div class=\"coloana\">");
            out.println("Cod produs");
            out.println("</div>");
            out.println("<input name = 'codProdus' />");

            out.println("<br>");
            out.println("<div class=\"coloana\">");
            out.println("Pret");
            out.println("</div>");
            out.println("<input name = 'pret' />");

            out.println("<br>");
            out.println("<div class=\"coloana\">");
            out.println("An fabricatie");
            out.println("</div>");
            out.println("<input name = 'anFabricatie' />");

            out.println("<br>");
            out.println("<div class=\"coloana\">");
            out.println("Garantie");
            out.println("</div>");
            out.println("<input name = 'garantie' />");

            out.println("<br>");
            out.println("<div class=\"coloana\">");
            out.println("Stoc");
            out.println("</div>");
            out.println("<input name = 'stoc' />");

            out.println("<br>");
            out.println("<div class=\"coloana\">");
            out.println("Marca");
            out.println("</div>");
            out.println("<input name = 'marca' />");

            out.println("<br>");
            out.println("<div class=\"coloana\">");
            out.println("Producator ");
            out.println("</div>");
            out.println("<input name = 'producator' />");

            out.println("<br>");
            out.println("<div class=\"coloana\">");
            out.println("Tara provenienta");
            out.println("</div>");
            out.println("<input name = 'taraProvenienta' />");

            out.println("<br>");
            out.println("<button type = 'submit' id = \"adauga\" > Adauga componenta </button>");
            out.println("</form>");

            out.println("<br>");
            out.println("<form action = 'CautareProducator' method = 'post' >");
            out.println("<div id = \"produc\">");
            out.println("Cautare dupa producator: ");
            out.println("</div>");
            out.println("<input name = 'producatorr' id = \"produccc\" />");

            out.println("<button type = 'submit' id = \"cauta\"> Cauta </button>");
            out.println("<br>");

            out.println("</body>");
            out.println("</html>");
        }

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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProduseServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProduseServlet.class.getName()).log(Level.SEVERE, null, ex);
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
