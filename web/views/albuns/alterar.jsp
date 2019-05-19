<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="actionAdicionar" value="/albuns/alterar/${album.id}"></c:url>
<h2>Alteração do álbum ${album.nome}</h2>
<br>
<form:form action="${actionAdicionar}" method="post" modelAttribute="album">
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <form:errors path="nome" cssStyle="color: red"></form:errors>
                <label for="">Nome: </label>
                <form:input path="nome" cssClass="form-control"/>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label for="">Ano de lançamento</label> <br>
                <form:input path="anoLancamento" cssClass="form-control"/>
                <form:errors path="anoLancamento" cssStyle="color: red"></form:errors>

            </div>
        </div>
    </div>
    <button class="btn btn-primary" type="submit"> Enviar</button>
</form:form>