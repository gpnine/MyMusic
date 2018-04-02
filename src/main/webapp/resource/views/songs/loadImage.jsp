<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<title>HT | Music LoadImage</title>
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
						<h3 class="panel-title">歌曲详细信息</h3>
						<p class="panel-subtitle">Song detail information</p>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="metric">
									<form class="form-auth-small" action="<%=basePath%>/songs/loadCover" method="post" enctype="multipart/form-data">
										<div class="form-group">
											<input type="hidden" name="sId" value="<%=request.getParameter("sId")%>"> 
											上传图片：<input id="image" type="file" name="cover" onchange="test()">
										</div>
										<button type="submit" class="btn btn-primary btn-lg btn-block">点击上传</button>
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
</body>
	<!-- Javascript -->
	<script src="<%=basePath%>/resource/views/music/assets/vendor/jquery/jquery.min.js"></script>
	<script src="<%=basePath%>/resource/views/music/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>/resource/views/music/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="<%=basePath%>/resource/views/music/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="<%=basePath%>/resource/views/music/assets/scripts/klorofil-common.js"></script>
	<script>
	function test() {
        var filePath = $("#image").val();
        if("" != filePath) {
            var fileType = getFileType(filePath);
            //console.log(fileType);
            //判断上传的附件是否为图片 
            if("jpg" != fileType && "jpeg" != fileType  && "png" != fileType) {
                $("#image").val("");
                alert("请上传JPG,JPEG,PNG格式的图片");
            } else {
                //获取附件大小（单位：KB） 
                var fileSize = document.getElementById("image").files[0].size / 1024;
                if(fileSize > 2048) {
                    alert("图片大小不能超过2MB");
                }
            }
        }
    }

    function getFileType(filePath) {
        var startIndex = filePath.lastIndexOf(".");
        if(startIndex != -1)
            return filePath.substring(startIndex + 1, filePath.length).toLowerCase();
        else return "";
    }
	</script>
</html>
