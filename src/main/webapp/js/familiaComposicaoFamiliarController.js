$('#tabelaComposicaoFamiliar').ready(function (event) {

    var txtId = document.getElementById('txtId');
    var familiaId = txtId.value;
    var tabelaComposicaoFamiliar = document.getElementById("tabelaComposicaoFamiliar");
    var data = {
        familiaId: familiaId
    };

    if (familiaId != null && familiaId != "") {
        $.ajax({
            method: 'POST',
            data: data,
            url: '/sias/controleFamiliar/familiaMembro/readFamiliaMembroByFamilia',
            success: function (familiaMembroList) {
                if (familiaMembroList !== null) {
                    var body = document.createElement("tbody");
                    for (var indexFamiliaMembro = 0; indexFamiliaMembro < familiaMembroList.length; indexFamiliaMembro++) {
                        var row = document.createElement("tr");
                        var familiaMembro = familiaMembroList[indexFamiliaMembro];

                        var checkData = document.createElement("td");
                        var check = document.createElement("input");
                        check.type = "checkbox";
                        check.id = "checkTabelaFamiliaMembro";
                        check.value = JSON.stringify(familiaMembro);
                        checkData.appendChild(check);
                        row.appendChild(checkData);
                        var nomeData = document.createElement("td");
                        var nome = document.createTextNode(familiaMembro.nome);
                        nomeData.appendChild(nome);
                        row.appendChild(nomeData);
                        var grauParentesco = document.createElement("td");
                        grauParentesco.appendChild(document.createTextNode(familiaMembro.grauParentesco.codigo + ' - ' + familiaMembro.grauParentesco.descricao));
                        row.appendChild(grauParentesco);
                        var trashData = document.createElement("td");
                        var trash = document.createElement("a");
                        trash.id = "trashTabelaFamiliaMembro";
                        var spanTrash = document.createElement("span");
                        spanTrash.className = "glyphicon glyphicon-remove";
                        trash.appendChild(spanTrash);
                        trashData.appendChild(trash);
                        row.appendChild(trashData);
                        body.appendChild(row);
                    }
                    tabelaComposicaoFamiliar.appendChild(body);
                }
            }
        });
    }
});

$('#btnAdicionarMembro').click(function (event) {

    var familiaMembroModal = $('#familiaMembroModal');
    familiaMembroModal.find('#familiaMembroModalLabel').text('Cadastro de Membro Familiar - Novo');
    familiaMembroModal.modal();

});

$('#btnEditarMembro').click(function (event) {

    var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');
    var checkBoxCheckedList = tabelaComposicaoFamiliar.find('input:checkbox:checked');

    if (checkBoxCheckedList.length == 0) {
        $('#msgFailure').text('Selecione um membro para poder editá-lo.');
        $('#dlgFailure').modal('show');
        setTimeout(function () {
            $('#dlgFailure').modal('hide');
        }, 3000);
        return;
    }

    var familiaMembroModal = $('#familiaMembroModal');
    familiaMembroModal.find('#familiaMembroModalLabel').text('Cadastro de Membro Familiar - Editar');
    familiaMembroModal.modal();

});

$(document).on('change', '#checkTabelaFamiliaMembro', function (event) {

    var check = document.activeElement;

    if (check.checked) {
        var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');
        var checkBoxCheckedList = tabelaComposicaoFamiliar.find('input:checkbox:checked');
        for (var indexCheckBoxChecked = 0; indexCheckBoxChecked < checkBoxCheckedList.length; indexCheckBoxChecked++) {
            var checkBoxChecked = checkBoxCheckedList[indexCheckBoxChecked];
            if (checkBoxChecked != check) {
                checkBoxChecked.checked = false;
            }
        }

    }

});

