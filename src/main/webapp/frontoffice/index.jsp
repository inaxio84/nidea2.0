<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>
<h1>Bienvenido a la página de inicio de usuario</h1>


<img src="http://los40mx00.epimg.net/los40/imagenes/2016/02/26/lacorneta/1456512573_296187_1456512972_sumario_normal.jpg" alt="imagen de bienvenida">

<br>
applicationScope (jsp) == ServletContext (servlet) <br>

<h2>Usuarios Conectados</h2>

${applicationScope.usuarios_conectados}
<br>
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
				<td>${usuario.value.getNombre()}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<script type="text/javascript">
  setTimeout(function () { location.reload(true); }, 5000);
</script>
	
<%@include file="/templates/footer.jsp" %>