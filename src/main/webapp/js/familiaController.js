$("#familiaFormPanEndereco").ready(function (){
    
    var comboTipoResidencia = $("#comboTipoResidencia");
    var tipoResidencia = $("#tipoResidencia").val();
    $.each(comboTipoResidencia.children("option"), function (){
        if($(this).text() == tipoResidencia){
            comboTipoResidencia.val($(this).val());
        }
    });
    comboTipoResidencia.selectpicker('refresh');
    
    var comboMaterialParedes = $("#comboMaterialParedes");
    var materialPeredes = $("#materialParedes").val();
    $.each(comboMaterialParedes.children("option"), function (){
        if($(this).text() == materialPeredes){
            comboMaterialParedes.val($(this).val());
        }
    });
    comboMaterialParedes.selectpicker("refresh");
    
    var comboAcessoEnergia = $("#comboAcessoEnergia");
    var acessoEnergia = $("#acessoEnergiaEletrica").val();
    $.each(comboAcessoEnergia.children("option"), function (){
        if($(this).text() == acessoEnergia){
            comboAcessoEnergia.val($(this).val());
        }
    });
    comboAcessoEnergia.selectpicker("refresh");
    
    var comboAguaCanalizada = $("#comboAguaCanalizada");
    var aguaCanalizada = $("#aguaCanalizada").val();
    $.each(comboAguaCanalizada.children("option"), function (){
        if($(this).text() == aguaCanalizada){
            comboAguaCanalizada.val($(this).val());
        }
    });
    comboAguaCanalizada.selectpicker("refresh");
    
    var comboFormaAbastecimento = $("#comboFormaAbastecimentoAgua");
    var formaAbastecimento = $("#formaAbastecimentoAgua").val();
    $.each(comboFormaAbastecimento.children("option"), function (){
        if($(this).text() == formaAbastecimento){
            comboFormaAbastecimento.val($(this).val());
        }
    });
    comboFormaAbastecimento.selectpicker("refresh");
    
    var comboEscoamentoSanitario = $("#comboEscoamentoSanitario");
    var escomentoSanitario = $("#escoamentoSanitario").val();
    $.each(comboEscoamentoSanitario.children("option"), function (){
        if($(this).text() == escomentoSanitario){
            comboEscoamentoSanitario.val($(this).val());
        }
    });
    comboEscoamentoSanitario.selectpicker("refresh");
    
    var comboColetaLixo = $("#comboColetaLixo");
    var coletaLixo = $("#coletaLixo").val();
    $.each(comboColetaLixo.children("option"), function (){
        if($(this).text() == coletaLixo){
            comboColetaLixo.val($(this).val());
        }
    });
    comboColetaLixo.selectpicker("refresh");
    
    var comboAcessibilidade = $("#comboAcessibilidade");
    var acessibilidade = $("#acessibilidade").val();
    $.each(comboAcessibilidade.children("option"), function(){
        if($(this).text() == acessibilidade){
            comboAcessibilidade.val($(this).val());
        }
    });
    comboAcessibilidade.selectpicker("refresh");
    
    var combolocalizacaoAreaRisco = $("#comboLocalizacaoRisco");
    var localizacaoRisco = $("#localizacaoRisco").val();
    $.each(combolocalizacaoAreaRisco.children("option"), function (){
        if($(this).text() == localizacaoRisco){
            combolocalizacaoAreaRisco.val($(this).val());
        }
    });
    combolocalizacaoAreaRisco.selectpicker("refresh");
    
    var comboAcessoGeografico = $("#comboAcessoGeografico");
    var acessoGeografico = $("#acessoGeografico").val();
    $.each(comboAcessoGeografico.children("option"), function (){
        if($(this).text() == acessoGeografico){
            comboAcessoGeografico.val($(this).val());
        }
    });
    comboAcessoGeografico.selectpicker("refresh");
    
    var comboAreaViolencia = $("#comboAreaViolencia");
    var areaViolencia = $("#areaViolencia").val();
    $.each(comboAreaViolencia.children("option"), function (){
        if($(this).text() == areaViolencia){
            comboAreaViolencia.val($(this).val());
        }
    });
    comboAreaViolencia.selectpicker("refresh");
});

