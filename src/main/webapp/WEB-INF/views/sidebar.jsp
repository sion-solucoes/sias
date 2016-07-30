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
                        <img src="<c:url value="/img/profile-pic.jpg"/>" alt="">
                    </c:if>
                    <c:if test="${not empty usuarioSessao.foto}">
                        <img alt="" src="<c:url value="${usuarioSessao.foto}"/>" class="margem photo-user" />
                    </c:if>
                    
                </div>

                <div class="sp-info">
                    ${usuarioSessao.email}
                    <i class="zmdi zmdi-caret-down"></i>
                </div>
            </a>

            <ul class="main-menu">
                <li>
                    <a href="<c:url value="/home/alterarSenha"/>"><i class="zmdi zmdi-lock"></i> Alterar Senha</a>
                </li>
                <li>
                    <a href="<c:url value="/home/deslogar"/>"><i class="zmdi zmdi-time-restore"></i> Sair</a>
                </li>
            </ul>
        </div>
        <ul class="main-menu">
            <li class="sub-menu">
                <a href="<c:url value="#"/>" data-ma-action="submenu-toggle"><i class="zmdi zmdi-home"></i> Controle Familiar</a>
                <ul>
                    <li>
                        <a href="<c:url value="/controleFamiliar/familia"/>">Cadastro de Família</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/visita"/>">Agendamento de Visitas</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/acompanhamento"/>">Acompanhamento</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/relatorio"/>">Requisição de Benefício Eventual</a>
                    </li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="<c:url value="#"/>" data-ma-action="submenu-toggle"><i class="zmdi zmdi-view-list"></i> Cadastros Básicos</a>
                <ul>
                    <li>
                        <a href="<c:url value="/cadastrosBasicos/unidadeFederacao"/>"> Cadastro de Unidade Federação(UF)</a>
                    </li>
                    <li>
                        <a href="<c:url value="/cadastrosBasicos/municipio"/>"> Cadastro de Município</a>
                    </li>
                    <li>
                        <a href="<c:url value="/cadastrosBasicos/cep"/>"> Cadastro de CEP</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/formaIngresso"/>"> Cadastro de Forma de Ingresso</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/beneficioEventual"/>"> Cadastro de Benefício Eventual</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/especificidadeSocial"/>"> Cadastro de Benefício Eventual</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/especificidadeSocial"/>"> Cadastro de Especificidade Social</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/grauParentesco"/>"> Cadastro de Grau de Parentesco</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/documentoProvidenciavel"/>"> Cadastro de Documento Providenciável</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/escolaridade"/>"> Cadastro de Escolaridade</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/condicaoOcupacao"/>"> Cadastro de Condição de Ocupação</a>
                    </li>
                    <li>
                        <a href="<c:url value="/controleFamiliar/deficiencia"/>"> Cadastro de Deficiência</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="zmdi zmdi-print"></i> Relatórios</a>
            </li>
            <li class="sub-menu ${controleAmbiente}">
                <a href="#" data-ma-action="submenu-toggle"><i class="zmdi zmdi-settings"></i> Controle de Ambiente</a>
                <ul>
                    <li>
                        <a class="${unidadeAtendimento}" href="<c:url value="/controleAmbiente/unidadeAtendimento"/>"> Cadastro de Unidade de Atendimento</a>
                    </li>
                    <li>
                        <a class="${usuario}" href="<c:url value="/controleAmbiente/usuario"/>"> Cadastro de Usuário</a>
                    </li>
                </ul>
            </li>
        </ul>
    </aside>

