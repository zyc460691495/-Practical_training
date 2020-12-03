<html lang="en">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper" class="animate__animated animate__flash">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="ui unstackable striped table">
                    <thead>
                    <tr>
                        <th>
                            类目编号
                        </th>
                        <th>
                            类目名字
                        </th>
                        <th>
                            类目编号
                        </th>
                        <th>
                            创建时间
                        </th>
                        <th>
                            更新时间
                        </th>
                        <th colspan="2" class="center aligned">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list productCategoryPage.content as category>
                        <tr class="">
                            <td>
                                ${category.categoryId}
                            </td>
                            <td>
                                ${category.categoryName}
                            </td>
                            <td>
                                ${category.categoryType}
                            </td>
                            <td>
                                ${category.createTime}
                            </td>
                            <td>
                                ${category.updateTime}
                            </td>
                            <td>
                                <a href="/seller/category/index?categoryId=${category.categoryId}">修改</a>
                            </td>
                            <td>
                                <a href="/seller/category/remove?categoryId=${category.categoryId}">删除</a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
<#--                <table class="table table-striped table-hover">-->
<#--                    <thead>-->
<#--                    <tr>-->
<#--                        <th>-->
<#--                            类目编号-->
<#--                        </th>-->
<#--                        <th>-->
<#--                            类目名字-->
<#--                        </th>-->
<#--                        <th>-->
<#--                            类目编号-->
<#--                        </th>-->
<#--                        <th>-->
<#--                            创建时间-->
<#--                        </th>-->
<#--                        <th>-->
<#--                            更新时间-->
<#--                        </th>-->
<#--                        <th colspan="2">操作</th>-->
<#--                    </tr>-->
<#--                    </thead>-->
<#--                    <tbody>-->
<#--                    <#list productCategoryPage.content as category>-->
<#--                        <tr class="success">-->
<#--                            <td>-->
<#--                                ${category.categoryId}-->
<#--                            </td>-->
<#--                            <td>-->
<#--                                ${category.categoryName}-->
<#--                            </td>-->
<#--                            <td>-->
<#--                                ${category.categoryType}-->
<#--                            </td>-->
<#--                            <td>-->
<#--                                ${category.createTime}-->
<#--                            </td>-->
<#--                            <td>-->
<#--                                ${category.updateTime}-->
<#--                            </td>-->
<#--                            <td>-->
<#--&lt;#&ndash;                                <a href="/seller/category/index?productId=${category.categoryId}">修改</a>&ndash;&gt;-->
<#--                                <a href="/seller/category/index?categoryId=${category.categoryId}">修改</a>-->
<#--                            </td>-->
<#--                            <td>-->
<#--                                <a href="/seller/category/remove?categoryId=${category.categoryId}">删除</a>-->
<#--                            </td>-->
<#--                        </tr>-->
<#--                    </#list>-->
<#--                    </tbody>-->
<#--                </table>-->
            </div>
            <div class="col-md-12 column">
                <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else >
                        <li><a href="/seller/category/list?pageNum=${currentPage-1}&pageSize=${pageSize}">上一页</a></li>
                    </#if>

                    <#list 1..productCategoryPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else >
                            <li><a href="/seller/category/list?pageNum=${index}&pageSize=${pageSize}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte productCategoryPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else >
                        <li><a href="/seller/category/list?pageNum=${currentPage+1}&pageSize=${pageSize}">下一页</a></li>
                    </#if>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>