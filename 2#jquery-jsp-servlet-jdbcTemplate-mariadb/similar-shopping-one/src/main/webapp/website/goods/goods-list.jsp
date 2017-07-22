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
            <table>
                <tr>
                    <th>id${requestScope.goodsList[0].id}</th>
                    <th>name</th>
                    <th>price</th>
                    <th>number</th>
                </tr>
                <c:forEach var="goods" items="${requestScope.goodsList}">
                    <tr>
                        <td>${goods.id}</td>
                        <td>${goods.name}</td>
                        <td>${goods.price}</td>
                        <td>${goods.number}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
