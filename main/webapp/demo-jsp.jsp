<%@ page import="java.util.*" %>
<%

	request.setAttribute("x", 2);

	List list = new ArrayList();
	list.add(1);
	list.add(2);
	list.add(3);
	request.setAttribute("list", list);
	

%>

<html>
<body>

${list}
<hr>
${list.get(0)}

<hr>
${list.get(x)}


</body>
</html>