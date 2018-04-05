<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<%@page import="com.ipartek.formacion.nidea.controller.backoffice.BackofficeMaterialesController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>


<%
Material material = (Material)request.getAttribute("material");

%>

SOY UN FORMULARIO
<label for="id">Id:</label>
<input type=text value="<%=material.getNombre()%>" name="id">
<label for="nombre">Material:</label>
<input type=text value="" name="nombre">
<label for=precio>Precio:</label>
<input type=text value="" name="precio">



<a href="backoffice/materiales?op=-1" class="btn btn-primary">Volver</a>

<jsp:include page="/templates/footer.jsp"></jsp:include>