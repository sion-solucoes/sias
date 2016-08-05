FullCalendarConfig = {
    timeFormat: 'H(:mm)',
    header: {
        left: 'prev, next, today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
    },
    dayClick: function (date, event, view) {
        $('#dia').val(date.format());
        modal({
            buttons: {
                add: {
                    id: 'add-event',
                    css: 'btn-success',
                    label: 'Adicionar'
                }
            },
            title: 'Adicionar Evento (' + date.format() + ')'
        });
    },
    eventMouseover: function (calEvent, jsEvent, view) {
        var tooltip = '<div class="event-tooltip">' + calEvent.description + '</div>';
        $("body").append(tooltip);
        $(this).mouseover(function (e) {
            $(this).css('z-index', 10000);
            $('.event-tooltip').fadeIn('500');
            $('.event-tooltip').fadeTo('10', 1.9);
        }).mousemove(function (e) {
            $('.event-tooltip').css('top', e.pageY + 10);
            $('.event-tooltip').css('left', e.pageX + 20);
        });
    },
    eventMouseout: function (calEvent, jsEvent) {
        $(this).css('z-index', 8);
        $('.event-tooltip').remove();
    },
    eventClick: function (calEvent, jsEvent, view) {
        currentEvent = calEvent;
        modal({
            buttons: {
                delete: {
                    id: 'delete-event',
                    css: 'btn-danger',
                    label: 'Excluir'
                },
                update: {
                    id: 'update-event',
                    css: 'btn-success',
                    label: 'Atualizar'
                }
            },
            title: 'Editar Evento "' + calEvent.title + '"',
            event: calEvent
        });
    }
}

function modal(data) {
    $('#visitaCalendarModal').html(data.title);
    $('#visitaCalendarModal button:not(".btn-default")').remove();
    $('#title').val(data.event ? data.event.title : '');
    if (!data.event) {
        var now = new Date();
        var time = now.getHours() + ':' + (now.getMinutes() < 10 ? '0' + now.getMinutes() : now.getMinutes());
    } else {
        var time = data.event.date.split(' ')[1].slice(0, -3);
        time = time.charAt(0) === '0' ? time.slice(1) : time;
    }
    $('#time').val(time);
    $('#description').val(data.event ? data.event.description : '');
    $('#color').val(data.event ? data.event.color : '#3a87ad');
    $.each(data.buttons, function (index, button) {
        $('#visitaCalendarModal .modal-footer').prepend('<button type="button" id="' + button.id + '" class="btn ' + button.css + '">' + button.label + '</button>')
    });
    $('#visitaCalendarModal').modal();
}

$('#visitaCalendarModal').on('click', '#add-event', function (e) {
    currentDate = $('input[name="dia"]').val();
    if (validator(['title', 'description'])) {
        $.post('crud/addEvent.php', {
            title: $('#title').val(),
            description: $('#description').val(),
            color: $('#color').val(),
            date: currentDate + ' ' + getTime()
        }, function (result) {
            $('#visitaCalendarModal').modal('hide');
            $('#visitaCalendarModal').fullCalendar("refetchEvents");
        });
    }
});

$('#visitaCalendarModal').on('click', '#update-event', function (e) {
    currentDate = $('input[name="dia"]').val();
    if (validator(['title', 'description'])) {
        $.post('crud/updateEvent.php', {
            id: currentEvent._id,
            title: $('#title').val(),
            description: $('#description').val(),
            color: $('#color').val(),
            date: currentDate + ' ' + getTime()
        }, function (result) {
            $('#visitaCalendarModal').modal('hide');
            $('#calendar').fullCalendar("refetchEvents");
        });
    }
});

$('#visitaCalendarModal').on('click', '#delete-event', function (e) {
    $.get('crud/deleteEvent.php?id=' + currentEvent._id, function (result) {
        $('#visitaCalendarModal').modal('hide');
        $('#visitaCalendarModal').fullCalendar("refetchEvents");
    });
});

function getTime() {
    var time = $('#time').val();
    return (time.indexOf(':') == 1 ? '0' + time : time) + ':00';
}

function validator(elements) {
    var errors = 0;
    $.each(elements, function (index, element) {
        if ($.trim($('#' + element).val()) == '')
            errors++;
    });
    if (errors) {
        $('.error').html('Por favor entre com o Título e a Descrição');
        return false;
    }
    return true;
}