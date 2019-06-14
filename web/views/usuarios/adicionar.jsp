<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="actionAdicionar" value="/usuarios/adicionar"></c:url>
<h2>Inserção de novo usuário</h2>
<br>
<form:form action="${actionAdicionar}" method="post" modelAttribute="usuario">
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <form:errors path="username" cssStyle="color: red"></form:errors>
                <label for="">Conta: </label>
                <form:input path="username" cssClass="form-control"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label for="">Senha</label> <br>
                <form:password path="password" cssClass="form-control" />
                <form:errors path="password" cssStyle="color: red"></form:errors>

            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label for="">Perfil</label> <br>
                <select name="role" id="" class="form-control">
                    <option value="ROLE_ADMIN">Administrador</option>
                    <option value="ROLE_USER">Usuário Comum</option>
                </select>
            </div>
        </div>
    </div>
    <button class="btn btn-primary" type="submit"> Enviar</button>
</form:form>