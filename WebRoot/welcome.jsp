<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'welcome.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	._div{
		display:inline-block;
		width: 100px;
		height: 100px;
		border-radius: 20px;
		overflow: hidden;
		transition: width .5s,height .5s,transform: .5s;
		-webkit-transition: width .5s,height .5s,-webkit-transform .5s;
	}
	._div img{
		width:100%;
		height:100%;
	}
	._div:hover{
		width: 150px;
		height: 150px;
		transform: rotate(360deg);
		-webkit-transform: rotate(360deg);
		
	}

	</style>
  </head>
  
  <body>
    <div class="_div" ><img src="aaa.jpg" id="img1"/></div>
    <div class="_div" ><img src="aaa.jpg" id="img1"/></div>
    <br />
    <div class="_div" ><img src="aaa.jpg" id="img1"/></div>
    <div class="_div" ><img src="aaa.jpg" id="img1"/></div>
  </body>
</html>
