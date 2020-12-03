<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>买家下单系统</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <link rel="stylesheet" href="../../static/css/nav.css">
    <link rel="stylesheet" href="../../static/css/animate.css">
    <style>
        body{
            background-color: rgb(117,145,173);
        }
    </style>

</head>

<body>
<div class="channel">
    <table class="ui celled striped table animate__animated animate__flipInY">
        <thead>
        <tr>
            <th colspan="3">
                用户个人信息
            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="collapsing">
                <i class="user icon"></i> 用户名
            </td>
            <td>${buyer.username}</td>
        </tr>
        <tr>
            <td>
                <i class="phone square icon"></i> 手机号
            </td>
            <td>${buyer.buyerPhone}</td>
        </tr>
        <tr>
            <td>
                <i class="home icon"></i> 地址
            </td>
            <td>${buyer.buyerAddress}</td>
        </tr>
        <tr>
            <td>
                <i class="cloud icon"></i> openID
            </td>
            <td>${buyer.buyerOpenId}</td>
        </tr>
        </tbody>
    </table>
</div>
<#include "comnav.ftl">
</body>

</html>

