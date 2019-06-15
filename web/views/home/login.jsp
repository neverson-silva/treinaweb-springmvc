<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Login</h2>
<br>
<form action="/login" method="post">
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label for="">Conta: </label>
                <input name="username" class="form-control"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label for="">Senha</label> <br>
                <input type="password" name="password" class="form-control" />
            </div>
        </div>
    </div>
    <button class="btn btn-primary" type="submit">Entrar</button>
</form>