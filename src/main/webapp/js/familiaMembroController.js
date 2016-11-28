$('#familiaMembroForm').ready(function () {

    var comboGrauParentesco = $('#comboGrauParentesco');
    $.ajax({
        method: 'POST',
        url: '/cadastrosBasicos/grauParentesco/readAll',
        success: function (data) {
            if (data !== null) {
                for (var i = 0; i < data.length; i++) {
                    var grauParentesco = data[i];
                    var option = document.createElement("option");
                    option.value = grauParentesco.id;
                    option.text = grauParentesco.codigo + ' - ' + grauParentesco.descricao;
                    comboGrauParentesco.append(option);
                }
            }
        }
    });

    var comboEscolaridade = $('#comboEscolaridade');
    $.ajax({
        method: 'POST',
        url: '/cadastrosBasicos/escolaridade/readAll',
        success: function (data) {
            if (data !== null) {
                for (var i = 0; i < data.length; i++) {
                    var escolaridade = data[i];
                    var option = document.createElement("option");
                    option.value = escolaridade.id;
                    option.text = escolaridade.codigo + ' - ' + escolaridade.descricao;
                    comboEscolaridade.append(option);
                }
                comboEscolaridade.selectpicker('refresh');
            }
        }
    });

    var comboCondicaoOcupacao = $('#comboCondicaoOcupacao');
    $.ajax({
        method: 'POST',
        url: '/cadastrosBasicos/condicaoOcupacao/readAll',
        success: function (data) {
            if (data !== null) {
                for (var i = 0; i < data.length; i++) {
                    var condicaoOcupacao = data[i];
                    var option = document.createElement("option");
                    option.value = condicaoOcupacao.id;
                    option.text = condicaoOcupacao.codigo + ' - ' + condicaoOcupacao.descricao;
                    comboCondicaoOcupacao.append(option);
                }
                comboCondicaoOcupacao.selectpicker('refresh');
            }
        }
    });

    var comboDeficiencia = $('#comboDeficiencia');
    $.ajax({
        method: 'POST',
        url: '/cadastrosBasicos/deficiencia/readAll',
        success: function (data) {
            if (data !== null) {
                for (var i = 0; i < data.length; i++) {
                    var deficiencia = data[i];
                    var option = document.createElement("option");
                    option.value = deficiencia.id;
                    option.text = deficiencia.codigo + ' - ' + deficiencia.descricao;
                    comboDeficiencia.append(option);
                }
                comboDeficiencia.selectpicker('refresh');
            }
        }
    });

});


