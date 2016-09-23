$('#formLogin').submit(function (event) {

    var txtEmail = document.getElementById("txtEmail");
    var txtSenha = document.getElementById("txtSenha");

    var lblSeguranca = document.getElementById("lblSeguranca");
    var txtNumeroSeguranca = document.getElementById("txtNumeroSeguranca");
    var txtCodigoSeguranca = document.getElementById("txtCodigoSeguranca");

    var data = {
        email: txtEmail.value,
        senha: txtSenha.value
    };

    $.ajax({
        method: 'POST',
        url: '/home',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    var numeroSeguranca = data.numeroSeguranca;
                    lblSeguranca.innerHTML = "Informe o código " + numeroSeguranca + " de seu cartão de segurança."
                    txtNumeroSeguranca.value = numeroSeguranca;
                    txtCodigoSeguranca.value = null;
                    $('#dlgSeguranca').modal('show');
                } else {
                    document.location.assign('/sias/home/loginError');
                }
            }
        }
    });

    return false;
});

$('#formSeguranca').submit(function (event) {

    var txtEmail = document.getElementById("txtEmail");
    var txtSenha = document.getElementById("txtSenha");
    var txtNumeroSeguranca = document.getElementById("txtNumeroSeguranca");
    var txtCodigoSeguranca = document.getElementById("txtCodigoSeguranca");

    var data = {
        email: txtEmail.value,
        senha: txtSenha.value,
        numeroSeguranca: txtNumeroSeguranca.value,
        codigoSeguranca: txtCodigoSeguranca.value
    };

    $.ajax({
        method: 'POST',
        url: '/home/verificaSeguranca',
        data: data,
        success: function (data) {
            if (data != null) {
                var success = data.success;
                if (success) {
                    document.location.assign('/home');
                } else {
                    document.location.assign('/home/loginError');
                }
            }
        }
    });
    
    return false;
});
