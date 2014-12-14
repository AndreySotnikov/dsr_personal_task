<#include "/part/header.ftl">

<form method="post" action="/author/update/${author.idAuthor}" name="author">
    <div class="form-group">
        <label >Family</label>
        <input type="text" class="form-control" name="family" value="${author.family}">
    </div>
    <div class="form-group">
        <label >Name</label>
        <input type="text" class="form-control" name="name" value="${author.name}">
    </div>
    <div class="form-group">
        <label >Year</label>
        <input type="number" class="form-control" name="year" value="${author.year}">
    </div>
    <input class="btn btn-primary" type="submit" value="Submit">
</form>

<#include "/part/footer.ftl">