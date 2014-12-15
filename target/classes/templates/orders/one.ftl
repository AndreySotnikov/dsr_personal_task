<#include "/part/header.ftl">
<h1>Информация о заказе</h1>
<ul>
    <li>ID: ${order.idOrder}</li>
    <li>Покупатель: ${order.FIO}</li>
    <li>Общая стоимость: ${order.price}</li>
    <li>Содержиое заказа</li>
</ul>
<div class="row">
    <div class="col-sm-8">
        <table class="table table-striped">
            <tr>
                <th>Авторы</th>
                <th>Название</th>
                <th>Цена</th>
            </tr>
        <#list order.book as book>
            <tr>
                <td>
                    <ul>
                        <#list book.author as author>
                            <li>${author.family} ${author.name}</li>
                        </#list>
                    </ul>
                </td>
                <td>${book.name}</td>
                <td>${book.price}</td>
            </tr>
        </#list>
        </table>
    </div>
</div>

<#include "/part/footer.ftl">