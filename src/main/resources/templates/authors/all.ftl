<#include "/part/header.ftl">
<#if error==1>
<p class="bg-warning">Невозможно удалить автора, пока у него существуют книги</p>
</#if>
<h1>Все авторы</h1>
<div class="row">
    <div class="col-sm-8">
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Год рождения</th>
                <th>Действия</th>
            </tr>
        <#list authorList as author>
            <tr>
                <td>${author.idAuthor}</td>
                <td>${author.family}</td>
                <td>${author.name}</td>
                <td>${author.year}</td>
                <td>
                    <span class="glyphicon glyphicon-pencil"></span>
                    <a href="/author/update/${author.idAuthor}">Edit</a>
                    <span class="glyphicon glyphicon-remove"></span>
                    <a href="/author/delete/${author.idAuthor}">Delete</a>
                </td>
            </tr>
        </#list>
        </table>
    </div>
</div>
<span class="glyphicon glyphicon-plus"></span>
<a href="/author/add">Добавить</a>


<#include "/part/footer.ftl">