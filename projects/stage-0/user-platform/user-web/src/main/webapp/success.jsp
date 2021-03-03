<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div style="text-align: center">
	当前数据库中所有的用户信息: <br/>
	<table border="1" cellpadding="3" cellspacing="0" style="margin:auto">
		<tr><td>id</td>
			<td>名称</td>
			<td>email</td>
			<td>电话号码</td>
			<td>密码</td>
		</tr>
	<c:forEach items="${users}" var="user">

			<tr><td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>${user.phoneNumber}</td>
				<td>${user.password}</td>
			</tr>

	</c:forEach>
</table>
</div>
</body>