<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle de Registro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow">
                <div class="card-header bg-info text-white">
                    <h4 class="mb-0">🚗 Detalle de Registro</h4>
                </div>
                <div class="card-body">
                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <th width="30%" class="table-light">ID:</th>
                            <td>${registro.id}</td>
                        </tr>
                        <tr>
                            <th class="table-light">Placa:</th>
                            <td><strong>${registro.placaVehiculo}</strong></td>
                        </tr>
                        <tr>
                            <th class="table-light">Hora de Entrada:</th>
                            <td>${registro.horaEntrada}</td>
                        </tr>
                        <tr>
                            <th class="table-light">Hora de Salida:</th>
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
                        </tr>
                        <tr>
                            <th class="table-light">Ubicación:</th>
                            <td>${registro.ubicacion}</td>
                        </tr>
                        <tr>
                            <th class="table-light">Tipo de Vehículo:</th>
                            <td>${registro.tipoVehiculo.nombreTipo}</td>
                        </tr>
                        <c:if test="${not empty registro.tipoVehiculo.descripcion}">
                            <tr>
                                <th class="table-light">Descripción:</th>
                                <td>${registro.tipoVehiculo.descripcion}</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>

                    <div class="d-flex gap-2 flex-wrap">
                        <a href="${pageContext.request.contextPath}/registro" class="btn btn-secondary">
                            ← Volver
                        </a>

                        <c:if test="${rol == 'ADMINISTRADOR'}">
                            <a href="${pageContext.request.contextPath}/registro/editar/${registro.id}"
                               class="btn btn-warning">
                                ✏️ Editar
                            </a>
                        </c:if>

                        <c:if test="${rol == 'ADMINISTRADOR' || rol == 'ACOMODADOR'}">
                            <a href="${pageContext.request.contextPath}/registro/actualizar-ubicacion/${registro.id}"
                               class="btn btn-primary">
                                📍 Actualizar Ubicación
                            </a>
                        </c:if>

                        <c:if test="${rol == 'ADMINISTRADOR' || rol == 'ACOMODADOR'}">
                            <c:if test="${registro.horaSalida == null}">
                                <a href="${pageContext.request.contextPath}/registro/registrar-salida/${registro.id}"
                                   class="btn btn-danger">
                                    🚪 Registrar Salida
                                </a>
                            </c:if>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>