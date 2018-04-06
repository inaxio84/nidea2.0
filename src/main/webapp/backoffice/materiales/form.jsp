<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<%@page import="com.ipartek.formacion.nidea.controller.backoffice.BackofficeMaterialesController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>




<label for="id">Id:</label>
<input type="text" value="${material.id}" name="id">
<label for="nombre">Material:</label>
<input type="text" value="${material.nombre}" name="nombre">
<label for=precio>Precio:</label>
<input type="text" value="${material.precio}" name="precio">

<c:if test="${material.id>-1}">
	<a href="backoffice/materiales?id=${material.id}&op=<%=BackofficeMaterialesController.OP_GUARDAR%>" class="btn btn-primary">Modificar Material</a>
	<a href="backoffice/materiales?id=${material.id}&op=<%=BackofficeMaterialesController.OP_ELIMINAR%>" class="btn btn-danger">Eliminar Material</a>
</c:if>

<c:if test="${material.id==-1}">
	<a href="backoffice/materiales?id=${material.id}&op=<%=BackofficeMaterialesController.OP_GUARDAR%>" class="btn btn-success">Añadir Material</a>
</c:if>
<br>

<a href="backoffice/materiales?op=-1" class="btn btn-primary">Volver</a>

<jsp:include page="/templates/footer.jsp"></jsp:include>