<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
 <c:when test="${userObj.nombreUsuario != null}">

<style type="text/css">
		
		span.campoConError {
			color: red;
		}
		
	</style>	
<h2>Generar Reporte VentasOnlineDetalle</h2>
<form action="reporteVentasOnlineDetalle.html">
<div class="row">
 <div class="input-field col s5">
 
 <input type="text" name="fecha" id="fecha" class="datepicker">
 <label for="fecha">Seleccionar fecha</label>
</div>
</div>

<div class="row">
                        <div class="input-field col">
                            <input type="submit" value="Mostrar Reporte" class="btn waves-effect"/>
                            
                        </div>
                    </div>
                    
                    <p><span class="red accent-4">${vacio}</span></p>	



 </form> 
<script>
$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15, // Creates a dropdown of 15 years to control year,
    today: 'Hoy',
    clear: 'Limpiar',
    close: 'Cerrar',
    format: 'yyyy-mm-dd' ,
    closeOnSelect: true // Close upon selecting a date,
  });



</script>




 </c:when>    
    <c:otherwise>
      <c:redirect  url="salir.html"></c:redirect>  
    </c:otherwise>
</c:choose>