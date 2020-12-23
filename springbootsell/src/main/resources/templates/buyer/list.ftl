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
            padding-top: 10px !important;
            padding-bottom: 10px !important;
            padding-left: 15px !important;
            padding-right: 15px !important;
        }
        .me-t {
            padding-top: 5px !important;
            padding-bottom: 5px !important;
            padding-left: 15px !important;
            padding-right: 15px !important;
        }
        .ui.table {
            font-size: 19px !important;
        }
        body{
            background-color: rgb(117,145,173);
        }
    </style>
</head>

<body>
<div class="channel" style="margin-top: -80px !important;">
    <table class="ui unstackable striped table animate__animated animate__bounceInUp">
        <thead>
        <tr>
            <th class="me-th">订单编号</th>
            <th class="me-th">用户名</th>
            <th class="me-th">电话号码</th>
            <th class="me-th">地址</th>
            <th class="me-th">openId</th>
            <th class="me-th">总金额</th>
            <th class="me-th">订单状态</th>
            <th class="me-th">支付状态</th>
            <th class="me-th">创建时间</th>
            <th class="me-th">更新时间</th>
            <th colspan="3" class="me-th">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list orderMasterList as orderMaster>
            <tr>
                <td class="me-t">${orderMaster.orderId}</td>
                <td class="me-t">${orderMaster.userName}</td>
                <td class="me-t">${orderMaster.buyerPhone}</td>
                <td class="me-t">${orderMaster.buyerAddress}</td>
                <td class="me-t">${orderMaster.buyerOpenId}</td>
                <td class="me-t">${orderMaster.orderAmount}</td>
                <td class="me-t">
                    <#if orderMaster.orderStatus==0>
                        新订单
                    <#elseif orderMaster.orderStatus==1>
                        完结
                    <#elseif orderMaster.orderStatus==2>
                        已取消
                    <#else >
                        无状态
                    </#if>
                </td>
                <td class="me-t">
                    <#if orderMaster.payStatus==0>
                        等待支付
                    <#elseif orderMaster.payStatus==1>
                        已支付
                    <#else>
                        无状态
                    </#if>
                </td>
                <td class="me-t">${orderMaster.createTime}</td>
                <td class="me-t">${orderMaster.updateTime}</td>
                <td colspan="me-t">
                    <#if orderMaster.payStatus==0 && orderMaster.orderStatus==0>
                        <a href="/buyer/admin/pay?orderId=${orderMaster.orderId}&userName=${orderMaster.userName}">去支付</a>
                    </#if>

                    <#if orderMaster.payStatus==1 && orderMaster.orderStatus==0>
                        <a href="/buyer/admin/receive?orderId=${orderMaster.orderId}&userName=${orderMaster.userName}">确认收货</a>
                    </#if>

                </td>
                <td class="me-t">
                    <#if orderMaster.orderStatus==0>
                        <a href="/buyer/admin/cancel?orderId=${orderMaster.orderId}&userName=${orderMaster.userName}">取消订单</a>
                    </#if>
                </td>

                <td class="me-t">
                    <a href="/buyer/admin/detail?orderId=${orderMaster.orderId}">查看详情</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<#include "comnav.ftl">
</body>

</html>

