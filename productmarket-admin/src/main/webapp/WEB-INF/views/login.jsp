<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form modelAttribute="usuario" method="post" action="verificarLogin.html" >

<table>
<tr>
<td>
 <div class="input-field col s5">
<form:input  path="usuario" />  
<label for="usuario">Usuario</label>
</div>
</td>

</tr>
<tr>
<td>
 <div class="input-field col s5">
<form:password  path="password" />  
<label for="password">Password</label>
</div>
</td>

</tr>

<tr>
<td>
<button class="btn waves-effect waves-light" type="submit" name="action">Iniciar sesión
    <i class="material-icons right">send</i>
  </button>

</td>
</tr>

</table>

   <p><span class="red accent-4">${falla}</span></p>
   <p><span class="red accent-4">${vacio}</span></p>
</form:form>




