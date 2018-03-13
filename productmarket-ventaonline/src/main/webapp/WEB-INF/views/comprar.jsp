<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
 <script type="text/javascript" src="js/materialize.min.js"></script>
<title>Confirmar compra</title>
</head>
<body>
 <div class="container">
<h1>Confirmar compra</h1>

<h2>Datos personales:</h2>
<table  class="striped">
        <thead>
         
        </thead>

        <tbody>
          <tr>
            <td> <span class="red-text text-darken-2">Nombre: </span> ${orden.nombre} ${orden.apellidoPaterno} ${orden.apellidoMaterno}</td>
          </tr>
           <tr>
            <td><span class="red-text text-darken-2">Calle y número: </span>${orden.calle}</td>
            </tr>
           
            <tr>
            <td><span class="red-text text-darken-2">Entrecalles: </span>${orden.entrecalles}</td>
            </tr>
           
             <tr>
            <td><span class="red-text text-darken-2">Colonia: </span>${orden.colonia}</td>
            </tr>
            
            <tr>
            <td><span class="red-text text-darken-2">Municipio: </span>${orden.municipio}</td>
            </tr>
            
            <tr>
            <td><span class="red-text text-darken-2">Estado: </span>${orden.estado}</td>
            </tr>
            
            <tr>
            <td><span class="red-text text-darken-2">País: </span>${orden.pais}</td>
            </tr>
            
            <tr>
            <td><span class="red-text text-darken-2">Código Postal: </span>${orden.codigoPostal}</td>
            </tr>
            
            <tr>
            <td><span class="red-text text-darken-2">Teléfono: </span>${orden.telefono}</td>
            </tr>
            
             <tr>
            <td><span class="red-text text-darken-2">Email: </span>${orden.email}</td>
            </tr>
            
         
          
          
          </tbody>
      </table>

<h2>Orden:</h2>

 <table class="bordered">

              <thead>
                    <tr>
                        
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
                     <td>${c.cantidad}</td>
                     <td>${c.producto.nombreProducto}</td>
                     <td>${c.producto.precio}</td>
                     <td>${c.producto.precio * c.cantidad}</td>
                     
                     </tr>
                    
                    
                    </c:forEach>
                    <tr>
                    <td colspan="3">Total</td>
                    <td>${t}</td>
                    
                    
                    </tr>

                   </tbody>


                 </table><br>
    
    
    <form:form   modelAttribute="orden" method="post" action="pagar">
    
    
    <form:hidden path="nombre"  value="${orden.nombre}"/>
    <form:hidden path="apellidoPaterno"  value="${orden.apellidoPaterno}"/>
    <form:hidden path="apellidoMaterno"  value="${orden.apellidoMaterno}"/>
    <form:hidden path="calle"  value="${orden.calle}"/>
    <form:hidden path="entrecalles"  value="${orden.entrecalles}"/>
    <form:hidden path="colonia"  value="${orden.colonia}"/>
    <form:hidden path="municipio"  value="${orden.municipio}"/>
    <form:hidden path="estado"  value="${orden.estado}"/>
    <form:hidden path="pais"  value="${orden.pais}"/>
    <form:hidden path="codigoPostal"  value="${orden.codigoPostal}"/>
    <form:hidden path="telefono"  value="${orden.telefono}"/>
     <form:hidden path="email"  value="${orden.email}"/>
      
      
    
    <div class="row">
                        <div class="input-field col">
                            <input type="submit" value="Pagar" class="btn waves-effect"/>
                            <a href="cancelarCompra" class="waves-effect waves-light btn">Cancelar Compra</a>
                        </div>
                    </div>
    
    
    
    
    
    
    </form:form>
    
    
    


</div>


</body>
</html>