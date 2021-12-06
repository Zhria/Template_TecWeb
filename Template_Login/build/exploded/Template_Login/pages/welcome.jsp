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

<body>
<div id="centerFrame" class="myDiv">
			<br/>
			<div id="header">
			<iframe name="header" src="<%=request.getContextPath()%>/fragments/header.jsp"></iframe>
			</div>
			
			<div id="menu">
			<iframe name="menu" src="<%=request.getContextPath()%>/fragments/menu.jsp"></iframe>
			</div>
			
			<div id="main">
			<iframe name="main">
				<p>This is the home page of the project. You can navigate the project through a navbar or a menu</p>
			</iframe>
			</div>

			<iframe name="footer" src="<%=request.getContextPath()%>/fragments/footer.jsp"></iframe>
		</div>
</body>

</html>
