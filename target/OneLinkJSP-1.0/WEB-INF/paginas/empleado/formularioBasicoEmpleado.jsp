<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form-group">
    <label for="nombre">Nombre</label>
    <input type="text" class="form-control" name="nombre" required value="${param.nombre}">

</div>
<div class="form-group">
    <label for="apellido">Apellido</label>
    <input type="text" class="form-control" name="apellido" required value="${param.apellido}">

</div>
<div class="form-group">

    <label for="tipoDoc">Tipo Documento</label>
    <select class="form-select" id="tipoDoc" onchange="" name="tipoDoc" >
        <option value=0>-Selecccionar-</option>

        <c:forEach var="tipoDoc"  items="${sessionScope.tiposDocumentos}">
            <option value=${tipoDoc.idTipoDocumento} ${tipoDoc.isSelected? 'selected="selected"' : ''}> "${tipoDoc.label}"</option>
        </c:forEach>



    </select>

</div>
<div class="form-group">
    <label for="documento">Documento</label>
    <input type="text" class="form-control" name="documento" required value="${param.documento}">

</div>
<div class="form-group">

    <label for="area">Area</label>
    <select class="form-select" id="area" onchange="" name="area">
        <option value=0>-Selecccionar-</option>
        <c:forEach var="area" items="${sessionScope.areas}">
            <option value=${area.idArea} ${area.isSelected? 'selected="selected"' : ''}> "${area.label}"</option>
        </c:forEach>
    </select>

</div>

<div class="form-group">

    <label for="subArea">SubArea</label>
    <select class="form-select" id="subArea" onchange="" name="subArea">
        <option value=0>-Selecccionar-</option>
        <c:forEach var="subArea" items="${sessionScope.subAreas}">
            <option value=${subArea.idSubArea} ${subArea.isSelected? 'selected="selected"' : ''}> "${subArea.label}"</option>
        </c:forEach>
    </select>

</div>
