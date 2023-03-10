<#macro login path>
    <form action="${path}" method="post">
        <div><label> Ваше имя : <input type="text" name="username"/> </label></div>
        <div><label> Пароль: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Войти"/></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Выйти"/>
    </form>
</#macro>

<#macro Box>
    <form action="${path}" method="post">
        <div><input type="submit" value="Корзина"/></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</#macro>

