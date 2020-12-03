<div class="menu_container">
    <input type="checkbox" name="open" id="open">
    <label for="open" class="bt">
        <span></span>
        <span></span>
        <span></span>
    </label>
    <ul class="menu">
        <li style="--i:1">
<#--            <a href="/buyer/admin/buy?username=${buyer.username}">-->
            <a href="/buyer/admin/personInfo?username=${buyer.username}">
                查看个人信息
            </a>
        </li><li style="--i:1">
            <a href="/buyer/admin/update?username=${buyer.username}">
                修改个人信息
            </a>
        </li>
        <li style="--i:2">
            <a href="/buyer/admin/buy?username=${buyer.username}">
                开始下单
            </a>
        </li>
        <li style="--i:3">
            <a href="/buyer/admin/list?username=${buyer.username}">
                查看历史订单
            </a>
        </li>
        <li style="--i:4">
            <a href="/buyer/admin/index">
                注销
            </a>
        </li>
    </ul>
</div>