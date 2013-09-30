<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<h1>Editar Alumno</h1>

<form action="editar" method="POST">
	<h3>Legajo: ${alumno.legajo}</h3>
	<input type="text" name="nombre" placeholder="Nombre" value="${alumno.nombre}" />
	<br />
	<input type="text" name="apellido" placeholder="Apellido" value="${alumno.apellido}" />
	<br />
	<input type="hidden" name="legajo" placeholder="Legajo" value="${alumno.legajo}" />
	<input type="text" name="dia" placeholder="Dia" value="${alumno.nacimiento.getDate()}"/>
	<input type="text" name="mes" placeholder="Mes" value="${alumno.nacimiento.getMonth()+1}"/>
	<input type="text" name="año" placeholder="Año" value="${alumno.nacimiento.getYear()+1900}"/>
	<button class="btn btn-info">Guardar</button>
</form>