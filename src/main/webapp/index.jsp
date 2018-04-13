<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<%

	// Scriplet < %  ...   % >
	// varias sentencias 
	String nombre = "pepe";
	//Date date = new Date();
    //System.out.println(new Timestamp(date.getTime()));
	String hora = "10:78";
	
	//sentencia para que nos genere un nullPointerException y nos lleve a la pagina de error.jsp
	String nulo=null;
	nulo.length();

%>

<h2>Hello <%=nombre%></h2>
<p><%=hora%></p>

<a href="generar-mesa"> ¿Quieres Comprar una Mesa ?</a>


<jsp:include page="templates/footer.jsp"></jsp:include>