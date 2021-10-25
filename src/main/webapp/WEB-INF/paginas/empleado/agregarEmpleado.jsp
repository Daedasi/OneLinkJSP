<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="agregarEmpleadoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Agregar Empleado</h5>
                <button class="btn-close" data-bs-dismiss="modal" >

                </button>
            </div> 

            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" 
                  method="POST" class="needs-validation">
                <div class="modal-body">

                    <jsp:include page="/WEB-INF/paginas/empleado/formularioBasicoEmpleado.jsp"/>

                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>


            </form>
        </div>
    </div>

</div>
