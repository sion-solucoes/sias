<%-- 
    Document   : especificidadeSocialForm
    Created on : 29/08/2015, 12:16:50
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Cadastro de Especificidade Social</h2>
                </div>
            </div>
            <div class="card-header card-padding">
                <form class="form-horizontal" role="form" method="POST" id="especificidadeSocialForm">
                    <div class="card-header">
                        <h4>Dados Básicos</h4>
                    </div>
                    <input type="hidden" id="txtId" value="${especificidadeSocial.id}"/>
                    <div class="form-group">
                        <label for="txtDescricao" class="col-sm-2 control-label">Descrição</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input placeholder="Descrição" maxlength="50" name="descricao" class="form-control input-sm" id="txtDescricao" value="${especificidadeSocial.descricao}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="checkIndigena" class="col-sm-2 control-label">Indígena</label>
                        <div class="col-md-6">
                            <label class="checkbox checkbox-inline m-r-20">
                                <c:if test="${especificidadeSocial.indigena}">
                                    <input type="checkbox" name="indigena" id="checkIndigena" checked/>    
                                </c:if>
                                <c:if test="${!especificidadeSocial.indigena}">
                                    <input type="checkbox" name="indigena" id="checkIndigena"/>    
                                </c:if>
                                <i class="input-helper"></i>
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtPovoEtnia" class="col-sm-2 control-label">Povo/Etnia</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input placeholder="Povo/Etnia" maxlength="50" name="povoEtnia" class="form-control" id="txtPovoEtnia" value="${especificidadeSocial.povoEtnia}"/>    
                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-2">
                                <button type="submit" id="btnConfirmar" class="btn bgm-blue">Confirmar</button>
                            </div>
                            <div class="col-md-2">
                                <a href="<c:url value = "/cadastrosBasicos/especificidadeSocial"/>" type="button" class="btn bgm-white">Voltar</a>
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
<script src="<c:url value="/js/especificidadeSocialController.js"/>"></script>
