<html lang="en">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper" class="animate__animated animate__fadeInUp">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/seller/product/save">

                        <div class="form-group">
                            <label for="exampleInputEmail1">名称</label>
                            <input name="productName" type="text" class="form-control"
                                   value="${(productInfo.productName)!''}"/>
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">价格</label>
                            <input name="productPrice" type="text" class="form-control"
                                   value="${(productInfo.productPrice)!''}"/>
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">库存</label>
                            <input name="productStock" type="text" class="form-control"
                                   value="${(productInfo.productStock)!''}"/>
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">描述</label>
                            <input name="productDescription" type="text" class="form-control"
                                   value="${(productInfo.productDescription)!''}"/>
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">图片</label>
                            <img width="100px" height="100px"
                                 src="${(productInfo.productIcon)!''}"
                                    <#if (productInfo.productId)??>
                                    <#else>
                                        hidden
                                    </#if>
                            >
                            <input name="productIcon" type="text" class="form-control"
                                   value="${(productInfo.productIcon)!''}"/>
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">类目</label>
                            <select name="categoryType" class="form-group">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                            <#if (productInfo.categoryType)?? && productInfo.categoryType==category.categoryType>
                                                selected
                                            </#if>
                                    >${category.categoryName}</option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>