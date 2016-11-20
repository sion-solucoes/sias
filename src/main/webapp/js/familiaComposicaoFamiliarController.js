$('#tabelaComposicaoFamiliar').ready(function (event) {

    var txtId = document.getElementById('txtId');
    var familiaId = txtId.value;
    var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');
    tabelaComposicaoFamiliar.prop('familiaMembroList', new Array());
    var data = {
        familiaId: familiaId
    };
    
    if (familiaId !== null && familiaId !== "") {
        $.ajax({
            method: 'POST',
            data: data,
            url: '/controleFamiliar/familiaMembro/readFamiliaMembroByFamilia',
            success: function (familiaMembroList) {
                if (familiaMembroList !== null) {
                    tabelaComposicaoFamiliar.bootgrid('append', familiaMembroList);
                    tabelaComposicaoFamiliar.prop('familiaMembroList', familiaMembroList);
                }
            }
        });
    }

});

$('#btnAdicionarMembro').click(function (event) {
    var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');
    tabelaComposicaoFamiliar.prop('index', null);
    var familiaMembroModal = $('#familiaMembroModal');
    familiaMembroModal.find('#familiaMembroModalLabel').text('Cadastro de Membro Familiar - Novo');
    familiaMembroModal.modal();
});

function  editarMembro(index) {
    var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');
    tabelaComposicaoFamiliar.prop('index', index);
    var familiaMembroModal = $('#familiaMembroModal');
    familiaMembroModal.find('#familiaMembroModalLabel').text('Cadastro de Membro Familiar - Editar');
    familiaMembroModal.modal();
}

function removerMembro(index) {
    var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');
    var familiaMembroList = tabelaComposicaoFamiliar.prop('familiaMembroList');
    familiaMembroList.splice(index, 1);
    tabelaComposicaoFamiliar.bootgrid('clear');
    tabelaComposicaoFamiliar.bootgrid('append', familiaMembroList);
}