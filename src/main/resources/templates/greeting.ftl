<#import "parts/common.ftl" as c>

<@c.page>
    <div>Здраствуй пользователь, ты в магазине спорт товаров</div>
    <form action="/products" method="get">
        <input type="submit" value="Заглинуть в магазин" />
    </form>
</@c.page>
