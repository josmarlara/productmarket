<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
 <c:when test="${userObj.nombreUsuario != null}">
<h2>Agregar Producto</h2>

<form:form id="productoForm" modelAttribute="producto" enctype="multipart/form-data"  method="post" action="guardarProducto.html" 
cssClass="col s12" >
<table>
<tr>
<td>
 
<form:input  path="idReferencia" id="idReferencia" cssClass="validate"  />  
<label for="idReferencia">Id Referencia(Campo obligatorio)</label>

</td>

</tr>
<tr>
<td>
 
<form:input  path="nombreProducto" id="nombreProducto" cssClass="validate"  />  
<label for="nombreProducto"   >Nombre Producto(Campo obligatorio)</label>

</td>

</tr>

<tr>
<td>
 
<form:input  path="codigoBarras" id="codigoBarras"   />  
<label for="codigoBarras"   >Código de Barras</label>

</td>

</tr>

<tr>
<td>

<form:textarea path="descripcion"  id="descripcion" cssClass="validate" />  
<label for="descripcion"   >Descripción(Campo obligatorio)</label>

</td>

</tr>
<tr>
<td>
 
<form:input  path="cantidad" id="cantidad"   />  
<label for="cantidad"   >Cantidad(Número entero)</label>

</td>

</tr>

<tr>
<td>
 
<form:input  path="precio" id="precio"   />  
<label for="precio"   >Precio</label>

</td>

</tr>
<tr>
<td>
 
 <form:input path="file"   type="file" id="file" />  
<label for="file"   >Agregar imagen producto(menor a 5megas)</label>

</td>

</tr>
<tr>
<td>
 
<form:input  path="unidad" id="unidad"   />  
<label for="unidad"   >Unidad</label>

</td>

</tr>




<tr>
<td>
<button class="btn waves-effect waves-light" type="submit" name="action">guardarProducto
    <i class="material-icons right">send</i>
  </button>

</td>
</tr>

</table>
</form:form>

<script src="js/jquery.validate.js"></script>
<script src="js/additional-methods.js"></script>
<script src="js/messages_es.js"></script>
<script>
$("#productoForm").validate({
    rules: {
      idReferencia: {
    	        required: true,
    	        number: true
    	       },
      nombreProducto: {
        required: true
      },
      descripcion: {
    	           required: true
    	         },
      cantidad: {
          number: true
        },
    	precio: {
    	             number: true
    	           },
        file: {
        	extension: "png|jpe?g|gif"
          }
   },
    submitHandler: function(form) {
    	form.submit();

        //alert("producto enviado");
     }
  });

</script>
</c:when>    
    <c:otherwise>
      <c:redirect  url="salir.html"></c:redirect>  
    </c:otherwise>
</c:choose>