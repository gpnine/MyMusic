<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<link rel="stylesheet" href="<%=basePath%>/resource/views/songs/fenye/paging.css">
<body>
	<table class="table">
		<thead>
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>邮箱</th>
				<th>生日</th>
				<th>电话号码</th>
				<th>地址</th>
			</tr>
			<tr>
			</tr>
		</thead>
		<tbody id="tbody">
		</tbody>
	</table>
	<div class="box" id="box"></div>
</body>
<script src="<%=basePath%>/resource/views/jquery-3.2.1.min.js"></script>
<script>
	var cName = $("#cName").val();
	$.ajax({
		url:"<%=basePath%>/user/vipLike",
		method : "post",
		data:{
			cName:cName,
		},
		success : function(data) {
			if(data!=""){
				$("#tbody").html("");
				for (var i = 0;i < data.length;i++) {
    				$("#tbody").append('<tr><td>'+data[i].cId+'</td>'
    						+'<td>'+data[i].cName+'</td>'
    						+'<td>'+data[i].email+'</td>'
    						+'<td>'+data[i].birthDay+'</td>'
    						+'<td>'+data[i].cPhone+'</td>'
    						+'<td>'+data[i].adress+'</td>'
    						+'</tr>')
    			}
			}
		}
	});
</script>
