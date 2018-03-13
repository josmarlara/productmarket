<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
<div class="col s12 indigo accent-4 "><h3>Product Market-Administrador</h3></div>
<c:choose>
 <c:when test="${userObj.nombreUsuario != null}">
        Bienvenido:${userObj.nombreUsuario} 
       
    </c:when>    
    <c:otherwise>
      <c:redirect  url="salir.html"></c:redirect>  
    </c:otherwise>
</c:choose>

</div>
