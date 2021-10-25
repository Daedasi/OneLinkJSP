
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Required meta tags -->

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS y Font Awesome -->
        <jsp:include page="../comunes/includeBootstrap.jsp"/>



    </head>
    <body>
        <!-- Cabecero-->
        <jsp:include page="../comunes/navBar.jsp" />

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idEmpleado=${empleado.idEmpleado}"
              method="POST" class="needs-validation">



            <!--Botones de navegación-->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Empleado ${empleado.nombre}</h4>
                                </div>
                                <div class="card-body">
                                    <jsp:include page="/WEB-INF/paginas/empleado/formularioBasicoEmpleado.jsp">
                                        <jsp:param name="nombre" value ="${empleado.nombre}"/>
                                        <jsp:param name="apellido" value ="${empleado.apellido}"/>
                                        <jsp:param name="tipoDoc" value ="${empleado.tipoDocumento}"/>
                                        <jsp:param name="documento" value ="${empleado.documento}"/>
                                        <jsp:param name="tiposDocumentosDTO" value ="${tiposDocumentosDTO}"/>
                                        <jsp:param name="areasDTO" value ="${areasDTO}"/>
                                        <jsp:param name="subAreasDTO" value ="${subAreasDTO}"/>
                                        
                                        
                                        
                                    </jsp:include>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form>

        <!--pie de página-->
        <jsp:include page="../comunes/footer.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>


</html>
