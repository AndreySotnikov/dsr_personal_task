<#include "/part/header.ftl">

<form method="post" action="/genre/add" name="Genre">
    <div class="form-group">
        <label >Name</label>
        <input type="text" class="form-control" name="name">
    </div>
    <input class="btn btn-primary" type="submit" value="Submit">
</form>

<#include "/part/footer.ftl">