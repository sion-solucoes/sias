$(document).ready(function (event) {

    var txtId = document.getElementById("txtId");
    var usuarioId = txtId.value;

    var tabelaCodigos1 = document.getElementById("tabelaCodigosSeguranca1-5");
    var tabelaCodigos2 = document.getElementById("tabelaCodigosSeguranca6-10");

    var data = {
        usuarioId: usuarioId
    };

    if (usuarioId != null && usuarioId != "") {
        $.ajax({
            method: 'POST',
            data: data,
            url: '/sias/controleAmbiente/usuarioSeguranca/readByUsuarioId',
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
    data.append("file", fileFoto.files[0]);
    $.ajax({
        method: 'POST',
        url: '/sias/controleAmbiente/usuario/foto',
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

    var tabelaCodigos1 = document.getElementById("tabelaCodigosSeguranca1-5");
    var tabelaCodigos2 = document.getElementById("tabelaCodigosSeguranca6-10");

    $.ajax({
        method: 'POST',
        url: '/sias/controleAmbiente/usuarioSeguranca/gerarCodigos',
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

    var txtEmail = document.getElementById("txtEmail");

    var usuarioSegurancaList = new Array();
    var tabelaCodigosSeguranca1 = document.getElementById("tabelaCodigosSeguranca1-5");
    for (var tabelaUsuarioSeguranca = 1; tabelaUsuarioSeguranca < tabelaCodigosSeguranca1.rows.length; tabelaUsuarioSeguranca++) {
        var row = tabelaCodigosSeguranca1.rows[tabelaUsuarioSeguranca];
        var data = row.cells[1];
        var codigo = data.innerText;
        if (codigo != null && codigo != "") {
            var usuarioSeguranca = {
                codigo: codigo
            };
            usuarioSegurancaList.push(usuarioSeguranca);
        }
    }
    var tabelaCodigosSeguranca2 = document.getElementById("tabelaCodigosSeguranca6-10");
    for (var tabelaUsuarioSeguranca = 1; tabelaUsuarioSeguranca < tabelaCodigosSeguranca2.rows.length; tabelaUsuarioSeguranca++) {
        var row = tabelaCodigosSeguranca2.rows[tabelaUsuarioSeguranca];
        var data = row.cells[1];
        var codigo = data.innerText;
        if (codigo != null && codigo != "") {
            var usuarioSeguranca = {
                codigo: codigo
            };
            usuarioSegurancaList.push(usuarioSeguranca);
        }
    }

    var id = null;
    if (txtId.value != null && txtId.value != "") {
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
        url: '/sias/controleAmbiente/usuario/imprimirCodigos',
        data: data,
        success: function (data) {
            if (data != null) {
                window.open(data, '_blank');
            }
        }
    });
});

$('#btnConfirmar').click(function (event) {

    var txtId = document.getElementById("txtId");
    var radioTipoMaster = document.getElementById("radioTipoMaster");
    var radioTipoTecnico = document.getElementById("radioTipoTecnico");
    var radioTipoAdministrativo = document.getElementById("radioTipoAdministrativo");
    var txtEmail = document.getElementById("txtEmail");
    var txtSenha = document.getElementById("txtSenha");
    var txtConfirmacaoSenha = document.getElementById("txtConfirmacaoSenha");
    var txtNome = document.getElementById("txtNome");
    var txtSobrenome = document.getElementById("txtSobrenome");
    var txtFoto = document.getElementById("txtFoto");

    var senha = txtSenha.value;
    var confirmacaoSenha = txtConfirmacaoSenha.value;

    if (senha != confirmacaoSenha) {
        $('#msgFailure').text('As senhas não coincidem!');
        $('#dlgFailure').modal('show');
        setTimeout(function () {
            $('#dlgFailure').modal('hide');
        }, 3000);
        return;
    }
   
    var usuarioSegurancaList = new Array();
    var tabelaCodigosSeguranca1 = document.getElementById("tabelaCodigosSeguranca1-5");
    for (var tabelaUsuarioSeguranca = 1; tabelaUsuarioSeguranca < tabelaCodigosSeguranca1.rows.length; tabelaUsuarioSeguranca++) {
        var row = tabelaCodigosSeguranca1.rows[tabelaUsuarioSeguranca];
        var data = row.cells[1];
        var codigo = data.innerText;
        if (codigo != null && codigo != "") {
            var usuarioSeguranca = {
                codigo: codigo
            };
            usuarioSegurancaList.push(usuarioSeguranca);
        }
    }
    var tabelaCodigosSeguranca2 = document.getElementById("tabelaCodigosSeguranca6-10");
    for (var tabelaUsuarioSeguranca = 1; tabelaUsuarioSeguranca < tabelaCodigosSeguranca2.rows.length; tabelaUsuarioSeguranca++) {
        var row = tabelaCodigosSeguranca2.rows[tabelaUsuarioSeguranca];
        var data = row.cells[1];
        var codigo = data.innerText;
        if (codigo != null && codigo != "") {
            var usuarioSeguranca = {
                codigo: codigo
            };
            usuarioSegurancaList.push(usuarioSeguranca);
        }
    }

    var tipo = null;
    if (radioTipoMaster.checked) {
        tipo = 1;
    } else if (radioTipoTecnico.checked) {
        tipo = 2;
    } else if (radioTipoAdministrativo.checked) {
        tipo = 3;
    }

    var id = null;
    if (txtId.value != null && txtId.value != "") {
        id = txtId.value;
    }

    var usuario = {
        id: id,
        tipo: tipo,
        email: txtEmail.value,
        senha: txtSenha.value,
        nome: txtNome.value,
        sobrenome: txtSobrenome.value,
        usuarioUnidadeAtendimentoList: usuarioUnidadeAtendimentoList,
        usuarioSegurancaList: usuarioSegurancaList,
        foto: txtFoto.value
    };

    var data = {
        json: JSON.stringify(usuario)
    };

    $.ajax({
        method: 'POST',
        url: '/sias/controleAmbiente/usuario/save',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                var msg = data.msg;
                if (msg != null) {
                    if (success) {
                        $('#msgSuccess').text(msg);
                        $('#dlgSuccess').modal('show');
                        setTimeout(function () {
                            document.location.assign('/sias/controleAmbiente/usuario');
                        }, 3000);
                    } else {
                        $('#msgFailure').text(msg);
                        $('#dlgFailure').modal('show');
                        setTimeout(function () {
                            $('#dlgFailure').modal('hide');
                        }, 3000);
                    }
                }
            }
        }
    });

});