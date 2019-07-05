/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.WordBankControl;
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
@WebServlet(name = "RandomSentence", urlPatterns = {"/RandomSentence"})
public class RandomSentence extends HttpServlet {

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
            WordBankControl wordControl = new WordBankControl();

            //call random number generator for each integer
            int min = 0;
            int personMax = game.getTheGame().getPersonNounArray().length - 1;
            int adverbMax = game.getTheGame().getAdverbArray().length - 1;
            int verbTenseMax = game.getTheGame().getVerbDoubleArray().length - 1;
            int verbMax = game.getTheGame().getVerbDoubleArray()[0].length - 1;
            int adjectiveMax = game.getTheGame().getAdjectiveDoubleArray()[0].length - 1;
            int objectMax = game.getTheGame().getObjectNounArray().length - 1;
            int placeMax = game.getTheGame().getPlaceNounArray().length - 1;

            int personNum = wordControl.setRandomNumber(min, personMax);
            int adverbNum = wordControl.setRandomNumber(min, adverbMax);
            int verbTenseNum = wordControl.setRandomNumber(min, verbTenseMax);
            int verbNum = wordControl.setRandomNumber(min, verbMax);
            int adjectiveNum = wordControl.setRandomNumber(min, adjectiveMax);
            int objectNum = wordControl.setRandomNumber(min, objectMax);
            int placeNum = wordControl.setRandomNumber(min, placeMax);

            // insert selections to retrieve words and set sentence options
            wordControl.wordSelection(personNum, adverbNum, verbTenseNum, verbNum, adjectiveNum, objectNum, placeNum);

            // build a random number and assign the sentence
            int sentenceMax = game.getTheGame().getSentence().size() - 1;
            int sentenceNum = wordControl.setRandomNumber(min, sentenceMax);
            String sentence = wordControl.assignTheSentence(sentenceNum); // This determines the sentence to use

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Random Sentence</title>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"smallCss.css\">");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class=\"title\">");
            out.println("<h1>Here's your random crazy sentence!</h1>");
            out.println("</div>");

            // Display the sentence
            out.println("<div class=\"sentence\">");
            out.println("<p>" + sentence + "</p>");
            out.println("</div>");

            out.println("<div class=\"end\">");
            out.println("<button><a href=\"endGame.html\">Done</a></button>");
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
