/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidad.ClsEntidadPortafolio;
import Entidad.ClsEntidadPortafolioMaterialDocente;
import Entidad.ClsEntidadPortafolioMaterialEstudiante;
import Negocio.ClsNegocioInformeFinalCurso;
import Negocio.ClsNegocioPortafolio;
import Negocio.ClsNegocioPortafolioMaterialDocente;
import Negocio.ClsNegocioPortafolioMaterialEstudiante;
import Negocio.ClsNegocioUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author enzocv
 */
public class GuardarPortafolio extends HttpServlet {

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
            out.println("<title>Servlet GuardarPortafolio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GuardarPortafolio at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        PrintWriter out = response.getWriter();
        String codDocente = String.valueOf(request.getSession().getAttribute("codDocente"));
        
        String id_Curso = request.getParameter("idcurso");
        String revisado = request.getParameter("caRevisadoPor");
        
        String estado = request.getParameter("Guardar") != null ? "Guardado":"Enviado";
        
        String Asiste = request.getParameter("asiste");
        String Aprobado = request.getParameter("estAprobado");
        String Desaprobado = request.getParameter("estDesapro");
        
        /*Obtener el IDCARGAACADEMICA*/
        String idCargaAcademica = "";
        ClsNegocioUsuario docente = new ClsNegocioUsuario();
        ResultSet rsDocente;
        try {
            rsDocente = docente.obtenerDatosPruebaEntrada(codDocente, id_Curso);
            while (rsDocente.next()) {
                idCargaAcademica = rsDocente.getString(8);
            }
            docente.conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(GuardarInfoFinal.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*FIN DE OBTENER CARGAACADEMICA*/
        
        /*GUARDAR CABECERA PORTAFOLIO*/
//        ClsEntidadPortafolio entiPortafolio = new ClsEntidadPortafolio();
//        ClsNegocioPortafolio negPortafolio = new ClsNegocioPortafolio();
//        
//        entiPortafolio.setIdCargaAcademica(Integer.parseInt(idCargaAcademica));
//        entiPortafolio.setEstadoPortafolio(estado);
//        entiPortafolio.setEstudianteAsisten(Integer.parseInt( Asiste ) );
//        entiPortafolio.setEstudianteAprobado(Integer.parseInt( Aprobado ));
//        entiPortafolio.setEstudianteDesaprobado(Integer.parseInt(Desaprobado));
//        entiPortafolio.setRecepcioadoPor(revisado);
//
//        negPortafolio.AgregarPortafolio(entiPortafolio);
        
        /*FIN GUARDAR CABECERA PORTAFOLIO*/
//        out.println(Asiste);
//        out.println(Aprobado);
//        out.println(Desaprobado);
//        out.println(revisado);
        
        /* RECIBIR DATOS DE CAPACIDADES */
        ArrayList<String> datosTabla1 = new ArrayList<>();
//        ArrayList<String> datosMedidasCorrectivas = new ArrayList<>();

        Enumeration parameterList = request.getParameterNames();
        while( parameterList.hasMoreElements() )
        {
          String sName = parameterList.nextElement().toString();
          if(sName.toLowerCase().startsWith("t1")){
            datosTabla1.add(request.getParameter(sName));
          }
        }
        
        ClsEntidadPortafolioMaterialDocente entiMaterialDocente = new ClsEntidadPortafolioMaterialDocente();
        ClsNegocioPortafolioMaterialDocente negoMaterialDocente =  new ClsNegocioPortafolioMaterialDocente();

        ClsEntidadPortafolioMaterialEstudiante entiMaterialEstudiante = new ClsEntidadPortafolioMaterialEstudiante();
        ClsNegocioPortafolioMaterialEstudiante negoMaterialEstudiante =  new ClsNegocioPortafolioMaterialEstudiante();

//        ArrayList<String> idinfo = negoMaterialDocente.obtenerInfoFinalDocente(id_Curso,codDocente);
//        String id[] = idinfo.toArray(new String[idinfo.size()]);

        for (int i = 0; i < datosTabla1.size(); i+=3) {
            entiMaterialDocente.setIdPortafolio(Integer.parseInt( idCargaAcademica ));
            entiMaterialDocente.setMaterial(datosTabla1.get(i));
            String digi = datosTabla1.get(i+1).equals("digital") && datosTabla1.get(i+1) != null  ? "Si":"No";
            String impre = datosTabla1.get(i+2).equals("impreso") && datosTabla1.get(i+2) != null ? "Si":"No";
            boolean digital = false;
            boolean impreso = false;
            if (digi.equals("Si")) digital = true;
            if (impre.equals("Si")) impreso = true;
            
            out.println("T:"+datosTabla1.size());
            out.println("D:"+datosTabla1.get(i));
            out.println("DI:"+ datosTabla1.get(i+1) );
            out.println("IM:"+ datosTabla1.get(i+2) );
            out.println("CAN"+datosTabla1.get(i+3));
            out.println("BO DI"+ digi  );
            out.println("BO IM"+ impre );
            out.println("=================");
            
//            entiMaterialDocente.setDigital( digital );
//            entiMaterialDocente.setImpreso( impreso );
//            entiMaterialDocente.setCantidad( Integer.parseInt(datosTabla1.get(i+3)) );
//            
//            negoMaterialDocente.AgregarDetallePortafolioMaterialDocente(entiMaterialDocente);
        }

        try {
            negoMaterialDocente.cst.close();
            negoMaterialDocente.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(GuardarPortafolio.class.getName()).log(Level.SEVERE, null, ex);
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
