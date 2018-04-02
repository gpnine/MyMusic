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
				<th>歌名</th>
				<th>歌曲全称</th>
				<th>歌手名</th>
				<th>下载歌曲</th>
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
var counts = Math.ceil(${songCount}/10);
$('#box').paging({
    initPageNo: 1, // 初始页码
    totalPages: counts, //总页数
    slideSpeed: 600, // 缓动速度。单位毫秒
    jump: true, //是否支持跳转
    callback: function(page) { // 回调函数
    	console.log(page);
    	$.ajax({
    		url:"<%=basePath%>/songs/selectAll?page="+page,
    		method : "get",
    		success : function(data) {
    			$("#tbody").html("");
    			for (var i = 0;i < data.length;i++) {
    				$("#tbody").append('<tr><td>'+data[i].sId+'</td>'
    						+'<td>'+data[i].title+'</td>'
    						+'<td>'+data[i].src+'</td>'
    						+'<td>'+data[i].singer+'</td>'
    						+'<td><a href="<%=basePath%>/xiazai/downloadSong?phone=${phone}&sId='+data[i].sId+'" onClick="return confirm()">点击下载</a></td>'
      						+'</tr>')
    			}
    		}
    	});
    }
})
</script>
