<#include "/part/header.ftl">
<#if errors??>
<div class="alert alert-danger" role="alert">
    <#list errors as error>
        <p>${error}</p>
    </#list>
</div>
</#if>
<form method="post" action="<#if book?? && book.idBook??>/book/update/${book.idBook}<#else>/book/add</#if>" name="book">
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
        <input type="text" class="form-control" name="name"  <#if book?? && book.name??>value="${book.name}"></#if>
    </div>
    <div class="form-group">
        <label >Год издания</label>
        <input type="text" class="form-control" name="year" <#if book?? && book.year??>value="${book.year}"</#if> pattern="\d*">
    </div>
    <div class="form-group">
        <label >Объем</label>
        <input type="text" class="form-control" name="volume" <#if book?? && book.volume??>value="${book.volume}"</#if> pattern="\d*">
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
        <input type="text" class="form-control" name="price" <#if book?? && book.price??>value="${book.price}"</#if> pattern="\d*">
    </div>
    <input class="btn btn-primary" type="submit" value="Submit">
</form>

<#include "/part/footer.ftl">