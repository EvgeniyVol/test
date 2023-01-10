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
            <th></th>
            <th></th>
            <th></th>
            <th><@l.logout /></th>
        </tr>
    </table>
    <form>
        <table>
            <thead>
            <tr>
                <th>Номер</th>
                <th>Название</th>
                <th>Количесвто</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <#list orders as orders>
                <tr>
                    <td>${orders.id}</td>
                    <td>${orders.id_Products.product_name}</td>
                    <td>${orders.product_count}</td>
                    <td><a href="delit"><input type="button" value="Удалить" />
                        </a></td>
                    <td><a href="allorders"><input type="button" value=" + " />
                        </a></td>
                    <td><a href="allorders"><input type="button" value=" - " />
                        </a></td>
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
    </form>
    <a href="http://localhost:8080/p/all"><input type="button" value="За покупками" /></a>
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