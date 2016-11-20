<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="familiaFormPanComposicaoFamiliar">
    <div class="card-header">
        <h3>Composição Familiar</h3>
    </div>
    <hr>
    <center class="form-group">
        <div class="col-md-5"></div>
        <div class="col-md-2 text-center">
            <button type="button" class="btn bgm-blue" id="btnAdicionarMembro">
                Adicionar Membro
            </button>
        </div>
        <div class="col-md-5"></div>
    </center>
    <div class="form-group m-t-30">
        <div class="col-md-12">
            <table class="table table-striped table-vmiddle table-bootgrid" id="tabelaComposicaoFamiliar">
                <thead>
                    <tr>
                        <th data-column-id="nome">Nome</th>
                        <th data-column-id="grauParentesco" data-formatter="grauParentesco">Grau Parentesco</th>
                        <th data-column-id="nis">NIS</th>
                        <th data-column-id="commands" data-formatter="composicaoFamiliar" data-sortable="false">Ações</th>
                    </tr>
                </thead>
            </table>
        </div>
    </div>
</div>

