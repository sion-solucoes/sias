$(document).ready(function () {
    $('body').on('click', '[data-ma-action]', function (e) {
        e.preventDefault();

        var $this = $(this);
        var action = $(this).data('ma-action');

        switch (action) {

            /*-------------------------------------------
             Sidebar & Chat Open/Close
             ---------------------------------------------*/
            case 'sidebar-open':
                var target = $this.data('ma-target');
                var backdrop = '<div data-ma-action="sidebar-close" class="ma-backdrop" />';

                $('body').addClass('sidebar-toggled');
                $('#header, #header-alt, #main').append(backdrop);
                $this.addClass('toggled');
                $(target).addClass('toggled');

                break;

            case 'sidebar-close':
                $('body').removeClass('sidebar-toggled');
                $('.ma-backdrop').remove();
                $('.sidebar, .ma-trigger').removeClass('toggled')

                break;


                /*-------------------------------------------
                 Profile Menu Toggle
                 ---------------------------------------------*/
            case 'profile-menu-toggle':
                $this.parent().toggleClass('toggled');
                $this.next().slideToggle(200);

                break;


                /*-------------------------------------------
                 Mainmenu Submenu Toggle
                 ---------------------------------------------*/
            case 'submenu-toggle':
                $this.next().slideToggle(200);
                $this.parent().toggleClass('toggled');

                break;


                /*-------------------------------------------
                 Top Search Open/Close
                 ---------------------------------------------*/
                //Open
            case 'search-open':
                $('#header').addClass('search-toggled');
                $('#top-search-wrap input').focus();

                break;

                //Close
            case 'search-close':
                $('#header').removeClass('search-toggled');

                break;


                /*-------------------------------------------
                 Header Notification Clear
                 ---------------------------------------------*/
            case 'clear-notification':
                var x = $this.closest('.list-group');
                var y = x.find('.list-group-item');
                var z = y.size();

                $this.parent().fadeOut();

                x.find('.list-group').prepend('<i class="grid-loading hide-it"></i>');
                x.find('.grid-loading').fadeIn(1500);


                var w = 0;
                y.each(function () {
                    var z = $(this);
                    setTimeout(function () {
                        z.addClass('animated fadeOutRightBig').delay(1000).queue(function () {
                            z.remove();
                        });
                    }, w += 150);
                })

                //Popup empty message
                setTimeout(function () {
                    $('.him-notification').addClass('empty');
                }, (z * 150) + 200);

                break;
                
                /*-------------------------------------------
                 Login Window Switch
                 ---------------------------------------------*/
            case 'login-switch':
                var loginblock = $this.data('ma-block');
                var loginParent = $this.closest('.lc-block');

                loginParent.removeClass('toggled');

                setTimeout(function () {
                    $(loginblock).addClass('toggled');
                });

                break;


                /*-------------------------------------------
                 Profile Edit/Edit Cancel
                 ---------------------------------------------*/
                //Edit
            case 'profile-edit':
                $this.closest('.pmb-block').toggleClass('toggled');

                break;

            case 'profile-edit-cancel':
                $(this).closest('.pmb-block').removeClass('toggled');

                break;


                /*-------------------------------------------
                 Action Header Open/Close
                 ---------------------------------------------*/
                //Open
            case 'action-header-open':
                ahParent = $this.closest('.action-header').find('.ah-search');

                ahParent.fadeIn(300);
                ahParent.find('.ahs-input').focus();

                break;

                //Close
            case 'action-header-close':
                ahParent.fadeOut(300);
                setTimeout(function () {
                    ahParent.find('.ahs-input').val('');
                }, 350);

                break;

                /*-------------------------------------------
                 Change Header Skin
                 ---------------------------------------------*/
            case 'change-skin':

                var skin = $this.data('ma-skin');
                $('[data-ma-theme]').attr('data-ma-theme', skin);

                break;
        }
    });
});
$(document).ready(function () {
    /*-------------------------------------------
     Sparkline
     ---------------------------------------------*/
    function sparklineBar(id, values, height, barWidth, barColor, barSpacing) {
        $('.' + id).sparkline(values, {
            type: 'bar',
            height: height,
            barWidth: barWidth,
            barColor: barColor,
            barSpacing: barSpacing
        })
    }

    function sparklineLine(id, values, width, height, lineColor, fillColor, lineWidth, maxSpotColor, minSpotColor, spotColor, spotRadius, hSpotColor, hLineColor) {
        $('.' + id).sparkline(values, {
            type: 'line',
            width: width,
            height: height,
            lineColor: lineColor,
            fillColor: fillColor,
            lineWidth: lineWidth,
            maxSpotColor: maxSpotColor,
            minSpotColor: minSpotColor,
            spotColor: spotColor,
            spotRadius: spotRadius,
            highlightSpotColor: hSpotColor,
            highlightLineColor: hLineColor
        });
    }

    function sparklinePie(id, values, width, height, sliceColors) {
        $('.' + id).sparkline(values, {
            type: 'pie',
            width: width,
            height: height,
            sliceColors: sliceColors,
            offset: 0,
            borderWidth: 0
        });
    }

    /* Mini Chart - Bar Chart 1 */
    if ($('.stats-bar')[0]) {
        sparklineBar('stats-bar', [6, 4, 8, 6, 5, 6, 7, 8, 3, 5, 9, 5, 8, 4], '35px', 3, '#fff', 2);
    }

    /* Mini Chart - Bar Chart 2 */
    if ($('.stats-bar-2')[0]) {
        sparklineBar('stats-bar-2', [4, 7, 6, 2, 5, 3, 8, 6, 6, 4, 8, 6, 5, 8], '35px', 3, '#fff', 2);
    }

    /* Mini Chart - Line Chart 1 */
    if ($('.stats-line')[0]) {
        sparklineLine('stats-line', [9, 4, 6, 5, 6, 4, 5, 7, 9, 3, 6, 5], 68, 35, '#fff', 'rgba(0,0,0,0)', 1.25, 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 3, '#fff', 'rgba(255,255,255,0.4)');
    }

    /* Mini Chart - Line Chart 2 */
    if ($('.stats-line-2')[0]) {
        sparklineLine('stats-line-2', [5, 6, 3, 9, 7, 5, 4, 6, 5, 6, 4, 9], 68, 35, '#fff', 'rgba(0,0,0,0)', 1.25, 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 3, '#fff', 'rgba(255,255,255,0.4)');
    }

    /* Mini Chart - Pie Chart 1 */
    if ($('.stats-pie')[0]) {
        sparklinePie('stats-pie', [20, 35, 30, 5], 45, 45, ['#fff', 'rgba(255,255,255,0.7)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.2)']);
    }

    /* Dash Widget Line Chart */
    if ($('.dash-widget-visits')[0]) {
        sparklineLine('dash-widget-visits', [9, 4, 6, 5, 6, 4, 5, 7, 9, 3, 6, 5], '100%', '70px', 'rgba(255,255,255,0.7)', 'rgba(0,0,0,0)', 2, '#fff', '#fff', '#fff', 5, 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.1)');
    }



    /*-------------------------------------------
     Easy Pie Charts
     ---------------------------------------------*/
    function easyPieChart(id, trackColor, scaleColor, barColor, lineWidth, lineCap, size) {
        $('.' + id).easyPieChart({
            trackColor: trackColor,
            scaleColor: scaleColor,
            barColor: barColor,
            lineWidth: lineWidth,
            lineCap: lineCap,
            size: size
        });
    }

    /* Main Pie Chart */
    if ($('.main-pie')[0]) {
        easyPieChart('main-pie', 'rgba(255,255,255,0.2)', 'rgba(255,255,255,0)', 'rgba(255,255,255,0.7)', 2, 'butt', 148);
    }

    /* Others */
    if ($('.sub-pie-1')[0]) {
        easyPieChart('sub-pie-1', 'rgba(255,255,255,0.2)', 'rgba(255,255,255,0)', 'rgba(255,255,255,0.7)', 2, 'butt', 90);
    }

    if ($('.sub-pie-2')[0]) {
        easyPieChart('sub-pie-2', 'rgba(255,255,255,0.2)', 'rgba(255,255,255,0)', 'rgba(255,255,255,0.7)', 2, 'butt', 90);
    }
});
$(window).load(function () {

    if (!document.URL.endsWith('home'))
        return;

    function notify(message, type) {
        $.growl({
            message: message
        }, {
            type: type,
            allow_dismiss: false,
            label: 'Cancel',
            className: 'btn-xs btn-inverse',
            placement: {
                from: 'bottom',
                align: 'left'
            },
            delay: 2500,
            animate: {
                enter: 'animated fadeInUp',
                exit: 'animated fadeOutDown'
            },
            offset: {
                x: 30,
                y: 30
            }
        });
    }

    var usuario = $('.sp-info').prop('id');

    setTimeout(function () {
        if (!$('.login-content')[0]) {
            notify('Bem-vindo ' + usuario, 'inverse');
        }
    }, 1000);
});
$(document).ready(function () {
    var now = new Date();
    var mesAtual = now.getMonth() + 1;
    
    $.ajax({
        method: 'POST',
        url: '/home/loadFamiliaVisitaDataChart',
        data: {
            mesAtual: mesAtual
        },
        success: function (dados){
            var i = 1;
            /*----------------------------------------------
            Make some random data for Flot Line Chart
            ----------------------------------------------*/
           var data = [
                [1, dados[i++]], 
                [2, dados[i++]], 
                [3, dados[i++]],
                [4, dados[i++]], 
                [5, dados[i++]], 
                [6, dados[i++]], 
                [7, dados[i++]],
                [8, dados[i++]], 
                [9, dados[i++]], 
                [10, dados[i++]],
                [11, dados[i++]], 
                [12, dados[i++]], 
                [13, dados[i++]], 
                [14, dados[i++]],
                [15, dados[i++]], 
                [16, dados[i++]], 
                [17, dados[i++]],
                [18, dados[i++]], 
                [19, dados[i++]], 
                [20, dados[i++]], 
                [21, dados[i++]],
                [22, dados[i++]], 
                [23, dados[i++]], 
                [24, dados[i++]],
                [25, dados[i++]], 
                [26, dados[i++]], 
                [27, dados[i++]], 
                [28, dados[i++]],
                [29, dados[i++]], 
                [30, dados[i++]]
               ];
               
            /* Create an Array push the data + Draw the bars*/

            var barData = new Array();

            barData.push({
                data: data,
                bars: {
                    show: true,
                    barWidth: 0.08,
                    order: 1,
                    lineWidth: 0,
                    fillColor: '#8BC34A'
                }
            });
            
            /*---------------------------------
            Let's create the chart
            ---------------------------------*/
           if ($('#bar-chart')[0]) {
               $.plot($("#bar-chart"), barData, {
                   grid: {
                       borderWidth: 1,
                       borderColor: '#eee',
                       show: true,
                       hoverable: true,
                       clickable: true
                   },
                   yaxis: {
                       tickColor: '#eee',
                       tickDecimals: 0,
                       font: {
                           lineHeight: 13,
                           style: "normal",
                           color: "#9f9f9f",
                       },
                       shadowSize: 0
                   },
                   xaxis: {
                       tickColor: '#fff',
                       tickDecimals: 0,
                       font: {
                           lineHeight: 13,
                           style: "normal",
                           color: "#9f9f9f"
                       },
                       shadowSize: 0,
                   },
                   legend: {
                       container: '.flc-bar',
                       backgroundOpacity: 0.5,
                       noColumns: 0,
                       backgroundColor: "white",
                       lineWidth: 0
                   }
               });
           }
        }
    });

//    /*---------------------------------
//     Tooltips for Flot Charts
//     ---------------------------------*/
//    if ($(".flot-chart")[0]) {
//        $(".flot-chart").bind("plothover", function (event, pos, item) {
//            if (item) {
//                var x = item.datapoint[0].toFixed(2),
//                        y = item.datapoint[1].toFixed(2);
//                $(".flot-tooltip").html(item.series.label + " of " + x + " = " + y).css({top: item.pageY + 5, left: item.pageX + 5}).show();
//            }
//            else {
//                $(".flot-tooltip").hide();
//            }
//        });
//
//        $("<div class='flot-tooltip' class='chart-tooltip'></div>").appendTo("body");
//    }
});
$(document).ready(function () {

    /*-----------------------------------------
     Make some random data for the Chart
     -----------------------------------------*/
    var d1 = [];
    for (var i = 0; i <= 10; i += 1) {
        d1.push([i, parseInt(Math.random() * 30)]);
    }
    var d2 = [];
    for (var i = 0; i <= 20; i += 1) {
        d2.push([i, parseInt(Math.random() * 30)]);
    }
    var d3 = [];
    for (var i = 0; i <= 10; i += 1) {
        d3.push([i, parseInt(Math.random() * 30)]);
    }

    /*---------------------------------
     Chart Options
     ---------------------------------*/
    var options = {
        series: {
            shadowSize: 0,
            curvedLines: {//This is a third party plugin to make curved lines
                apply: true,
                active: true,
                monotonicFit: true
            },
            lines: {
                show: false,
                lineWidth: 0,
            },
        },
        grid: {
            borderWidth: 0,
            labelMargin: 10,
            hoverable: true,
            clickable: true,
            mouseActiveRadius: 6,
        },
        xaxis: {
            tickDecimals: 0,
            ticks: false
        },
        yaxis: {
            tickDecimals: 0,
            ticks: false
        },
        legend: {
            show: false
        }
    };

    /*---------------------------------
     Let's create the chart
     ---------------------------------*/
    if ($("#curved-line-chart")[0]) {
        $.plot($("#curved-line-chart"), [
            {data: d1, lines: {show: true, fill: 0.98}, label: 'Product 1', stack: true, color: '#e3e3e3'},
            {data: d3, lines: {show: true, fill: 0.98}, label: 'Product 2', stack: true, color: '#f1dd2c'}
        ], options);
    }

    /*---------------------------------
     Tooltips for Flot Charts
     ---------------------------------*/
    if ($(".flot-chart")[0]) {
        $(".flot-chart").bind("plothover", function (event, pos, item) {
            if (item) {
                var x = item.datapoint[0].toFixed(2),
                        y = item.datapoint[1].toFixed(2);
                $(".flot-tooltip").html(item.series.label + " of " + x + " = " + y).css({top: item.pageY + 5, left: item.pageX + 5}).show();
            }
            else {
                $(".flot-tooltip").hide();
            }
        });

        $("<div class='flot-tooltip' class='chart-tooltip'></div>").appendTo("body");
    }
});
$(document).ready(function () {

    /*---------------------------------
     Make some random data
     ---------------------------------*/
    var data = [];
    var totalPoints = 300;
    var updateInterval = 30;

    function getRandomData() {
        if (data.length > 0)
            data = data.slice(1);

        while (data.length < totalPoints) {

            var prev = data.length > 0 ? data[data.length - 1] : 50,
                    y = prev + Math.random() * 10 - 5;
            if (y < 0) {
                y = 0;
            } else if (y > 90) {
                y = 90;
            }

            data.push(y);
        }

        var res = [];
        for (var i = 0; i < data.length; ++i) {
            res.push([i, data[i]])
        }

        return res;
    }

    /*---------------------------------
     Create Chart
     ---------------------------------*/
    if ($('#dynamic-chart')[0]) {
        var plot = $.plot("#dynamic-chart", [getRandomData()], {
            series: {
                label: "Server Process Data",
                lines: {
                    show: true,
                    lineWidth: 0.2,
                    fill: 0.6
                },
                color: '#00BCD4',
                shadowSize: 0,
            },
            yaxis: {
                min: 0,
                max: 100,
                tickColor: '#eee',
                font: {
                    lineHeight: 13,
                    style: "normal",
                    color: "#9f9f9f",
                },
                shadowSize: 0,
            },
            xaxis: {
                tickColor: '#eee',
                show: true,
                font: {
                    lineHeight: 13,
                    style: "normal",
                    color: "#9f9f9f",
                },
                shadowSize: 0,
                min: 0,
                max: 250
            },
            grid: {
                borderWidth: 1,
                borderColor: '#eee',
                labelMargin: 10,
                hoverable: true,
                clickable: true,
                mouseActiveRadius: 6,
            },
            legend: {
                container: '.flc-dynamic',
                backgroundOpacity: 0.5,
                noColumns: 0,
                backgroundColor: "white",
                lineWidth: 0
            }
        });

        /*---------------------------------
         Update
         ---------------------------------*/
        function update() {
            plot.setData([getRandomData()]);
            // Since the axes don't change, we don't need to call plot.setupGrid()

            plot.draw();
            setTimeout(update, updateInterval);
        }
        update();
    }
});
$(document).ready(function () {

    /*---------------------------------------------------
     Make some random data for Recent Items chart
     ---------------------------------------------------*/
    var data = [];
    var totalPoints = 100;
    var updateInterval = 30;

    function getRandomData() {
        if (data.length > 0)
            data = data.slice(1);

        while (data.length < totalPoints) {

            var prev = data.length > 0 ? data[data.length - 1] : 50,
                    y = prev + Math.random() * 10 - 5;
            if (y < 0) {
                y = 0;
            } else if (y > 90) {
                y = 90;
            }

            data.push(y);
        }

        var res = [];
        for (var i = 0; i < data.length; ++i) {
            res.push([i, data[i]])
        }

        return res;
    }

    /*---------------------------------------------------
     Make some random data for Flot Line Chart
     ---------------------------------------------------*/

    var d1 = [];
    for (var i = 0; i <= 10; i += 1) {
        d1.push([i, parseInt(Math.random() * 30)]);
    }
    var d2 = [];
    for (var i = 0; i <= 20; i += 1) {
        d2.push([i, parseInt(Math.random() * 30)]);
    }
    var d3 = [];
    for (var i = 0; i <= 10; i += 1) {
        d3.push([i, parseInt(Math.random() * 30)]);
    }

    /*---------------------------------
     Chart Options
     ---------------------------------*/
    var options = {
        series: {
            shadowSize: 0,
            lines: {
                show: false,
                lineWidth: 0,
            },
        },
        grid: {
            borderWidth: 0,
            labelMargin: 10,
            hoverable: true,
            clickable: true,
            mouseActiveRadius: 6,
        },
        xaxis: {
            tickDecimals: 0,
            ticks: false
        },
        yaxis: {
            tickDecimals: 0,
            ticks: false
        },
        legend: {
            show: false
        }
    };

    /*---------------------------------
     Regular Line Chart
     ---------------------------------*/
    if ($("#line-chart")[0]) {
        $.plot($("#line-chart"), [
            {data: d1, lines: {show: true, fill: 0.98}, label: 'Product 1', stack: true, color: '#e3e3e3'},
            {data: d3, lines: {show: true, fill: 0.98}, label: 'Product 2', stack: true, color: '#FFC107'}
        ], options);
    }


    /*---------------------------------
     Recent Items Table Chart
     ---------------------------------*/
    if ($("#recent-items-chart")[0]) {
        $.plot($("#recent-items-chart"), [
            {data: getRandomData(), lines: {show: true, fill: 0.8}, label: 'Items', stack: true, color: '#00BCD4'},
        ], options);
    }


    /*---------------------------------
     Tooltips for Flot Charts
     ---------------------------------*/
    if ($(".flot-chart")[0]) {
        $(".flot-chart").bind("plothover", function (event, pos, item) {
            if (item) {
                var x = item.datapoint[0].toFixed(2),
                        y = item.datapoint[1].toFixed(2);
                $(".flot-tooltip").html(item.series.label + " of " + x + " = " + y).css({top: item.pageY + 5, left: item.pageX + 5}).show();
            }
            else {
                $(".flot-tooltip").hide();
            }
        });

        $("<div class='flot-tooltip' class='chart-tooltip'></div>").appendTo("body");
    }
});
$(document).ready(function () {
    
    var now = new Date();
    var mes = now.getMonth() + 1;
    
    $.ajax({
        method: 'POST',
        url: '/home/loadBeneficioEventualDataChart',
        data: {mesAtual: mes},
        success: function (dados){
            var pieData = [
                {data: dados.auxilioNatalidade, color: '#F44336', label: 'Auxílio Natalidade'},
                {data: dados.auxilioFuneral, color: '#03A9F4', label: 'Auxílio Funeral'},
                {data: dados.situacoesEmergencia, color: '#FFA500', label: 'Kit para situações de emergência'},
                {data: dados.cestaBasica, color: '#8BC34A', label: 'Cesta Básica'},
                {data: dados.aluguel, color: '#FFEB3B', label: 'Aluguel'},
                {data: dados.outros, color: '#009688', label: 'Outros'},
            ];

            /*---------------------------------
             Pie Chart
             ---------------------------------*/
            if ($('#pie-chart')[0]) {
                $.plot('#pie-chart', pieData, {
                    series: {
                        pie: {
                            show: true,
                            stroke: {
                                width: 2,
                            },
                        },
                    },
                    legend: {
                        container: '.flc-pie',
                        backgroundOpacity: 0.5,
                        noColumns: 0,
                        backgroundColor: "white",
                        lineWidth: 0
                    },
                    grid: {
                        hoverable: true,
                        clickable: true
                    },
                    tooltip: true,
                    tooltipOpts: {
                        content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
                        shifts: {
                            x: 20,
                            y: 0
                        },
                        defaultTheme: false,
                        cssClass: 'flot-tooltip'
                    }

                });
            }
        }
    });

    /*---------------------------------
     Donut Chart
     ---------------------------------*/
    if ($('#donut-chart')[0]) {
        $.plot('#donut-chart', pieData, {
            series: {
                pie: {
                    innerRadius: 0.5,
                    show: true,
                    stroke: {
                        width: 2,
                    },
                },
            },
            legend: {
                container: '.flc-donut',
                backgroundOpacity: 0.5,
                noColumns: 0,
                backgroundColor: "white",
                lineWidth: 0
            },
            grid: {
                hoverable: true,
                clickable: true
            },
            tooltip: true,
            tooltipOpts: {
                content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
                shifts: {
                    x: 20,
                    y: 0
                },
                defaultTheme: false,
                cssClass: 'flot-tooltip'
            }

        });
    }
});
/*----------------------------------------------------------
 Detect Mobile Browser
 -----------------------------------------------------------*/
