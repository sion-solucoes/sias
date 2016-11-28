<%-- 
    Document   : usuarioForm
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
                    <h2>Cadastro de Usuário</h2>
                </div>
            </div>
            <div class="card-body card-padding">
                <form class="form-horizontal" role="form" method="POST">
                    <input id="txtUsuarioUnidadeAtendimento" type="hidden" value="${usuario.unidadeAtendimento.id}">
                    <input id="txtId" type="number" hidden="true" name="id" value="${usuario.id}">
                    <input id="txtFoto" hidden="true" name="foto" value="${usuario.foto}">
                    <div class="card-header">
                        <h4>Dados de Usuário</h4>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Tipo de Usuário</label>
                        <div class="col-md-6">
                            <label class="radio radio-inline m-r-20">
                                <c:if test="${(usuario.tipo == 1) && (not empty usuario.tipo)}">
                                    <c:if test="${usuarioSessao.tipo == 1}">
                                        <input type="radio" name="tipo" id="radioTipoMaster" value="1" checked>
                                    </c:if>
                                    <c:if test="${usuarioSessao.tipo != 1}">
                                        <input type="radio" name="tipo" id="radioTipoMaster" value="1">
                                    </c:if>
                                </c:if>
                                <i class="input-helper"></i>
                                Master
                            </label>

                            <label class="radio radio-inline m-r-20">
                                <c:if test="${(usuario.tipo == 2) && (not empty usuario.tipo)}">
                                    <input type="radio" name="tipo" id="radioTipoTecnico" value="2" checked>
                                </c:if>
                                <c:if test="${(usuario.tipo != 2) || (empty usuario.tipo)}">
                                    <input type="radio" name="tipo" id="radioTipoTecnico" value="2">
                                </c:if>
                                <i class="input-helper"></i>
                                Técnico
                            </label>

                            <label class="radio radio-inline m-r-20">
                                <c:if test="${(usuario.tipo == 3) && (not empty usuario.tipo)}">
                                    <input type="radio" name="tipo" id="radioTipoAdministrativo" value="3" checked>
                                </c:if>
                                <c:if test="${(usuario.tipo != 3) || (empty usuario.tipo)}">
                                    <input type="radio" name="tipo" id="radioTipoAdministrativo" value="3">
                                </c:if>
                                <i class="input-helper"></i>
                                Administrativo
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Unidade de Atendimento</label>
                        <div class="col-md-6">
                            <select class="selectpicker" title="Selecione..." data-live-search="true" id="unidadeAtendimento">
                                <c:if test="${not empty unidadeAtendimentoList}">
                                    <c:forEach var="unidadeAtendimento" items="${unidadeAtendimentoList}">
                                        <option value="${unidadeAtendimento.codigo}">${unidadeAtendimento.descricao}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="txtEmail" class="control-label col-sm-2">Email</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input type="email" placeholder="Email" name="email" class="form-control input-sm" id="txtEmail" value="${usuario.email}"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtSenha" class="control-label col-sm-2">Senha</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input placeholder="Senha" type="password" name="senha" class="form-control input-sm" id="txtSenha" value="${usuario.senha}"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtConfirmacaoSenha" class="control-label col-sm-2">Confirmar Senha</label>
                        <div class="col-md-6">
                            <div class="fg-line">
                                <input placeholder="Confirme a Senha" type="password" name="confirmSenha" class="form-control input-sm" id="txtConfirmacaoSenha" value="${usuario.senha}"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Foto</label>
                        <div class="col-md-4">
                            <c:if test="${empty usuario.foto}">
                                <img id="imgFoto" alt="" src="<c:url value="/img/icon-user.png"/>" width="100" height="100" class="img-rounded photo" />                
                            </c:if>
                            <c:if test="${not empty usuario.foto}">
                                <img id="imgFoto" alt="" src="${usuario.foto}" width="100" height="100" class="img-rounded photo" />                
                            </c:if>
                        </div>
                        <div class="col-md-6">
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <span class="btn btn-primary btn-file m-r-10">
                                    <span class="fileinput-new">Mudar a Imagem</span>
                                    <span class="fileinput-exists">Mudar</span>
                                    <input id="fileFoto" type="file" name="..." accept="image/*">
                                </span>
                                <span class="fileinput-filename"></span>
                                <a href="#" class="close fileinput-exists" data-dismiss="fileinput">&times;</a>
                            </div>
                        </div>
                    </div>

                    <div class="card-header">
                        <h4>Dados Pessoais</h4>
                    </div>
                    <div class="card-body card-padding">
                        <div class="form-group">
                            <label for="txtNome" class="control-label col-sm-2">Nome</label>
                            <div class="col-md-6">
                                <div class="fg-line">
                                    <input placeholder="Nome" type="text" name="nome" class="form-control input-sm" id="txtNome" value="${usuario.nome}"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtSobrenome" class="control-label col-sm-2">Sobrenome</label>
                            <div class="col-md-6">
                                <div class="fg-line">
                                    <input placeholder="Sobrenome" type="text" name="sobrenome" class="form-control input-sm" id="txtSobrenome" value="${usuario.sobrenome}"/>    
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-header">
                        <h4>Códigos de Segurança</h4>
                    </div>
                    <div class="card-body card-padding">
                        <div class="form-group">
                            <div class="col-md-3">
                                <button id="btnGerarCodigos" type="button" class="btn bgm-blue">Gerar Códigos</button>
                            </div>
                            <div class="col-md-3">
                                <a type="button" href="<c:url value = "/controleAmbiente/usuario/${usuario.id}/cartaoSeguranca.pdf"/>" href="" target="_blank" class="btn bgm-blue">Imprimir</a>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Códigos Gerados</label>
                            <div class="col-md-5">
                                <table class="table table-striped table-bordered table-condensed" id="tabelaCodigosSeguranca1-5">
                                    <thead
                                        <tr>
                                            <th>Sequência</th>
                                            <th>Código</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="cont" begin="1" end="5">
                                            <tr>
                                                <td>${cont}</td>
                                                <td></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="col-md-5">
                                <table class="table table-striped table-bordered table-condensed" id="tabelaCodigosSeguranca6-10">
                                    <thead
                                        <tr>
                                            <th>Sequência</th>
                                            <th>Código</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="cont" begin="6" end="10">
                                            <tr>
                                                <td>${cont}</td>
                                                <td></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="row clearfix">
                            <div class="form-group">
                                <div class="col-md-4"></div>
                                <div class="col-md-2">
                                    <button type="button" id="btnConfirmar" class="btn bgm-blue">Confirmar</button>
                                </div>
                                <div class="col-md-2">
                                    <a href="<c:url value = "/controleAmbiente/usuario"/>" type="button" class="btn bgm-white">Voltar</a>
                                </div>
                                <div class="col-md-4"></div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>

<script type="text/javascript" src="<c:url value="/js/usuarioController.js"/>"></script>



