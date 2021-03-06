<%@ include file="../template/header.jsp"%>
<div class="android-content mdl-layout__content">
    <div align="center">
        <a href="add">Add User</a><br/>
        ${msg}
        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp ">
            <thead>
                <tr> 
                    <th class="mdl-data-table__cell--non-numeric">User Name</th>
                    <th>Password</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items = "${users}" var="user">
                <tr>
                    <td class="mdl-data-table__cell--non-numeric"><c:out value = "${user.userName}"/></td>
                <td><c:out value = "${user.password}"/></td>
                <td><a href="edit?id=${user.id}">Edit</a> | 
                    <a onclick="return confirm('Are you sure you want to delete?')" href="del?id=${user.id}">Delete</a>
                </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="../template/footer.jsp"%>

