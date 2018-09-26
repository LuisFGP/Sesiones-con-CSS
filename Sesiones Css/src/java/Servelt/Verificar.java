/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelt;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luis Garcia
 */
@WebServlet(name = "Verificar", urlPatterns = {"/Verificar"})
public class Verificar extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        String e=(String)sesion.getAttribute("email");
        String c=(String)sesion.getAttribute("contra");
        String rol=(String)sesion.getAttribute("Rol");
        
        if(rol.equals("1")){
            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("Bienvenid@ "+ e + " eres admin<br>");
            out.println("<a href=\"/SesionesCss/Comprar.jsp\"> Comprar</a><br>");
            out.println("<a href=\"/SesionesCss/Vender.jsp\"> Vender</a><br>");
            out.println("<a href=\"/SesionesCss/Reg.jsp\"> Generar Vendendedor</a><br>");
            out.println("<a href=\"/SesionesCss/Vic.jso\"> Ver productos</a><br>");
            out.println("<a href=\"/SesionesCss/index.html\"> Volver</a>");
            out.println("<br>");
            out.println("<br></body></html>");
        }
        else{
            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("Bienvenid@ "+e+ " eres Usuario");
            out.println("<a href=\"/SesionesCss/Comprar.jsp\"> Comprar</a><br>");
            out.println("<a href=\"/SesionesCss/Vic.jso\"> Ver productos</a><br>");
            out.println("<a href=\"/SesionesCss/index.html\"> Volver</a>");
            out.println("<br>");
            out.println("<br></body></html>");
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
