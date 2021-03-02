<head>
<jsp:directive.include
	file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
<title>My Home Page</title>
	<script language="javascript" type="text/javascript">
		function register() {
			window.location.href="/user-web/register.html";
		}

	</script>
</head>
<body>
	<div class="container-lg">
		<!-- Content here -->
		Hello,World 2021
		<br/>
		<button onclick="register()">register</button>
	</div>
</body>