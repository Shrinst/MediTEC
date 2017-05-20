package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import package1.DataBase;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Meditec - Start Page</title>\n");
      out.write("        <link rel='stylesheet' type='text/css' href='sheet1.css'>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
String name = request.getParameter("name");
        String img = request.getParameter("img");
        String id = request.getParameter("id").substring(0,4);
        DataBase database = new DataBase();
        String[] doctor = database.DoctorList(id,name);
      out.write("\n");
      out.write("        <div id=\"info\">\n");
      out.write("            <img src=\"");
      out.print(img);
      out.write("\" alt=\"profilePhoto\" height=\"20%\" width=\"60%\">\n");
      out.write("            <a><p><br>Name:");
      out.print(name);
      out.write("</p></a>\n");
      out.write("            <a><p><br>Doctor ID: ");
      out.print(id);
      out.write("</p></a>\n");
      out.write("            <a><p><br>Calificación:");
      out.print(doctor[1]);
      out.write("</p></a>\n");
      out.write("        </div>\n");
      out.write("        <form action = \"main.jsp\" method = \"GET\" ID=\"agenda\">\n");
      out.write("                <input type = \"text\" name = \"img\" value=\"");
      out.print(img);
      out.write("\" style=\"visibility: hidden\"><br>\n");
      out.write("                <input type = \"text\" name = \"id\" value=\"");
      out.print(id);
      out.write("\" style=\"visibility: hidden\"><br>\n");
      out.write("                <input type = \"submit\" value = \"Agenda\" />\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
