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
					  
					  
					  
					 
           </form>
                    <c:set var="t" value="0"></c:set>
                    <c:forEach var="c" items="${sessionScope.cart}">
                    <c:set var="t" value="${t + c.producto.precio * c.cantidad}"></c:set>
                    </c:forEach>
           <h4>Total Compra:${t}</h4>
           
           
            <a href="verCompra" class="waves-effect waves-light btn">Detalle Compra</a>   
           <a href="comprar" class="waves-effect waves-light btn">Comprar</a>
           <a href="cancelarCompra" class="waves-effect waves-light btn">Cancelar Compra</a>
           
         <c:if test="${empty productoList}">
                No hay productos busca otra ocurrencia
            </c:if>  
           
      
           <c:if test="${not empty productoList}">   
     <div class="paging"></div>       
          
    <div class="row" >  
   <c:forEach items="${productoList}" var="pro">
      <div class="element">
           <div class="col s12 m7">
   
    <h2 class="header"><c:out value="${pro.nombreProducto}"/></h2>
    <div class="card horizontal">
      <div class="card-image">
        <img src="${pageContext.request.contextPath}/imagenProducto?id=${pro.idProducto}" alt="imagen no disponible" />
      </div>
      <div class="card-stacked">
        <div class="card-content">
       
       <table>
       
       <tr>
       <td>
       <ul class="collection">
      <li class="collection-item">Descripcion: </li>
      <li class="collection-item">Cantidad disponible:</li>
      <li class="collection-item">Precio:</li>
      
       </ul>
       </td>
       
       <td>
       <ul class="collection">
      <li class="collection-item"><c:out value="${pro.descripcion}"/> </li>
      <li class="collection-item"><c:out value="${pro.cantidad}"/> </li>
      <li class="collection-item">$<c:out value="${pro.precio}"/></li>
      
       </ul>
       </td>
       
       
       
        </tr>
       </table> 
        
        </div>
        <div class="card-action">
          <a href="agregarCompra?id=<c:out value='${pro.idProducto}'/>"
          class="waves-effect waves-light btn">Agregar</a>
        </div>
      </div>
    </div>
  </div>
      </div>     
   </c:forEach>
  
  
 </div>
           
     <div class="paging"></div>
           
           
    </c:if>       
           
           
           
           
           
           
           
           
           
   
        </div>
  
  
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
        <script src="js/jquery.ba-hashchange.js"></script>
        <script src="js/jquery.paging.min.js"></script>
        <script>

            /*
             * Slicing the content with two pagers and using the URL Hash event
             */
            (function() {

                var prev = {
                    start: 0,
                    stop: 0
                };


                var content = $('.element');

                var Paging = $(".paging").paging(content.length, {
                    onSelect: function() {

                        var data = this.slice;

                        content.slice(prev[0], prev[1]).css('display', 'none');
                        content.slice(data[0], data[1]).fadeIn("slow");

                        prev = data;

                        return true; // locate!
                    },
                    onFormat: function(type) {

                        switch (type) {

                            case 'block':

                                if (!this.active)
                                    return '<span class="disabled">' + this.value + '</span>';
                                else if (this.value != this.page)
                                    return '<em><a href="#' + this.value + '">' + this.value + '</a></em>';
                                return '<span class="current">' + this.value + '</span>';

                            case 'right':
                            case 'left':

                                if (!this.active) {
                                    return '';
                                }
                                return '<a href="#' + this.value + '">' + this.value + '</a>';

                            case 'next':

                                if (this.active) {
                                    return '<a href="#' + this.value + '" class="next">Next &raquo;</a>';
                                }
                                return '<span class="disabled">Next &raquo;</span>';

                            case 'prev':

                                if (this.active) {
                                    return '<a href="#' + this.value + '" class="prev">&laquo; Previous</a>';
                                }
                                return '<span class="disabled">&laquo; Previous</span>';

                            case 'first':

                                if (this.active) {
                                    return '<a href="#' + this.value + '" class="first">|&lt;</a>';
                                }
                                return '<span class="disabled">|&lt;</span>';

                            case 'last':

                                if (this.active) {
                                    return '<a href="#' + this.value + '" class="prev">&gt;|</a>';
                                }
                                return '<span class="disabled">&gt;|</span>';

                            case 'fill':
                                if (this.active) {
                                    return "...";
                                }
                        }
                        return ""; // return nothing for missing branches
                    },
                    format: '[< ncnnn! >]',
                    perpage: 3,
                    lapping: 0,
                    page: null // we await hashchange() event
                });


                $(window).hashchange(function() {

                    if (window.location.hash)
                        Paging.setPage(window.location.hash.substr(1));
                    else
                        Paging.setPage(1); // we dropped "page" support and need to run it by hand
                });

                $(window).hashchange();
            })();
        </script>
  
  
  
  
  
  
  
  
  
</body>
</html>