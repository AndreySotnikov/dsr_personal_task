<#include "/part/header.ftl">

<form method="post" action="/author/add" name="Author">
    <div class="form-group">
        <label >Family</label>
        <input type="text" class="form-control" name="family">
    </div>
    <div class="form-group">
        <label >Name</label>
        <input type="text" class="form-control" name="name">
    </div>
    <div class="form-group">
        <label >Year</label>
        <input type="number" class="form-control" name="year">
    </div>
    <input class="btn btn-primary" type="submit" value="Submit">
</form>

<#include "/part/footer.ftl">