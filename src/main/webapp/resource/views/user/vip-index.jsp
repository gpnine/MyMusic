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
<script src="<%=basePath%>/resource/views/songs/fenye/paging.js"></script>
<script>
var countStr = ${vipCount};
var counts = Math.ceil(countStr/10);
$('#box').paging({
    initPageNo: 1, // 初始页码
    totalPages: counts, //总页数
    slideSpeed: 600, // 缓动速度。单位毫秒
    jump: true, //是否支持跳转
    callback: function(page) { // 回调函数
    	$.ajax({
    		url:"<%=basePath%>/user/selectVip?page="+page,
    		method : "get",
    		success : function(data) {
    			$("#tbody").html("");
    			console.log(data)
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
    	});
    }
})
</script>
