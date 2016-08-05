<%-- 
    Document   : grauParentescoForm
    Created on : 01/09/2015, 20:33:10
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Cadastro de Grau de Parentesco</h2>
                </div>
                <div class="pull-right">
                    <a href="<c:url value = "/controleFamiliar/grauParentesco"/>" type="button" class="btn bgm-blue">Voltar</a>
                </div>
            </div>
            <div class="card-body card-padding">
                <form class="form-horizontal" role="form" method="POST">
                    <div class="card-header">
                        <h4>Dados B�sicos</h4>
                    </div>
                    <div class="form-group">
                        <label for="txtCodigo" class="col-sm-2 control-label">C�digo</label>
                        <div class="col-md-4">
                            <div class="fg-line">
                                <input type="text" placeholder="C�digo" max="100" min="0" name="codigo" class="form-control input-sm" id="txtCodigo" value="${grauParentesco.codigo}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtDescricao" class="col-sm-2 control-label">Descri��o</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input placeholder="Descri��o" maxlength="50" name="descricao" class="form-control input-sm" id="txtDescricao" value="${grauParentesco.descricao}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2"></label>
                        <div class="col-md-6">
                            <button type="submit" class="btn bgm-blue" id="btnConfirmar">Confirmar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
        <!--<div class="container">
            <h2>Cadastro de Grau de Parentesco</h2>
            <hr>
            <div class="row clearfix">
                <form method="post" role="form">
                    
                    
                    <div class="row clearfix">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <button type="submit" class="btn btn-primary sias-default buttons hvr-bob margem">
                                <img alt="" src="<c:url value="/img/icon-confirm.png"/>" class="img-rounded" />
                                Confirmar
                            </button>
                        </div>
                        <div class="col-md-4"></div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <a href="<c:url value = "/controleFamiliar/grauParentesco"/>" class="btn btn-primary sias-default buttons hvr-bob">
                                <img alt="" src="<c:url value="/img/icon-back.png"/>" class="img-rounded" />
                                Voltar
                            </a>
                        </div>
                        <div class="col-md-4"></div>
                    </div>
                </form>
            </div>
        </div>

        
        
    </body>
</html>-->