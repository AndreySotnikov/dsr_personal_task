<#include "/part/header.ftl">
<h1>Информация об авторе</h1>
<ul>
    <li>ID: ${author.idAuthor}</li>
    <li>Фамилия: ${author.family}</li>
    <li>Имя: ${author.name}</li>
    <li>Год рождения: ${author.year}</li>
</ul>
<p>Статистика автора</p>
<ul>
    <li>Суммарная прибыль: ${sum}</li>
    <#if maxYear==0>
        <li>У автора не добавлены книги</li>
    <#else>
        <li> Жанры автора
            <ul>
                <#list genres as genre>
                    <li>${genre}</li>
                </#list>
            </ul>
        </li>
        <li>
            Писательский стаж: ${minYear} - ${maxYear}
        </li>
    </#if>
</ul>


<#include "/part/footer.ftl">