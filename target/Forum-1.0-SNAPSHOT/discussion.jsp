
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:useBean id="discussion" scope="session" class="entity.DiscussionBean"></jsp:useBean>
<head>
    <title>Discussion</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<br>
<div class="card" style="width: 80%; margin: auto">
    <h5 class="card-title"><%=discussion.getTitle()%></h5>
    <div class="card-body">
        <p class="card-text"><%=discussion.getBody()%></p>
        <a href="/like?id=<%=discussion.getDiscussionID()%>" class="card-link">Like: <%=discussion.getLikes()%></a>
        <a href="/dislike?id=<%=discussion.getDiscussionID()%>" class="card-link">Dislike: <%=discussion.getDislikes()%></a>
    </div>
</div>
</body>
</html>
