<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="familiaFormPanComposicaoFamiliar">
    <div class="card-header">
        <h3>Composição Familiar</h3>
    </div>
    <hr>
    <center class="form-group">
        <div class="col-md-4"></div>
        <div class="col-md-2 text-center">
            <button type="button" class="btn bgm-blue" id="btnAdicionarMembro">
                Adicionar Membro
            </button>
        </div>
        <div class="col-md-2 text-center">
            <button type="button" class="btn bgm-blue" id="btnEditarMembro">
                Editar Membro
            </button>
        </div>
        <div class="col-md-4"></div>
    </center>
    <div class="form-group m-t-30">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-condensed" id="tabelaComposicaoFamiliar">
            <thead>
                <tr>
                    <th></th>
                    <th>Nome</th>
                    <th>Grau Parentesco</th>
                    <th><span class="glyphicon glyphicon-trash"></span></th>
                </tr>
            </thead>
        </table>
        </div>
    </div>
</div>