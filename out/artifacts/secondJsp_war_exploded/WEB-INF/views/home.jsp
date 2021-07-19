<%@include file="../includes/header.jsp"%>
      <h1>Students</h1>
      <hr>
      <div class="pull-right">
        <a class="btn btn-success btn-sm" href="${SITE_URL}/students?action=add"><span class="glyphicon glyphicon-plus"></span>Add</a>
      </div>
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Roll</th>
            <th>Enrolled</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <c:choose>
            <c:when test="${students.size() == 0}">
              <tr>
                <td colspan="5">Student Record not available!</td>
              </tr>
            </c:when>
            <c:otherwise>
              <c:forEach var="student" items="${students}">
                <tr>
                  <td>${student.id}</td>
                  <td>${student.name}</td>
                  <td>${student.roll}</td>
                  <td>
                      <c:choose>
                        <c:when test="${student.enrolled}">
                          <span class="label label-success">Enrolled</span>
                        </c:when>
                        <c:otherwise>
                          <span class="label label-danger">Not Enrolled</span>
                        </c:otherwise>
                      </c:choose>
                  </td>
                  <td>
                    <span>
                      <a href="${SITE_URL}/students?action=edit&id=${student.id}" class="btn btn-warning btn-sm"><span class="glyphicon glyphicon-pencil"></span> </a>
                    </span>
                    <span>
                      <a href="${SITE_URL}/students?action=delete&id=${student.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')"><span class="glyphicon glyphicon-trash"></span> </a>
                    </span>
                  </td>
                </tr>
              </c:forEach>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
<%@include file="../includes/footer.jsp"%>
