
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Spring MVC</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal" var="principal"/>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Albuns
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/albuns/listar">Listar</a>
                    <a class="dropdown-item" href="/albuns/adicionar">Cadastrar</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Musicas
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/musicas/listar">Listar</a>
                    <a class="dropdown-item" href="/musicas/adicionar">Cadastrar</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Usuarios
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/usuarios/listar">Listar</a>
                    <a class="dropdown-item" href="/usuarios/adicionar">Cadastrar</a>
                </div>
            </li>
        </ul>
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a class="dropdown-toggle"
                   data-toggle="dropdown"
                    role="button" aria-haspopup="true"
                >
                    Bem-Vindo ${principal.username}
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="/logout">Sair</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    </sec:authorize>

</nav>