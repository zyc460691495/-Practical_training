<html lang="en">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper" class="animate__animated animate__pulse">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/seller/category/save">
                        <div class="form-group">
                            <label for="exampleInputFile">类目名称</label>
                            <input type="text" class="form-control" name="categoryName"
                                value="${(category.categoryName)!''}"/>
                        </div>
                        <input hidden type="text" name="categoryId"
                            value="${(category.categoryId)!''}"/>
                        <input hidden type="text" name="categoryType"
                               value="${(category.categoryType)!''}"/>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>