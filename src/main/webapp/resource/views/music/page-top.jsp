<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="<%=basePath%>/resource/views/music/page-play.jsp"><img src="<%=basePath%>/resource/views/music/assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth">
						<i class="lnr lnr-arrow-left-circle"></i>
					</button>
				</div>
				<form class="navbar-form navbar-left" action="<%=basePath%>/resource/views/songs/page-like.jsp">
					<div class="input-group">
						<input type="text" name="title" value="" class="form-control" placeholder="Search song's name..."> <span class="input-group-btn"><button type="submit" class="btn btn-primary">Go</button></span>
					</div>
				</form>
				<div class="navbar-btn navbar-btn-right">
					<a class="btn btn-success update-pro" href="<%=basePath%>/user/userInfo?phone=${phone}"><i class="fa fa-rocket"></i><span>用户中心</span></a>
				</div>
				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						</a>
							<ul class="dropdown-menu notifications">
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>System space is almost full</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>Monthly report is available</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>Your request has been approved</a></li>
								<li><a href="#" class="more">See all notifications</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="lnr lnr-question-circle"></i> <span>Table</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">crm_user</a></li>
								<li><a href="#">menus</a></li>
								<li><a href="#">singer</a></li>
								<li><a href="#">songs</a></li>
								<li><a href="#">user_menu</a></li>
							</ul></li>
						<li class="dropdown"><a href="<%=basePath%>/resource/views/music/page-login.jsp" class="crm_login">请登录</a></li>
						<!-- <li>
							<a class="update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
						</li> -->
					</ul>
				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="menu">
			<div class="menus">菜单名称</div>
			<div class="add" id="add">
				<b>+</b>
			</div>
		</div>
</body>
<script src="<%=basePath%>/resource/views/jquery-3.2.1.min.js"></script>
<script>
	var phone = '${phone}';
	if (phone!= '') {
		if(phone=="18395592587"){
			$(".crm_login").html("管理员");
		}else{
			$(".crm_login").html(phone);
		}
	}
</script>