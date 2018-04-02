<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<title>HT | Music Register</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<link rel="stylesheet" href="<%=basePath%>/resource/views/music/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>/resource/views/music/assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>/resource/views/music/assets/vendor/linearicons/style.css">
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
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">
							<div class="header">
								<div class="logo text-center">
									<img src="<%=basePath%>/resource/views/music/assets/img/logo-dark.png" alt="Klorofil Logo">
								</div>
								<p class="lead">注册用户</p>
							</div>
							<form class="form-auth-small" action="<%=basePath%>/user/reg" method="post" onsubmit="return checkForm()">
								<div class="form-group">
									<input type="text" class="form-control" id="phone" value="${phone}" name="phone" onblur="checkUserPhone()" placeholder="请输入手机号"> <span class="phone_yanzheng">${Errormsg}</span>
								</div>
								<div class="form-group">
									<input type="password" class="form-control" id="password1" onblur="checkPassword1()" name="password" placeholder="请输入密码"> <span class="password1_yanzheng"></span>
								</div>
								<div class="form-group">
									<input type="password" class="form-control" id="password2" onblur="checkPassword2()" name="password2" placeholder="确认密码"> <span class="password2_yanzheng">${Errorpwd}</span>
								</div>
								<button type="submit" class="btn btn-primary btn-lg btn-block">注册</button>
								<div class="bottom">
									<span class="helper-text lf"><i class="fa fa-lock"></i> <a href="#">忘记密码?</a></span>
									<span class="helper-text lr"><a href="<%=basePath%>/resource/views/music/page-login.jsp">已注册去登录</a></span>
								</div>
							</form>
						</div>
					</div>
					<div class="right">
						<div class="overlay"></div>
						<div class="content text">
							<a style="color: white" href="<%=basePath%>/resource/views/music/page-play.jsp"><h1 class="heading">Free Bootstrap dashboard template</h1>
							<p>by The Develovers</p></a>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->
</body>
<script src="<%=basePath%>/resource/views/jquery-3.2.1.min.js"></script>
<script>
	function checkForm() {
		if (checkUserPhone() && checkPassword1() && checkPassword2()) {
			return true;
		} else {
			return false;
		}
	}
	function checkUserPhone() {
		console.log($("#phone").val())
		if ($("#phone").val() == "") {
			$(".phone_yanzheng").html("电话号码不能为空");
			return false;
		} else {
			var pattern = /^1[34578]\d{9}$/;
			if (pattern.test($("#phone").val())) {
				$(".phone_yanzheng").html("");
				return true;
			} else {
				$(".phone_yanzheng").html("格式不对，请重新输入");
				return false;
			}
		}
	}
	function checkPassword1() {
		console.log($("#password1").val())
		if ($("#password1").val() == "") {
			$(".password1_yanzheng").html("密码不能为空");
			return false;
		} else {
			var pattern = /^[0-9a-zA-Z_]{6,15}$/;
			if (pattern.test($("#password1").val())) {
				$(".password1_yanzheng").html("");
				return true;
			} else {
				$(".password1_yanzheng").html("请输入6到15位的密码");
				return false;
			}
		}
	}
	function checkPassword2() {
		console.log($("#password2").val())
		if ($("#password2").val() == "") {
			$(".password2_yanzheng").html("密码不能为空");
			return false;
		} else {
			if ($("#password1").val() == $("#password2").val()) {
				$(".password2_yanzheng").html("");
				return true;
			} else {
				$(".password2_yanzheng").html("两次密码输入不一致");
				return false;
			}
		}
	}
</script>
</html>
