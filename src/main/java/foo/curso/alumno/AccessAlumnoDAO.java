package foo.curso.alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import com.jolbox.bonecp.BoneCPDataSource;

import foo.curso.entities.Alumno;

public class AccessAlumnoDAO {
	private DataSource ds;
	
	private AccessAlumnoDAO (){
		ds = setupDataSource();
	}
	private static final AccessAlumnoDAO INSTANCE = new AccessAlumnoDAO(); 

	/* Private constructor prevents 
	 * instantiation from other classes */

	public static AccessAlumnoDAO getInstance() { 
		return INSTANCE; 
	}
	
	public DataSource setupDataSource() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		String url = "jdbc:mysql://localhost/capacitacion";
		String user = "root";
		String password = "";

		// Class.forName("org.hsqldb.jdbcDriver"); 	// load the DB driver
		BoneCPDataSource ds = new BoneCPDataSource();  // create a new datasource object
	 	ds.setJdbcUrl(url);		// set the JDBC url
		ds.setUsername(user);				// set the username
		ds.setPassword(password);				// set the password
		ds.setMinConnectionsPerPartition(5);
		
		return ds;
	}

	public Alumno get(int legajo) {
		Alumno alumno = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			conn = ds.getConnection();
			stmt = conn.prepareStatement("SELECT nombre, apellido, legajo, nacimiento FROM alumno WHERE legajo = ?");
			stmt.setInt(1,legajo);
			rs = stmt.executeQuery();

			if(rs.next()){
				String nombre = rs.getString(1);
				String apellido = rs.getString(2);
				int leg = rs.getInt(3);
				Date nacimiento = rs.getDate(4);

				alumno = new Alumno(nombre, apellido, leg, nacimiento);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return alumno;
	}

	public ArrayList<Alumno> getAll() {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			conn = ds.getConnection();
			stmt = conn.prepareStatement("SELECT nombre, apellido, legajo, nacimiento FROM alumno ORDER BY nombre");
			rs = stmt.executeQuery();

			while(rs.next()){
				String nombre = rs.getString(1);
				String apellido = rs.getString(2);
				int legajo = rs.getInt(3);
				Date nacimiento = rs.getDate(4);

				Alumno alumno = new Alumno(nombre, apellido, legajo, nacimiento);

				alumnos.add(alumno);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return alumnos;
	}

	public void save(Alumno unAlumno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = ds.getConnection();
			stmt = conn.prepareStatement("UPDATE alumno SET nombre = ?, apellido = ?, nacimiento = ? WHERE legajo = ?");
			stmt.setString(1, unAlumno.getNombre());
			stmt.setString(2, unAlumno.getApellido());
			stmt.setDate(3,	new java.sql.Date(unAlumno.getNacimiento().getTime()));
			stmt.setInt(4, unAlumno.getLegajo());
			stmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//TODO: agregar manejo de Autonumérico
	public void crear(Alumno unAlumno){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = ds.getConnection();
			stmt = conn.prepareStatement("INSERT INTO alumno (nombre,apellido,nacimiento) VALUES (?,?,?)");
			stmt.setString(1, unAlumno.getNombre());
			stmt.setString(2, unAlumno.getApellido());
			stmt.setDate(3, new java.sql.Date(unAlumno.getNacimiento().getTime()));
			stmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void eliminar(int legajo){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = ds.getConnection();
			stmt = conn.prepareStatement("DELETE FROM alumno WHERE legajo = ?");
			stmt.setInt(1, legajo);
			stmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
