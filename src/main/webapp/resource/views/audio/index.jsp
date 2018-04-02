1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ path;
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/views/audio/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/views/audio/css/audio.css">
	<title>音频播放</title>
</head>
<body>

<div class="audio-box">
	<div class="audio-container">

		<div class="audio-view">
			<div class="audio-cover"></div>
			<div class="audio-body">
				<h3 class="audio-title">${songs.title}</h3>
				<input class="audio-sId" type="text" value=${songs.sId}>
				<div class="audio-backs">
					<div class="audio-this-time">00:00</div>
					<div class="audio-count-time">00:00</div>
					<div class="audio-setbacks">
						<i class="audio-this-setbacks"> <span class="audio-backs-btn"></span>
						</i> <span class="audio-cache-setbacks"> </span>
					</div>
				</div>
			</div>
			<div class="audio-btn">
				<div class="audio-select">
					<div action="prev" class="icon-fast-backward"></div>
					<div action="play" data-on="icon-play" data-off="icon-pause" class="icon-play"></div>
					<div action="next" class="icon-fast-forward"></div>
					<!--<div action="menu" class="icon-list-alt"></div>-->
					<div action="volume" class="icon-volume-up">
						<div class="audio-set-volume">
							<div class="volume-box">
								<i><span class="audio-backs-btn"></span></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>/resource/views/audio/js/audio.js"></script>
<script src="<%=basePath%>/resource/views/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    var sId = $(".audio-sId").val();
    $.ajax({
        url : "<%=basePath%>/songs/selectAll?page=1",
        method : "get",
        success : function(data) {
            console.log(data)
            var setConfig = {
                song : data,
                error : function(meg) {
                    console.log(meg);
                }
            };
            var audioFn = audioPlay(setConfig);
            if (audioFn) {
                //开始加载音频,1为播放,0不播放
                audioFn.loadFile(0);
            }
        },
    })
</script>
</html>