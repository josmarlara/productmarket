<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
 <c:when test="${userObj.nombreUsuario != null}">
 <c:if test="${empty usuarioList}">
                No hay usarios
            </c:if>
            <c:if test="${not empty usuarioList}">  
             <table class="striped">
                    <thead>
                    <tr>
                        <th>Administrador</th>
                        <th>Nombre Usuario</th>
                        <th>Pasword</th>
                        <th>Actualizar</th>
                        <th>Eliminar</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${usuarioList}" var="usr">
                        <tr>
                            
                            <td><c:out value="${usr.nombreUsuario}"/></td>
                            <td><c:out value="${usr.usuario}"/></td>
                            <td><c:out value="${usr.password}"/></td> 
                            <td><a href="editarUsuario.html?id=<c:out value='${usr.idUsuario}'/> " 
                            class="waves-effect waves-light btn" >Actualizar</a></td>
                            <td><a href="eliminarUsuario.html?id=<c:out value='${usr.idUsuario}'/>"
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