<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>买家下单系统</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <link rel="stylesheet" href="../../static/css/nav.css">
    <link rel="stylesheet" href="../../static/css/animate.css">
    <style>
        .me-th {
            padding-top: 15px !important;
            padding-bottom: 15px !important;
            /*padding-left: 10px !important;*/
            /*padding-right: 10px !important;*/
        }
        .me-t {
            padding-top: 5px !important;
            padding-bottom: 5px !important;
            /*padding-left: 10px !important;*/
            /*padding-right: 10px !important;*/
        }
        body{
            background-color: rgb(117,145,173);
        }
    </style>
</head>

<body>
<div class="channel">
    <form role="form" method="post" action="/buyer/admin/save" class="animate__animated animate__bounceInDown">
        <table class="ui unstackable striped table">
            <thead>
            <tr>
                <th class="me-th">名称</th>
                <th class="me-th">图片</th>
                <th class="me-th">单价</th>
                <th class="me-th right aligned">数量</th>
            </tr>
            </thead>
            <tbody>
            <#list productInfoList as product>
                <#if product.productStatus==0>
                    <tr>
                        <input type="hidden" value="${product.productId}" name="productId">
                        <input type="hidden" value="${product.productName}" name="productName">
                        <td class="me-t">${product.productName}</td>
                        <input type="hidden" value="${product.productIcon}" name="productIcon">
                        <td class="me-t">
                            <img width="100px" height="100px" src="${product.productIcon}">
                        </td>
                        <input type="hidden" value="${product.productPrice}" name="productPrice">
                        <td class="me-t">${product.productPrice}</td>
                        <td class="right aligned me-t">
                            <input value="0" type="text" name="productQuantity">
                        </td>
                    </tr>
                </#if>
            </#list>

            </tbody>
        </table>
        <input type="hidden" value="${buyer.buyerPhone}" name="buyerPhone">
        <input type="hidden" value="${buyer.username}" name="username">
        <input type="hidden" value="${buyer.buyerAddress}" name="buyerAddress">
        <input type="hidden" value="${buyer.buyerOpenId}" name="buyerOpenId">
        <button type="submit" class="ui labeled icon button massive">
            <i class="cart plus icon"></i>
            提交
        </button>
    </form>
</div>
<#include "comnav.ftl">
</body>

</html>

