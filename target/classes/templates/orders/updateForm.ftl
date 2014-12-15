<#include "/part/header.ftl">
<#if errors??>
<div class="alert alert-danger" role="alert">
    <#list errors as error>
        <p>${error}</p>
    </#list>
</div>
</#if>
<form method="post" action="/order/update/${order.idOrder}" name="order">
    <div class="form-group">
        <label >ФИО покупателя</label>
        <input type="text" class="form-control" name="FIO" value="${order.FIO}" >
    </div>
    <div class="form-group">
        <label>Книги</label>
        <select multiple class="form-control" name="books">
        <#list bookList as book>
            <option value="${book.idBook}">${book.idBook} ${book.name}</option>
        </#list>
        </select>
    </div>
    <input class="btn btn-primary" type="submit" value="Submit">
</form>

<#include "/part/footer.ftl">