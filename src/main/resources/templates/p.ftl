<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

   <#-- <form action="https://ya.ru" method="get">
        <input type="submit" value="Кнопка №1" />
    </form>-->
    <div>Каталог</div>
    <br>
    <form method="get" action="all">
        <input type="text" name="name" value="${name?ifExists}">
        <button type="submit">Найти по названию</button>
    </form>
    <form method="get" action="categories">
        <input type="text" name="filter" value="${name?ifExists}">
        <button type="submit">Найти по категории</button>
    </form>

    <table>
        <thead>
        <tr>
            <th>Название</th>
            <th>Цена</th>
            <th>Категория</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list products as products>
            <tr>
                <td>${products.product_name}</td>
                <td>${products.product_price}</td>
                <td>${products.сategoriesName}</td>
                <td><a href="/user/${products.id}"><input type="button" value="В корзину" />
                    </a></td>
            </tr>
        <#else>
            Товары не найдены
        </#list>
        </tbody>
    </table>



</@c.page>