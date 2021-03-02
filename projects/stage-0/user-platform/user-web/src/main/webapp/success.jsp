<head>
<jsp:directive.include
	file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
<title>My Home Page</title>
</head>
<body>
	<div class="container-lg" style="text-align: center; margin-top: 50px">
		<!-- Content here -->
		 <%=request.getAttribute("name") %> register success
		 <br/>
	</div>
<div>
	当前数据库中所有的用户信息:  <%=request.getAttribute("users") %>
</div>
</body>