$(document).ready(function () {

    var url = document.URL.replace(document.origin, '');

    var anchor = $('a[href="' + url + '"]');
    var liPai = anchor.parent();
    var liAvo = liPai.parents('li');

    liAvo.addClass('active');
    liAvo.addClass('toggled');

    liPai.addClass('active');
    liPai.addClass('toggled');

});