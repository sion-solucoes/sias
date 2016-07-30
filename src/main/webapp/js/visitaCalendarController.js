$(document).ready(function () {

    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();

    var cId = $('#calendar');

    cId.fullCalendar({
        header: {
            right: '',
            center: 'prev, title, next',
            left: ''
        },
        theme: true, //Do not remove this as it ruin the design
        selectable: true,
        selectHelper: true,
        editable: true,
        //On Day Select
        select: function (start, end, allDay) {
            $('#addNew-event').modal('show');
            $('#addNew-event input:text').val('');
            $('#getStart').val(start);
            $('#getEnd').val(end);
        }
    });

    //Create and ddd Action button with dropdown in Calendar header. 
    var actionMenu = '<ul class="actions actions-alt" id="fc-actions">' +
            '<li class="dropdown">' +
            '<a href="" data-toggle="dropdown"><i class="zmdi zmdi-more-vert"></i></a>' +
            '<ul class="dropdown-menu dropdown-menu-right">' +
            '<li class="active">' +
            '<a data-view="month" href="">Visão por mês</a>' +
            '</li>' +
            '<li>' +
            '<a data-view="basicWeek" href="">Visão por semana</a>' +
            '</li>' +
            '<li>' +
            '<a data-view="agendaWeek" href="">Visão por semana(em agenda)</a>' +
            '</li>' +
            '<li>' +
            '<a data-view="basicDay" href="">Visão por dia</a>' +
            '</li>' +
            '<li>' +
            '<a data-view="agendaDay" href="">Visão por dia(em agenda)</a>' +
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
        var eventName = $('#eventName').val();
        var tagColor = $('.event-tag > span.selected').attr('data-tag');

        if (eventName != '') {
            //Render Event
            $('#calendar').fullCalendar('renderEvent', {
                title: eventName,
                start: $('#getStart').val(),
                end: $('#getEnd').val(),
                allDay: true,
                className: tagColor

            }, true); //Stick the event

            $('#addNew-event form')[0].reset()
            $('#addNew-event').modal('hide');
        }

        else {
            $('#eventName').closest('.form-group').addClass('has-error');
        }
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