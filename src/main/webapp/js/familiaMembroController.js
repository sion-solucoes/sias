$('#familiaMembroModal').on('shown.bs.modal', function () {

    var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');
    var comboGrauParentesco = $('#comboGrauParentesco');
    var txtNome = $('#txtNome');
    var comboSexo = $('#comboSexo');
    var txtApelido = $('#txtApelido');
    var txtDataNascimento = $('#txtDataNascimento');
    var txtNomeMae = $('#txtNomeMae');
    var txtNIS = $('#txtNIS');
    var txtCPF = $('#txtCPF');
    var txtRG = $('#txtRG');
    var txtOrgaoExpedidorRG = $('#txtOrgaoExpedidorRG');
    var txtUFEmissaoRG = $('#txtUFEmissaoRG');
    var txtDataEmissaoRG = $('#txtDataEmissaoRG');
    var tabelaDocumentosProvidenciaveis = $('#tabelaDocumentosProvidenciaveis');
    var checkDocumentoProvidenciavelList = tabelaDocumentosProvidenciaveis.find('input');
    var comboEscolaridade = $('#comboEscolaridade');
    var checkSabeLerEscrever = $('#checkSabeLerEscrever');
    var checkFrequentaEscolaAtualmente = $('#checkFrequentaEscolaAtualmente');
    var checkPossuiCarteiraTrabalho = $('#checkPossuiCarteiraTrabalho');
    var comboCondicaoOcupacao = $('#comboCondicaoOcupacao');
    var checkPossuiQualificacaoProfissional = $('#checkPossuiQualificacaoProfissional');
    var txtDescricaoQualificacaoProfissional = $('#txtDescricaoQualificacaoProfissional');
    var txtRendaMensal = $('#txtRendaMensal');
    var comboDeficiencia = $('#comboDeficiencia');
    var checkNecessitaCuidadosConstantes = $('#checkNecessitaCuidadosContantes');
    var txtDescricaoNecessidadeCuidadosConstantes = $('#txtDescricaoNecessidadeCuidadosConstantes');
    var checkUsuarioRemediosControlados = $('#checkUsuarioRemediosControlados');
    var checkUsuarioBebidasAlcoolicas = $('#checkUsuarioBebidasAlcoolicas');
    var checkUsuarioEntorpecentes = $('#checkUsuarioEntorpecentes');
    var checkGestante = $('#checkGestante');
    var txtMesesGestacao = $('#txtMesesGestacao');
    var checkIniciouPreNatal = $('#checkIniciouPreNatal');

    comboGrauParentesco.prop('selectedIndex', 0);
    comboGrauParentesco.prop('disabled', true);
    txtNome.val('');
    comboSexo.prop('selectedIndex', 0);
    txtApelido.val('');
    txtDataNascimento.val('');
    txtNomeMae.val('');
    txtNIS.val('');
    txtCPF.val('');
    txtRG.val('');
    txtOrgaoExpedidorRG.val('');
    txtUFEmissaoRG.val('');
    txtDataEmissaoRG.val('');
    for (var indexDocumentoProvidenciavel = 0; indexDocumentoProvidenciavel < checkDocumentoProvidenciavelList.length; indexDocumentoProvidenciavel++) {
        var check = checkDocumentoProvidenciavelList[indexDocumentoProvidenciavel];
        check.checked = false;
    }
    comboEscolaridade.prop('selectedIndex', 0);
    checkSabeLerEscrever.prop('checked', false);
    checkFrequentaEscolaAtualmente.prop('checked', false);
    checkPossuiCarteiraTrabalho.prop('checked', false);
    comboCondicaoOcupacao.prop('selectedIndex', 0);
    checkPossuiQualificacaoProfissional.prop('checked', false);
    txtDescricaoQualificacaoProfissional.val('');
    txtDescricaoQualificacaoProfissional.prop('disabled', true);
    txtRendaMensal.val(0);
    comboDeficiencia.prop('selectedIndex', 0);
    checkNecessitaCuidadosConstantes.prop('checked', false);
    txtDescricaoNecessidadeCuidadosConstantes.val('');
    txtDescricaoNecessidadeCuidadosConstantes.prop('disabled', true);
    checkUsuarioRemediosControlados.prop('checked', false);
    checkUsuarioBebidasAlcoolicas.prop('checked', false);
    checkUsuarioEntorpecentes.prop('checked', false);
    checkGestante.prop('checked', false);
    txtMesesGestacao.val('');
    txtMesesGestacao.prop('disabled', true);
    checkIniciouPreNatal.prop('checked', false);
    checkIniciouPreNatal.prop('disabled', true);

    var indexOrdem = tabelaComposicaoFamiliar.prop('rows').length - 1;

    if ($('#familiaMembroModalLabel').text().indexOf('Editar') > 0) {
        indexOrdem = tabelaComposicaoFamiliar.find('input:checkbox').index(tabelaComposicaoFamiliar.find('input:checkbox:checked'));
        var checkBoxCheckedList = tabelaComposicaoFamiliar.find('input:checkbox:checked');
        var familiaMembro = JSON.parse(checkBoxCheckedList[0].value);
        comboGrauParentesco.val(familiaMembro.grauParentesco.id);
        txtNome.val(familiaMembro.nome);
        comboSexo.val(familiaMembro.sexo);
        txtApelido.val(familiaMembro.apelido);
        txtDataNascimento.val(familiaMembro.dataNascimento);
        txtNomeMae.val(familiaMembro.nomeMae);
        txtNIS.val(familiaMembro.nis);
        txtCPF.val(familiaMembro.cpf);
        txtRG.val(familiaMembro.rg);
        txtOrgaoExpedidorRG.val(familiaMembro.rgOrgaoExpedidor);
        txtUFEmissaoRG.val(familiaMembro.rgUFEmissao);
        txtDataEmissaoRG.val(familiaMembro.rgDataEmissao);
        for (var indexDocumentoProvidenciavel = 1; indexDocumentoProvidenciavel < checkDocumentoProvidenciavelList.length; indexDocumentoProvidenciavel++) {
            var check = checkDocumentoProvidenciavelList[indexDocumentoProvidenciavel];
            if (familiaMembro.familiaMembroDocumentoProvidenciavelList) {
                for (var indexFamiliaMembroDocumentoProvidenciavel = 0; indexFamiliaMembroDocumentoProvidenciavel < familiaMembro.familiaMembroDocumentoProvidenciavelList.length; indexFamiliaMembroDocumentoProvidenciavel++) {
                    var familiaMembroDocumentoProvidenciavel = familiaMembro.familiaMembroDocumentoProvidenciavelList[indexFamiliaMembroDocumentoProvidenciavel];
                    var documentoProvidenciavel = familiaMembroDocumentoProvidenciavel.documentoProvidenciavel;
                    if (check.value == documentoProvidenciavel.id) {
                        check.prop('checked', true);
                    }
                }
            }
        }
        comboEscolaridade.val(familiaMembro.escolaridade.id);
        checkSabeLerEscrever.prop('checked', familiaMembro.sabeLerEscrever);
        checkFrequentaEscolaAtualmente.prop('checked', familiaMembro.frequentaEscolaAtualmente);
        checkPossuiCarteiraTrabalho.prop('checked', familiaMembro.possuiCarteiraTrabalho);
        comboCondicaoOcupacao.val(familiaMembro.condicaoOcupacao.id);
        checkPossuiQualificacaoProfissional.prop('checked', familiaMembro.possuiQualificacaoProfissional);
        txtDescricaoQualificacaoProfissional.val(familiaMembro.descricaoQualificacaoProfissional);
        txtRendaMensal.val(familiaMembro.rendaMensal.toFixed(2));
        if (familiaMembro.deficiencia != null && familiaMembro.defiencia.id != null) {
            comboDeficiencia.val(familiaMembro.deficiencia.id);
        }
        checkNecessitaCuidadosConstantes.prop('checked', familiaMembro.necessitaCuidadosConstantes);
        txtDescricaoNecessidadeCuidadosConstantes.val(familiaMembro.descricaoNecessidadeCuidadosConstantes);
        checkUsuarioRemediosControlados.prop('checked', familiaMembro.usuarioRemediosControlados);
        checkUsuarioBebidasAlcoolicas.prop('checked', familiaMembro.usuarioBebidasAlcoolicas);
        checkUsuarioEntorpecentes.prop('checked', familiaMembro.usuarioEntorpecentes);
        checkGestante.prop('checked', familiaMembro.gestante);
        txtMesesGestacao.val(familiaMembro.mesesGestacao);
        checkIniciouPreNatal.prop('checked', familiaMembro.iniciouPrestacao);
    }

    if (indexOrdem === 0) {
        comboGrauParentesco.prop('selectedIndex', 1);
        comboGrauParentesco.prop('disabled', true);
        comboGrauParentesco.selectpicker('refresh');
    } else {
        comboGrauParentesco.prop('disabled', false);
        comboGrauParentesco.selectpicker('refresh');
    }


    txtRendaMensal.priceFormat(PriceFormatConfig);

});

