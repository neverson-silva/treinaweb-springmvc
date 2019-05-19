<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Listagem de Álguns</h2>
<br>
<table class="table">
    <thead>
        <tr>
            <td>ID</td>
            <td>Nome do Álbum</td>
            <td>Ano do Lançamento</td>
            <td>Ações</td>
        </tr>
    </thead>
    <tbody>
        <c:if test="${!empty albuns}">
            <c:forEach items="${albuns}" var="album">
                <tr>
                    <td>${album.id}</td>
                    <td>${album.nome}</td>
                    <td>${album.anoLancamento}</td>
                    <td>
                        <a href="/albuns/alterar/${album.id}">Alterar</a>
                        <a href="/albuns/excluir/${album.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>
<hr>
<a href="/albuns/adicionar" class="btn btn-primary">Novo álbum</a>