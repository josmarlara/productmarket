<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
 <c:when test="${userObj.nombreUsuario != null}">
        <h2>Selecciona en el menú lo quieras realizar</h2>
       
    </c:when>    
    <c:otherwise>
      <c:redirect  url="salir.html"></c:redirect>  
    </c:otherwise>
</c:choose>