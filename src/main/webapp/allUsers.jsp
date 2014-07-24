<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body>  
    <table border="1">  
        <tbody>  
        <tr>  
            <th>id</th>  
            <th>姓名</th>  
        </tr>  
        <c:if test="${!empty users }">  
            <c:forEach items="${users }" var="user">  
                <tr>  
                    <td>${user.id }</td>  
                    <td>${user.username }</td>  
                </tr>               
            </c:forEach>  
        </c:if>  
    </tbody>  
</table>  
</body>   
</html> 