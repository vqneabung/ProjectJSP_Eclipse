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
import model.DayDTO;
import model.DishDTO;
import model.ProductDTO;
import model.SpecMealDTO;
import model.SpecMealDetailDTO;
import model.UserMealDTO;

/**
 *
 * @author VQN
 */
public class InsertUserMealDetailServlet extends HttpServlet {

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
            ProductDAO p = new ProductDAO();
            DishDAO dh = new DishDAO();
            UserMealDetailDAO umd = new UserMealDetailDAO();
            DayDAO d = new DayDAO();
            UserMealDAO um = new UserMealDAO();

            int dayNum = Integer.parseInt(request.getParameter("insert_dayNum"));
            int productID = Integer.parseInt(request.getParameter("insert_productID"));
            int dishID = Integer.parseInt(request.getParameter("insert_dishID").trim());
            int userMealID = Integer.parseInt(request.getParameter("insert_userMealID").trim());

            //email khong trung
            int rs = umd.insertUserMealDetail(productID, dishID, userMealID, dayNum);

            if (rs >= 1) {
                out.print("<p>Da insert thanh cong </p>");
                out.print("<p><a href='jsp/admin/admin_home.jsp'>back</a></p>");
            } else {
                out.print("<p>something wrong</p>");
                out.print("<p><a href='jsp/admin/admin_home.jsp'>back</a></p>");
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

        ProductDAO p = new ProductDAO();
        DishDAO dh = new DishDAO();
        UserMealDetailDAO umd = new UserMealDetailDAO();
        UserMealDAO um = new UserMealDAO();
        DayDAO d = new DayDAO();
        PrintWriter out = response.getWriter();

        String btn_insert = request.getParameter("btn_insert");
        if (btn_insert == null) {

            ArrayList<ProductDTO> product = p.getAllProducts();
            ArrayList<DishDTO> dish = dh.getAllDish();
            ArrayList<DayDTO> day = d.getAllDay();
            UserMealDTO userMeal = um.getUserMealByUserID(Integer.parseInt(request.getParameter("userMealID").trim()));

            SpecMealDAO sm = new SpecMealDAO();
            SpecMealDetailDAO smd = new SpecMealDetailDAO();

            ArrayList<SpecMealDTO> specMealList = sm.getAllSpecMeal();
            ArrayList<SpecMealDetailDTO> specMealDetailList = smd.getAllSpecMealDetail();

            request.setAttribute("specMealList", specMealList);
            request.setAttribute("specMealDetailList", specMealDetailList);

            request.setAttribute("productList", product);
            request.setAttribute("dishList", dish);
            request.setAttribute("dayList", day);
            request.setAttribute("userMeal", userMeal);

//            out.print("<h1>" + product.get(0).getProductName());
//            out.print("<h1>" + dish.get(0).getDishName());
//            out.print("<h1>" + day.get(0).getDayText());
//            out.print("<h1>" + specMeal.toString());
            request.getRequestDispatcher("/jsp/home/usermealdetail_insert.jsp").forward(request, response);
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
