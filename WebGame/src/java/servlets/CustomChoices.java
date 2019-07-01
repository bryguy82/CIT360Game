/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bryan
 */
@WebServlet(name = "CustomChoices", urlPatterns = {"/CustomChoices"})
public class CustomChoices extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Custom Word Selection</title>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"basicCss.css\">");           
            out.println("</head>");
            out.println("<body>");
            
            // Form for nouns, verbs, etc.
            out.println("<form action=\"CustomSentence\" method=\"post\">");
            out.println("<fieldset class=\"custom\">");
            out.println("<legend>Parts of Speech</legend>");
            
            out.println("<label class=\"above\">Person Noun<input type=\"number\" name=\"personNoun\" min=\"0\" max=\"10\" autofocus required></label>");
            out.println("<label class=\"above\">Adverb<input type=\"number\" name=\"adverb\" min=\"0\" max=\"10\" required></label>");
            out.println("<label class=\"above\">Verb<input type=\"number\" name=\"verb\" min=\"0\" max=\"10\" required></label>");
            out.println("<label class=\"above\">Adjective<input type=\"number\" name=\"adjective\" min=\"0\" max=\"10\" required></label>");
            out.println("<label class=\"above\">Object Noun<input type=\"number\" name=\"objectNoun\" min=\"0\" max=\"10\" required></label>");
            out.println("<input class=\"above\" type=\"submit\" value=\"Go!\">");
            
            out.println("</fieldset>");
            out.println("</form>");

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
        processRequest(request, response);
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
        processRequest(request, response);
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
