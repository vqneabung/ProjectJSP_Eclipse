/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.web.usermeal;

import dao.DayDAO;
import dao.DishDAO;
import dao.ProductDAO;
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
import model.SpecMealDTO;
import model.SpecMealDetailDTO;

/**
 *
 * @author VQN
 */
public class InsertUserMealServlet extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            UserMealDAO um = new UserMealDAO();

            int userID = Integer.parseInt(request.getParameter("insert_userMealID").trim());
            String userMealName = request.getParameter("insert_userMealName");

            int rs = um.insertUserMeal(userMealName, userID);

            if (rs >= 1) {
                out.print("<p>Da insert thanh cong </p>");
                out.print("<p><a href='jsp/home/home.jsp'>back</a></p>");
            } else {
                out.print("<p>something wrong</p>");
                out.print("<p><a href='jsp/home/home.jsp'>back</a></p>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String btn_insert = request.getParameter("btn_insert");

        ProductDAO p = new ProductDAO();
        DishDAO dh = new DishDAO();
        UserMealDetailDAO umd = new UserMealDetailDAO();
        UserMealDAO um = new UserMealDAO();
        DayDAO d = new DayDAO();
        PrintWriter out = response.getWriter();

        if (btn_insert == null) {

            SpecMealDAO sm = new SpecMealDAO();
            SpecMealDetailDAO smd = new SpecMealDetailDAO();

            ArrayList<SpecMealDTO> specMealList = sm.getAllSpecMeal();
            ArrayList<SpecMealDetailDTO> specMealDetailList = smd.getAllSpecMealDetail();

            request.setAttribute("specMealList", specMealList);
            request.setAttribute("specMealDetailList", specMealDetailList);

            int userID = Integer.parseInt(request.getParameter("userID"));
            request.setAttribute("userID", userID);

            request.getRequestDispatcher("/jsp/home/usermeal_insert.jsp").forward(request, response);

        } else {
            processRequest(request, response);
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
