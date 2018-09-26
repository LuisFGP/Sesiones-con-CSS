/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelt;

import java.io.IOException;
import java.io.PrintWriter;
import Clases.Conexion;
import javax.jms.Session;
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
@WebServlet(name = "ValidaReg", urlPatterns = {"/ValidaReg"})
public class ValidaReg extends HttpServlet {
    
    String Email;
    String Contra;
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidaReg</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaReg at " + request.getContextPath() + "</h1>");
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
        Email=request.getParameter("Email");
        Contra=request.getParameter("Contra");
        String Rol="";
        Conexion cone= new Conexion();
        
        if(cone.Con(Email, Contra).equals("Oka")){

        
            Rol= cone.Rol(Email, Contra);

            
            HttpSession sesion= request.getSession();
            sesion.setAttribute("email", Email);
            sesion.setAttribute("contra", Contra);
            sesion.setAttribute("Rol", Rol);
            
            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("¡Bienvenido!" + Rol +"<br>");
            out.println("<a href=\"/SesionesCss/Verificar\">Verifica tu Sesion</a>");
            out.println("<a href=\"/SesionesCss/index.html\"> Volver</a><br>");
            out.println("<br></body></html>");
        
        }
        else{
            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body>");
            out.println("Cuenta Valida");
            out.println("<a href=\"/SesionesCss/index.html\"> Volver</a>");
            out.println("<br>");
            out.println("<br></body></html>");
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
