<%-- 
    Document   : home
    Created on : 12/06/2015, 22:37:07
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h2>Beneficiados(neste mês)</h2>
                </div>
                <div class="card-body card-padding">
                    <div id="pie-chart" class="flot-chart-pie"></div>
                    <div class="flc-pie hidden-xs"></div>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h2>Acompanhamentos(neste mês)</h2>
                </div>
                <div class="card-body">
                    <div id="site-visits" class="dw-item bgm-teal">
                        <div class="dwi-header">
                            <div class="p-30">
                                <div class="dash-widget-visits"></div>
                            </div>
                        </div>
                        <div class="list-group lg-even-white">
                            <div class="list-group-item media sv-item">
                                <div class="pull-right">
                                    <div class="stats-bar"></div>
                                </div>
                                <div class="media-body">
                                    <small>Total de Acompanhamentos</small>
                                    <h3>40</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h2>Visitas(neste mês)</h2>
                </div>
                <div class="card-body card-padding-sm">
                    <div id="bar-chart" class="flot-chart"></div>
                    <div class="flc-bar"></div>
                </div>
            </div>
        </div>

    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>


