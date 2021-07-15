<%@include file="../includes/header.jsp"%>
    <h1>Edit Student</h1>
    <hr/>
    <form method="post" action="${SITE_URL}/students">
        <div class="form-group">
            <label>Name</label>
            <input class="form-control" type="text" name="name" value="${student.name}"/>
        </div>
        <div class="form-group">
            <label>Roll</label>
            <input class="form-control" type="number" min="1" max="1000" name="roll"  value="${student.roll}"/>
        </div>
        <div class="checkbox">
            <strong>Is this student Enrolled? </strong>
            <label>
                <input type="checkbox" name="enrolled"
                        <c:if test="${student.enrolled}">
                            checked="checked"
                        </c:if>
                /> Yes
            </label>
        </div>
        <input type="hidden" name="id" value="${student.id}" />
        <button type="submit" class="btn btn-success">Save</button>
        <a href="${SITE_URL}/students" class="btn btn-danger">Back</a>
    </form>
<%@include file="../includes/footer.jsp"%>
