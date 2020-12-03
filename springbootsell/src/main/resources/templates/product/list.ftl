<html lang="en">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper" class="animate__animated animate__flash">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="ui unstackable striped table">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2" class="center aligned">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list productInfoPage.content as productInfo>
                            <tr>
                                <td>${productInfo.productId}</td>
                                <td>${productInfo.productName}</td>
                                <td>
                                    <img id="foodpic" height="40px"  src="${productInfo.productIcon}">
                                </td>
                                <td>${productInfo.productPrice}</td>
                                <td>${productInfo.productStock}</td>
                                <td>${productInfo.productDescription}</td>
                                <td>${productInfo.categoryType}</td>
                                <td>${productInfo.createTime}</td>
                                <td>${productInfo.updateTime}</td>
                                <td>
                                    <a href="/seller/product/index?productId=${productInfo.productId}">修改</a>
                                </td>
                                <td>
                                    <a href="/seller/product/updateSale?productId=${productInfo.productId}">
                                        <#if productInfo.productStatus==0>
                                            下架
                                        <#else>
                                            上架
                                        </#if>

                                    </a>
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
                            <li><a href="/seller/product/list?pageNum=${currentPage-1}&pageSize=${pageSize}">上一页</a>
                            </li>
                        </#if>

                        <#-- 1.. val 代表从1 开始循环       获取查询数据的总页数  ${productInfoPage.getTotalPages()  }-->

                        <#list 1..productInfoPage.getTotalPages() as index>
                        <#--   ${index}-->
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else >
                                <li><a href="/seller/product/list?pageNum=${index}&pageSize=${pageSize}">${index}</a>
                                </li>
                            </#if>
                        </#list>

                        <#if currentPage gte productInfoPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/seller/product/list?pageNum=${currentPage+1}&pageSize=${pageSize}">下一页</a>
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

<#--<html lang="en">-->

<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
<#--    <title>卖家后台管理系统</title>-->
<#--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">-->
<#--    <style>-->
<#--        * {-->
<#--            margin: 0;-->
<#--            padding: 0;-->
<#--            box-sizing: border-box;-->
<#--            font-family: 'Poppins', sans-serif;-->
<#--        }-->

<#--        body {-->
<#--            min-height: 100vh;-->
<#--            background: #150019;-->
<#--        }-->

<#--        .navigation {-->
<#--            position: fixed;-->
<#--            width: 60px;-->
<#--            height: 100%;-->
<#--            background: #3e0748;-->
<#--            transition: 0.5s;-->
<#--            overflow: hidden;-->
<#--        }-->

<#--        .navigation:hover,-->
<#--        .navigation.active {-->
<#--            width: 300px;-->
<#--        }-->

<#--        .navigation ul {-->
<#--            position: absolute;-->
<#--            top: 0;-->
<#--            left: 0;-->
<#--            width: 100%;-->
<#--        }-->

<#--        .navigation ul li {-->
<#--            position: relative;-->
<#--            width: 100%;-->
<#--            list-style: none;-->
<#--        }-->

<#--        .navigation ul li:hover {-->
<#--            background: #ea1d63;-->
<#--        }-->

<#--        .navigation ul li a {-->
<#--            position: relative;-->
<#--            display: none;-->
<#--            width: 100%;-->
<#--            display: flex;-->
<#--            text-decoration: none;-->
<#--            color: #fff;-->
<#--        }-->

<#--        .navigation ul li a .icon {-->
<#--            position: relative;-->
<#--            display: block;-->
<#--            min-width: 60px;-->
<#--            height: 60px;-->
<#--            line-height: 60px;-->
<#--            text-align: center;-->
<#--        }-->

<#--        .navigation ul li a .icon .fa {-->
<#--            font-size: 24px;-->
<#--        }-->

<#--        .navigation ul li a .title {-->
<#--            position: relative;-->
<#--            display: block;-->
<#--            padding: 0 10px;-->
<#--            height: 60px;-->
<#--            line-height: 60px;-->
<#--            text-align: start;-->
<#--            white-space: nowrap;-->
<#--        }-->

<#--        .toggle {-->
<#--            position: absolute;-->
<#--            top: 0;-->
<#--            right: 0;-->
<#--            width: 60px;-->
<#--            height: 60px;-->
<#--            background: #330748;-->
<#--            cursor: pointer;-->
<#--        }-->

<#--        .toggle.active {-->
<#--            background: #ea1d63;-->
<#--        }-->

<#--        .toggle:before {-->
<#--            content: '\f0c9';-->
<#--            font-family: fontAwesome;-->
<#--            position: absolute;-->
<#--            width: 100%;-->
<#--            height: 100%;-->
<#--            line-height: 60px;-->
<#--            text-align: center;-->
<#--            font-size: 24px;-->
<#--            color: #fff;-->
<#--        }-->

<#--        .toggle.active:before {-->
<#--            content: '\f00d';-->
<#--        }-->

<#--        @media (max-width: 767px) {-->
<#--            .navigation {-->
<#--                left: -60px;-->
<#--            }-->
<#--            .navigation.active {-->
<#--                left: 0px;-->
<#--                width: 100%;-->
<#--            }-->
<#--        }-->
<#--    </style>-->
<#--</head>-->

<#--<body>-->
<#--<div class="navigation">-->
<#--    <ul>-->
<#--        <li>-->
<#--            <a href="">-->
<#--                <span class="icon"><i class="fa fa-home" aria-hidden="true"></i></span>-->
<#--                <span class="title">Home</span>-->
<#--            </a>-->
<#--        </li>-->
<#--        <li>-->
<#--            <a href="">-->
<#--                <span class="icon"><i class="fa fa-user" aria-hidden="true"></i></span>-->
<#--                <span class="title">Profile</span>-->
<#--            </a>-->
<#--        </li>-->
<#--        <li>-->
<#--            <a href="">-->
<#--                <span class="icon"><i class="fa fa-comment" aria-hidden="true"></i></span>-->
<#--                <span class="title">Messages</span>-->
<#--            </a>-->
<#--        </li>-->
<#--        <li>-->
<#--            <a href="">-->
<#--                <span class="icon"><i class="fa fa-question-circle" aria-hidden="true"></i></span>-->
<#--                <span class="title">Help</span>-->
<#--            </a>-->
<#--        </li>-->
<#--        <li>-->
<#--            <a href="">-->
<#--                <span class="icon"><i class="fa fa-cog" aria-hidden="true"></i></span>-->
<#--                <span class="title">Setting</span>-->
<#--            </a>-->
<#--        </li>-->
<#--        <li>-->
<#--            <a href="">-->
<#--                <span class="icon"><i class="fa fa-lock" aria-hidden="true"></i></span>-->
<#--                <span class="title">Password</span>-->
<#--            </a>-->
<#--        </li>-->
<#--        <li>-->
<#--            <a href="">-->
<#--                <span class="icon"><i class="fa fa-sign-out" aria-hidden="true"></i></span>-->
<#--                <span class="title">Sign Out</span>-->
<#--            </a>-->
<#--        </li>-->
<#--    </ul>-->
<#--</div>-->
<#--<div class="toggle" onclick="toggleMenu()"></div>-->

<#--<div style="width: 200px; height: 500px; background-color: blue;">-->

<#--</div>-->

<#--<script type="text/javascript">-->
<#--    function toggleMenu() {-->
<#--        let navigation = document.querySelector('.navigation');-->
<#--        let toggle = document.querySelector('.toggle');-->
<#--        navigation.classList.toggle('active');-->
<#--        toggle.classList.toggle('active');-->
<#--    }-->
<#--</script>-->
<#--</body>-->

<#--</html>-->



