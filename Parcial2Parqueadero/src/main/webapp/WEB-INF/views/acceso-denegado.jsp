<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acceso Denegado</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .error-container {
            text-align: center;
            max-width: 500px;
            padding: 40px;
        }
        .error-icon {
            font-size: 100px;
            margin-bottom: 20px;
        }
        .btn-group-custom {
            margin-top: 30px;
        }
    </style>
</head>
<body>
<div class="error-container">
    <div class="error-icon">⛔</div>
    <h1 class="display-5 fw-bold text-danger mb-3">Acceso Denegado</h1>
    <p class="lead text-muted">
        No tienes permisos para acceder a esta página.
    </p>
    <p class="text-secondary">
        Si crees que esto es un error, contacta al administrador.
    </p>

    <div class="btn-group-custom">
        <a href="${pageContext.request.contextPath}/registro" class="btn btn-primary btn-lg me-2">
            ← Volver al Inicio
        </a>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-secondary btn-lg">
            Cerrar Sesión
        </a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>