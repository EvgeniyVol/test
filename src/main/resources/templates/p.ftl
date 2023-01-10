<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

    <table>
        <tr>
            <th>Каталог</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th>Пользователь: ${User}</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th><form action="orders" >

                    <div><input type="submit" value="Корзина"/></div>
                    <#--<input type="hidden" name="_csrf" value="${_csrf.token}" />-->
                </form></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th><@l.logout /></th>

        </tr>
    </table>

</a>
    <br>
    <br>
    <table>
        <tr><form method="get">
                <th><input type="text" name="name" value="${name?ifExists}"></th>
                <th><button type="submit">Найти по названию</button></th>
            </form></tr>
        <tr>
            <form method="get">
                <th><input type="text" name="categorie" value="${categorie?ifExists}"></th>
                <th><button type="submit">Найти по категории</button></th>
            </form>
        </tr>
    </table>


<form method="post">
    <table>
        <thead>
        <tr>
            <th>Название</th>
            <th>Цена</th>
            <th>Категория</th>
            <th>Фирма</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list products as products>
            <tr>
                <td>${products.product_name}</td>
                <td>${products.product_price}</td>
                <td>${products.id_Categories.category_name}</td>
                <td>${products.id_Manufacturers.manufacturer_name}</td>
                <td><input type="hidden" name="_csrf" value="${_csrf.token}" /><button type="submit" name="id" value="${products.id?ifExists}">В корзину</button></td>
            </tr>
        <#else>
            Товары не найдены
        </#list>
        </tbody>
    </table>
    </form>


</@c.page>