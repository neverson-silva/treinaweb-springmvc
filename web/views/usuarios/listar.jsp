<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>Listagem de Usuários</h2>
<br>
<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Conta</th>
            <th>Role</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${!empty usuarios}">
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.username}</td>
                    <td>${usuario.role}</td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>
<hr>
<a href="/usuarios/adicionar" class="btn btn-primary">Nova usuário</a>