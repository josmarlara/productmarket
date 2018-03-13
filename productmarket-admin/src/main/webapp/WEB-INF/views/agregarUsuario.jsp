<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
 <c:when test="${userObj.nombreUsuario != null}">
<h2>Agregar Usuario</h2>
<style type="text/css">
		
		span.campoConError {
			color: red;
		}
		
	</style>	

<form:form modelAttribute="usuario" method="post" action="guardarUsuario.html" >

<table>
<tr>
<td>
 <div class="input-field col s5">

<form:input  path="nombreUsuario" />   
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
<form:input  path="usuario" />  
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
<form:input  path="password" />   
<label for="password">Password</label>
</div>
</td>

</tr>
<tr>
<td><form:errors path="password" cssClass="campoConError"/></td>
</tr>
<tr>
<td>
<button class="btn waves-effect waves-light" type="submit" name="action">guardarUsuario
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