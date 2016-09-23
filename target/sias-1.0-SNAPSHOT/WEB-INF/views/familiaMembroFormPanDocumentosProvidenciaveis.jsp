<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="familiaMembroFormPanDocumentosProvidenciaveis">
    <div class="card-header">
        <h3>Documentos Providenciáveis</h3>
    </div>
    <hr>
    <c:if test="${not empty documentoProvidenciavelList}">
        <c:forEach var="documentoProvidenciavel" items="${documentoProvidenciavelList}">
            <div class="row form-group p-l-15">
                <div class="checkbox col-md-4 m-l-15">
                    <label>
                        <input type="checkbox" name="documentoProvidenciavel[]" value="${documentoProvidenciavel.id}"/>
                        <i class="input-helper"></i>
                        ${documentoProvidenciavel.descricao}
                    </label>
                </div>
            </div>
        </c:forEach>
    </c:if>
<!--    <div class="row clearfix margem">
        <div class="col-md-12">
            <table class="table table-striped margem" id="tabelaDocumentosProvidenciaveis">
                <thead>
                    <tr>
                        <th><input type="checkbox" name="documentoProvidenciavel" id="checkDocumentoProvidenciavelAll"/></th>
                        <th>Código</th>
                        <th>Descrição</th>
                    </tr>
                </thead>
            </table>
        </div>
    </div>-->
</div>