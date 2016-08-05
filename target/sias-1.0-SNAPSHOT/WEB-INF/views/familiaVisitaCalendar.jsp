<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="pull-left">
                    <h2>Agendamento de Visitas</h2>
                </div>
            </div>
            <div class="card-body card-padding">
                <div id="calendar"></div>
            </div>
        </div>
    </div>
</section>

<%@include file="familiaVisitaModal.jsp" %>

<%@include file="/WEB-INF/views/footer.jsp" %>

<script type="text/javascript" src="<c:url value="/js/familiaVisitaController.js"/>"></script>