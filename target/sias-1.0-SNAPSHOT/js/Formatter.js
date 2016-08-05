function formatInteiro(inteiro){
    if ( !mascaraInteiro(inteiro)){
        event.returnValue = false;
    }
    return inteiro;
}

function formatCPF(cpf) {
    if (!mascaraInteiro(cpf)) {
        event.returnValue = false;
    }
    return formataCampo(cpf, '000.000.000-00', event);
}

function formatCEP(cep) {
    if (!mascaraInteiro(cep)) {
        event.returnValue = false;
    }
    return formataCampo(cep, '00.000-000', event);
}

function mascaraInteiro() {
    if (event.keyCode < 48 || event.keyCode > 57) {
        event.returnValue = false;
        return false;
    }
    return true;
}

function formataCampo(campo, mascara, evento) {

    var boleanoMascara;

    var digitado = evento.keyCode;
    exp = /\-|\.|\/|\(|\)| /g
    campoSoNumeros = campo.value.toString().replace(exp, "");

    var posicaoCampo = 0;
    var novoValor = "";
    var tamanhoMascara = campoSoNumeros.length;

    if (digitado != 8) {
        for (i = 0; i <= tamanhoMascara; i++) {
            boleanoMascara = ((mascara.charAt(i) == "-") || (mascara.charAt(i) == ".")
                    || (mascara.charAt(i) == "/"))
            boleanoMascara = boleanoMascara || ((mascara.charAt(i) == "(")
                    || (mascara.charAt(i) == ")") || (mascara.charAt(i) == " "))
            if (boleanoMascara) {
                novoValor += mascara.charAt(i);
                tamanhoMascara++;
            } else {
                novoValor += campoSoNumeros.charAt(posicaoCampo);
                posicaoCampo++;
            }
        }
        campo.value = novoValor;
        return true;
    } else {
        return true;
    }
}