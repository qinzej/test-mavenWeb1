<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function createAjaxObj()
	{
		var req;
		if(window.XMLHttpRequest)
		{
			req = new XMLHttpReqest();
		}
		else
		{
			req = new ActiveXObject("Msxml2.XMLHTTP");
		}
		return req;
	}
	
	function sendAjaxReq()
	{
		var req = createAjaxObj();
		req.open("get","/mavenWeb1/MultiController/showJSON.do");
		req.setRequsetHeader("accept","application/json");
		req.onreadystatechange = function(){
			eval("var result="+req.responseText);
			document.getElementById("div1").innerHTML=result[0].uname;
		}
		req.send(null);
	}
</script>
<body>
	this is a test!
	<br />
	<a href="javascript:void(0);" onclick="sendAjaxReq();">测试</a>
	<dir></dir>
</body>
</html>