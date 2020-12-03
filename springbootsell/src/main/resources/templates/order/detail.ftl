<html lang="en">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper" class="animate__animated animate__bounceInDown">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="ui unstackable striped table">
                        <thead>
                        <tr>
                            <th>详情编号</th>
                            <th>订单编号</th>
                            <th>商品编号</th>
                            <th>商品名称</th>
                            <th>商品价格</th>
                            <th>商品重量</th>
                            <th>商品图片</th>
                            <th>创建时间</th>
                            <th>更新时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderDetailList as orderDetail>
                            <tr>
                                <td>${orderDetail.detailId}</td>
                                <td>${orderDetail.orderId}</td>
                                <td>${orderDetail.productId}</td>
                                <td>${orderDetail.productName}</td>
                                <td>${orderDetail.productPrice}</td>
                                <td>${orderDetail.productQuantity}</td>
                                <td>
                                    <img height="40px" src="${orderDetail.productIcon}">
                                </td>
                                <td>${orderDetail.createTime}</td>
                                <td>${orderDetail.updateTime}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
<#--                    <table class="table table-bordered table-condensed">-->
<#--                        <thead>-->
<#--                        <tr>-->
<#--                            <th>详情编号</th>-->
<#--                            <th>订单编号</th>-->
<#--                            <th>商品编号</th>-->
<#--                            <th>商品名称</th>-->
<#--                            <th>商品价格</th>-->
<#--                            <th>商品重量</th>-->
<#--                            <th>商品图片</th>-->
<#--                            <th>创建时间</th>-->
<#--                            <th>更新时间</th>-->
<#--                        </tr>-->
<#--                        </thead>-->
<#--                        <tbody>-->
<#--                        &lt;#&ndash; 通过.content 获取page中的每一个对象&ndash;&gt;-->
<#--                        <#list orderDetailList as orderDetail>-->
<#--                            <tr>-->
<#--                                <td>${orderDetail.detailId}</td>-->
<#--                                <td>${orderDetail.orderId}</td>-->
<#--                                <td>${orderDetail.productId}</td>-->
<#--                                <td>${orderDetail.productName}</td>-->
<#--                                <td>${orderDetail.productPrice}</td>-->
<#--                                <td>${orderDetail.productQuantity}</td>-->
<#--                                <td>-->
<#--                                    <img width="100px" height="100px" src="${orderDetail.productIcon}">-->
<#--                                </td>-->
<#--                                <td>${orderDetail.createTime}</td>-->
<#--                                <td>${orderDetail.updateTime}</td>-->
<#--                            </tr>-->
<#--                        </#list>-->

<#--                        </tbody>-->
<#--                    </table>-->
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>