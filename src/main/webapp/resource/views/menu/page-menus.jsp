<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<title>HT | Music Menus</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<link rel="stylesheet" href="<%=basePath%>/resource/views/music/assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>/resource/views/music/assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>/resource/views/music/assets/vendor/linearicons/style.css">
<link rel="stylesheet" href="<%=basePath%>/resource/views/music/assets/vendor/chartist/css/chartist-custom.css">
<!-- MAIN CSS -->
<link rel="stylesheet" href="<%=basePath%>/resource/views/music/assets/css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" href="<%=basePath%>/resource/views/music/assets/css/demo.css">
<!-- GOOGLE FONTS -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
	rel="stylesheet">
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76" href="<%=basePath%>/resource/views/music/assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96" href="<%=basePath%>/resource/views/music/assets/img/favicon.png">
</head>
<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<jsp:include page="${basePath}/resource/views/music/page-top.jsp" flush="true" />
		<!-- LEFT SIDEBAR -->
		<jsp:include page="${basePath}/resource/views/music/page-left.jsp" flush="true" />
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading">
							<h3 class="panel-title">菜单页</h3>
							<p class="panel-subtitle">Date:${date} | Menus Operator</p>
						</div>
						<div class="panel-body">
							<div class="row row1">
								<jsp:include page="${basePath}/resource/views/menus/menus-index.jsp" flush="true" />
							</div>
							<div class="row">
								<form class="form-auth-small" action="<%=basePath%>/caidan/addMenu" method="post">
									<div class="form-group">
										<input type="text" class="form-control" name="addName" placeholder="请输入要添加的功能">
									</div>
									<button type="submit" class="btn btn-primary btn-lg btn-block">点击添加</button>
									<div class="${msgclass}">${msg}</div>
								</form>
							</div>
							<div class="row">
								<div class="col-md-9">
									<div id="headline-chart" class="ct-chart"></div>
								</div>
							</div>
						</div>
					</div>
					<!-- END OVERVIEW -->
				</div>
			</div>
		</div>
		<!-- END MAIN CONTENT -->
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>
	<!-- END WRAPPER -->
</body>
<!-- Javascript -->
<script	src="<%=basePath%>/resource/views/music/assets/vendor/jquery/jquery.min.js"></script>
<script	src="<%=basePath%>/resource/views/music/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script	src="<%=basePath%>/resource/views/music/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script	src="<%=basePath%>/resource/views/music/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
<script	src="<%=basePath%>/resource/views/music/assets/vendor/chartist/js/chartist.min.js"></script>
<script	src="<%=basePath%>/resource/views/music/assets/scripts/klorofil-common.js"></script>
</html>