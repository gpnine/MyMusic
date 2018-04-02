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
				<th>菜单名</th>
				<th>父级序号</th>
				<th>修改</th>
				<th>删除</th>
				<th>添加子菜单</th>
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
var countStr = ${userCaidanCount};
var counts = Math.ceil(countStr/10);
$('#box').paging({
    initPageNo: 1, // 初始页码
    totalPages: counts, //总页数
    slideSpeed: 600, // 缓动速度。单位毫秒
    jump: true, //是否支持跳转
    callback: function(page) { // 回调函数
    	console.log(page);
    	$.ajax({
    		url:"<%=basePath%>/userCaidan/selectAll?page="+page,
    		method : "get",
    		success : function(data) {
    			$("#tbody").html("");
    			for (var i = 0;i < data.length;i++) {
    				$("#tbody").append('<tr><td>'+data[i].mId+'</td>'
    						+'<td>'+data[i].mName+'</td>'
    						+'<td>'+data[i].pId+'</td>'
    						+'<td><a href="<%=basePath%>/userCaidan/xiugaiMenus?mId='+data[i].mId+'">点击修改</a></td>'
    						+'<td><a href="<%=basePath%>/userCaidan/deleteMenus?mId='+data[i].mId+'">点击删除</a></td>'
    						+'<td><a href="<%=basePath%>/userCaidan/addChildMenus?mId='+data[i].mId+'">点击添加子菜单</a></td>'
    						+'</tr>')
    			}
    		}
    	});
    }
})
</script>
