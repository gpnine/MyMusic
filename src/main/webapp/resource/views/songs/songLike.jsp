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
				<th>上传图片</th>
				<th>上传歌词</th>
				<th>修改</th>
				<th>删除</th>
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
  	var title = $("#title").val();
  	$.ajax({
  		url:"<%=basePath%>/songs/selectLike",
  		method : "post",
  		async:false,
  		data:{
  			title:title,
  		},
  		success : function(data) {
  			counts=5;
  			if(data!=""){
  				$("#tbody").html("");
      			for (var i = 0;i < data.length;i++) {
      				$("#tbody").append('<tr><td>'+data[i].sId+'</td>'
      						+'<td>'+data[i].title+'</td>'
      						+'<td>'+data[i].src+'</td>'
      						+'<td>'+data[i].singer+'</td>'
      						+'<td><a href="<%=basePath%>/resource/views/songs/loadImage.jsp?sId='+data[i].sId+'">点击上传</a></td>'
      						+'<td><a href="<%=basePath%>/resource/views/songs/loadLyric.jsp?sId='+data[i].sId+'">点击上传</a></td>'
      						+'<td><a href="<%=basePath%>/songs/xiugaiSongs?sId='+data[i].sId+'">点击修改</a></td>'
      						+'<td><a href="<%=basePath%>/songs/deleteSongs?sId='+data[i].sId+'">点击删除</a></td>'
      						+'</tr>')
      			}
  			}
  		}
  	});
</script>
