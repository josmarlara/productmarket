<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
 <script type="text/javascript" src="js/materialize.min.js"></script>
<title>Shop Producto market</title>
</head>
<body>
          <div class="container">
         <form action="buscarProducto" >
            		
            		
            		<table>
            		<tr>
            		<td>
					   <div class="input-field col s5">
                       <input type='text' name='nombreProducto' id='nombreProducto'/>  
                      <label for="nombreProducto">BuscarProducto</label>
                      </div>
					  </td> 
					  <td>
					  <button class="btn waves-effect waves-light" type="submit" name="action">buscar
                    <i class="material-icons right">send</i>
                     </button>
                     </td>
                     </tr>
				</table>	  
					  
					  
			 <p><span class="red accent-4">${vacio}</span></p>		  
					 
           </form>
                  <c:set var="t" value="0"></c:set>
                    <c:forEach var="c" items="${sessionScope.cart}">
                    <c:set var="t" value="${t + c.producto.precio * c.cantidad}"></c:set>
                    </c:forEach>
      <h4>Total Compra: ${t} </h4>  <a href="verCompra" class="waves-effect waves-light btn">Detalle Compra</a>   
           <a href="comprar" class="waves-effect waves-light btn">Comprar</a> 
           <a href="cancelarCompra" class="waves-effect waves-light btn">Cancelar Compra</a>   
    <div class="carousel carousel-slider center" data-indicators="true">
    
    <div class="carousel-item red white-text" href="#one!">
      <h2>First Panel</h2>
      <p class="white-text">This is your first panel</p>
    </div>
    <div class="carousel-item amber white-text" href="#two!">
      <h2>Second Panel</h2>
      <p class="white-text">This is your second panel</p>
    </div>
    <div class="carousel-item green white-text" href="#three!">
      <h2>Third Panel</h2>
      <p class="white-text">This is your third panel</p>
    </div>
    <div class="carousel-item blue white-text" href="#four!">
      <h2>Fourth Panel</h2>
      <p class="white-text">This is your fourth panel</p>
    </div>
  </div>
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
   
        </div>
  <script>
  $('.carousel.carousel-slider').carousel({fullWidth: true});
  
  </script>
</body>
</html>