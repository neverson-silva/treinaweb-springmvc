
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>

<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>
        <tiles:insertAttribute name="title"></tiles:insertAttribute>
    </title>
    <link  type="text/css" href="/resources/css/bootstrap.min.css"/>
    <spring:url value="/resources/js/jquery.min.js" var="jqueryJs"></spring:url>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"></spring:url>
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs"></spring:url>
    <script src="${jqueryJs}"></script>
    <link rel="stylesheet" href="${bootstrapCss}">
    <script src="${bootstrapJs}"></script>
</head>
<body>
    <div style="width: 100%">
        <tiles:insertAttribute name="header" ignore="false"></tiles:insertAttribute>
    </div>
    <div style="width: 100%" class="container">
        <tiles:insertAttribute name="body" ignore="false"></tiles:insertAttribute>
    </div>
    <div style="width: 100%">
        <tiles:insertAttribute name="footer" ignore="false"></tiles:insertAttribute>
    </div>
</body>

</html>
