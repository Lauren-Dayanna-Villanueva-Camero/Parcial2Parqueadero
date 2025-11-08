<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Salida</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-danger text-white">
                    <h4 class="mb-0">🚪 Registrar Salida</h4>
                </div>
                <div class="card-body">

                    <div class="alert alert-warning">
                        <h5 class="alert-heading">🚗 ${registro.placaVehiculo}</h5>
                        <hr>
                        <p class="mb-1"><strong>Tipo:</strong> ${registro.tipoVehiculo.nombreTipo}</p>
                        <p class="mb-1"><strong>Ubicación:</strong> ${registro.ubicacion}</p>
                        <p class="mb-0"><strong>Hora Entrada:</strong> ${registro.horaEntrada}</p>
                    </div>

                    <form action="${pageContext.request.contextPath}/registro/registrar-salida" method="post">
                        <input type="hidden" name="id" value="${registro.id}" />

                        <div class="mb-3">
                            <label for="horaSalida" class="form-label">Hora de Salida <span class="text-danger">*</span></label>
                            <input type="datetime-local"
                                   class="form-control"
                                   id="horaSalida"
                                   name="horaSalida"
                                   required />
                            <small class="text-muted">Seleccione la fecha y hora de salida</small>
                        </div>

                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-danger">
                                🚪 Registrar Salida
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