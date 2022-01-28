<%--
  Created by IntelliJ IDEA.
  User: Смирных Павел
  Date: 28.12.2021
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:if test="${form != null}">
        <c:if test="${table == 2}">
            <table class="table">
                <tr>
                    <td><a class="btn btn-success" href="${pageContext.request.contextPath}/add?table=2&type=1">Add
                        beam</a></td>
                    <td align="center"><a class="btn btn-success"
                                          href="${pageContext.request.contextPath}/add?table=2&type=2">Add
                        fitting</a></td>
                    <td align="right"><a class="btn btn-success"
                                         href="${pageContext.request.contextPath}/add?table=2&type=3">Add
                        pipe</a></td>
                </tr>
            </table>
        </c:if>
        <c:if test="${table == 4}">
            <table class="table">
                <tr>
                    <td><a class="btn btn-success" href="${pageContext.request.contextPath}/add?table=4&type=1">Add
                        legal person</a></td>
                    <td align="right"><a class="btn btn-success"
                                          href="${pageContext.request.contextPath}/add?table=4&type=2">Add
                        private person</a></td>
                </tr>
            </table>
        </c:if>
        <form action="${pageContext.request.contextPath}/add?table=${table}&type=${type}" method="post">
            <%= (String) request.getAttribute("form") %>
            <input class="btn btn-success" type="submit" value="Add">
        </form>
    </c:if>
</div>
</body>
</html>
