$(document).ready(function () {
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    var cId = $('#calendar'); //Change the name if you want. I'm also using thsi add button for more actions

    //Generate the Calendar
    cId.fullCalendar({
        header: {
            right: '',
            center: 'prev, title, next',
            left: ''
        },
        theme: true, //Do not remove this as it ruin the design
        selectable: true,
        selectHelper: true,
        eventRender: function (event, element) {
            element.find('.fc-content').append("<button id='delete-event' class='fc-time'>X</button>");
            element.find("#delete-event").click(function () {
                $.ajax({
                    method: 'POST',
                    url: '/controleFamiliar/familiaVisita/delete',
                    data: {
                        id: event._id
                    },
                    success: function () {
                        $('#calendar').fullCalendar('refetchEvents');
                    }
                });
            });
        },
        events: function (start, end, timezone, callback) {
            $.ajax({
                method: 'POST',
                url: '/controleFamiliar/familiaVisita/find',
                data: {
                    inicio: moment(start).format('DD/MM/YYYY HH:mm'),
                    fim: moment(start).format('DD/MM/YYYY HH:mm')
                },
                success: function (data) {
                    if (data != null) {
                        if (data.success) {
                            var events = [];
                            var familiaVisitaList = data.familiaVisitaList;
                            $.each(familiaVisitaList, function (index, familiaVisita) {
                                events.push({
                                    id: familiaVisita.id,
                                    title: familiaVisita.familia.nomePessoaReferencia,
                                    allDay: false,
                                    start: new Date(familiaVisita.inicio),
                                    end: new Date(familiaVisita.fim),
                                    className: familiaVisita.cor
                                });
                            });
                            callback(events);

                        }
                    }
                }
            });
        },
        //On Day Select
        select: function (start, end, allDay) {
            $('#addNew-event').modal('show');
            $('#dtpInicio').val(moment(start).format('DD/MM/YYYY HH:mm'));
            $('#dtpFim').val(moment(end).format('DD/MM/YYYY HH:mm'));
        }
    });
    //Create and ddd Action button with dropdown in Calendar header. 
    var actionMenu = '<ul class="actions actions-alt" id="fc-actions">' +
            '<li class="dropdown">' +
            '<a href="" data-toggle="dropdown"><i class="zmdi zmdi-more-vert"></i></a>' +
            '<ul class="dropdown-menu dropdown-menu-right">' +
            '<li class="active">' +
            '<a data-view="month" href="">Visão mensal</a>' +
            '</li>' +
            '<li>' +
            '<a data-view="basicWeek" href="">Visão semanal</a>' +
            '</li>' +
            '<li>' +
            '<a data-view="agendaWeek" href="">Visão semanal(em agenda)</a>' +
            '</li>' +
            '<li>' +
            '<a data-view="basicDay" href="">Visão diária</a>' +
            '</li>' +
            '<li>' +
            '<a data-view="agendaDay" href="">Visão diária(em agenda)</a>' +
            '</li>' +
            '</ul>' +
            '</div>' +
            '</li>';
    cId.find('.fc-toolbar').append(actionMenu);
    //Event Tag Selector
    (function () {
        $('body').on('click', '.event-tag > span', function () {
            $('.event-tag > span').removeClass('selected');
            $(this).addClass('selected');
        });
    })();
    //Add new Event
    $('body').on('click', '#addEvent', function () {

        var familia = $('#comboFamilia').val();
        var usuario = $('#comboUsuario').val();
        var dataHoraInicio = $('#dtpInicio').val();
        var dataHoraFim = $('#dtpFim').val();
        var cor = $('.event-tag > span.selected').attr('data-tag');
        if (familia == null || familia == '') {
            $('#comboFamilia').closest('.form-group').addClass('has-error');
            return;
        }
        if (usuario == null || usuario == '') {
            $('#comboUsuario').closest('.form-group').addClass('has-error');
            return;
        }
        if (dataHoraInicio == null || dataHoraInicio == '') {
            $('#dtpInicio').closest('.form-group').addClass('has-error');
            return;
        }
        if (dataHoraFim == null || dataHoraFim == '') {
            $('#dtpFim').closest('.form-group').addClass('has-error');
            return;
        }

        var familiaVisita = {
            familia: {
                id: familia
            },
            usuario: {
                id: usuario
            },
            inicio: dataHoraInicio,
            fim: dataHoraFim,
            cor: cor
        };
        var data = {
            json: JSON.stringify(familiaVisita)
        };
        $.ajax({
            method: 'POST',
            url: '/controleFamiliar/familiaVisita/save',
            data: data,
            success: function (data) {
                if (data != null) {
                    var success = data.success;
                    var msg = data.msg;
                    if (msg != null) {
                        if (success) {
                            $('#msgSuccess').text(msg);
                            $('#dlgSuccess').modal('show');
                            $('#calendar').fullCalendar('refetchEvents');
                            $('#addNew-event form')[0].reset();
                            $('#addNew-event').modal('hide');
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
    //Calendar views
    $('body').on('click', '#fc-actions [data-view]', function (e) {
        e.preventDefault();
        var dataView = $(this).attr('data-view');
        $('#fc-actions li').removeClass('active');
        $(this).parent().addClass('active');
        cId.fullCalendar('changeView', dataView);
    });
});        
