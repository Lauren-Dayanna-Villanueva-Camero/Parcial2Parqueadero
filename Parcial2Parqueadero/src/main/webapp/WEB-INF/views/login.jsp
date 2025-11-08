<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Sistema Parqueadero</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .login-container {
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
            padding: 40px;
            width: 100%;
            max-width: 400px;
        }
        .login-header {
            text-align: center;
            margin-bottom: 30px;
        }
        .login-header h2 {
            color: #333;
            font-weight: 600;
            margin-bottom: 10px;
        }
        .login-header p {
            color: #666;
            font-size: 14px;
        }
        .btn-login {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            border: none;
            width: 100%;
            padding: 12px;
            font-weight: 600;
            margin-top: 10px;
        }
        .btn-login:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
        }
        .info-box {
            background-color: #f8f9fa;
            border-radius: 8px;
            padding: 15px;
            margin-top: 20px;
            font-size: 13px;
            color: #666;
        }
        .info-box strong {
            color: #333;
            display: block;
            margin-bottom: 8px;
        }
    </style>
</head>
<body>
<div class="login-container">
    <div class="login-header">
        <h2>🚗 Sistema Parqueadero</h2>
        <p>Gestión de Entradas y Salidas</p>
    </div>

    <c:if test="${param.error != null}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong>❌ Error:</strong> Usuario o contraseña incorrectos
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    </c:if>

    <c:if test="${param.logout != null}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>✅ Éxito:</strong> Has cerrado sesión correctamente
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/perform-login" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Email o Usuario</label>
            <input type="text"
                   class="form-control"
                   id="username"
                   name="username"
                   placeholder="Ingresa Tu Email"
                   required
                   autofocus>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Contraseña</label>
            <input type="password"
                   class="form-control"
                   id="password"
                   name="password"
                   placeholder="Ingresa tu contraseña"
                   required>
        </div>

        <button type="submit" class="btn btn-primary btn-login">
            Iniciar Sesión
        </button>
    </form>

    <div class="info-box">
        <strong>👥 Usuarios de prueba:</strong>
        <small>
            <div>👨‍💼 <strong>Administrador:</strong> admin@parqueadero.com / 1234</div>
            <div>👨‍💼 <strong>Acomodador:</strong> acomodador@parqueadero.com / 1234</div>
            <div>👤 <strong>Cliente:</strong> cliente@parqueadero.com / 1234</div>
        </small>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>