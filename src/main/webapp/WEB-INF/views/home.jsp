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
                    <h2>Beneficiados (no mês)</h2>
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
                    <h2>Visitas (no mês)</h2>
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


