<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>



<section id="empleados">


    <div class="container">
        <div class="row">



            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Empleado</h4>
                    </div>
                    <table id="table"
                           data-toggle="table"
                           data-height="5"
                           data-pagination="true"
                           class="table table-striped table-dark" >
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Tipo Documento</th>
                                <th># Documento</th>
                                <th>Area</th>
                                <th>SubArea</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- Iteramos cada elemento de la lista de empleados-->
                            <c:forEach var="empleado" items="${empleados}">
                                <tr>
                                    <td>${empleado.idEmpleado}</td>
                                    <td>${empleado.nombre} ${empleado.apellido}</td>
                                    <td>${empleado.tipoDocumento.label} </td>

                                    <td>${empleado.documento}</td>
                                    <td>${empleado.area.label} </td>
                                    <td>${empleado.subArea.label} </td>

                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idEmpleado=${empleado.idEmpleado}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar

                                        </a>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idEmpleado=${empleado.idEmpleado}"
                                           class="btn btn-danger btn-block">
                                            <i class="fas fa-trash"></i> Eliminar

                                        </a>

                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>


                </div>
            </div>

        </div>
    </div>
</section>


<!-- Agregar Cliente MODAL -->
<jsp:include page="/WEB-INF/paginas/empleado/agregarEmpleado.jsp"/>