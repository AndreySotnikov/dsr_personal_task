<#include "/part/header.ftl">

<form method="post" action="/book/add" name="book">
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
        <input type="text" class="form-control" name="name" >
    </div>
    <div class="form-group">
        <label >Год издания</label>
        <input type="text" class="form-control" name="year" >
    </div>
    <div class="form-group">
        <label >Объем</label>
        <input type="number" class="form-control" name="volume" >
    </div>
    <div class="form-group">
        <label>Авторы</label>
        <select multiple class="form-control" name="authors">
        <#list authorList as author>
            <option value="${author.idAuthor}">${author.idAuthor} ${author.family} ${author.name} ${author.year}</option>
        </#list>
        </select>
    </div>
    <input class="btn btn-primary" type="submit" value="Submit">
</form>

<#include "/part/footer.ftl">