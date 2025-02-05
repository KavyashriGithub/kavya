<%@page import="java.util.*"%>
<%@page import="shoopping_cart.dao.ProductDao"%>
<%@page import="shopping_cart.connection.DbCon"%>
<%@page import="shopping_cart.model.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth); 
        }
  ProductDao pd = new ProductDao(DbCon.getConnection());
  List<Product> products = pd.getAllProducts();
  ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
  if(cart_list != null){
  	request.setAttribute("cart_list", cart_list);
  }
    %>
    
<!DOCTYPE html>
<html>
<head>
<title>welcome</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
<%@include file="includes/Navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
    <%
    if( !products.isEmpty()){
    	for(Product p:products){
    	%>
<div class="col-md-3 my-6 ">
<div class="card w=100" style="width: 18rem;">
<img class="card-img-top"src="product-images/<%=p.getImage() %>" alt="Card image cap">
<div class="card-body">
<h5 class="card-title">card:<%=p.getName() %></h5>
<h6 class="price">price:<%=p.getPrice()%></h6>
<h6 class="category">category:<%=p.getCategory() %></h6>
<div class="mt-3 d-flex justify-content-between">   
<a href="add-to-cart?id=<%= p.getId() %>" class="btn btn-dark">add to cart</a>
<a href="order-now?quantity=1&id=<%= p.getId() %>" class="btn btn-primary">buy now</a>
</div>
</div>
</div> 
</div>
    <% 
  }
    }
 %>

</div></div>

<%@include file="includes/footer.jsp"%>
</body>
</html>