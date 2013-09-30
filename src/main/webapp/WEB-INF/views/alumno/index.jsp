<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<h1>Index Alumno</h1>

<form action="add" method="POST">
	<input type="text" name="nombre" placeholder="Nombre" />
	<br />
	<input type="text" name="apellido" placeholder="Apellido" />
	<br />	
	<input type="text" name="dia" placeholder="Dia" />
	<input type="text" name="mes" placeholder="Mes" />
	<input type="text" name="ano" placeholder="Año" />
	<button>Submit</button>
</form>
<table class="table">
	<tr>
		<th>Legajo</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Fecha de nacimiento</th>
		<th>Opciones</th>
	</tr>
	<c:forEach items="${alumnos}" var="alumno" varStatus="i">
		<tr>
			<td>${alumno.legajo}</td>
			<td>${alumno.nombre}</td>
			<td>${alumno.apellido}</td>
			<td>${alumno.nacimiento.toString()}</td>
			<td>
				<form action="editar" method="GET">
					<input type="hidden" name="legajo" value="${alumno.legajo}" />
					<button class="btn btn-primary">Editar</button>
				</form>
			</td>
			<td>
				<form action="eliminar" method="POST">
					<input type="hidden" name="legajo" value="${alumno.legajo}" />
					<button class="btn btn-warning">Eliminar</button>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>