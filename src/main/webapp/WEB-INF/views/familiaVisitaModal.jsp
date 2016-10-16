<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="addNew-event" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Agende uma nova visita</h4>
            </div>
            <div class="modal-body">
                <form class="addEvent" role="form">
                    <div class="form-group">
                        <label for="comboFamilia" class="control-label">Família</label>
                        <select class="selectpicker" title="Selecione..." data-live-search="true" id="comboFamilia">
                            <c:if test="${not empty familiaList}">
                                <c:forEach var="familia" items="${familiaList}">
                                    <option value="${familia.id}"><h3>${familia.nomePessoaReferencia} | Endereço: ${familia.logradouroEndereco}, ${familia.numeroEndereco}, ${familia.bairroEndereco}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="comboUsuario" class="control-label">Técnico Responsável</label>
                        <select class="selectpicker" title="Selecione..." data-live-search="true" id="comboUsuario">
                            <c:if test="${not empty usuarioList}">
                                <c:forEach var="usuario" items="${usuarioList}">
                                    <option value="${usuario.id}">${usuario.nome} - ${usuario.email}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="dtpInicio" class="control-label">Data/Hora Inicial</label>
                        <div class="dtp-container">
                            <input type='text' id="dtpInicio" class="form-control date-time-picker" placeholder="Clique aqui...">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="dtpFim" class="control-label">Data/Hora Final</label>
                        <div class="dtp-container">
                            <input type='text' id="dtpFim" class="form-control date-time-picker" placeholder="Clique aqui...">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="eventName">Cor</label>
                        <div class="event-tag">
                            <span data-tag="bgm-teal" class="bgm-teal selected"></span>
                            <span data-tag="bgm-red" class="bgm-red"></span>
                            <span data-tag="bgm-pink" class="bgm-pink"></span>
                            <span data-tag="bgm-blue" class="bgm-blue"></span>
                            <span data-tag="bgm-lime" class="bgm-lime"></span>
                            <span data-tag="bgm-green" class="bgm-green"></span>
                            <span data-tag="bgm-cyan" class="bgm-cyan"></span>
                            <span data-tag="bgm-orange" class="bgm-orange"></span>
                            <span data-tag="bgm-purple" class="bgm-purple"></span>
                            <span data-tag="bgm-gray" class="bgm-gray"></span>
                            <span data-tag="bgm-black" class="bgm-black"></span>
                        </div>
                    </div>

                </form>
            </div>

            <div class="modal-footer">
                <button type="submit" class="btn btn-link" id="addEvent">Agendar</button>
                <button type="button" class="btn btn-link" data-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
</div>