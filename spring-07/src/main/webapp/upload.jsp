<%--
  Created by IntelliJ IDEA.
  User: yaokaiming
  Date: 2020/9/6
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick20" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"><br/>
        文件<input type="file" name="multipartFile"><br/>
        <input type="submit" value="提交">
    </form>

</body>
</html>
