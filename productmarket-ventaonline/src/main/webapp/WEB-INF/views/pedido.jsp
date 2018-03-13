<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
 <script type="text/javascript" src="js/materialize.min.js"></script>
<title>Registra tu pedido</title>
<style type="text/css">
            .input-error { margin-bottom: 6px !important; }
            .text-error { font-size: 0.8em !important; }
        </style>
</head>
<body>
          <div class="container">
         <h3>Ingresa tu pedido</h3> 
         
          <c:set var="t" value="0"></c:set>
                    <c:forEach var="c" items="${sessionScope.cart}">
                    <c:set var="t" value="${t + c.producto.precio * c.cantidad}"></c:set>
                    </c:forEach>
           <h4>Total Compra: ${t}</h4>
           
           <form:form modelAttribute="orden" method="post" action="registrar" >

<div class="row">
 <div class="input-field col s5">
<form:label  path="nombre" >Nombre</form:label>   
<form:input  path="nombre" cssErrorClass="invalid input-error" />   
<form:errors path="nombre" cssClass="red-text text-error"/>
</div>
</div>

<div class="row">
 <div class="input-field col s5">
<form:label  path="apellidoPaterno" >Apellido Paterno</form:label>   
<form:input  path="apellidoPaterno" cssErrorClass="invalid input-error" />   
<form:errors path="apellidoPaterno" cssClass="red-text text-error"/>
</div>
</div>

<div class="row">
 <div class="input-field col s5">
<form:label  path="apellidoMaterno" >Apellido Materno</form:label>   
<form:input  path="apellidoMaterno"  />   
</div>
</div>

<div class="row">
 <div class="input-field col s5">
<form:label  path="calle" >Calle y número</form:label>   
<form:input  path="calle" cssErrorClass="invalid input-error" />   
<form:errors path="calle" cssClass="red-text text-error"/>
</div>
</div>


<div class="row">
 <div class="input-field col s5">
<form:label  path="entrecalles" >Entre  que calles</form:label>   
<form:input  path="entrecalles"  />   
</div>
</div>

<div class="row">
 <div class="input-field col s5">
<form:label  path="colonia" >Colonia</form:label>   
<form:input  path="colonia" cssErrorClass="invalid input-error" />   
<form:errors path="colonia" cssClass="red-text text-error"/>
</div>
</div>

<div class="row">
 <div class="input-field col s5">
<form:label  path="municipio" >Municipio</form:label>   
<form:input  path="municipio" cssErrorClass="invalid input-error" />   
<form:errors path="municipio" cssClass="red-text text-error"/>
</div>
</div>

<div class="row">
 <div class="input-field col s5">
<form:label  path="estado" >Estado</form:label>   
<form:input  path="estado" cssErrorClass="invalid input-error" />   
<form:errors path="estado" cssClass="red-text text-error"/>
</div>
</div>


<div class="row">
 <div class="input-field col s5">
<form:label  path="pais" >País</form:label>   
<form:input  path="pais" cssErrorClass="invalid input-error" />   
<form:errors path="pais" cssClass="red-text text-error"/>
</div>
</div>


<div class="row">
 <div class="input-field col s5">
<form:label  path="codigoPostal" >Código postal</form:label>   
<form:input  path="codigoPostal" cssErrorClass="invalid input-error" />   
<form:errors path="codigoPostal" cssClass="red-text text-error"/>
</div>
</div>


<div class="row">
 <div class="input-field col s5">
<form:label  path="telefono" >Teléfono</form:label>   
<form:input  path="telefono" cssErrorClass="invalid input-error" />   
<form:errors path="telefono" cssClass="red-text text-error"/>
</div>
</div>



<div class="row">
 <div class="input-field col s5">
<form:label  path="email" >Email</form:label>   
<form:input  path="email" cssErrorClass="invalid input-error" />   
<form:errors path="email" cssClass="red-text text-error"/>
</div>
</div>



 <div class="row">
                        <div class="input-field col">
                            <input type="submit" value="Registrar" class="btn waves-effect"/>
                            <a href="cancelarCompra" class="waves-effect waves-light btn">Cancelar Compra</a>
                        </div>
                    </div>

</form:form>  
         </div>


</body>
</html>