$('#comboFormaIngresso').ready(function (event) {

    var txtFormaIngresso = $('#txtFormaIngresso');
    var formaIngressoId = txtFormaIngresso.val();
    var combo = $('#comboFormaIngresso');
    combo.selectpicker({
        size: 4
    });

    $.ajax({
        method: 'POST',
        url: '/sias/controleFamiliar/formaIngresso/readAll',
        success: function (data) {
            var formaIngressoList = data;
            if (formaIngressoList != null) {
                for (var indexFormaIngresso = 0; indexFormaIngresso < formaIngressoList.length; indexFormaIngresso++) {
                    var formaIngresso = formaIngressoList[indexFormaIngresso];
                    var option = document.createElement("option");
                    option.value = formaIngresso.id;
                    option.innerText = formaIngresso.descricao;
                    if (formaIngressoId == formaIngresso.id) {
                        option.selected = true;
                    }
                    combo.append(option);
                }
                combo.selectpicker('refresh');
            }
        }
    });
});

$('#comboFormaIngresso').change(function (event) {

    var comboFormaIngresso = $('#comboFormaIngresso');
    var formaIngresso = comboFormaIngresso.find(':selected').text();

    var txtDetalheFormaIngressoEncaminhamento = $('#txtDetalheFormaIngressoEncaminhamento');
    if (formaIngresso.indexOf("encaminhamento") > 0) {
        txtDetalheFormaIngressoEncaminhamento.prop('disabled', false);
    } else {
        txtDetalheFormaIngressoEncaminhamento.prop('disabled', true);
    }

});