<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Registros</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>🚗 Registros de Parqueadero</h2>
        <div>
            <span class="badge bg-primary me-2">${rol}</span>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-danger btn-sm">
                Cerrar Sesión
            </a>
        </div>
    </div>

    <c:if test="${rol == 'ADMINISTRADOR'}">
        <div class="mb-3">
            <a href="${pageContext.request.contextPath}/registro/nuevo" class="btn btn-success">
                ➕ Nuevo Registro
            </a>
        </div>
    </c:if>

    <div class="card shadow">
        <div class="card-body">
            <c:if test="${empty registros}">
                <div class="text-center py-4">
                    <h5 class="text-muted">No hay registros de parqueadero</h5>
                    <p class="text-muted">No se han encontrado vehículos registrados.</p>
                </div>
            </c:if>

            <c:if test="${not empty registros}">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Placa</th>
                                <th>Entrada</th>
                                <th>Salida</th>
                                <th>Ubicación</th>
                                <th>Tipo</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${registros}" var="registro">
                                <tr>
                                    <td>${registro.id}</td>
                                    <td><strong>${registro.placaVehiculo}</strong></td>
                                    <td>${registro.horaEntrada}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${registro.horaSalida != null}">
                                                ${registro.horaSalida}
                                            </c:when>
                                            <c:otherwise>
                                                <span class="badge bg-warning">En parqueadero</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>${registro.ubicacion}</td>
                                    <td>${registro.tipoVehiculo.nombreTipo}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${registro.horaSalida == null}">
                                                <span class="badge bg-success">Activo</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="badge bg-secondary">Completado</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <div class="btn-group btn-group-sm">
                                            <a href="${pageContext.request.contextPath}/registro/ver/${registro.id}"
                                               class="btn btn-outline-info" title="Ver detalles">
                                                👁️
                                            </a>
                                            
                                            <c:if test="${rol == 'ADMINISTRADOR'}">
                                                <a href="${pageContext.request.contextPath}/registro/editar/${registro.id}"
                                                   class="btn btn-outline-warning" title="Editar">
                                                    ✏️
                                                </a>
                                            </c:if>

                                            <c:if test="${(rol == 'ADMINISTRADOR' || rol == 'ACOMODADOR') && registro.horaSalida == null}">
                                                <a href="${pageContext.request.contextPath}/registro/actualizar-ubicacion/${registro.id}"
                                                   class="btn btn-outline-primary" title="Actualizar ubicación">
                                                    📍
                                                </a>
                                            </c:if>

                                            <c:if test="${(rol == 'ADMINISTRADOR' || rol == 'ACOMODADOR') && registro.horaSalida == null}">
                                                <a href="${pageContext.request.contextPath}/registro/registrar-salida/${registro.id}"
                                                   class="btn btn-outline-danger" title="Registrar salida">
                                                    🚪
                                                </a>
                                            </c:if>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>