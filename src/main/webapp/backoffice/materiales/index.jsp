<%@page import="com.ipartek.formacion.nidea.controller.backoffice.BackofficeMaterialesController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>




<h1>Backoffice Materiales</h1>



<form class="form-inline" action="backoffice/materiales" method="get">
	<div class="input-group">
	<input type="hidden" name="op" value="<%=BackofficeMaterialesController.OP_BUSQUEDA%>">
	      <input class="form-control py-2" type="search" name="search" 
		         placeholder="nombre del material">
	      <span class="input-group-append">
	        <button class="btn btn-outline-secondary" type="button">
	            <i class="fa fa-search"></i>
	        </button>
	      </span>
	</div>
	
	<div class="form-inline col-md-4">
		<input type="submit" value="Buscar">
	</div>
	<a href="backoffice/materiales?id=-1&op=<%=BackofficeMaterialesController.OP_MOSTRAR_FORMULARIO%>&nombre=${material.nombre}" class="btn btn-primary">Añadir material</a>
</form>
	


<br>
<hr>




<table id="materiales" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Id</th>
				<th>Material</th>
				<th>Precio</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Id</th>
				<th>Material</th>
				<th>Precio</th>
			</tr>
		</tfoot>
		<tbody>
		<c:forEach  items="${materiales}" var="material">
			<tr>
				<td>${material.id}</td>
				<td><a href="backoffice/materiales?id=${material.id}&op=<%=BackofficeMaterialesController.OP_MOSTRAR_FORMULARIO%>&nombre=${material.nombre}">${material.nombre}</a></td>
				<td<c:if test = "${material.precio > 6 && material.precio < 25}"> style="color:blue" </c:if> <c:if test = "${material.precio > 24}"> style="color:red" </c:if>>${material.precio}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

<hr>



<jsp:include page="/templates/footer.jsp"></jsp:include>