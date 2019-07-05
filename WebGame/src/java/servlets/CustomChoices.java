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
import model.Game;

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
            throws ServletException, IOException, NullPointerException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // Start objects for the functions in that class
            Game game = new Game();

            // Get array/list sizes to use as the maxes
            int min = 0;
            int personMax = game.getTheGame().getPersonNounArray().length - 1;
            int adverbMax = game.getTheGame().getAdverbArray().length - 1;
            int verbTenseMax = game.getTheGame().getVerbDoubleArray().length - 1;
            int verbMax = game.getTheGame().getVerbDoubleArray()[0].length - 1;
            int adjectiveMax = game.getTheGame().getAdjectiveDoubleArray()[0].length - 1;
            int objectMax = game.getTheGame().getObjectNounArray().length - 1;
            int placeMax = game.getTheGame().getPlaceNounArray().length - 1;
            int sentenceMax = game.getTheGame().getSentence().size() - 1;

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Custom Word Selection</title>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"smallCss.css\">");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class=\"title\">");
            out.println("<h1>Please make a selection</h1>");
            out.println("</div>");

            // Form for nouns, verbs, etc.
            out.println("<div class=\"custom\">");
            out.println("<form action=\"CustomSentence\" method=\"post\">");

            // Put min and max array/list sizes to be dynamic
            out.println("<label>Sentence<input type=\"number\" name=\"sentenceNum\" min=\"" + min + "\" max=\"" + sentenceMax + "\" required></label>");
            out.println("<label>Past (0) Present (1) Future (2)<input type=\"number\" name=\"verbTense\" min=\"" + min + "\" max=\"" + verbTenseMax + "\" required></label>");

            out.println("<label>Person Noun<input type=\"number\" name=\"personNoun\" min=\"" + min + "\" max=\"" + personMax + "\" autofocus required></label>");
            out.println("<label>Adverb<input type=\"number\" name=\"adverb\" min=\"" + min + "\" max=\"" + adverbMax + "\" required></label>");
            out.println("<label>Verb<input type=\"number\" name=\"verb\" min=\"" + min + "\" max=\"" + verbMax + "\" required></label>");
            out.println("<label>Adjective<input type=\"number\" name=\"adjective\" min=\"" + min + "\" max=\"" + adjectiveMax + "\" required></label>");
            out.println("<label>Object Noun<input type=\"number\" name=\"objectNoun\" min=\"" + min + "\" max=\"" + objectMax + "\" required></label>");
            out.println("<label>Place<input type=\"number\" name=\"placeNoun\" min=\"" + min + "\" max=\"" + placeMax + "\" required></label>");
            out.println("<input type=\"submit\" value=\"Go!\">");

            out.println("</form>");
            out.println("</div>");

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
