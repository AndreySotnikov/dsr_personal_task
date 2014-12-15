<#include "/part/header.ftl">
<#if errors??>
<div class="alert alert-danger" role="alert">
    <#list errors as error>
        <p>${error}</p>
    </#list>
</div>
</#if>
<form method="post" action="<#if order?? && order.idOrder??>/order/update/${order.idOrder}<#else>/order/add</#if>" name="order">
    <div class="form-group">
        <label >ФИО покупателя</label>
        <input type="text" class="form-control" name="FIO" <#if order?? && order.FIO??>value="${order.FIO}"</#if> >
    </div>
    <div class="form-group">
        <label>Книги</label>
        <select multiple class="form-control" name="books">
        <#list bookList as book>
            <option value="${book.idBook}">${book.idBook} ${book.name}</option>
        </#list>
        </select>
    </div>
    <div class="form-group">
        <label>Дата</label>
        <input type="text" class="form-control" name = "date" placeholder="DD/MM/YYYY" <#if order?? && order.date??>value="${order.date}"pattern="(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d" </#if> >
    </div>
    <input class="btn btn-primary" type="submit" value="Submit">
</form>

<#include "/part/footer.ftl">