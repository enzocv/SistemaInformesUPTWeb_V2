/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidad.ClsEntidadPortafolioMaterialDocente;
import Negocio.ClsNegocioPortafolio;
import Negocio.ClsNegocioPortafolioMaterialDocente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Drei
 */
public class TraerDatosCompletosPortafolio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet TraerDatosCompletosPortafolio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TraerDatosCompletosPortafolio at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        String id_Portafolio = request.getParameter("id_Portafolio");
        String campo1[] = new String[11];
        
        try {
            ClsNegocioPortafolio negoPorta = new ClsNegocioPortafolio();
            ArrayList<String> informe = negoPorta.seleccionarInfoPortafolio(id_Portafolio);
            campo1 = informe.toArray(new String[informe.size()]);
            negoPorta.conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
//        ClsNegocioPortafolioMaterialDocente detalleInfoFinal = new ClsNegocioPortafolioMaterialDocente();
//        
//        ArrayList<ClsEntidadPortafolioMaterialDocente> detalle = detalleInfoFinal.seleccionarPortafolioMaterialDocente(id_Portafolio);        
//        Iterator iterator = detalle.iterator();
//
//        Object campo[] = new Object[4];
//        
//        
//
//        while (iterator.hasNext()) {            
//            ClsEntidadPortafolioMaterialDocente objDetalle;
//            objDetalle = (ClsEntidadPortafolioMaterialDocente) iterator.next();
//
//
//            campo[0] = String.valueOf(objDetalle.getMaterial());
//            if(objDetalle.isDigital()){
//                campo[1] = Boolean.TRUE;
//            }else{
//                campo[1] = Boolean.FALSE;
//            }
//            if(objDetalle.isImpreso()){
//                campo[2] = Boolean.TRUE;
//            }else{
//                campo[2] = Boolean.FALSE;
//            }
//            campo[3] = objDetalle.getCantidad();
//
//            modelo.addRow(campo);
//        }
//        try {
//            detalleInfoFinal.conexion.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(FrmPortafolio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        tablaDocente.setModel(modelo);
        
        
        request.setAttribute("campo1", campo1);
//        request.setAttribute("campo3", campo3);
//        request.setAttribute("campo4", campo4);
        request.getRequestDispatcher("portafolioActualizar.jsp?id_Portafolio="+id_Portafolio).forward(request, response);
    }
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
