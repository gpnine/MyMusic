<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<title>HT | Music UserInfo</title>
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
		<jsp:include page="${basePath}/resource/views/music/user-top.jsp" flush="true"/>
		<!-- LEFT SIDEBAR -->
		<jsp:include page="${basePath}/resource/views/music/user-left.jsp" flush="true"/>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="panel panel-headline">
					<div class="panel-heading">
						<h3 class="panel-title">用户详细信息</h3>
						<p class="panel-subtitle">User detail information</p>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="metric">
									<form class="form-auth-small" action="<%=basePath%>/user/update?phone=${phone}" method="post" onsubmit="return checkForm()">
										<div class="form-group">
											<input type="text" disabled class="form-control" value="${phone}">
										</div>
										<div class="form-group">
											<input type="text" class="form-control" name="password" placeholder="请输入密码" value="${password}">
										</div>
										<div class="form-group">
											<input type="text" class="form-control" name="cName" placeholder="请输入用户名" value="${user.cName}">
										</div>
										<div class="form-group">
											<input type="email" class="form-control" name="email" placeholder="请输入邮箱帐号" value="${user.email}">
										</div>
										<div class="form-group">
											<input type="text" id="birthday" class="form-control" name="birthDay" placeholder="请输入出生日期如：1994-01-12" value="${user.birthDay}" onblur="checkBirthDay()"><span class="birthday_yanzheng"></span>
										</div>
										<div class="form-group">
											<input type="text" class="form-control" name="adress" placeholder="请输入公司地址" value="${user.adress}">
										</div>
										<div class="form-group">
											<input type="text" disabled class="form-control" value="${vip}">
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
	<script>
	function checkForm(){
	    if(checkBirthDay()){
	        return true;
	    }else{
	        return false;
	    }
	}
	function checkBirthDay(){
		console.log($("#birthday").val())
		if ($("#birthday").val()==""){
	        $(".birthday_yanzheng").html("出生日期不能为空");
	        return false;
	    }else{
	        var pattern = /^(19|20)\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$/;
	        if (pattern.test($("#birthday").val())){
	            $(".birthday_yanzheng").html("");
	            return true;
	        }else {
	            $(".birthday_yanzheng").html("格式不对，请重新输入");
	            return false;
	        }
	    }
	}
	$(function() {
		var data, options;

		// headline charts
		data = {
			labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
			series: [
				[23, 29, 24, 40, 25, 24, 35],
				[14, 25, 18, 34, 29, 38, 44],
			]
		};

		options = {
			height: 300,
			showArea: true,
			showLine: false,
			showPoint: false,
			fullWidth: true,
			axisX: {
				showGrid: false
			},
			lineSmooth: false,
		};



		// visits trend charts
		data = {
			labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
			series: [{
				name: 'series-real',
				data: [200, 380, 350, 320, 410, 450, 570, 400, 555, 620, 750, 900],
			}, {
				name: 'series-projection',
				data: [240, 350, 360, 380, 400, 450, 480, 523, 555, 600, 700, 800],
			}]
		};

		options = {
			fullWidth: true,
			lineSmooth: false,
			height: "270px",
			low: 0,
			high: 'auto',
			series: {
				'series-projection': {
					showArea: true,
					showPoint: false,
					showLine: false
				},
			},
			axisX: {
				showGrid: false,

			},
			axisY: {
				showGrid: false,
				onlyInteger: true,
				offset: 0,
			},
			chartPadding: {
				left: 20,
				right: 20
			}
		};



		// visits chart
		data = {
			labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
			series: [
				[6384, 6342, 5437, 2764, 3958, 5068, 7654]
			]
		};

		options = {
			height: 300,
			axisX: {
				showGrid: false
			},
		};

		// real-time pie chart
		var sysLoad = $('#system-load').easyPieChart({
			size: 130,
			barColor: function(percent) {
				return "rgb(" + Math.round(200 * percent / 100) + ", " + Math.round(200 * (1.1 - percent / 100)) + ", 0)";
			},
			trackColor: 'rgba(245, 245, 245, 0.8)',
			scaleColor: false,
			lineWidth: 5,
			lineCap: "square",
			animate: 800
		});

	});
	</script>
</body>

</html>
