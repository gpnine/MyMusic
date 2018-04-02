<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<link rel="stylesheet"
	href="<%=basePath%>/resource/views/songs/src/css/smusic.css" />
<body>
	<div class="grid-music-container f-usn">
		<div class="m-music-play-wrap">
			<div class="u-cover"></div>
			<div class="m-now-info">
				<h1 class="u-music-title">
					<strong>标题</strong><small>歌手</small>
				</h1>
				<div class="m-now-controls">
					<div class="u-control u-process">
						<span class="buffer-process"></span> <span class="current-process"></span>
					</div>
					<div class="u-control u-time">00:00/00:00</div>
					<div class="u-control u-volume">
						<div class="volume-process" data-volume="0.50">
							<span class="volume-current"></span> <span class="volume-bar"></span>
							<span class="volume-event"></span>
						</div>
						<a class="volume-control"></a>
					</div>
				</div>
				<div class="m-play-controls">
					<a class="u-play-btn prev" title="上一曲"></a> <a
						class="u-play-btn ctrl-play play" title="暂停"></a> <a
						class="u-play-btn next" title="下一曲"></a> <a
						class="u-play-btn mode mode-list current" title="列表循环"></a> <a
						class="u-play-btn mode mode-random" title="随机播放"></a> <a
						class="u-play-btn mode mode-single" title="单曲循环"></a>
				</div>
			</div>
		</div>
		<div class="m-music-list-wrap"></div>
		<div class="m-music-lyric-wrap">
			<div class="inner">
				<ul class="js-music-lyric-content">
					<li class="eof">暂无歌词...</li>
				</ul>
			</div>
		</div>
	</div>
	<input type="hidden" value="<%=basePath%>" id="path">
	<script src="<%=basePath%>/resource/views/songs/src/js/smusic.js"></script>
	<script src="<%=basePath%>/resource/views/jquery-3.2.1.min.js"></script>
	<script>
	var basePath = document.getElementById("path").value+"/resource/views/";
	$.ajax({
		url : "<%=basePath%>/songs/selectAll?page=1",
		method : "get",
		success : function(data) {
			for(var i=0;i<data.length;i++){
				data[i].cover=basePath+data[i].cover;
				data[i].lyric=basePath+"music/"+data[i].lyric;
				data[i].src=basePath+"songs/"+data[i].src;
			}
			new SMusic({
		        musicList : data,
		        autoPlay  : false,  //是否自动播放
		        defaultMode : 1,   //默认播放模式，随机
		        callback   : function (obj) {  //返回当前播放歌曲信息
		            console.log(obj);
		            /*{title: "赤血长殷", singer: "王凯", cover: "http://data.smohan.net/upload/other/cxcy/cover.jpg", src: "http://data.smohan.net/upload/other/cxcy/music.mp3", index: 4}*/
		        }
		    });
		},
	}) 
    
</script>
</body>