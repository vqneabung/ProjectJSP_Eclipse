/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.web.usermeal;

import dao.SpecMealDAO;
import dao.SpecMealDetailDAO;
import dao.UserMealDAO;
import dao.UserMealDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.SpecMealDTO;
import model.SpecMealDetailDTO;
import model.UserDTO;
import model.UserMealDTO;
import model.UserMealDetailDTO;

/**
 *
 * @author VQN
 */
public class ManageUserMealServlet extends HttpServlet {

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
            UserMealDAO um = new UserMealDAO();
            UserMealDetailDAO umd = new UserMealDetailDAO();

            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("User");

            if (user != null) {

                ArrayList<UserMealDTO> userMealList = um.getAllUserMealByUserID(user.getUserID());
                ArrayList<UserMealDetailDTO> userMealDetailList = umd.getAllUserMealDetail();

                out.println(user.getUserID());
                out.println(userMealList);
                out.println(userMealDetailList);

                

                request.setAttribute("userMealList", userMealList);
                request.setAttribute("userMealDetailList", userMealDetailList);

                if (userMealList != null || userMealDetailList != null) {
                    request.getRequestDispatcher("jsp/home/usermeals.jsp").forward(request, response);
                } else {
                    response.sendRedirect("jsp/home/home.jsp");
                }
            } else {
                response.sendRedirect("jsp/home/home.jsp");
            }
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
