<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

    <form action="https://ya.ru" method="get">
        <input type="submit" value="Кнопка №1" />
    </form>
<#--    <div>Список продуктов</div>
    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter?ifExists}">
        <button type="submit">Найти</button>
    </form>
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <strong>${message.authorName}</strong>
        </div>
    <#else>
        Товары не найдены
    </#list>-->


</@c.page>