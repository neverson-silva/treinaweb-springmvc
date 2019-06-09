<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="actionEditar" value="/musicas/alterar"></c:url>
<h2>Alteração da música ${musica.nome}</h2>
<br>
<form:form action="${actionEditar}" method="post" modelAttribute="musica">
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <form:errors path="nome" cssStyle="color: red"></form:errors>
                <label for="">Id: </label>
                <form:input path="id" cssClass="form-control" readonly="true"/>
            </div>
        </div>
    </div>
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
                <label for="">Ano de Criação</label> <br>
                <form:input path="dataCriacao" cssClass="form-control"/>
                <form:errors path="dataCriacao" cssStyle="color: red"></form:errors>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label for="">Álbum</label> <br>
                <form:select path="album.id" class="form-control">
                    <form:options items="${albuns}" itemLabel="nome" itemValue="id" />
                </form:select>
            </div>
        </div>
    </div>
    <button class="btn btn-primary" type="submit"> Salvar</button>
</form:form>