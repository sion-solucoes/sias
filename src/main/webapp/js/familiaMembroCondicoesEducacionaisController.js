$('#comboEscolaridade').ready(function (event) {

    var txtEscolaridade = document.getElementById('txtEscolaridade');
    var escolaridadeId = txtEscolaridade.value;
    var comboEscolaridade = $('#comboEscolaridade');
    comboEscolaridade.selectpicker({
        size: 4
    });

    $.ajax({
        method: 'POST',
        url: '/controleFamiliar/escolaridade/readAll',
        success: function (data) {
            if (data !== null) {
                for (var i = 0; i < data.length; i++) {
                    var escolaridade = data[i];
                    var option = document.createElement("option");
                    option.selected = escolaridadeId === escolaridade.id;
                    option.value = escolaridade.id;
                    option.text = escolaridade.codigo + ' - ' + escolaridade.descricao;
                    comboEscolaridade.append(option);
                }
                comboEscolaridade.selectpicker('refresh');
            }
        }
    });
});
