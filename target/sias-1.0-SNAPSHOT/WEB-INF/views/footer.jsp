<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</section>

<div class="page-loader" style="display: none;">
    <div class="preloader pls-blue">
        <svg class="pl-circular" viewBox="25 25 50 50">
        <circle class="plc-path" cx="50" cy="50" r="20"></circle>
        </svg>
        <p>Por favor, aguarde...</p>
    </div>
</div>

<!-- Modal formulação do problema -->
<div class="modal fade" id="resultadoPesquisa" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h3 class="modal-title text-center">Resultados da pesquisa</h3>
            </div>
            <div class="modal-body">
                <div class="m-15 table-responsive" id="tabela-resultados">
                    <table class="table table-condensed table-striped table-vmiddle">
                        <thead>
                            <tr>
                                <th>Pessoa referência</th>
                                <th>NIS</th>
                            </tr>
                        </thead>
                        <tbody id="resultados">
                            
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/moment.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/fullcalendar.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/pt-br.js"/>"></script>

<script type="text/javascript" src="<c:url value="/js/sidebar.js"/>"></script>

<script type="text/javascript" src="<c:url value="/js/app.js"/>"></script>

<script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/FullCalendarConfig.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/select2.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/Select2TecnicoConfig.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/Select2FamiliaConfig.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/Searcher.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/Formatter.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.price-format.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/PriceFormatConfig.js"/>"></script>

<!-- js template -->
<script type="text/javascript" src="<c:url value="/js/jquery.sparkline.min.js"/>"></script>
<script type="text/javascript" rc="<c:url value="/js/jquery.easypiechart.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.flot.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.flot.pie.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.flot.resize.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.flot.tooltip.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.flot.orderBars.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/curvedLines.js"/>"></script>

<script type="text/javascript" src="<c:url value="/js/jquery.mCustomScrollbar.concat.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/waves.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/bootstrap-growl.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/sweetalert.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.bootgrid.updated.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/bootgridConfig.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/bootstrap-select.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/bootstrap-datetimepicker.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.bootstrap.wizard.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/autosize.min.js"/>"></script>

<script type="text/javascript" src="<c:url value="/js/Msg.js"/>"></script>

</body>
</html>