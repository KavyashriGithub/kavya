package Shoopiing_cart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoopping_cart.dao.OrderDao;
import shopping_cart.connection.DbCon;



/**
 * Servlet implementation class CancelOrderServlet
 */
@WebServlet("/cancel-order")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("canceled");
		try(PrintWriter out=response.getWriter()){
			String id=request.getParameter("id");

			if(id!= null) {
				OrderDao orderDao=new OrderDao(DbCon.getConnection());
				orderDao.cancelOrder(Integer.parseInt(id));
			}
			
			response.sendRedirect("orders.jsp");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
