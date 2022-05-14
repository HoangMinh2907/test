/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.plant.Plant;
import pe.plant.PlantDAO;

/**
 *
 * @author PHT
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String op = request.getParameter("op");
        try {
            switch (op) {
                case "Search": {
                    PlantDAO dao = new PlantDAO();
                    String searchText = request.getParameter("searchText");
                    List<Plant> list = dao.getPlants(searchText);
                    request.setAttribute("list", list);
                    url = "searchPage.jsp";
                    HttpSession session=request.getSession();
                    session.setAttribute("searchText", searchText);
                }
                break;
                case "UpdateForm": {
                    PlantDAO dao = new PlantDAO();
                    int id = Integer.parseInt(request.getParameter("id"));
                    Plant plant = dao.selectById(id);
                    request.setAttribute("plant", plant);
                    url = "plantPage.jsp";
                }
                break;
                case "Update": {
                    PlantDAO dao = new PlantDAO();
                    int id = Integer.parseInt(request.getParameter("id"));
                    int status = Integer.parseInt(request.getParameter("status"));
                    int count = dao.updateStatus(id, status);
                    url = "searchPage.jsp";
                }
                break;
            }
        } catch (Exception e) {            
            url = ERROR;
            request.setAttribute("errorMessage", e.getMessage());
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
