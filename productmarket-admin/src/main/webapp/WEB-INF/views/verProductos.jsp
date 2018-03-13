<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
 <c:when test="${userObj.nombreUsuario != null}">
 <c:if test="${empty productoList}">
                No hay productos
            </c:if>
            <c:if test="${not empty productoList}">  
             <form action="buscarProducto.html" >
            		
					   <div class="input-field col s5">
                       <input type='text' name='nombreProducto' id='nombreProducto'/>  
                      <label for="nombreProducto">BuscarProducto</label>
                      </div>
					  
					  <button class="btn waves-effect waves-light" type="submit" name="action">buscar
                    <i class="material-icons right">send</i>
                     </button>
					  
					  
					  
					  
					 
            	</form> 
             
             
             
             
             
             <table class="striped">
                    <thead>
                    <tr>
                        <th>idProducto</th>
                        <th>idReferencia</th>
                        <th>Nombre Producto</th>
                         <th>Código de barras</th>
                         <th>Descripción</th> 
                          <th>Cantidad</th>
                         <th>Precio</th>
                         <th>Imagen</th> 
                         <th>Unidad</th> 
                        <th>Actualizar</th>
                        <th>Eliminar</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${productoList}" var="pro">
                     
                        
                        <tr>
                         
                            <td><c:out value="${pro.idProducto}"/></td>
                            <td><c:out value="${pro.idReferencia}"/></td>
                            <td><c:out value="${pro.nombreProducto}"/></td>
                            <td><c:out value="${pro.codigoBarras}"/></td>
                            <td><c:out value="${pro.descripcion}"/></td>
                            <td><c:out value="${pro.cantidad}"/></td>
                            <td><c:out value="${pro.precio}"/></td>
                            <td><img src="${pageContext.request.contextPath}/imagenProducto.html?id=${pro.idProducto}" alt="imagen no disponible" height="100" width="100" /></td> 
                             <td><c:out value="${pro.unidad}"/></td>
                            <td><a href="editarProducto.html?id=<c:out value='${pro.idProducto}'/> " 
                            class="waves-effect waves-light btn" >Actualizar</a></td>
                            <td><a href="eliminarProducto.html?id=<c:out value='${pro.idProducto}'/>"
                            class="waves-effect waves-light btn" >Eliminar</a></td>                          
                     
                        </tr>
                      
                    </c:forEach>
                    </tbody>
                </table>
         
            
         
            
       </c:if>
 </c:when>    
    <c:otherwise>
      <c:redirect  url="salir.html"></c:redirect>  
    </c:otherwise>
</c:choose>