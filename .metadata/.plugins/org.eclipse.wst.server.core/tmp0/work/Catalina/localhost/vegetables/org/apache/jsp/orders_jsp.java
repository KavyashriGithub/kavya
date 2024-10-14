/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.30
 * Generated at: 2024-09-30 05:17:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shoopping_cart.dao.OrderDao;
import java.util.*;
import shopping_cart.connection.DbCon;
import shopping_cart.model.*;
import java.text.DecimalFormat;

public final class orders_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/includes/head.jsp", Long.valueOf(1725031456806L));
    _jspx_dependants.put("/includes/Navbar.jsp", Long.valueOf(1725268159285L));
    _jspx_dependants.put("/includes/footer.jsp", Long.valueOf(1723273095054L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("shopping_cart.model");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("shopping_cart.connection.DbCon");
    _jspx_imports_classes.add("java.text.DecimalFormat");
    _jspx_imports_classes.add("shoopping_cart.dao.OrderDao");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
 
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf",dcf);
    User auth = (User) request.getSession().getAttribute("auth");
    List<Order> orders = null;
    if (auth != null) {
        request.setAttribute("auth", auth); 
        
        orders =new OrderDao(DbCon.getConnection()).userOrders(auth.getId());
       
        
        }else{
        	response.sendRedirect("login.jsp");
        }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if(cart_list != null){
    	request.setAttribute("cart_list", cart_list);
    }
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\">");
      out.write("\r\n");
      out.write("<title>orders page</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <a class=\"navbar-brand\" href=\"index.jsp\">shopping cart</a>\r\n");
      out.write("  \r\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("  </button>\r\n");
      out.write("  \r\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("    <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("      <li class=\"nav-item active\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"index.jsp\">Home </a>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"cart.jsp\">cart<span class=\"badge badge-danger px-1\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ cart_list.size()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span></a>\r\n");
      out.write("      </li>\r\n");
      out.write("     \r\n");
      out.write("     ");
 if(auth != null){ 
      out.write("\r\n");
      out.write("    \t <li class=\"nav-item\">\r\n");
      out.write("         <a class=\"nav-link disabled\" href=\"orders.jsp\">orders</a>\r\n");
      out.write("       </li>\r\n");
      out.write("       <li class=\"nav-item\">\r\n");
      out.write("         <a class=\"nav-link disabled\" href=\"log-out\">logout</a>\r\n");
      out.write("       </li>\r\n");
      out.write("     ");

     } else{
    	 
      out.write(" \r\n");
      out.write("     \r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link disabled\" href=\"login.jsp\">login</a>\r\n");
      out.write("      </li>\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("     \r\n");
      out.write("    </ul>\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class =\"container\">\r\n");
      out.write("<div class=\"card-header my-3\">All Orders</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<table class=\"table table-light\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">Date</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">Name</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">Category</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">Quantity</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">Price</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">Cancel</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t");

			if(orders != null){
				for(Order o:orders){
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(o.getDate() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(o.getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(o.getCategory() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(o.getQuantity() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(dcf.format(o.getPrice()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td><a class=\"btn btn-sm btn-danger\" href=\"cancel-order?id=");
      out.print( o.getOrderid());
      out.write("\">cancel</a></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
}
			}
			
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" ></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\"></script>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
