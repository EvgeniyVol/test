<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Страница входа в систему
<@l.login "/login" />
<a href="/registration">Создайте аккаунт</a>
</@c.page>
