package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import package1.DataBase;

public final class appoinments_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel='stylesheet' type='text/css' href='appointments.css'>\n");
      out.write("        <title>MediTEC - Appointments</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

        String name = request.getParameter("name");
        String img = request.getParameter("img");
        String id = request.getParameter("id").substring(0,4);
        DataBase database = new DataBase();
        String[] doctor = database.DoctorList(id,"d");
        String[] citas = database.AppointmentsList(name);
        
        
      out.write("\n");
      out.write("        <div id=\"info\">\n");
      out.write("            <img src=\"");
      out.print(img);
      out.write("\" alt=\"profilePhoto\" height=\"20%\" width=\"60%\">\n");
      out.write("            <a><p><br>Name:");
      out.print(doctor[2]);
      out.write("</p></a>\n");
      out.write("            <a><p><br>Doctor ID: ");
      out.print(id);
      out.write("</p></a>\n");
      out.write("            <a><p><br>Calificación:");
      out.print(doctor[1]);
      out.write("</p></a>\n");
      out.write("        </div>\n");
      out.write("        ");
 
            for (int i = 0; i < citas.length; i++) {
                if(i%2==0){
      out.write("\n");
      out.write("                    <div id=\"citas1\">\n");
      out.write("                ");
}else{
      out.write("\n");
      out.write("                    <div id=\"citas2\">\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
for (int j = 0; j < 7; j++) {
      out.write("\n");
      out.write("                    <p ID=\"");
      out.print((i*7)+j);
      out.write("\"></p>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                    </div>\n");
      out.write("            ");
}
        
      out.write("\n");
      out.write("        <script>");
 
            for (int i = 0; i < citas.length; i++) {
                String x = "'{"+citas[i]+"}'";
      out.write("\n");
      out.write("                var obj = JSON.parse(");
      out.print(x);
      out.write(");\n");
      out.write("                document.getElementById(\"\"+");
      out.print((i*7)+0);
      out.write(").innerHTML = \"Fecha: \"+obj.date;\n");
      out.write("                document.getElementById(\"\"+");
      out.print((i*7)+1);
      out.write(").innerHTML = \"Doctor ID: \"+obj.doctorId;\n");
      out.write("                document.getElementById(\"\"+");
      out.print((i*7)+2);
      out.write(").innerHTML = \"ID: \"+obj.id;\n");
      out.write("                document.getElementById(\"\"+");
      out.print((i*7)+3);
      out.write(").innerHTML = \"Location: \"+obj.location;\n");
      out.write("                document.getElementById(\"\"+");
      out.print((i*7)+4);
      out.write(").innerHTML = \"Patient Name: \"+obj.patientName;\n");
      out.write("                document.getElementById(\"\"+");
      out.print((i*7)+5);
      out.write(").innerHTML = \"Pay: \"+obj.pay;\n");
      out.write("                document.getElementById(\"\"+");
      out.print((i*7)+6);
      out.write(").innerHTML = \"Symtomps: \"+obj.symptomps;\n");
      out.write("                ");
}
            
      out.write("\n");
      out.write("        </script>\n");
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
