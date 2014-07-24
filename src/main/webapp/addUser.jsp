<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function postUserInfo() {
		var form = document.forms[0];
		form.action = "/mavenWeb1/MultiController/showUser.do";
		form.method = "post";
		form.submit();
	}
</script>
</head>
<body>
	this is a test!
	<br />

	<form name="userForm" action="">
		姓名：<input type="text" name="userName"> <br /> 年龄：<input
			type="text" name="age"> <br /> 
	</form>
    <input type="button" value="提交" onclick="postUserInfo()">
</body>
</html>