package foo.curso.entities;

import java.util.Date;

public class Alumno {
	private String nombre;
	private String apellido;
	private int legajo;
	private Date nacimiento;
	
	public Alumno(String nombre, String apellido, int legajo, Date nacimiento){
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.nacimiento = nacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	@Override
	public String toString(){
		return this.nombre + " " + this.apellido;
	}
	
	public static Alumno crearAlumno(String nombre, String apellido, int legajo, Date nacimiento){
		Alumno alumno = new Alumno(nombre, apellido, legajo, nacimiento);
		
		//Voy a guardar el alumno en la base de datos
		/*String url = "jdbc:mysql://localhost/capacitacion";
		String user = "root";
		String password = "";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement("INSERT INTO alumno (nombre,apellido,legajo,nacimiento) VALUES (?,?,?,?)");
			stmt.setString(1, alumno.nombre);
			stmt.setString(2, alumno.apellido);
			stmt.setInt(3, alumno.legajo);
			stmt.setDate(4, new java.sql.Date(alumno.nacimiento.getTime()));
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
		}*/
		
		return alumno;
	}

	/*public static ArrayList<Alumno> getAll() {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		//Voy a obtener todos los alumnos del a db.
		String url = "jdbc:mysql://localhost/captton";
		String user = "root";
		String password = "";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement("SELECT nombre, apellido, legajo, nacimiento FROM alumnos ORDER BY nombre");
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
	}*/
	
	/*public static Alumno get(int legajo) {
		Alumno alumno = null;
		
		//Voy a obtener todos los alumnos del a db.
		String url = "jdbc:mysql://localhost/captton";
		String user = "root";
		String password = "";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement("SELECT nombre, apellido, legajo, nacimiento FROM alumnos WHERE legajo = ?");
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
	}*/

	/*public void save() {
		//Voy a guardar el alumno en la base de datos
		String url = "jdbc:mysql://localhost/captton";
		String user = "root";
		String password = "";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement("UPDATE alumnos SET nombre = ?, apellido = ?, nacimiento = ? WHERE legajo = ?");
			stmt.setString(1, this.nombre);
			stmt.setString(2, apellido);
			stmt.setDate(3,	new java.sql.Date(nacimiento.getTime()));
			stmt.setInt(4, this.legajo);
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
	
	*/
	
}
