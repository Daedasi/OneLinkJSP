<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">OneLink</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarPrincipal" aria-controls="navbarPrincipal" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarPrincipal">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    <li class="nav-item">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/ServletControlador">Lista</a>
                    </li>

                    <c:forEach var="param" items="${param}">

                        <c:if test="${param.lista==1}">
                            <li class="nav-item">
                                <a class="nav-item nav-link" href="#" data-bs-toggle="modal" data-bs-target="#agregarEmpleadoModal" >Agregar</a>
                            </li>


                        </c:if>

                    </c:forEach>
                </ul>
                <c:forEach var="param" items="${param}">

                    <c:if test="${param.lista==1}">


                        <form class="d-flex" action="${pageContext.request.contextPath}/ServletControlador?accion=buscar"
                              method="POST">
                            <input class="form-control me-3" type="search" placeholder="Buscar por nombre o Documento" aria-label="Search" name="parametro">
                            <button class="btn btn-outline-light" type="submit">Search</button>
                        </form>

                    </c:if>

                </c:forEach>

            </div>
        </div>
    </nav>
</header>

