<html lang="zh" xmlns:th="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8">
    <title>Login Form</title>
    <link rel="stylesheet" href="../../static/css/login.css">
</head>

<body>
    <form class="login_box" action="/buyer/admin/login"  method="post">
        <h1>登录</h1>
        <input type="text" name="username" class="input_box" placeholder="账号">
        <input type="password" name="password" class="input_box" placeholder="密码">
        <input type="submit" class="btn" value="登录">
        <a href="reg.ftl" style="font-size: 10px">还没有账号？立即注册</a>
    </form>
</body>

</html>