<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Listagem de Álbuns</h2>
<br>
<div class="row">
    <div class="col-md-6">
        <div class="form-group">
            <label>Álbum a ser pesquisado!</label>
            <input id="txt-pesquisa" type="text" class="form-control">
        </div>
        <button class="btn btn-primary" id="btn-pesquisar">Buscar</button>
    </div>
</div>
<table class="table" id="tbl-albuns">
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
<script>
    $(document).ready(function () {
        $('#btn-pesquisar').click(function(){
            var nomeAlbum = $('#txt-pesquisa').val()
            var urlAjax = '/albuns/porNome?nome=' + nomeAlbum
            console.log(urlAjax)
            $.ajax({
                method: 'GET',
                url: urlAjax,
                success: (data) => {
                    $('#tbl-albuns tbody > tr').remove()
                    $.each(data, (index, album) => {
                        $('#tbl-albuns tbody').append(
                            "<tr>" +
                            "<td>" + album.id + "</td>" +
                            "<td>" + album.nome + "</td>" +
                            "<td>" + album.anoLancamento + "</td>" +
                            "<td>" +
                            "<a href='/albuns/alterar/" + album.id + "'>Alterar <a/> |" +
                            "<a href='/albuns/excluir/" + album.id +  "'>Excluir <a/>" +
                            "</td>" +
                            "</tr>"
                        )
                    })


                },
                error: () => {
                    alert("Houve um erro na requisição.")
                }
            })
        })
    })
</script>