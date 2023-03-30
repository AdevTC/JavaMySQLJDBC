package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Esta clase representa la conexión a la base de datos
public class Conexion {
	//Atributos
	String user;
	String port;
	String hostname;
	String conector;
	String database;
	String password;
	String url;
	Connection con;
	
	//Constructor
	public Conexion(String user, String port, String hostname, String conector, String database, String password, String url) {
		//Inicializamos los atributos
		this.user = user;
		this.port = port;
		this.hostname = hostname;
		this.conector = conector;
		this.database = database;
		this.password = password;
		this.url = url;
	}

	//Método
	public Connection abrirConexion() throws ClassNotFoundException, SQLException {
		//Cargamos el driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Establecemos la conexión
		this.con = DriverManager.getConnection(this.url, this.user, this.password);
		//Devolvemos la conexión
		return this.con;
		
	}

}

