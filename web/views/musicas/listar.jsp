<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>Listagem de Músicas</h2>
<br>
<table class="table">
    <thead>
        <tr>
            <td>ID</td>
            <td>Nome da Música</td>
            <td>Data de criação</td>
            <td>Nome do Álbum</td>
            <td>Ações</td>
        </tr>
    </thead>
    <tbody>
        <c:if test="${!empty musicas}">
            <c:forEach items="${musicas}" var="musica">
                <tr>
                    <td>${musica.id}</td>
                    <td>${musica.nome}</td>

                    <td><fmt:formatDate timeZone="UTC" value="${musica.dataCriacao}" pattern="dd/MM/yyyy"/></td>
                    <td>${musica.album.nome}</td>
                    <td>
                        <a href="/musicas/alterar/${musica.id}">Alterar</a>
                        <a href="/musicas/excluir/${musica.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>
<hr>
<a href="/musicas/adicionar" class="btn btn-primary">Nova música</a>