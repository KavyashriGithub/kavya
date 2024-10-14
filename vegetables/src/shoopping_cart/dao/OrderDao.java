package shoopping_cart.dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import shopping_cart.model.*;



public class OrderDao {

	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public OrderDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean insertOrder(Order model) {
		boolean result=false;
		try {
			query="INSERT INTO orders (p_id,u_id,quantity,o_date)VALUES(?,?,?,?)";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, model.getId());
			pst.setInt(2,model.getUid());
			pst.setInt(3,model.getQuantity());
			pst.setString(4,model.getDate());
			pst.executeUpdate();
			result= true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
		
	}
	public List<Order>userOrders(int id){
		List<Order>list=new ArrayList<>();
		try {
			query="select* from orders where u_id=? order by orders.o_id desc";
		pst=this.con.prepareStatement(query);
		pst.setInt(1,id);
		rs=pst.executeQuery();
		while(rs.next()) {
			Order order=new Order();
			ProductDao productDao=new ProductDao(this.con);
		int pId=rs.getInt("p_id");
		Product product= productDao.getSingleProduct(pId);
		order.setOrderid(rs.getInt("o_id"));
		order.setId(pId);
		order.setName(product.getName());
		order.setCategory(product.getCategory());
		order.setPrice(product.getPrice()*rs.getInt("quantity"));
		order.setQuantity(rs.getInt("quantity"));
		order.setDate(rs.getString("o_date"));
		list.add(order);
		}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;
	}
	public  void cancelOrder(int id) {
//		boolean result =false;
		try {
			query="delete from orders where o_id=?";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, id);
			pst.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
//		return result;
		
	}
}
