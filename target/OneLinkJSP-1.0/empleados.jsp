
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Required meta tags -->
    
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS y Font Awesome -->
        <jsp:include page="WEB-INF/paginas/comunes/includeBootstrap.jsp"/>

        
    </head>
    <body>
        <!-- Cabecero-->
        
        
        <jsp:include page="WEB-INF/paginas/comunes/navBar.jsp">
            <jsp:param name="lista" value="1"/>
        </jsp:include>
        
        
        <!--listado de empleados-->
        <jsp:include page="WEB-INF/paginas/empleado/listadoEmpleados.jsp"/>
        
        <!--pie de página-->
        <jsp:include page="WEB-INF/paginas/comunes/footer.jsp"/>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link href="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.css" rel="stylesheet">

<script src="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.js"></script>
    </body>
    
    
</html>
