<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>买家下单系统</title>
    <link rel="stylesheet" href="../../static/css/nav.css">
    <link rel="stylesheet" href="../../static/css/animate.css">
    <style>
        input{
            height: 30px;
            margin: 10px;
        }
        body{
            background-color: rgb(117,145,173);
        }
    </style>
</head>

<body>
<div class="channel">
    <form role="form" method="post" action="/buyer/admin/renew" class="animate__animated animate__bounceInUp">
        <label>电话号码:</label>
        <input type="text" name="buyerPhone" value="${buyer.buyerPhone}">
        <br>
        <br>
        <label>地址:</label>
        <input type="text" name="buyerAddress" value="${buyer.buyerAddress}">
        <br>
        <br>
        <label>openID:</label>
        <input type="text" name="buyerOpenId" value="${buyer.buyerOpenId}">
        <br>
        <br>
        <label>密码</label>
        <input  type="password" name="password" value="${buyer.password}">
        <br>
        <br>
        <label>再次输入密码</label>
        <input  type="password" name="password" value="${buyer.password}">
        <br>
        <br>

        <input  type="hidden" name="username" value="${buyer.username}">

        <button type="submit" style="padding:10px 30px 10px 30px;">提交</button>
    </form>
</div>
<#include "comnav.ftl">
</body>

</html>

