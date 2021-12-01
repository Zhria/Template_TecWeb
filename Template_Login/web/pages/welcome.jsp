<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!-- codice html restituito al client -->
<!DOCTYPE HTML PUBLIC >
<html>
<head>
<title>Welcome page</title>
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />

		<link type="text/css" href="styles/iframe.css" rel="stylesheet"></link>
</head>

<!-- //da fare con <iframe src= width= height= >-->

<frameset rows="10%,70%,20%">

	<frame name="header"
		src="<%=request.getContextPath()%>/fragments/header.jsp">

	<frameset cols="25%,75%">
		<frame name="list"
			src="<%=request.getContextPath()%>/fragments/menu.jsp" />
		<frame name="content"
			src="<%=request.getContextPath()%>/pages/center.html" />
	</frameset>

	<frame name="footer"
		src="<%=request.getContextPath()%>/fragments/footer.jsp">

	<noframes>
		Your browser does not support frames. Click
		<a href="<%=request.getContextPath()%>/fragments/menu.jsp">here</a>
		for the list of available pages.
	</noframes>
</frameset>

<body>
	<!--ricavo lo username dell'utente dall'attributo della request-->
	<%String username = (String)request.getAttribute("username"); %>
	Welcome	<%=username %>!
</body>

</html>
