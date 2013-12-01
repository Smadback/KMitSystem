
package com.kmitsystem.servlets.user;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Smadback
 */
public class UserProfileServlet extends HttpServlet {

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
        
        String name = request.getParameter("user");
        
//        UserServiceProvider provider = new UserServiceProvider());
//        GetEverythingInput input = new GetEverythingInput(name);
//        GetEverythingResult result = provider.getEverything(input);
        
        // prepare the output and write it into the session
//        User user = result.getUser();
//        List<Team> teams = result.getTeams();
//        List<Tournament> tournaments = result.getTournaments();
        
//        request.setAttribute("user", user);
//        request.setAttribute("teams", team);
//        request.setAttribute("tournaments", tournaments);
        
        // write the errorlist into the session-attribute "errors"
//        if(result.getErrorList().size() > 0) {
//            request.getSession().setAttribute("errors", result.getErrorList());
//        }
        
        // redirect to the page www.kmitsystem.de/teams
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/profile/index.jsp");
        rd.include(request, response);
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
