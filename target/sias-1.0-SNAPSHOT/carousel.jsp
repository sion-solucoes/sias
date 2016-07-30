<%-- 
    Document   : carousel
    Created on : 25/07/2015, 13:45:52
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="/css/carousel.css"/>" rel="stylesheet">
        
        <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

    </head>
    <body>

        <div class="carousel slide margem" id="carousel-388523">
            <ol class="carousel-indicators">
                <li data-slide-to="0" data-target="#carousel-388523" class="active">
                </li>
                <li data-slide-to="1" data-target="#carousel-388523">
                </li>
                <li data-slide-to="2" data-target="#carousel-388523">
                </li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img alt="" class="img-background" src="<c:url value="/img/gestao.jpg"/>">
                    <div class="carousel-caption background-one-color">
                        <h1 class="animated flip">
                            <b>Gestão</b>
                        </h1>
                    </div>
                </div>
                <div class="item">
                    <img alt="" src="<c:url value="/img/tecnologia.jpg"/>" class="img-background">
                    <div class="carousel-caption background-two-color">
                        <h1 class="animated flip">
                            <b>e Tecnologia</b>
                        </h1>   
                    </div>
                </div>
                <div class="item">
                    <img alt="" src="<c:url value="/img/educacao.jpg"/>" class="img-background">
                    <div class="carousel-caption background-three-color">
                        <h1 class="animated flip">
                            <b>para a Educação.</b>
                        </h1>   
                    </div>
                </div>
            </div> 
            <a class="left carousel-control" href="#carousel-388523" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a> 
            <a class="right carousel-control" href="#carousel-388523" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>

        <script src="<c:url value="/js/jquery.min.js"/>"></script>
        <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

    </body>
</html>
