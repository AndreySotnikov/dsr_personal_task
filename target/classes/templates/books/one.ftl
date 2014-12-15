<#include "/part/header.ftl">
<h1>Информация о книге</h1>
<ul>
    <li>ID: ${book.idBook}</li>
    <li>Название: ${book.name}</li>
    <ul>Список авторов
        <#list book.author as author>
            <li>${author.family} ${author.name}</li>
        </#list>
    </ul>
    <li>Объем: ${book.volume}</li>
    <li>Год издания: ${book.year}</li>
    <li>Цена: ${book.price}</li>
    <li>Прибыль книги: ${profit}</li>
</ul>

<#include "/part/footer.ftl">