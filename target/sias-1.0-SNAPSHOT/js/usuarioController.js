$(document).ready(function (event) {

    var txtId = document.getElementById('txtId');
    var usuarioId = txtId.value;

    var tabelaCodigos1 = document.getElementById('tabelaCodigosSeguranca1-5');
    var tabelaCodigos2 = document.getElementById('tabelaCodigosSeguranca6-10');

    var data = {
        usuarioId: usuarioId
    };

    if (usuarioId != null && usuarioId != '') {
        $.ajax({
            method: 'POST',
            data: data,
            url: '/controleAmbiente/usuarioSeguranca/readByUsuarioId',
            success: function (usuarioSegurancaList) {
                if (usuarioSegurancaList != null) {
                    for (var indexUsuarioSeguranca = 0; indexUsuarioSeguranca < usuarioSegurancaList.length; indexUsuarioSeguranca++) {
                        if (indexUsuarioSeguranca < 5) {
                            tabelaCodigos1.rows[indexUsuarioSeguranca + 1].cells[1].innerText = usuarioSegurancaList[indexUsuarioSeguranca].codigo;
                        } else {
                            tabelaCodigos2.rows[indexUsuarioSeguranca - 4].cells[1].innerText = usuarioSegurancaList[indexUsuarioSeguranca].codigo;
                        }
                    }
                }
            }
        });
    }
});

$('#fileFoto').change(function (event) {

    var fileFoto = event.currentTarget;

    var txtFoto = document.getElementById('txtFoto');
    var imgFoto = document.getElementById('imgFoto');

    var data = new FormData();
    data.append('file', fileFoto.files[0]);
    $.ajax({
        method: 'POST',
        url: '/controleAmbiente/usuario/foto',
        data: data,
        processData: false,
        contentType: false,
        success: function (data) {
            txtFoto.setAttribute('value', data);
            imgFoto.setAttribute('src', data);
        }
    });

});

$('#btnGerarCodigos').click(function (event) {

    var tabelaCodigos1 = document.getElementById('tabelaCodigosSeguranca1-5');
    var tabelaCodigos2 = document.getElementById('tabelaCodigosSeguranca6-10');

    $.ajax({
        method: 'POST',
        url: '/controleAmbiente/usuarioSeguranca/gerarCodigos',
        success: function (data) {
            if (data != null) {
                for (var indexCodigos = 0; indexCodigos < data.length; indexCodigos++) {
                    if (indexCodigos < 5) {
                        tabelaCodigos1.rows[indexCodigos + 1].cells[1].innerText = data[indexCodigos];
                    } else {
                        tabelaCodigos2.rows[indexCodigos - 4].cells[1].innerText = data[indexCodigos];
                    }
                }
            }
        }
    });
});

$('#btnImprimirCodigos').click(function (event) {

    var txtEmail = document.getElementById('txtEmail');

    var usuarioSegurancaList = new Array();
    var tabelaCodigosSeguranca1 = document.getElementById('tabelaCodigosSeguranca1-5');
    for (var tabelaUsuarioSeguranca = 1; tabelaUsuarioSeguranca < tabelaCodigosSeguranca1.rows.length; tabelaUsuarioSeguranca++) {
        var row = tabelaCodigosSeguranca1.rows[tabelaUsuarioSeguranca];
        var data = row.cells[1];
        var codigo = data.innerText;
        if (codigo != null && codigo != '') {
            var usuarioSeguranca = {
                codigo: codigo
            };
            usuarioSegurancaList.push(usuarioSeguranca);
        }
    }
    var tabelaCodigosSeguranca2 = document.getElementById('tabelaCodigosSeguranca6-10');
    for (var tabelaUsuarioSeguranca = 1; tabelaUsuarioSeguranca < tabelaCodigosSeguranca2.rows.length; tabelaUsuarioSeguranca++) {
        var row = tabelaCodigosSeguranca2.rows[tabelaUsuarioSeguranca];
        var data = row.cells[1];
        var codigo = data.innerText;
        if (codigo != null && codigo != '') {
            var usuarioSeguranca = {
                codigo: codigo
            };
            usuarioSegurancaList.push(usuarioSeguranca);
        }
    }

    var id = null;
    if (txtId.value != null && txtId.value != '') {
        id = txtId.value;
    }

    var usuario = {
        id: id,
        email: txtEmail.value,
        usuarioSegurancaList: usuarioSegurancaList
    };

    var data = {
        json: JSON.stringify(usuario)
    };

    $.ajax({
        method: 'POST',
        url: '/controleAmbiente/usuario/imprimirCodigos',
        data: data,
        success: function (data, response) {
            if (data != null) {
                window.open('data:application/pdf,' + escape(data), '_blank');
            }
        }
    });
});

$('#btnConfirmar').click(function (event) {

    var txtId = $('#txtId');
    var radioTipo = $(':radio[name="tipo"]:checked');
    var txtEmail = $('#txtEmail');
    var txtSenha = $('#txtSenha');
    var txtConfirmacaoSenha = $('#txtConfirmacaoSenha');
    var txtNome = $('#txtNome');
    var txtSobrenome = $('#txtSobrenome');
    var txtFoto = $('#txtFoto');
    var unidadeAtendimento = $('#unidadeAtendimento');

    var usuarioSegurancaList = new Array();
    var tabelaCodigosSeguranca1 = $('#tabelaCodigosSeguranca1-5 tr');
    for (var tabelaUsuarioSeguranca = 1; tabelaUsuarioSeguranca < tabelaCodigosSeguranca1.length; tabelaUsuarioSeguranca++) {
        var row = tabelaCodigosSeguranca1[tabelaUsuarioSeguranca];
        var data = row.cells[1];
        var codigo = data.innerText;
        if (codigo != null && codigo != '') {
            var usuarioSeguranca = {
                codigo: codigo
            };
            usuarioSegurancaList.push(usuarioSeguranca);
        }
    }
    var tabelaCodigosSeguranca2 = $('#tabelaCodigosSeguranca6-10 tr');
    for (var tabelaUsuarioSeguranca = 1; tabelaUsuarioSeguranca < tabelaCodigosSeguranca2.length; tabelaUsuarioSeguranca++) {
        var row = tabelaCodigosSeguranca2[tabelaUsuarioSeguranca];
        var data = row.cells[1];
        var codigo = data.innerText;
        if (codigo != null && codigo != '') {
            var usuarioSeguranca = {
                codigo: codigo
            };
            usuarioSegurancaList.push(usuarioSeguranca);
        }
    }

    var id = null;
    if (txtId.value != null && txtId.value != '') {
        id = txtId.value;
    }

    var usuario = {
        id: id,
        tipo: radioTipo.val(),
        email: txtEmail.val(),
        senha: txtSenha.val(),
        nome: txtNome.val(),
        sobrenome: txtSobrenome.val(),
        unidadeAtendimento: {
            id: unidadeAtendimento.val()
        },
        usuarioSegurancaList: usuarioSegurancaList,
        foto: txtFoto.val()
    };

    var data = {
        json: JSON.stringify(usuario)
    };

    $.ajax({
        method: 'POST',
        url: '/controleAmbiente/usuario/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    var voltarListagem = function () {
                        document.location.assign('/controleAmbiente/usuario');
                    };
                    Msg.notify(data.msg, 'success', 2000, null, voltarListagem);
                } else {
                    Msg.notify(data.msg, 'warning');
                }
            }
        },
        failure: function (data) {
            Msg.notify('Erro inesperado. Contate o adminstrador do Sistema', 'warning');
        }
    });

});
