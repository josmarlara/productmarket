<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
 <c:when test="${userObj.nombreUsuario != null}">
<h2>Actualizar Usuario</h2>
<style type="text/css">
		
		span.campoConError {
			color: red;
		}
		
	</style>	

<form:form modelAttribute="usuario" method="post" action="modificarUsuario.html" >

<table>
<tr>
<td>
 <div class="input-field col s5">
 <form:hidden path="idUsuario" value="${usuarioObj.idUsuario}"/>
<form:input  path="nombreUsuario" value="${usuarioObj.nombreUsuario}"/>   
<label for="nombreUsuario">Nombre de administrador</label>
</div>
</td>

</tr>
<tr>
<td><form:errors path="nombreUsuario" cssClass="campoConError"/></td>
</tr>



<tr>
<td>
 <div class="input-field col s5">
<form:input  path="usuario" value="${usuarioObj.usuario}"/>  
<label for="usuario">Usuario</label>
</div>
</td>

</tr>
<tr>
<td><form:errors path="usuario" cssClass="campoConError"/></td>
</tr>
<tr>
<td>
 <div class="input-field col s5">
<form:input  path="password" value="${usuarioObj.password}"/>   
<label for="password">Password</label>
</div>
</td>

</tr>
<tr>
<td><form:errors path="password" cssClass="campoConError"/></td>
</tr>
<tr>
<td>
<button class="btn waves-effect waves-light" type="submit" name="action">actualizarUsuario
    <i class="material-icons right">send</i>
  </button>

</td>
</tr>

</table>
    <p><span class="red accent-4">${insert}</span></p>
  
</form:form>
</c:when>    
    <c:otherwise>
      <c:redirect  url="salir.html"></c:redirect>  
    </c:otherwise>
</c:choose>