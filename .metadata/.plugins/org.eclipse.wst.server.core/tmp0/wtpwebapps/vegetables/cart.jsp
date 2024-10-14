<%@page import="java.text.DecimalFormat"%>
<%@page import="shoopping_cart.dao.ProductDao"%>
<%@page import="java.util.*"%>
<%@page import="shopping_cart.connection.DbCon"%>
<%@page import="shopping_cart.model.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf",dcf);
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("person", auth); 
        }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if(cart_list != null){
    	ProductDao pDao = new ProductDao(DbCon.getConnection());
    	cartProduct = pDao.getCartProducts(cart_list);
    	double total =	pDao.getTotalCartPrice(cart_list);
    request.setAttribute("cart_list", cart_list);
    	request.setAttribute("total",total);
    }
    %>
<!DOCTYPE html>
<html>
<head>

<%@include file="includes/head.jsp"%>
<title>cart page</title>
<style type="text/css">
.table tbody td{
vartical-align:middle;
}
.btn-incre, .btn-decre{
box-shadow:none;
font-size :25px;
}
</style>

</head>
<body>
<%@include file="includes/Navbar.jsp"%>
<div class="container">
<div class="d-flex py-3">
<h1>Total Price:${ (total>0)?dcf.format(total):0 } </h1>
<h3><a class="mx-3 btn btn-primary" href="cart-check-out"> check out</a></h3>
</div>
<table class="table table-light">
<thead>
<tr>
<th scope="col">Name</th>
<th scope="col">category</th>
<th scope="col">price</th>
<th scope="col">Buy Now</th>
<th scope="col">Cancel</th>
</tr>
</thead>
<tbody>
<% if(cart_list != null){
	for(Cart c: cartProduct){%>
		<tr>
		<td><%= c.getName() %></td>
		<td><%= c.getCategory() %></td>
		<td><%= dcf.format(c.getPrice())%></td>
		<td>
		<form action="order-now" method="post" class="form-inline">
		<input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
		<div class="form-group d-flex justify-content-between ">
		<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
		<input type="text" name="quantity" class="foam-control " value="<%=c.getQuantity() %>" readonly>
		<a class="btn btn-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a>
		</div>
		<button type="submit" class="btn btn-primary btn-sm">buy</button>
		</form>
		</td>
		<td><a class="btn btn-sm btn-danger" href="remove-from-cart?id=<%= c.getId()%>">Remove</a></td>
		</tr>
	<% }
}	
	%>

</tbody>

</table>
</div>
<%@include file="includes/footer.jsp"%>
</body>
</html>