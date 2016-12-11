$('#header').ready(function () {
    verificaNotificacao();
});
function verificaNotificacao() {

    $.ajax({
        method: 'POST',
        url: '/notificacao/verificaNotificacao',
        success: function (data) {
            if (data !== null) {
                if (data.length > 0) {
                    $('.him-counts').empty();
                    $('.him-counts').append(data.length);
                    $('.lg-body').empty();
                    jQuery.each(data, function () {
                        var notification = this;
                        var html = "<a class='list-group-item media' href='" + notification.href + "'>";
                        if (notification.icone !== null){
                            html += "<div class='pull-left'>";
                            html += notification.icone;
                            html += "</div>";
                        }
                        html += "<div class='media-body'>";
                        html += "<div class='lgi-heading'>" + notification.titulo + "</div>";
                        html += "<small class='lgi-text'>" + notification.conteudo + "</small>";
                        html += "</div>";
                        html += "</a>";
                        $('.lg-body').append(html);
                    });
                } else {
                    $('.him-counts').empty();
                    $('.lg-body').empty();
                }
            }
        }
    });

    setTimeout(function () {
        verificaNotificacao();
    }, 15000);

}