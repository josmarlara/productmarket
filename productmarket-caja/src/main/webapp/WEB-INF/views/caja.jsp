<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<title>Producto market punto de venta</title>
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
 <script type="text/javascript" src="js/materialize.min.js"></script>
<style type="text/css">
            .input-error { margin-bottom: 6px !important; }
            .text-error { font-size: 0.8em !important; }
        </style>
</head>

<body>
  <div class="container">

<h3>Product Market-Punto de venta</h3>







<form action="agregarProducto">

<div class="row">
 <div class="input-field col s5">
 
 <h6>Código de barras</h6>
</div>
</div>


<div class="row">
 <div class="input-field col s5">
 <input type='text' name='codigoBarras' id='codigoBarras' autofocus="autofocus" />  
 
</div>
</div>


<div class="row">
                        <div class="input-field col">
                            <input type="submit" value="Registrar" class="btn waves-effect"/>
                            
                        </div>
                    </div>
                    
                    <p><span class="red accent-4">${vacio}</span></p>	

</form>

<table class="bordered">

              <thead>
                    <tr>
                        <th>Eliminar</th>
                        <th>Cantidad</th>
                        <th>Nombre Producto</th>
                        <th>Precio</th>
                        <th>Sub total</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="t" value="0"></c:set>
                    <c:forEach var="c" items="${sessionScope.cart}">
                    <c:set var="t" value="${t + c.producto.precio * c.cantidad}"></c:set>
                     <tr>
                     <td><a href="borrarProducto?idProducto=${c.producto.idProducto}" class="waves-effect waves-light btn">BorrarProducto</a></td>
                     <td>${c.cantidad}</td>
                     <td>${c.producto.nombreProducto}</td>
                     <td>${c.producto.precio}</td>
                     <td>${c.producto.precio * c.cantidad}</td>
                     
                     </tr>
                    
                    
                    </c:forEach>
                    <tr>
                    <td colspan="4">Total</td>
                    <td>${t}</td>
                    
                    
                    </tr>

                   </tbody>


                 </table>




                 
 </div>
 
			 <div class="row">
                        <div class="input-field col">
                            <a href="pagar" class="waves-effect waves-light btn">Pagar</a>
                            <a href="cancelarCompra" class="waves-effect waves-light btn">Cancelar Compra</a>
                        </div>
                    </div>
			
			
	 		
			
	
 
 

 

</body>
</html>