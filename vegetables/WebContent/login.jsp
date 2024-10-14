<%@page import="java.util.*"%>
<%@page import="shopping_cart.connection.DbCon"%>
<%@page import="shopping_cart.model.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
       response.sendRedirect("index.jsp"); 
        }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if(cart_list != null){
    	request.setAttribute("cart_list", cart_list);
    }
    %>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/head.jsp"%>
<title>login page</title>

</head>
<body>

<%@include file="includes/Navbar.jsp"%>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">userLogin</div>
			<div class="card-body">
				<form action="user-Login" method="post">

					<div class="form-group">
						<label>Email Address</label> <input type="email"
							class="form.control" name="login-email"
							placeholder="enter your email" required>
					</div>
					<div class="form-group">
						<label>password</label> <input type="password"
							class="form.control" name="login-password" placeholder="****"
							required>
					</div>
					<div class="text-center">
						<button type="submit" class="btn-primary">login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
	
</body>
</html>