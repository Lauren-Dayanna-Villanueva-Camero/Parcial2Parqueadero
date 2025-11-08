<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${registro.id == null ? 'Nuevo' : 'Editar'} Registro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow">
                <div class="card-header bg-success text-white">
                    <h4 class="mb-0">📝 ${registro.id == null ? 'Nuevo' : 'Editar'} Registro</h4>
                </div>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/registro" method="post">
                        <input type="hidden" name="id" value="${registro.id}" />

                        <div class="mb-3">
                            <label for="placaVehiculo" class="form-label">Placa del Vehículo <span class="text-danger">*</span></label>
                            <input type="text"
                                   class="form-control"
                                   id="placaVehiculo"
                                   name="placaVehiculo"
                                   value="${registro.placaVehiculo}"
                                   maxlength="6"
                                   placeholder="ABC123"
                                   required />
                            <small class="text-muted">Máximo 6 caracteres</small>
                        </div>

                        <div class="mb-3">
                            <label for="ubicacion" class="form-label">Ubicación <span class="text-danger">*</span></label>
                            <input type="text"
                                   class="form-control"
                                   id="ubicacion"
                                   name="ubicacion"
                                   value="${registro.ubicacion}"
                                   placeholder="A-1, B-2, CS-100"
                                   maxlength="20"
                                   required />
                            <small class="text-muted">Ejemplo: A-1, B-2, CS-100</small>
                        </div>

                        <div class="mb-3">
                            <label for="tipoVehiculo" class="form-label">Tipo de Vehículo <span class="text-danger">*</span></label>
                            <select class="form-select" id="tipoVehiculo" name="tipoVehiculo.id" required>
                                <option value="">-- Seleccione un tipo --</option>
                                <c:forEach items="${tiposVehiculo}" var="tipo">
                                    <option value="${tipo.id}"
                                        ${registro.tipoVehiculo != null && registro.tipoVehiculo.id == tipo.id ? 'selected' : ''}>
                                            ${tipo.nombreTipo}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-success">
                                💾 Guardar Registro
                            </button>
                            <a href="${pageContext.request.contextPath}/registro" class="btn btn-outline-secondary">
                                ❌ Cancelar
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>