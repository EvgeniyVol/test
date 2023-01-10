<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout />
        <span><a href="/user">User list</a></span>
    </div>
    <div>
        <form method="post">
            <input type="text" name="manufacturer_name" placeholder="Введите название" />
            <input type="hidden" name="_csrf" value="${_csrf.token?ifExists}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div>Список сообщений</div>
    <form method="get">
        <input type="text" name="filter" value="${filter?ifExists}">
        <button type="submit">Найти</button>
    </form>

    <table>
        <thead>
        <tr>
            <th>Номер</th>
            <th>Название</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list manufacturers as manufacturers>
            <tr>

                <td>${manufacturers.id}</td>
                <td>${manufacturers.manufacturer_name}</td>
            </tr>
        <#else>
            Бренд не найден
        </#list>
        </tbody>
    </table>
</@c.page>