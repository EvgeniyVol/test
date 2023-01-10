<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

   <#-- <form action="https://ya.ru" method="get">
        <input type="submit" value="Кнопка №1" />
    </form>-->
    <table>
        <tr>
            <th>Каталог</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th><form action="orders" method="get">

                    <div><input type="submit" value="Корзина"/></div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
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
        <tr><form method="get" action="all">
                <th><input type="text" name="name" value="${name?ifExists}"></th>
                <th><button type="submit">Найти по названию</button></th>
            </form></tr>
        <tr>
            <form method="get" action="categories">
                <th><input type="text" name="categorie" value="${categorie?ifExists}"></th>
                <th><button type="submit">Найти по категории</button></th>
            </form>
        </tr>
    </table>


<form>
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
                <td>${products.id_Categories.category_name}</td>
                <td>${products.id_Manufacturers.manufacturer_name}</td>
                <td><a href="allorders"><input type="button" value="В корзину" />
                    </a></td>
            </tr>
        <#else>
            Товары не найдены
        </#list>
        </tbody>
    </table>
    </form>


</@c.page>