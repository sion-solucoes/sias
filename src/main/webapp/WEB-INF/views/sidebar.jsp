<%-- 
    Document   : navbar
    Created on : 24/07/2016, 19:41:33
    Author     : jaderhenrique
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<aside id="sidebar" class="sidebar c-overflow">
    <div class="s-profile">
        <a href="" data-ma-action="profile-menu-toggle">
            <div class="sp-pic">
                <c:if test="${empty usuarioSessao.foto}">
                    <img src="<c:url value="/img/icon-user.png"/>" alt="">
                </c:if>
                <c:if test="${not empty usuarioSessao.foto}">
                    <img alt="" src="<c:url value="${usuarioSessao.foto}"/>" class="margem photo-user" />
                </c:if>

            </div>

            <div class="sp-info" id="${usuarioSessao.nome}">
                ${usuarioSessao.nome} - ${usuarioSessao.email}
                <i class="zmdi zmdi-caret-down"></i>
            </div>
        </a>

        <ul class="main-menu">
            <li>
                <a href="<c:url value="/home/alterarSenha"/>"><i class="zmdi zmdi-lock"></i>Alterar Senha</a>
            </li>
            <li>
                <a href="<c:url value="/home/deslogar"/>"><i class="zmdi zmdi-time-restore"></i>Sair</a>
            </li>
        </ul>
    </div>
    <ul class="main-menu">
        <li class="sub-menu">
            <a href="<c:url value=""/>" data-ma-action="submenu-toggle"><i class="zmdi zmdi-home"></i>Controle Familiar</a>
            <ul>
                <li>
                    <a href="<c:url value="/controleFamiliar/familia"/>">Registro de Família</a>
                </li>
                <li>
                    <a href="<c:url value="/controleFamiliar/familiaVisita"/>">Agendamento de Visitas</a>
                </li>
                <li>
                    <a href="<c:url value="/controleFamiliar/requisicaoBeneficio"/>">Requisição de Benefício Eventual</a>
                </li>
            </ul>
        </li>
        <li class="sub-menu">
            <a href="<c:url value=""/>" data-ma-action="submenu-toggle"><i class="zmdi zmdi-view-list"></i> Cadastros Básicos</a>
            <ul>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/pais"/>">País</a>
                </li>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/unidadeFederacao"/>">Unidade Federativa(UF)</a>
                </li>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/municipio"/>">Município</a>
                </li>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/cep"/>">CEP</a>
                </li>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/formaIngresso"/>">Forma de Ingresso</a>
                </li>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/beneficioEventual"/>">Benefício Eventual</a>
                </li>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/especificidadeSocial"/>">Especificidade Social</a>
                </li>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/grauParentesco"/>">Grau de Parentesco</a>
                </li>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/documentoProvidenciavel"/>">Documento Providenciável</a>
                </li>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/escolaridade"/>">Escolaridade</a>
                </li>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/condicaoOcupacao"/>">Condição de Ocupação</a>
                </li>
                <li>
                    <a href="<c:url value="/cadastrosBasicos/deficiencia"/>">Deficiência</a>
                </li>
            </ul>
        </li>
        <li class="sub-menu">
            <a href="<c:url value=""/>" data-ma-action="submenu-toggle"><i class="zmdi zmdi-print"></i>Relatórios</a>
            <ul>
                <li>
                    <a class="${relatorios}" href="<c:url value="/relatorios/mensal"/>">Relatório Mensal de Atendimento</a>
                </li>
            </ul>
        </li>
        <li class="sub-menu">
            <a href="<c:url value=""/>" data-ma-action="submenu-toggle"><i class="zmdi zmdi-settings"></i>Controle de Ambiente</a>
            <ul>
                <li>
                    <a class="${unidadeAtendimento}" href="<c:url value="/controleAmbiente/unidadeAtendimento"/>">Unidade de Atendimento</a>
                </li>
                <li>
                    <a class="${usuario}" href="<c:url value="/controleAmbiente/usuario"/>">Usuário</a>
                </li>
            </ul>
        </li>
    </ul>
</aside>

