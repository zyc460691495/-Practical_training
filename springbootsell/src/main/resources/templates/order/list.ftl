<html lang="en">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper" class="animate__animated animate__fadeIn">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="ui unstackable striped table">
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>openID</th>
                            <th>订单金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th>更新时间</th>
                            <th colspan="2" class="center aligned">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderMasterPage.content as orderMaster>
                            <tr>
                                <td>${orderMaster.orderId}</td>
                                <td>${orderMaster.userName}</td>
                                <td>${orderMaster.buyerPhone}</td>
                                <td>${orderMaster.buyerAddress}</td>
                                <td>${orderMaster.buyerOpenId}</td>
                                <td>${orderMaster.orderAmount}</td>

                                <td>
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

                                <td>
                                    <#if orderMaster.payStatus==0>
                                        等待支付
                                    <#elseif orderMaster.payStatus==1>
                                        已支付
                                    <#else>
                                        无状态
                                    </#if>
                                </td>
                                <td>${orderMaster.createTime}</td>
                                <td>${orderMaster.updateTime}</td>
                                <td>
                                    <a href="/seller/order/detail?orderId=${orderMaster.orderId}">详情</a>
                                </td>
                                <td>
                                    <a href="/seller/order/remove?orderId=${orderMaster.orderId}">取消</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else >
                            <li><a href="/seller/order/list?pageNum=${currentPage-1}&pageSize=${pageSize}">上一页</a>
                            </li>
                        </#if>

                        <#list 1..orderMasterPage.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else >
                                <li><a href="/seller/order/list?pageNum=${index}&pageSize=${pageSize}">${index}</a>
                                </li>
                            </#if>
                        </#list>

                        <#if currentPage gte orderMasterPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/seller/order/list?pageNum=${currentPage+1}&pageSize=${pageSize}">下一页</a>
                            </li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>