<%-- 
    Document   : defienciaForm
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
                    <h2>Cadastro de Tipo de Deficiência</h2>
                </div>
                <div class="pull-right">
                    <a type="button" href="<c:url value = "/controleFamiliar/deficiencia"/>" class="btn bgm-blue">Voltar</a>
                </div>
            </div>
            <div class="card-body card-padding">
                <div class="card-header">
                    <h4>Dados Básicos</h4>
                </div>
                <form class="form-horizontal" role="form" method="POST">
                    <div class="form-group">
                        <label for="txtCodigo" class="control-label col-sm-2">Código</label>
                        <div class="col-md-4">
                            <div class="fg-line">
                                <input type="text" placeholder="Código" max="100" min="0" name="codigo" class="form-control input-sm" id="txtCodigo" value="${deficiencia.codigo}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtDescricao" class="control-label col-sm-2">Descrição</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input placeholder="Descrição" maxlength="50" name="descricao" class="form-control input-sm" id="txtDescricao" value="${deficiencia.descricao}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2"></label>
                        <div class="col-sm-4">
                            <button type="submit" class="btn bgm-blue" id="btnConfirmar">Confirmar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
