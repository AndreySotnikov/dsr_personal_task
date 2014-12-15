<#include "/part/header.ftl">
<#if error==1>
<div class="alert alert-danger" role="alert">
    Невозможно удалить книгу, пока она принадлежит заказу
</div>
</#if>
<h1>Все книги</h1>
<div class="row">
    <div class="col-sm-8">
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Жанр</th>
                <th>Название</th>
                <th>Год издания</th>
                <th>Объем</th>
                <th>Авторы</th>
                <th>Цена</th>
                <th>Подробная информация</th>
                <th>Действия</th>
            </tr>
        <#list bookList as book>
            <tr>
                <td>${book.idBook}</td>
                <td>${book.genre.name}</td>
                <td>${book.name}</td>
                <td>${book.year}</td>
                <td>${book.volume}</td>
                <ul>
                <td>
                    <#list book.author as author>
                    <li>${author.family} ${author.name}</li>
                    </#list>
                </td>
                </ul>
                <td>${book.price}</td>
                <td><a href="/book/show/${book.idBook}">Показать</a></td>
                <td>
                    <span class="glyphicon glyphicon-pencil"></span>
                    <a href="/book/update/${book.idBook}">Edit</a>
                    <span class="glyphicon glyphicon-remove"></span>
                    <a href="/book/delete/${book.idBook}">Delete</a>
                </td>
            </tr>
        </#list>
        </table>
    </div>
</div>
<span class="glyphicon glyphicon-plus"></span>
<a href="/book/add">Добавить</a>

<#include "/part/footer.ftl">