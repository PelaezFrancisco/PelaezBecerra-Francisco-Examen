<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Listar Telefonos</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="css/landing-page.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-light bg-light static-top">
    <div class="container">
      <a class="navbar-brand" href="index.html">Pag Amarillas Pancho!</a>
      <a class="btn btn-primary" href="/PelaezBecerra-JFrancisco-Examen/ListarController">Lista Completa</a>
      <a class="btn btn-primary" href="public/IniciarSesion.html">Iniciar Sesion</a>
    </div>
  </nav>

  <!-- Masthead -->
  <header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <h1 class="mb-5">Paginas Amarrilas Pancho!</h1>
        </div>
        <div class="col-xl-9 mx-auto">
          <h1 class="mb-5">Resultados de Busqueda</h1>
        </div>
      </div>
    </div>
  </header>
<br><br>
  <!-- Image Showcases -->
  <section class="showcase">
  	<div style="text-align: center; position: relative; left: 2%;">
  		<table style="width: 95%;border-collapse: collapse; border: 1px solid black; text-align: center;">
        <tr style="border: 1px solid black;">
            <td style="border: 1px solid black;"><strong>Nombre</strong></td>
            <td style="border: 1px solid black;"><strong>Apellido</strong></td>
            <td style="border: 1px solid black;"><strong>Cedula</strong></td>
            <td style="border: 1px solid black;"><strong>Direccion</strong></td>
            <td style="border: 1px solid black;"><strong>Email</strong></td>
            <td style="border: 1px solid black;"><strong>Telefono</strong></td>
            <td style="border: 1px solid black;"><strong>Tipo</strong></td>
            <td style="border: 1px solid black;"><strong>Operadora</strong></td>
            
        </tr>
        <c:forEach var="tel" items="${telefonos}">
            <tr style="border: 1px solid black;">
                <td style="border: 1px solid black;">${tel.persona.per_nombre}</td>
                <td style="border: 1px solid black;">${tel.persona.per_apellido}</td>
                <td style="border: 1px solid black;">${tel.persona.per_cedula}</td>
                <td style="border: 1px solid black;">${tel.persona.per_direccion}</td>
                <td style="border: 1px solid black;">${tel.persona.per_email}</td>
                <td style="border: 1px solid black;">${tel.tel_numero}</td>
                <td style="border: 1px solid black;">${tel.tipos.tip_nombre}</td>
                <td style="border: 1px solid black;">${tel.operador.ope_nombre}</td>

            </tr>
        </c:forEach>
    </table>
  	</div>
    
  </section>

  <!-- Testimonials -->

  <!-- Call to Action -->

  <!-- Footer -->
  <footer class="footer bg-light">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
		  <p class="text-muted small mb-4 mb-lg-0">Est. Juan Francisco Pelaez Becerra</p>
          <p class="text-muted small mb-4 mb-lg-0">&copy; Your Website 2020. All Rights Reserved.</p>
        </div>
        <div class="col-lg-6 h-100 text-center text-lg-right my-auto">
          <ul class="list-inline mb-0">
            <li class="list-inline-item mr-3">
              <a href="#">
                <i class="fab fa-facebook fa-2x fa-fw"></i>
              </a>
            </li>
            <li class="list-inline-item mr-3">
              <a href="#">
                <i class="fab fa-twitter-square fa-2x fa-fw"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <i class="fab fa-instagram fa-2x fa-fw"></i>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>