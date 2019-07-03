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
import model.Player;
import model.WordBank;

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // Build game here.
            Game game = new Game();
            Player player = new Player();
            WordBank wordbank = new WordBank();
            
            Object[] personNounArray;
            Object[] adverbArray;
            Object[] verbObject;
            Object[] adjectiveObject;
            Object[] objectNounArray;
            
            
            WordBankControl wordBankControl = new WordBankControl();
//            do {           
                wordBankControl.buildWordBank();

                personNounArray = game.getPersonNounArray();
                adverbArray = game.getAdverbArray();
                verbObject = game.getVerbObject();
                adjectiveObject = game.getAdjectiveObject();
                objectNounArray = game.getObjectNounArray();
//            } while (personNounArray.length == 0 || 
//                     adverbArray.length == 0 || 
//                     verbObject.length == 0 ||
//                     adjectiveObject.length == 0 ||
//                     objectNounArray.length == 0 );
            
            String test = (String) personNounArray[1];
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
            out.println("<div>TODO write content</div>");
            out.println("<p>" + test + "</p>");
            
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
