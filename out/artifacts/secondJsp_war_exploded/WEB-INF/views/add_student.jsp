<%@include file="../includes/header.jsp"%>
    <h1>Add Student</h1>
    <hr/>
    <form method="post" action="${SITE_URL}/students">
        <div class="form-group">
            <label>Name</label>
            <input class="form-control" type="text" name="name" />
        </div>
        <div class="form-group">
            <label>Roll</label>
            <input class="form-control" type="number" min="1" max="1000" name="roll" />
        </div>
        <div class="checkbox">
            <strong>Is this student Enrolled? </strong>
            <label>
                <input type="checkbox" name="enrolled" /> Yes
            </label>
        </div>
        <button type="submit" class="btn btn-success">Save</button>
        <a href="${SITE_URL}/students" class="btn btn-danger">Back</a>
    </form>
<%@include file="../includes/footer.jsp"%>
