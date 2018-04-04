<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>


<h1>Materiales</h1>

<ol>
	<c:forEach  items="${materiales}" var="material">
		<li <c:if test = "${material.precio > 6 && material.precio < 25}"> style="color:blue" </c:if> <c:if test = "${material.precio > 24}"> style="color:red" </c:if>>
			${material.nombre} - ${material.precio} &euro;
		</li>
	</c:forEach>
</ol>

<hr>

<ol>
	<c:forEach  items="${materiales}" var="material">
		<c:choose> 
         <c:when test = "${material.precio > 6 && material.precio < 25}">
            <li style="color:blue">
				${material.nombre} - ${material.precio} &euro;
			</li>
         </c:when>
         
         <c:when test = "${material.precio > 24}">
            <li style="color:red">
				${material.nombre} - ${material.precio} &euro;
			</li>
         </c:when>
         
         <c:otherwise>
             <li>
				${material.nombre} - ${material.precio} &euro;
			</li>
         </c:otherwise>
      </c:choose>
      
	</c:forEach>
</ol>