package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Negocio.ClsNegocioUsuario;
import java.sql.*;
import Negocio.ClsNegocioUsuario;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    
    ResultSet rs = null;
    String codDocente;
    String nivelUsuario;
    String mensaje = "";
    
    String usu = request.getParameter("txtUsuario");
    String pass = request.getParameter("txtPassword");   
    
    ClsNegocioUsuario usuario = new ClsNegocioUsuario();

    if((usu!=null) && (pass!=null)){
        boolean existe = false;
        rs = usuario.LoginUsuario(usu, pass);
        
        while (rs.next()) {                
                if (usu.equals(rs.getString(2)) && pass.equals(rs.getString(3))) {
                    if ("Activo".equals(rs.getString(5))) {
                        session.setAttribute("codDocente", rs.getString(2));
                        session.setAttribute("nivelUsuario", rs.getString(4));
                        session.setAttribute("estadoUsuario", rs.getString(5));  
                        session.setAttribute("nombreDocente", rs.getString(6));
                        rs.close();
                        usuario.conexion.close();
                        response.sendRedirect("reportesFaltantes.jsp");
                    }
                    else{
                        mensaje = "Lo sentimos: Te encuetras desactivado";
                    }
                
                }
                existe = true;
                break;
            }            
        if (existe == false) {
            mensaje = "El usuario no se encuentra registrado.";
        }
    }
    
    if(request.getParameter("Cancelar")!= null){
        mensaje = "";
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        \r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link href=\"css/styles.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <script src=\"js/jquery-3.1.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <title>Sistema UPT - Login</title> \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container-fluid background\">\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"row row-login-container\">\r\n");
      out.write("                <div class=\"col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-xs-12 login-container\">\r\n");
      out.write("                    <form name=\"frmlogin\" method=\"POST\" class=\"modal-form\">\r\n");
      out.write("                        <div class=\"modal-dialog\">\r\n");
      out.write("                          <div class=\"modal-content\">\r\n");
      out.write("                            <div class=\"modal-header\">\r\n");
      out.write("                              <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\r\n");
      out.write("                              <h4 class=\"modal-title\">Login</h4>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-body\">\r\n");
      out.write("                                <label class=\"control-label\">Usuario : </label>\r\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"txtUsuario\" placeholder=\"Ingresa usuario\">\r\n");
      out.write("                                <label class=\"control-label\">Password : </label>\r\n");
      out.write("                                <input class=\"form-control\" type=\"password\" name=\"txtPassword\" placeholder=\"Ingresa password\">                                \r\n");
      out.write("                                ");

                                    if (mensaje != "") {
                                            out.println("<p class='mensaje-login'>" + mensaje + "</p>");
                                        }
                                
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-footer\">\r\n");
      out.write("                                <input class=\"btn btn-primary\" type=\"submit\" name=\"Enviar\" value=\"Ingresar\">\r\n");
      out.write("                                <input class=\"btn btn-danger\" type=\"submit\" name=\"Cancelar\" value=\"Cancelar\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                          </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
