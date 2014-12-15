<#include "/part/header.ftl">
<h1>Все заказы</h1>
<div class="row">
    <div class="col-sm-8">
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Дата заказа</th>
                <th>Покупатель</th>
                <th>Стоимость</th>
                <th>Подробная информация</th>
                <th>Действия</th>
            </tr>
        <#list orderList as order>
            <tr>
                <td>${order.idOrder}</td>
                <td>${order.date}</td>
                <td>${order.FIO}</td>
                <td>${order.price}</td>
                <td><a href="/order/show/${order.idOrder}">Показать</a></td>
                <td>
                    <span class="glyphicon glyphicon-pencil"></span>
                    <a href="/order/update/${order.idOrder}">Edit</a>
                    <span class="glyphicon glyphicon-remove"></span>
                    <a href="/order/delete/${order.idOrder}">Delete</a>
                </td>
            </tr>
        </#list>
        </table>
    </div>
</div>
<span class="glyphicon glyphicon-plus"></span>
<a href="/order/add">Добавить</a>


<#include "/part/footer.ftl">