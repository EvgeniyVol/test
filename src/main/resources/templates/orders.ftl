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
            <#else>
                Корзина пуста


            </#list>
            </tbody>
        </table>

    <a href="http://localhost:8080/products"><input type="button" value="За покупками" /></a>
</@c.page>