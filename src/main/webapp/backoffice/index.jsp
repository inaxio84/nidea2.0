<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>Backoffice</h1>

<a href="backoffice/materiales">MATERIALES</a>



<!--  
<img src="img/Imagen1.png" width="100%" alt="dashboard">
-->
<h2>Usuarios Conectados</h2>
<table class="display datatable" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Id</th>
				<th>Usuario</th>

			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Id</th>
				<th>Usuario</th>

			</tr>
		</tfoot>
		<tbody>
		<c:forEach var="usuario" items="${applicationScope.usuarios_conectados}">
			<tr>
				<td>${usuario.key}</td>
				<td>${usuario.value.getUser()}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<script type="text/javascript">
  setTimeout(function () { location.reload(true); }, 5000);
</script>


<jsp:include page="/templates/footer.jsp"></jsp:include>