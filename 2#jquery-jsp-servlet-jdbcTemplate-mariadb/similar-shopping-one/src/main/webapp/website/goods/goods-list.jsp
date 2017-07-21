<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
    <div id="container">
        <div>
            <ul>
                <th>id${requestScope.goodsList[0].id}</th>
                <th>name</th>
                <th>price</th>
                <th>number</th>
            </ul>
            <ul>
                <c:forEach var="goodsList" items="${requestScope.goodsList}">
                    <li>${goodsList.id}</li>
                    <li>${goodsList.name}</li>
                    <li>${goodsList.price}</li>
                    <li>${goodsList.number}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</body>
</html>
