<%--
  Created by IntelliJ IDEA.
  User: turga
  Date: 22.04.2021
  Time: 3:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Discussion</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<jsp:useBean id="user" scope="session" class="entity.AccountBean"></jsp:useBean>
<br>
<br>
<br>
<div class="container">

    <div class="card bg-light">
        <article class="card-body mx-auto" style="max-width: 600px;">
            <h4 class="card-title text-center">Create Discussion</h4>

            <form action="/discussion" method="post">
                <div class="form-group">
                    <input id="uid" type="hidden" name="userid" value="<%=user.getUser_id()%>"/>
                </div>
                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" class="form-control" id="title" placeholder="Title" name="title">
                </div>
                <div class="form-group">
                    <label for="bdd">Body</label>
                    <textarea class="form-control" id="bdd" name="body" rows="3"></textarea>
                </div>


                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block" name = "submit" value="create">Create Discussion</button>
                </div> <!-- form-group// -->

            </form>
        </article>
    </div> <!-- card.// -->

</div>
</body>
</html>