$('#familiaForm').submit(function (event) {

    var txtId = $('#txtId');
    var comboFormaIngresso = $('#comboFormaIngresso');
    var txtDetalheFormaIngressoEncaminhamento = $('#txtDetalheFormaIngressoEncaminhamento');
    var txtObservacaoFormaIngresso = $('#txtObservacaoFormaIngresso');
    var tabelaComposicaoFamiliar = $('#tabelaComposicaoFamiliar');
    var familiaMembroList = tabelaComposicaoFamiliar.prop('familiaMembroList');
    var radioLocalizacao = $("input[type=radio][name='localizacaoEndereco']:checked").val();
    var checkEnderecoAbrigo = $('#checkEnderecoAbrigo');
    var comboCEPEndereco = $('#comboCEPEndereco');
    var txtLogradouroEndereco = $('#txtLogradouroEndereco');
    var txtNumeroEndereco = $('#txtNumeroEndereco');
    var txtBairroEndereco = $('#txtBairroEndereco');
    var txtPontoReferenciaEndereco = $('#txtPontoReferenciaEndereco');
    var comboTipoResidencia = $("#comboTipoResidencia");
    var comboMaterialParedes = $("#comboMaterialParedes");
    var comboAcessoEnergia = $("#comboAcessoEnergia");
    var comboAguaCanalizada = $("#comboAguaCanalizada");
    var comboFormaAbastecimentoAgua = $("#comboFormaAbastecimentoAgua");
    var comboEscoamentoSanitario = $("#comboEscoamentoSanitario");
    var comboColetaLixo = $("#comboColetaLixo");
    var txtNumeroComodos = $("#txtNumeroComodos");
    var txtNumeroDormitorios = $("#txtNumeroDormitorios");
    var comboAcessibilidade = $("#comboAcessibilidade");
    var comboLocalizacaoRisco = $("#comboLocalizacaoRisco");
    var comboAcessoGeografico = $("#comboAcessoGeografico");
    var comboAreaViolencia = $("#comboAreaViolencia");
    var txtObservacoesCondicoesHabitacionais = $("#txtObservacoesCondicoesHabitacionais");
        
    var id = txtId.val();
    if (id === '') {
        id = null;
    }

    var familia = {
        id: id,
        formaIngresso: {
            id: comboFormaIngresso.val()
        },
        detalheFormaIngressoEncaminhamento: txtDetalheFormaIngressoEncaminhamento.val(),
        observacaoFormaIngresso: txtObservacaoFormaIngresso.val(),
        familiaMembroList: familiaMembroList,
        localizacaoEndereco: radioLocalizacao,
        enderecoAbrigo: checkEnderecoAbrigo.prop('checked'),
        cepEndereco: {
            id: comboCEPEndereco.val()
        },
        logradouroEndereco: txtLogradouroEndereco.val(),
        numeroEndereco: txtNumeroEndereco.val(),
        bairroEndereco: txtBairroEndereco.val(),
        pontoReferenciaEndereco: txtPontoReferenciaEndereco.val(),
        tipoResidencia: comboTipoResidencia.children("option:selected").text(),
        materialParedesExternas: comboMaterialParedes.children("option:selected").text(),
        acessoEnergiaEletrica: comboAcessoEnergia.children("option:selected").text(),
        aguaCanalizada: comboAguaCanalizada.children("option:selected").text(),
        formaAbastecimentoAgua: comboFormaAbastecimentoAgua.children("option:selected").text(),
        escoamentoSanitario: comboEscoamentoSanitario.children("option:selected").text(),
        coletaLixo: comboColetaLixo.children("option:selected").text(),
        numeroComodos: txtNumeroComodos.val(),
        numeroDormitorios: txtNumeroDormitorios.val(),
        acessibilidade: comboAcessibilidade.children("option:selected").text(),
        localizacaoAreaRisco: comboLocalizacaoRisco.children("option:selected").text(),
        dificilAcessoGeografico: comboAcessoGeografico.children("option:selected").text(),
        areaConflitoViolencia: comboAreaViolencia.children("option:selected").text(),
        observacoesCondicoesHabitacionais: txtObservacoesCondicoesHabitacionais.val()
    };

    var data = {
        json: JSON.stringify(familia)
    };

    $.ajax({
        method: 'POST',
        url: '/controleFamiliar/familia/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('/controleFamiliar/familia');
                    };
                    Msg.notify(data.msg, 'success', 2000, null, voltarListagem);
                } else {
                    Msg.notify(data.msg, 'warning');
                }
            }
        }
    });

    return false;
});


