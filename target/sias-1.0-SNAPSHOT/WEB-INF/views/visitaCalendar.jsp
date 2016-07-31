<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Listagem de Unidade de Atendimento</h2>
            </div>
            <div id="calendar" class="card"></div>
        </div>
    </div>
</div>
</section>

<%@include file="visitaModal.jsp" %>

<%@include file="/WEB-INF/views/footer.jsp" %>

<script type="text/javascript" src="<c:url value="/js/visitaCalendarController.js"/>"></script>