<#include "/part/header.ftl">
<#if errors??>
<div class="alert alert-danger" role="alert">
    <#list errors as error>
        <p>${error}</p>
    </#list>
</div>
</#if>
<form method="post" action="<#if genre?? && genre.idGenre??>/genre/update/${genre.idGenre}<#else>/genre/add</#if>" name="genre">
    <div class="form-group">
        <label >Название</label>
        <input type="text" class="form-control" name="name" <#if genre?? && genre.name??>value="${genre.name}"</#if>>
    </div>
    <input class="btn btn-primary" type="submit" value="Submit">
</form>
<#include "/part/footer.ftl">