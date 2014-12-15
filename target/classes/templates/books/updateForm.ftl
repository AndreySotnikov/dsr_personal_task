<#include "/part/header.ftl">
<#if errors??>
<div class="alert alert-danger" role="alert">
    <#list errors as error>
        <p>${error}</p>
    </#list>
</div>
</#if>
<form method="post" action="/book/update/${book.idBook}" name="book">
    <div class="form-group">
        <label >Жанр</label>
        <select class="form-control" name="genre">
        <#list genreList as genre>
            <option value="${genre.idGenre}">${genre.name}</option>
        </#list>
        </select>
    </div>
    <div class="form-group">
        <label >Название</label>
        <input type="text" class="form-control" name="name" value="${book.name}">
    </div>
    <div class="form-group">
        <label >Год издания</label>
        <input type="text" class="form-control" name="year" value="${book.year}">
    </div>
    <div class="form-group">
        <label >Объем</label>
        <input type="text" class="form-control" name="volume" value="${book.volume}">
    </div>
    <div class="form-group">
        <label>Авторы</label>
        <select multiple class="form-control" name="authors">
        <#list authorList as author>
            <option value="${author.idAuthor}">${author.idAuthor} ${author.family} ${author.name} ${author.year}</option>
        </#list>
        </select>
    </div>
    <div class="form-group">
        <label >Цена</label>
        <input type="text" class="form-control" name="price" value="${book.price}">
    </div>
    <input class="btn btn-primary" type="submit" value="Submit">
</form>

<#include "/part/footer.ftl">