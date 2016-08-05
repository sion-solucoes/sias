<%-- 
    Document   : documentoProvidenciavelForm
    Created on : 29/08/2015, 11:21:33
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Cadastro de Documento Providenci�vel</h2>
                </div>
                <div class="pull-right">
                    <a href="<c:url value = "/controleFamiliar/documentoProvidenciavel"/>" class="btn bgm-blue">Voltar</a>
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
                                <input placeholder="C�digo" maxlength="5" name="codigo" class="form-control input-sm" id="txtCodigo" value="${documentoProvidenciavel.codigo}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtDescricao" class="control-label col-sm-2">Descri��o</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input placeholder="Descri��o" maxlength="50" name="descricao" class="form-control input-sm" id="txtDescricao" value="${documentoProvidenciavel.descricao}"/>    
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
<!--        <div class="container">
            <h2>Cadastro de Documento Providenci�vel</h2>
            <hr>
            <div class="row clearfix">
                <form method="post" role="form">
                    <div class="row clearfix">
                        <div class="col-md-2">
                            <div class="form-group">
                                <label for="txtCodigo">C�digo</label>
                                <input placeholder="C�digo" maxlength="5" name="codigo" class="form-control sias-default" id="txtCodigo" value="${documentoProvidenciavel.codigo}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="txtDescricao">Descri��o</label>
                                <input placeholder="Descri��o" maxlength="50" name="descricao" class="form-control sias-default" id="txtDescricao" value="${documentoProvidenciavel.descricao}"/>    
                            </div>
                        </div>
                    </div>
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
                            <a href="<c:url value = "/controleFamiliar/documentoProvidenciavel"/>" class="btn btn-primary sias-default buttons hvr-bob">
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