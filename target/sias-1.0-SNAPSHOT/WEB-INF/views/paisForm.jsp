<%-- 
    Document   : paisForm
    Created on : 12/06/2015, 22:37:07
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Cadastro de Pais</h2>
                </div>
            </div>
            <div class="card-body card-padding">
                <form class="form-horizontal" role="form" method="POST" id="paisForm">
                    <div class="card-header">
                        <h4>Dados Básicos</h4>
                    </div>
                    <input id="txtId" type="hidden" name="id" value="${pais.id}"/>    
                    <div class="form-group">
                        <label for="txtSigla" class="control-label col-sm-2">Sigla</label>
                        <div class="col-md-3">
                            <div class="fg-line">
                                <input placeholder="Sigla" maxlength="3" name="sigla" class="form-control input-sm" id="txtSigla" value="${pais.sigla}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtDescricao" class="control-label col-sm-2">Descrição</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input placeholder="Descrição" maxlength="100" name="descricao" class="form-control input-sm" id="txtDescricao" value="${pais.descricao}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtCodigoBACEN" class="control-label col-sm-2">Código(BACEN)</label>
                        <div class="col-md-4">
                            <div class="fg-line">
                                <input placeholder="Código(BACEN)" name="codigoBACEN" class="form-control input-sm" id="txtCodigoBACEN" value="${pais.codigoBACEN}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-2">
                                <button type="submit" class="btn bgm-blue" id="btnConfirmar">Confirmar</button>
                            </div>
                            <div class="col-md-2">
                                <a type="button" href="<c:url value = "/cadastrosBasicos/pais"/>" class="btn bgm-white">Voltar</a>
                            </div>
                            <div class="col-md-4"></div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
<script type="text/javascript" src="<c:url value="/js/paisController.js"/>"></script>