$('#familiaMembroModal').on('shown.bs.modal', function () {

    var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');

    $('#familiaMembroForm a').addClass('collapsed');
    $('#familiaMembroForm .collapse').removeClass('in');
    $('#familiaMembroForm [role="tab"]').removeClass('active');
    

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

    var checkDocumentoProvidenciavelList = $('input[type=checkbox][name="documentoProvidenciavel[]"]');

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

    var checkVitimaAmeacasDiscriminacao = $('#checkVitimaAmeacasDiscriminacao');
    var checkParticipaGruposReligiosos = $('#checkParticipaGruposReligiosos');
    var checkParticipaMovimentosSociais = $('#checkParticipaMovimentosSociais');
    var checkAcessoLazer = $('#checkAcessoLazer');
    var checkCompanhiaAdulto = $('#checkCompanhiaAdulto');

    var checkViolenciaFisica = $('#checkViolenciaFisica');
    var checkViolenciaPsicologica = $('#checkViolenciaPsicologica');
    var checkExploracaoSexual = $('#checkExploracaoSexual');
    var checkAbusoViolenciaSexual = $('#checkAbusoViolenciaSexual');
    var checkNegligenciaAbandono = $('#checkNegligenciaAbandono');
    var checkTrabalhoInfantil = $('#checkTrabalhoInfantil');
    var checkTrajetoriaRua = $('#checkTrajetoriaRua');
    var checkTraficoPessoas = $('#checkTraficoPessoas');
    var checkDiscriminacaoOrientacaoSexual = $('#checkDiscriminacaoOrientacaoSexual');
    var checkViolenciaIdosoPCD = $('#checkViolenciaIdosoPCD');

    var txtAcompanhamento = $('#txtAcompanhamento');

    comboGrauParentesco.prop('selectedIndex', 0);
    comboGrauParentesco.prop('disabled', true);
    txtNome.val('');
    comboSexo.prop('selectedIndex', 0);
    comboSexo.selectpicker('refresh');
    txtApelido.val('');
    txtDataNascimento.val('');
    txtNomeMae.val('');
    txtNIS.val('');
    txtCPF.val('');
    txtRG.val('');
    txtOrgaoExpedidorRG.val('');
    txtUFEmissaoRG.val('');
    txtDataEmissaoRG.val('');

    checkDocumentoProvidenciavelList.each(function () {
        $(this).prop('checked', false);
    });

    comboEscolaridade.prop('selectedIndex', 0);
    comboEscolaridade.selectpicker('refresh');
    checkSabeLerEscrever.prop('checked', false);
    checkFrequentaEscolaAtualmente.prop('checked', false);

    checkPossuiCarteiraTrabalho.prop('checked', false);
    comboCondicaoOcupacao.prop('selectedIndex', 0);
    comboCondicaoOcupacao.selectpicker('refresh');
    checkPossuiQualificacaoProfissional.prop('checked', false);
    txtDescricaoQualificacaoProfissional.val('');
    txtDescricaoQualificacaoProfissional.prop('disabled', true);
    txtRendaMensal.val(0);

    comboDeficiencia.prop('selectedIndex', 0);
    comboDeficiencia.selectpicker('refresh');
    checkNecessitaCuidadosConstantes.prop('checked', false);
    txtDescricaoNecessidadeCuidadosConstantes.val('');
    txtDescricaoNecessidadeCuidadosConstantes.prop('disabled', true);
    checkUsuarioRemediosControlados.prop('checked', false);
    checkUsuarioBebidasAlcoolicas.prop('checked', false);
    checkUsuarioEntorpecentes.prop('checked', false);
    checkGestante.prop('checked', false);
    txtMesesGestacao.val(0);
    txtMesesGestacao.prop('disabled', true);
    checkIniciouPreNatal.prop('checked', false);
    checkIniciouPreNatal.prop('disabled', true);

    checkVitimaAmeacasDiscriminacao.prop('checked', false);
    checkParticipaGruposReligiosos.prop('checked', false);
    checkParticipaMovimentosSociais.prop('checked', false);
    checkAcessoLazer.prop('checked', true);
    checkCompanhiaAdulto.prop('checked', true);

    checkViolenciaFisica.prop('checked', false);
    checkViolenciaPsicologica.prop('checked', false);
    checkExploracaoSexual.prop('checked', false);
    checkAbusoViolenciaSexual.prop('checked', false);
    checkNegligenciaAbandono.prop('checked', false);
    checkTrabalhoInfantil.prop('checked', false);
    checkTrajetoriaRua.prop('checked', false);
    checkTraficoPessoas.prop('checked', false);
    checkDiscriminacaoOrientacaoSexual.prop('checked', false);
    checkViolenciaIdosoPCD.prop('checked', false);

    txtAcompanhamento.val('');

    var familiaMembroIndex = tabelaComposicaoFamiliar.prop('index');
    if (familiaMembroIndex !== null) {
        var familiaMembro = tabelaComposicaoFamiliar.prop('familiaMembroList')[familiaMembroIndex];
        comboGrauParentesco.val(familiaMembro.grauParentesco.id);
        comboGrauParentesco.selectpicker('refresh');
        txtNome.val(familiaMembro.nome);
        comboSexo.val(familiaMembro.sexo);
        comboSexo.selectpicker('refresh');
        txtApelido.val(familiaMembro.apelido);
        txtDataNascimento.val(familiaMembro.dataNascimento);
        txtNomeMae.val(familiaMembro.nomeMae);
        txtNIS.val(familiaMembro.nis);
        txtCPF.val(familiaMembro.cpf);
        txtRG.val(familiaMembro.rg);
        txtOrgaoExpedidorRG.val(familiaMembro.rgOrgaoExpedidor);
        txtUFEmissaoRG.val(familiaMembro.rgUFEmissao);
        txtDataEmissaoRG.val(familiaMembro.rgDataEmissao);

        checkDocumentoProvidenciavelList.each(function () {
            if (familiaMembro.familiaMembroDocumentoProvidenciavelList) {
                for (var indexFamiliaMembroDocumentoProvidenciavel = 0; indexFamiliaMembroDocumentoProvidenciavel < familiaMembro.familiaMembroDocumentoProvidenciavelList.length; indexFamiliaMembroDocumentoProvidenciavel++) {
                    var familiaMembroDocumentoProvidenciavel = familiaMembro.familiaMembroDocumentoProvidenciavelList[indexFamiliaMembroDocumentoProvidenciavel];
                    var documentoProvidenciavel = familiaMembroDocumentoProvidenciavel.documentoProvidenciavel;
                    if (parseInt($(this).val()) === documentoProvidenciavel.id) {
                        $(this).prop('checked', true);
                    }
                }
            }
        });

        comboEscolaridade.val(familiaMembro.escolaridade.id);
        comboEscolaridade.selectpicker('refresh');
        checkSabeLerEscrever.prop('checked', familiaMembro.sabeLerEscrever);
        checkFrequentaEscolaAtualmente.prop('checked', familiaMembro.frequentaEscolaAtualmente);

        checkPossuiCarteiraTrabalho.prop('checked', familiaMembro.possuiCarteiraTrabalho);
        comboCondicaoOcupacao.val(familiaMembro.condicaoOcupacao.id);
        comboCondicaoOcupacao.selectpicker('refresh');
        checkPossuiQualificacaoProfissional.prop('checked', familiaMembro.possuiQualificacaoProfissional);
        txtDescricaoQualificacaoProfissional.val(familiaMembro.descricaoQualificacaoProfissional);
        txtRendaMensal.val(familiaMembro.rendaMensal.toFixed(2));

        if (familiaMembro.deficiencia !== null && familiaMembro.deficiencia.id !== null) {
            comboDeficiencia.val(familiaMembro.deficiencia.id);
            comboDeficiencia.selectpicker('refresh');
        }
        checkNecessitaCuidadosConstantes.prop('checked', familiaMembro.necessitaCuidadosConstantes);
        txtDescricaoNecessidadeCuidadosConstantes.val(familiaMembro.descricaoNecessidadeCuidadosConstantes);
        checkUsuarioRemediosControlados.prop('checked', familiaMembro.usuarioRemediosControlados);
        checkUsuarioBebidasAlcoolicas.prop('checked', familiaMembro.usuarioBebidasAlcoolicas);
        checkUsuarioEntorpecentes.prop('checked', familiaMembro.usuarioEntorpecentes);
        checkGestante.prop('checked', familiaMembro.gestante);
        txtMesesGestacao.val(familiaMembro.mesesGestacao);
        checkIniciouPreNatal.prop('checked', familiaMembro.iniciouPrestacao);

        checkVitimaAmeacasDiscriminacao.prop('checked', familiaMembro.vitimaAmeacasDiscriminacao);
        checkParticipaGruposReligiosos.prop('checked', familiaMembro.participaGruposReligiosos);
        checkParticipaMovimentosSociais.prop('checked', familiaMembro.participaMovimentosSociais);
        checkAcessoLazer.prop('checked', familiaMembro.acessoLazer);
        checkCompanhiaAdulto.prop('checked', familiaMembro.companhiaAdulto);

        checkViolenciaFisica.prop('checked', familiaMembro.violenciaFisica);
        checkViolenciaPsicologica.prop('checked', familiaMembro.violenciaPsicologica);
        checkExploracaoSexual.prop('checked', familiaMembro.exploracaoSexual);
        checkAbusoViolenciaSexual.prop('checked', familiaMembro.abusoViolenciaSexual);
        checkNegligenciaAbandono.prop('checked', familiaMembro.negligenciaAbandono);
        checkTrabalhoInfantil.prop('checked', familiaMembro.trabalhoInfantil);
        checkTrajetoriaRua.prop('checked', familiaMembro.trajetoriaRua);
        checkTraficoPessoas.prop('checked', familiaMembro.traficoPessoas);
        checkDiscriminacaoOrientacaoSexual.prop('checked', familiaMembro.discriminacaoOrientacaoSexual);
        checkViolenciaIdosoPCD.prop('checked', familiaMembro.violenciaIdosoPCD);

        txtAcompanhamento.val(familiaMembro.acompanhamento);
    }

    if (tabelaComposicaoFamiliar.bootgrid('getTotalRowCount') === 0 || familiaMembroIndex === 0) {
        comboGrauParentesco.prop('selectedIndex', 1);
        comboGrauParentesco.prop('disabled', true);
        comboGrauParentesco.selectpicker('refresh');
    } else {
        comboGrauParentesco.prop('disabled', false);
        comboGrauParentesco.selectpicker('refresh');
    }

    txtRendaMensal.priceFormat(PriceFormatConfig);

});

