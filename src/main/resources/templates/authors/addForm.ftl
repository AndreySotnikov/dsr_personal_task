<#include "/part/header.ftl">
<#if errors??>
<div class="alert alert-danger" role="alert">
    <#list errors as error>
        <p>${error}</p>
    </#list>
</div>
</#if>
<form method="post" action="<#if author?? && author.idAuthor??>/author/update/${author.idAuthor}<#else>/author/add</#if>"  name="author">
    <div class="form-group">
        <label >Фамилия</label>
        <input type="text" class="form-control" name="family" <#if author?? && author.family??>value="${author.family}"></#if>
    </div>
    <div class="form-group">
        <label >Имя</label>
        <input type="text" class="form-control" name="name" <#if author?? && author.name??>value="${author.name}"></#if>
    </div>
    <div class="form-group">
        <label >Год рождения</label>
        <input type="text" class="form-control" name="year" <#if author?? && author.year??>value="${author.year}"</#if> pattern="\d*">
    </div>
    <input class="btn btn-primary" type="submit" value="Submit">
</form>
<#include "/part/footer.ftl">