if (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
    $('html').addClass('ismobile');
}

$(window).load(function () {
    /*----------------------------------------------------------
     Page Loader
     -----------------------------------------------------------*/
    if (!$('html').hasClass('ismobile')) {
        if ($('.page-loader')[0]) {
            setTimeout(function () {
                $('.page-loader').fadeOut();
            }, 500);

        }
    }
})

$(document).ready(function () {


    /*----------------------------------------------------------
     Scrollbar
     -----------------------------------------------------------*/
    function scrollBar(selector, theme, mousewheelaxis) {
        $(selector).mCustomScrollbar({
            theme: theme,
            scrollInertia: 100,
            axis: 'yx',
            mouseWheel: {
                enable: true,
                axis: mousewheelaxis,
                preventDefault: true
            }
        });
    }

    if (!$('html').hasClass('ismobile')) {
        //On Custom Class
        if ($('.c-overflow')[0]) {
            scrollBar('.c-overflow', 'minimal-dark', 'y');
        }
    }


    /*----------------------------------------------------------
     Dropdown Menu
     -----------------------------------------------------------*/
    if ($('.dropdown')[0]) {
        //Propagate
        $('body').on('click', '.dropdown.open .dropdown-menu', function (e) {
            e.stopPropagation();
        });

        $('.dropdown').on('shown.bs.dropdown', function (e) {
            if ($(this).attr('data-animation')) {
                $animArray = [];
                $animation = $(this).data('animation');
                $animArray = $animation.split(',');
                $animationIn = 'animated ' + $animArray[0];
                $animationOut = 'animated ' + $animArray[1];
                $animationDuration = ''
                if (!$animArray[2]) {
                    $animationDuration = 500; //if duration is not defined, default is set to 500ms
                }
                else {
                    $animationDuration = $animArray[2];
                }

                $(this).find('.dropdown-menu').removeClass($animationOut)
                $(this).find('.dropdown-menu').addClass($animationIn);
            }
        });

        $('.dropdown').on('hide.bs.dropdown', function (e) {
            if ($(this).attr('data-animation')) {
                e.preventDefault();
                $this = $(this);
                $dropdownMenu = $this.find('.dropdown-menu');

                $dropdownMenu.addClass($animationOut);
                setTimeout(function () {
                    $this.removeClass('open')

                }, $animationDuration);
            }
        });
    }

    /*----------------------------------------------------------
     Calendar Widget
     -----------------------------------------------------------*/
    if ($('#calendar-widget')[0]) {

        (function () {
            $('#cw-body').fullCalendar({
                contentHeight: 'auto',
                theme: true,
                header: {
                    right: 'next',
                    center: 'title, ',
                    left: 'prev'
                },
                defaultDate: '2014-06-12',
                editable: true,
                events: [
                    {
                        title: 'All Day',
                        start: '2014-06-01',
                        className: 'bgm-cyan'
                    },
                    {
                        title: 'Long Event',
                        start: '2014-06-07',
                        end: '2014-06-10',
                        className: 'bgm-orange'
                    },
                    {
                        id: 999,
                        title: 'Repeat',
                        start: '2014-06-09',
                        className: 'bgm-lightgreen'
                    },
                    {
                        id: 999,
                        title: 'Repeat',
                        start: '2014-06-16',
                        className: 'bgm-lightblue'
                    },
                    {
                        title: 'Meet',
                        start: '2014-06-12',
                        end: '2014-06-12',
                        className: 'bgm-green'
                    },
                    {
                        title: 'Lunch',
                        start: '2014-06-12',
                        className: 'bgm-cyan'
                    },
                    {
                        title: 'Birthday',
                        start: '2014-06-13',
                        className: 'bgm-amber'
                    },
                    {
                        title: 'Google',
                        url: 'http://google.com/',
                        start: '2014-06-28',
                        className: 'bgm-amber'
                    }
                ]
            });
        })();

        //Display Current Date as Calendar widget header
        var mYear = moment().format('YYYY');
        var mDay = moment().format('dddd, MMM D');
        $('#calendar-widget .cwh-year').html(mYear);
        $('#calendar-widget .cwh-day').html(mDay);

    }

    /*----------------------------------------------------------
     Auto Size Textare
     -----------------------------------------------------------*/
    if ($('.auto-size')[0]) {
        autosize($('.auto-size'));
    }


    /*----------------------------------------------------------
     Text Field
     -----------------------------------------------------------*/
    //Add blue animated border and remove with condition when focus and blur
    if ($('.fg-line')[0]) {
        $('body').on('focus', '.fg-line .form-control', function () {
            $(this).closest('.fg-line').addClass('fg-toggled');
        })

        $('body').on('blur', '.form-control', function () {
            var p = $(this).closest('.form-group, .input-group');
            var i = p.find('.form-control').val();

            if (p.hasClass('fg-float')) {
                if (i.length == 0) {
                    $(this).closest('.fg-line').removeClass('fg-toggled');
                }
            }
            else {
                $(this).closest('.fg-line').removeClass('fg-toggled');
            }
        });
    }

    //Add blue border for pre-valued fg-flot text feilds
    if ($('.fg-float')[0]) {
        $('.fg-float .form-control').each(function () {
            var i = $(this).val();

            if (!i.length == 0) {
                $(this).closest('.fg-line').addClass('fg-toggled');
            }

        });
    }

    /*-----------------------------------------------------------
     Form Wizard
     -----------------------------------------------------------*/
    if ($('.form-wizard-basic')[0]) {
        $('.form-wizard-basic').bootstrapWizard({
            tabClass: 'fw-nav',
            'nextSelector': '.next',
            'previousSelector': '.previous'
        });
    }


    /*-----------------------------------------------------------
     Waves
     -----------------------------------------------------------*/
    (function () {
        Waves.attach('.btn:not(.btn-icon):not(.btn-float)');
        Waves.attach('.btn-icon, .btn-float', ['waves-circle', 'waves-float']);
        Waves.init();
    })();


    /*-----------------------------------------------------------
     Link prevent
     -----------------------------------------------------------*/
    $('body').on('click', '.a-prevent', function (e) {
        e.preventDefault();
    });

    /*-----------------------------------------------------------
     IE 9 Placeholder
     -----------------------------------------------------------*/
    if ($('html').hasClass('ie9')) {
        $('input, textarea').placeholder({
            customClass: 'ie9-placeholder'
        });
    }
});