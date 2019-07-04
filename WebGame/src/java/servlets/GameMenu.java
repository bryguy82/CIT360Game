/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.WordBankControl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Game;
import model.Player;
import model.WordBank;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryan
 */
@WebServlet(name = "GameMenu", urlPatterns = {"/GameMenu"})
public class GameMenu extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // Build game here.
            Game game = new Game();
            Player player = new Player();
            WordBank wordbank = new WordBank();
            game.setTheGame(game);
            game.setThePlayer(player);
            game.setWordBank(wordbank);

            // Object array holders
            Object[] personNounArray;
            Object[] adverbArray;
            Object[][] verbObject;
            Object[][] adjectiveObject;
            Object[] objectNounArray;

            // Set up the arrays: thread, http, json
            WordBankControl wordBankControl = new WordBankControl();
            wordBankControl.buildWordBank();

            // Get arrays from game object to test
            personNounArray = game.getTheGame().getPersonNounArray();
            adverbArray = game.getTheGame().getAdverbArray();
            verbObject = game.getTheGame().getVerbDoubleArray();
            adjectiveObject = game.getTheGame().getAdjectiveDoubleArray();
            objectNounArray = game.getTheGame().getObjectNounArray();

            String testing1 = "";
            String testing2 = "";
            String testing3 = "";
            String testing4 = "";
            String testing5 = "";
            if (personNounArray == null) {
                testing1 = "bad";
            } else {
                testing1 = "good";
            }
            if (adverbArray == null) {
                testing2 = "bad";
            } else {
                testing2 = "good";
            }
            if (verbObject == null) {
                testing3 = "bad";
            } else {
                testing3 = "good";
            }
            if (adjectiveObject == null) {
                testing4 = "bad";
            } else {
                testing4 = "good";
            }
            if (objectNounArray == null) {
                testing5 = "bad";
            } else {
                testing5 = "good";
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Crazy Sentence Menu</title>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"basicCss.css\">");
            out.println("</head>");
            out.println("<body>");
//            out.println("<p>" + testing1 +"</p>");
//            out.println("<p>" + testing2 +"</p>");
//            out.println("<p>" + testing3 +"</p>");
//            out.println("<p>" + testing4 +"</p>");
//            out.println("<p>" + testing5 +"</p>");

            // Form for the random game
            out.println("<form action=\"RandomSentence\" method=\"post\">");
            out.println("<input class=\"above\" type=\"submit\" value=\"Random Sentence\">");
            out.println("</form>");

            // From for the custom game
            out.println("<form action=\"CustomChoices\" method=\"post\">");
            out.println("<input class=\"above\" type=\"submit\" value=\"Custom Sentence\">");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
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
