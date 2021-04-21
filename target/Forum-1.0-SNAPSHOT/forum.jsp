<%@ page import="entity.AccountBean" %><%--
  Created by IntelliJ IDEA.
  User: turga
  Date: 13.04.2021
  Time: 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forum page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>


<body>
<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>
<table class="table" style="width: 80%; margin: 50px auto;">
    <thead>
    <tr>
        <th scope="col" style="width: 10%;">#</th>
        <th scope="col" style="width: 50%;"><span style="margin: auto">Title</span></th>
        <th scope="col" style="width: 25%;">Author</th>
        <th scope="col" style="width: 15%;">Action</th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>
</body>
</html>
