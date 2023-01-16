<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

    <table>
        <tr>
            <th>Корзина</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th>Пользователь: ${User}</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th><@l.logout /></th>
        </tr>
    </table>

        <table>
            <thead>
            <tr>
                <th>Название</th>
                <th>Бренд</th>
                <th>Количесвто</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <#list orders as orders>
                <tr>
                    <td>${orders.id_Products.product_name}</td>
                    <td>${orders.id_Products.id_Manufacturers.manufacturer_name}</td>
                    <td>${orders.product_count}</td>
                    <form method="get">
                        <td><input type="hidden" name="id" value="${orders.id}" /><input type="hidden" name="_csrf" value="${_csrf.token}" /><button type="submit" name="mode" value="${1}">Удалить</button></td>
                        <td><input type="hidden" name="_csrf" value="${_csrf.token}" /><button type="submit" name="mode" value="${2}">+</button></td>
                        <td><input type="hidden" name="_csrf" value="${_csrf.token}" /><button type="submit" name="mode" value="${3}">-</button></td>
                        <td><input type="hidden" name="_csrf" value="${_csrf.token}" /><button type="submit" name="mode" value="${4}">Купить</button></td></form>
                </tr>
           <#-- <#list products as products>
                &lt;#&ndash;<tr>
                    <td>${products.product_name}</td>
                    <td>${products.product_price}</td>
                    <td>${products.id_Categories.category_name}</td>
                    <td><a href="allorders"><input type="button" value="В корзину" />
                        </a></td>
                </tr>&ndash;&gt;
            </#list>-->
            <#else>
                Корзина пуста


            </#list>
            </tbody>
        </table>

    <a href="http://localhost:8080/products"><input type="button" value="За покупками" /></a>
<#--
&lt;#&ndash; <form action="https://ya.ru" method="get">
     <input type="submit" value="Кнопка №1" />
 </form>&ndash;&gt;
    <div>Каталог</div>
    <br>
    <form method="get" action="all">
        <input type="text" name="name" value="${name?ifExists}">
        <button type="submit">Найти по названию</button>
    </form>
    <form method="get" action="categories">
        <input type="text" name="categorie" value="${categorie?ifExists}">
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
                <td>${products.id_Categories.category_name}</td>
                <td><a href="/user/${products.id}"><input type="button" value="В корзину" />
                    </a></td>
            </tr>
        <#else>
            Товары не найдены
        </#list>
        </tbody>
    </table>
-->



</@c.page>