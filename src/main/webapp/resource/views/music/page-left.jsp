<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<body>
	<div id="sidebar-nav" class="sidebar">
		<div class="sidebar-scroll">
			<nav>
				<ul class="nav menu-ul">
				</ul>
			</nav>
		</div>
	</div>
</body>
<script src="<%=basePath%>/resource/views/jquery-3.2.1.min.js"></script>
<script>
	var phone = '${phone}';
	if (phone!= '') {
		$.ajax({
			url:"<%=basePath%>/caidan/selectBypId?pId=0",
			method : "get",
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					$('<li><a href="#subCaidan'+i+'"><span>' + data[i].mName + '</span><div id="subCaidan'+i+'"></div></li>').appendTo(".menu-ul");
					for (var j = 0; j < data[i].caidans.length; j++) {
						$('<li><a href="<%=basePath%>/caidan/selectBymId?mId='+ data[i].caidans[j].mId +'" ><span>' + data[i].caidans[j].mName + '</span></a><div id="subCaidan1'+j+'"></div></li>').appendTo("#subCaidan" + i);
					}
				}
			}
		});
	}else{
		$("#sidebar-nav").remove();
		$("html").css("background-color","white");
	}
</script>
</html>