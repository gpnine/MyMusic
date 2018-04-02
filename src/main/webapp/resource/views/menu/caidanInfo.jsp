<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<title>HT | Music CaidanInfo</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
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
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76" href="<%=basePath%>/resource/views/music/assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96" href="<%=basePath%>/resource/views/music/assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<jsp:include page="${basePath}/resource/views/music/page-top.jsp" flush="true"/>
		<!-- LEFT SIDEBAR -->
		<jsp:include page="${basePath}/resource/views/music/page-left.jsp" flush="true"/>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="panel panel-headline">
					<div class="panel-heading">
						<h3 class="panel-title">菜单详细信息</h3>
						<p class="panel-subtitle">User detail information</p>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="metric">
									<form class="form-auth-small" action="<%=basePath%>/caidan/updateCaidan" method="post">
										<div class="form-group">
											<input type="hidden" name="mId" value="${caidan.getmId()}">
											<input type="text" class="form-control" name="mName" placeholder="请输入菜单名" value="${caidan.getmName()}">
										</div>
										<button type="submit" class="btn btn-primary btn-lg btn-block">点击修改</button>
										<div class="${msgclass}">${msg}</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>
		<footer>
			<div class="container-fluid">
			</div>
		</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="<%=basePath%>/resource/views/music/assets/vendor/jquery/jquery.min.js"></script>
	<script src="<%=basePath%>/resource/views/music/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>/resource/views/music/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="<%=basePath%>/resource/views/music/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="<%=basePath%>/resource/views/music/assets/scripts/klorofil-common.js"></script>
</body>
</html>