$('#btnConfirmarFamiliaMembro').click(function (event) {

    var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');
    var familiaMembroModal = $('#familiaMembroModal');

    /*
     * Aba "Básico"
     * */
    var comboGrauParentesco = $('#comboGrauParentesco');
    var txtNome = $('#txtNome');
    var comboSexo = $('#comboSexo');
    var txtApelido = $('#txtApelido');
    var txtDataNascimento = $('#txtDataNascimento');
    var txtNomeMae = $('#txtNomeMae');
    var txtNIS = $('#txtNIS');
    var txtCPF = $('#txtCPF');
    var txtRG = $('#txtRG');
    var txtRGOrgaoExpedidor = $('#txtRGOrgaoExpedidor');
    var txtRGUFEmissao = $('#txtRGUFEmissao');
    var txtRGDataEmissao = $('#txtRGDataEmissao');
    /*
     * Aba "Documentos Providenciáveis"
     * */
    var familiaMembroDocumentoProvidenciavelList = new Array();
    var tabelaDocumentosProvidenciaveis = $('#tabelaDocumentosProvidenciaveis');
    var rowsTabelaDocumentosProvidenciaveis = tabelaDocumentosProvidenciaveis.prop('rows');
    for (var indexDocumentoProvidenciavel = 1; indexDocumentoProvidenciavel < rowsTabelaDocumentosProvidenciaveis.length; indexDocumentoProvidenciavel++) {
        var row = rowsTabelaDocumentosProvidenciaveis[indexDocumentoProvidenciavel];
        var data = row.cells[0];
        var check = $(data.children[0]);
        if (check.prop('checked')) {
            var documentoProvidenciavel = {
                id: check.value
            };
            var familiaMembroDocumentoProvidenciavel = {
                documentoProvidenciavel: documentoProvidenciavel
            };
            familiaMembroDocumentoProvidenciavelList.push(familiaMembroDocumentoProvidenciavel);
        }
    }

    /*
     * Aba "Condições Educacionais"
     * */
    var comboEscolaridade = $('#comboEscolaridade');
    var checkSabeLerEscrever = $('#checkSabeLerEscrever');
    var checkFrequentaEscolaAtualmente = $('#checkFrequentaEscolaAtualmente');
    var checkPossuiCarteiraTrabalho = $('#checkPossuiCarteiraTrabalho');
    var comboCondicaoOcupacao = $('#comboCondicaoOcupacao');
    var checkPossuiQualificacaoProfissional = $('#checkPossuiQualificacaoProfissional');
    var txtDescricaoQualificacaoProfissional = $('#txtDescricaoQualificacaoProfissional');
    var txtRendaMensal = $('#txtRendaMensal');
    var comboDeficiencia = $('#comboDeficiencia');
    var checkNecessitaCuidadosConstantes = $('#checkNecessitaCuidadosConstantes');
    var txtDescricaoNecessidadeCuidadosConstantes = $('#txtDescricaoNecessidadeCuidadosConstantes');
    var checkUsuarioRemediosControlados = $('#checkUsuarioRemediosControlados');
    var checkUsuarioBebidasAlcoolicas = $('#checkUsuarioBebidasAlcoolicas');
    var checkUsuarioEntorpecentes = $('#checkUsuarioEntorpecentes');
    var checkGestante = $('#checkGestante');
    var txtMesesGestacao = $('#txtMesesGestacao');
    var checkIniciouPreNatal = $('#checkIniciouPreNatal');

    var familiaMembro = {
        grauParentesco: {
            id: comboGrauParentesco.val()
        },
        nome: txtNome.val(),
        sexo: comboSexo.val(),
        apelido: txtApelido.val(),
        dataNascimento: txtDataNascimento.val() == '' ? null : txtDataNascimento.val(),
        nomeMae: txtNomeMae.val(),
        nis: txtNIS.val(),
        cpf: txtCPF.val(),
        rg: txtRG.val(),
        rgOrgaoExpedidor: txtRGOrgaoExpedidor.val(),
        rgUFEmissao: txtRGUFEmissao.val(),
        rgDataEmissao: txtRGDataEmissao.val() == '' ? null : txtRGDataEmissao.val(),
        familiaMembroDocumentoProvidenciavelList: familiaMembroDocumentoProvidenciavelList,
        escolaridade: {
            id: comboEscolaridade.val()
        },
        sabeLerEscrever: checkSabeLerEscrever.prop('checked'),
        frequentaEscolaAtualmente: checkFrequentaEscolaAtualmente.prop('checked'),
        possuiCarteiraTrabalho: checkPossuiCarteiraTrabalho.prop('checked'),
        condicaoOcupacao: {
            id: comboCondicaoOcupacao.val()
        },
        possuiQualificacaoProfissional: checkPossuiQualificacaoProfissional.prop('checked'),
        descricaoQualificacaoProfissional: txtDescricaoQualificacaoProfissional.val(),
        rendaMensal: parseFloat(txtRendaMensal.val().replace('R$ ', '').replace('.', '').replace(',', '.')),
        deficiencia: {
            id: comboDeficiencia.val()
        },
        necessitaCuidadosConstantes: checkNecessitaCuidadosConstantes.prop('checked'),
        descricaoNecessidadeCuidadosConstantes: txtDescricaoNecessidadeCuidadosConstantes.val(),
        usuarioRemediosControlados: checkUsuarioRemediosControlados.prop('checked'),
        usuarioBebidasAlcoolicas: checkUsuarioBebidasAlcoolicas.prop('checked'),
        usuarioEntorpecentes: checkUsuarioEntorpecentes.prop('checked'),
        gestante: checkGestante.prop('checked'),
        mesesGestacao: txtMesesGestacao.val(),
        iniciouPreNatal: checkIniciouPreNatal.prop('checked')
    };

    var row = tabelaComposicaoFamiliar.prop('rows')[0].cloneNode();
    var checkData = document.createElement("td");
    var check = document.createElement("input");
    check.type = "checkbox";
    check.id = "checkTabelaFamiliaMembro";
    check.value = JSON.stringify(familiaMembro);
    checkData.appendChild(check);
    row.appendChild(checkData);
    var nomeData = document.createElement("td");
    nomeData.value = txtNome.val();
    var nome = document.createTextNode(txtNome.val());
    nomeData.appendChild(nome);
    row.appendChild(nomeData);
    var grauParentesco = document.createElement("td");
    grauParentesco.value = comboGrauParentesco.val();
    grauParentesco.appendChild(document.createTextNode(comboGrauParentesco.find('option:selected').prop('innerText')));
    row.appendChild(grauParentesco);
    var trashData = document.createElement("td");
    var trash = document.createElement("a");
    trash.id = "trashTabelaFamiliaMembro";
    var spanTrash = document.createElement("span");
    spanTrash.className = "glyphicon glyphicon-remove";
    trash.appendChild(spanTrash);
    trashData.appendChild(trash);
    row.appendChild(trashData);
    if (familiaMembroModal.find('#familiaMembroModalLabel').text().indexOf('Editar') > 0) {
        var checkBoxCheckedList = tabelaComposicaoFamiliar.find('input:checkbox:checked');
        var dataAtual = checkBoxCheckedList[0].parentElement;
        var rowAtual = dataAtual.parentElement;
        $(rowAtual).html($(row).html());
    } else {
        var body = tabelaComposicaoFamiliar.find('tbody');
        if (body.length == 0) {
            body = document.createElement('tbody');
            body.appendChild(row);
            tabelaComposicaoFamiliar.append(body);
        } else {
            body.append(row);
        }
    }

    familiaMembroModal.modal('toggle');
    return;
});