$('#familiaMembroForm').submit(function (event) {

    var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');

    var familiaMembroModal = $('#familiaMembroModal');
    /*
     * Aba "Documentos Providenciáveis"
     * */
    var familiaMembroDocumentoProvidenciavelList = new Array();
    $('input[type=checkbox][name="documentoProvidenciavel[]"]:checked').each(function () {
        var familiaMembroDocumentoProvidenciavel = {
            documentoProvidenciavel: {
                id: $(this).val()
            }
        };
        familiaMembroDocumentoProvidenciavelList.push(familiaMembroDocumentoProvidenciavel);
    });
    var deficiencia = {
        id: $('#comboDeficiencia').val()
    };
    if (deficiencia.id === null || deficiencia.id === '') {
        deficiencia = null;
    }

    var escolaridade = {
        id: $('#comboEscolaridade').val()
    };
    if (escolaridade.id === null || escolaridade.id === '') {
        escolaridade = null;
    }

    var condicaoOcupacao = {
        id: $('#comboCondicaoOcupacao').val()
    };
    if (condicaoOcupacao.id === null || condicaoOcupacao.id === '') {
        condicaoOcupacao = null;
    }

    var familiaMembro = {
        grauParentesco: {
            id: $('#comboGrauParentesco').val(),
            codigo: $('#comboGrauParentesco option:selected').prop('label').split(' - ')[0],
            descricao: $('#comboGrauParentesco option:selected').prop('label').split(' - ')[1]
        },
        nome: $('#txtNome').val(),
        sexo: $('#comboSexo').val(),
        apelido: $('#txtApelido').val(),
        dataNascimento: $('#txtDataNascimento').val() === '' ? null : $('#txtDataNascimento').val(),
        nomeMae: $('#txtNomeMae').val(),
        nis: $('#txtNIS').val(),
        cpf: $('#txtCPF').val(),
        rg: $('#txtRG').val(),
        rgOrgaoExpedidor: $('#txtRGOrgaoExpedidor').val(),
        rgUFEmissao: $('#txtRGUFEmissao').val(),
        rgDataEmissao: $('#txtRGDataEmissao').val() === '' ? null : $('#txtRGDataEmissao').val(),
        
        familiaMembroDocumentoProvidenciavelList: familiaMembroDocumentoProvidenciavelList,
       
        escolaridade: escolaridade,
        sabeLerEscrever: $('#checkSabeLerEscrever').prop('checked'),
        frequentaEscolaAtualmente: $('#checkFrequentaEscolaAtualmente').prop('checked'),
        
        possuiCarteiraTrabalho: $('#checkPossuiCarteiraTrabalho').prop('checked'),
        condicaoOcupacao: condicaoOcupacao,
        possuiQualificacaoProfissional: $('#checkPossuiQualificacaoProfissional').prop('checked'),
        descricaoQualificacaoProfissional: $('#txtDescricaoQualificacaoProfissional').val(),
        rendaMensal: parseFloat($('#txtRendaMensal').val().replace('R$ ', '').replace('.', '').replace(',', '.')),
       
        deficiencia: deficiencia,
        necessitaCuidadosConstantes: $('#checkNecessitaCuidadosConstantes').prop('checked'),
        descricaoNecessidadeCuidadosConstantes: $('#txtDescricaoNecessidadeCuidadosConstantes').val(),
        usuarioRemediosControlados: $('#checkUsuarioRemediosControlados').prop('checked'),
        usuarioBebidasAlcoolicas: $('#checkUsuarioBebidasAlcoolicas').prop('checked'),
        usuarioEntorpecentes: $('#checkUsuarioEntorpecentes').prop('checked'),
        gestante: $('#checkGestante').prop('checked'),
        mesesGestacao: $('#txtMesesGestacao').val(),
        iniciouPreNatal: $('#checkIniciouPreNatal').prop('checked'),
        
        vitimaAmecasDiscriminacao: $('#checkVitimaAmeacasDiscriminacao').prop('checked'),
        participaGruposReligiosos: $('#checkParticipaGruposReligiosos').prop('checked'),
        participaMovimentosSociais: $('#checkParticipaMovimentosSociais').prop('checked'),
        acessoLazer: $('#checkAcessoLazer').prop('checked'),
        companhiaAdulto: $('#checkCompanhiaAdulto').prop('checked'),
       
        violenciaFisica : $('#checkViolenciaFisica').prop('checked'),
        violenciaPsicologica : $('#checkViolenciaPsicologica').prop('checked'),
        violenciaExploracaoSexual : $('#checkExploracaoSexual').prop('checked'),
        abusoViolenciaSexual : $('#checkAbusoViolenciaSexual').prop('checked'),
        negligenciaAbandono : $('#checkNegligenciaAbandono').prop('checked'),
        trabalhoInfantil : $('#checkNegligenciaAbandono').prop('checked'),
        trajetoriaRua : $('#checkTrajetoriaRua').prop('checked'),
        traficoPessoas : $('#checkTraficoPessoas').prop('checked'),
        discriminacaoOrientacaoSexual : $('#checkDiscriminacaoOrientacaoSexual').prop('checked'),
        violenciaIdosoPCD : $('#checkViolenciaIdosoPCD').prop('checked'),
        
        acompanhamento: $('#txtAcompanhamento').val()
    };

    var familiaMembroIndex = tabelaComposicaoFamiliar.prop('index');

    var familiaMembroList = tabelaComposicaoFamiliar.prop('familiaMembroList');
    if (familiaMembroIndex !== null) {
        familiaMembroList[familiaMembroIndex] = familiaMembro;
    } else {
        familiaMembroList.push(familiaMembro);
    }

    tabelaComposicaoFamiliar.bootgrid('clear');
    tabelaComposicaoFamiliar.bootgrid('append', familiaMembroList);

    familiaMembroModal.modal('toggle');

    return false;
});
