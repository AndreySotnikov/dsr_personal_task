<#include "/part/header.ftl">
<#if error==1>
<p class="bg-warning">Невозможно удалить жанр, пока у него существуют книги</p>
</#if>
<h1>Все жанры</h1>
<div class="row">
    <div class="col-sm-8">
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Книги</th>
                <th>Действия</th>
            </tr>
        <#list genreList as genre>
            <tr>
                <td>${genre.idGenre}</td>
                <td>${genre.name}</td>
                <ul>
                <td><#list genre.book as book>
                    <li>${book.name}</li>
                </#list>
                </td>
                </ul>
                <td>
                    <span class="glyphicon glyphicon-pencil"></span>
                    <a href="/genre/update/${genre.idGenre}">Edit</a>
                    <span class="glyphicon glyphicon-remove"></span>
                    <a href="/genre/delete/${genre.idGenre}">Delete</a>
                </td>
            </tr>
        </#list>
        </table>
    </div>
</div>
<span class="glyphicon glyphicon-plus"></span>
<a href="/genre/add">Добавить</a>


<#include "/part/footer.ftl">