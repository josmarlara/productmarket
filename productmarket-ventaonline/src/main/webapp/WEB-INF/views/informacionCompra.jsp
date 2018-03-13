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
<title>Información de compra</title>
</head>
<body>
          <div class="container">
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
                     <td><a href="borrarProducto?id=${c.producto.idProducto}" class="waves-effect waves-light btn">BorrarProducto</a></td>
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

     <br>
     <a href="buscarProductos" class="waves-effect waves-light btn">Continuar comprando</a>
     <a href="comprar" class="waves-effect waves-light btn">Comprar</a>
     <a href="cancelarCompra" class="waves-effect waves-light btn">Cancelar Compra</a>
</div>


</body>
</html>