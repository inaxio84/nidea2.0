<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>
<h1>Bienvenido a la página de inicio de usuario</h1>

applicationScope (jsp) == ServletContext (servlet) <br>

<h2>Usuarios Conectados</h2>

${applicationScope.usuarios_conectados}

<img src="http://los40mx00.epimg.net/los40/imagenes/2016/02/26/lacorneta/1456512573_296187_1456512972_sumario_normal.jpg" alt="imagen de bienvenida">

<table id="materiales" class="display" cellspacing="0" width="100%">
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
		<c:forEach var="ususario" items="${applicationScope.usuarios_conectados}">
			<tr>
				<td>${usuarios_conectados.key}</td>
				<td>${usuarios_conectados.value}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
<%@include file="/templates/footer.jsp" %>