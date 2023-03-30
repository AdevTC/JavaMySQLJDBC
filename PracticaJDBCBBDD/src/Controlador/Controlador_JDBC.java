package Controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Conexion;
import Modelo.DireccionCli;
import Modelo.DireccionCliDAO;

    // Esta clase será clase base con todos los métodos CRUD (insert, read, update, delete) y al menos 2 consultas extra
    // (buscar por nombre, o por salario o por otro campo o actualizar por un solo campo).
public class Controlador_JDBC implements DireccionCliDAO {

    // Declaramos cadenas de consulta SQL para la tabla "DIRECCIONCLI"
    // Consulta para seleccionar todos los registros de la tabla "DIRECCIONCLI"

    public final String SELECT_ALL = "SELECT * FROM DIRECCIONCLI";
    // Consulta para seleccionar registros que coinciden con un "idCliente" específico
    public final String SELECT_BY_IDCLIENTE = "SELECT * FROM DIRECCIONCLI WHERE idCliente = ?";
    // Consulta para seleccionar registros que coinciden con un "idDireccion" específico
    public final String SELECT_BY_IDDIRECCION = "SELECT * FROM DIRECCIONCLI WHERE idDireccion = ?";
    // Consulta para eliminar registros que coinciden con un "idDireccion" específico
    public final String DELETE_BY_IDDIRECCION = "delete FROM direccionCli WHERE idDireccion = ?";
    // Consulta para insertar nuevos registros en la tabla "DIRECCIONCLI"
    public final String INSERT = "insert into direccioncli values (?,?,?,?,?,?,?)";
    // Consulta para actualizar el campo "idCliente" de un registro que coincide con un "idDireccion" específico
    public final String UPDATE_IDCLIENTE = "update direccioncli set idCliente = ? where idDireccion = ?";
    // Consulta para actualizar el campo "Pais" de un registro que coincide con un "idDireccion" específico
    public final String UPDATE_PAIS = "update direccioncli set Pais = ? where idDireccion = ?";
    // Consulta para actualizar el campo "poblacion" de un registro que coincide con un "idDireccion" específico
    public final String UPDATE_POBLACION = "update direccioncli set poblacion = ? where idDireccion = ?";
    // Consulta para actualizar el campo "codPostal" de un registro que coincide con un "idDireccion" específico
    public final String UPDATE_CP = "update direccioncli set codPostal = ? where idDireccion = ?";
    // Consulta para actualizar el campo "calle" de un registro que coincide con un "idDireccion" específico
    public final String UPDATE_CALLE = "update direccioncli set calle = ? where idDireccion = ?";
    // Consulta para actualizar el campo "numero" de un registro que coincide con un "idDireccion" específico
    public final String UPDATE_NUMERO = "update direccioncli set numero = ? where idDireccion = ?";

    // Declaramos una clase "Controlador_JDBC" para gestionar la conexión y el acceso a la base de datos
    // Establecemos los parámetros de conexión con la base de datos (usuario, contraseña, host, etc.) utilizando
    // un objeto "Conexion"
    // Intentamos abrir una conexión utilizando el método "abrirConexion()" del objeto "Conexion"
    // Si se produce algún error al intentar abrir la conexión, se muestra el error en la consola mediante
    // "e.printStackTrace()" y se establece la conexión a "null"
    private Connection con;

    // Constructor de la clase "Controlador_JDBC"
    // Establecemos los parámetros de conexión con la base de datos utilizando un objeto "Conexion"
    // Intentamos abrir una conexión utilizando el método "abrirConexion()" del objeto "Conexion"
    // Si se produce algún error al intentar abrir la conexión, se muestra el error en la consola mediante
    // "e.printStackTrace()" y se establece la conexión a "null"
    public Controlador_JDBC() {
        // Establecemos los parámetros de conexión con la base de datos utilizando un objeto "Conexion"
        Conexion conector = new Conexion("root", "3306", "127.0.0.1", "jdbc:mysql",
                "practicanavidad", "root",
                "jdbc:mysql://127.0.0.1:3306/practicanavidad?characterEncoding=latin1&useConfigs=maxPerformance");

        try {
            // Intentamos abrir una conexión utilizando el método "abrirConexion()" del objeto "Conexion"
            con = conector.abrirConexion();
        } catch (ClassNotFoundException | SQLException e) {
            // Si se produce algún error al intentar abrir la conexión, se muestra el error en la consola mediante
            // "e.printStackTrace()" y se establece la conexión a "null"
            e.printStackTrace();
            con = null;
        }

    }

    // Implementamos el método "selectAll()" de la interfaz "IDireccionCliDAO" que se encarga de recuperar todas las direcciones de la tabla "DIRECCIONCLI" de la base de datos
    // Creamos un ArrayList vacío para almacenar las direcciones recuperadas
    // Utilizamos un objeto "Statement" para ejecutar una consulta a la base de datos utilizando la constante "SELECT_ALL"
    // Procesamos el resultado de la consulta utilizando un objeto "ResultSet" y un bucle "while"
    // Por cada fila de la tabla "DIRECCIONCLI" obtenida en el "ResultSet", creamos un objeto "DireccionCli" con los datos de la fila y lo añadimos al ArrayList
    // Si se produce algún error al intentar acceder a la base de datos, se muestra el error en la consola mediante "e.printStackTrace()" y se establece el ArrayList a "null"
    // Devolvemos el ArrayList de direcciones
    @Override
    public ArrayList<DireccionCli> selectAll() {
    // Creamos un ArrayList vacío para almacenar las direcciones recuperadas
        ArrayList<DireccionCli> lista = new ArrayList<>();

        try {
            // Utilizamos un objeto "Statement" para ejecutar una consulta a la base de datos utilizando la constante "SELECT_ALL"
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL);

            // Procesamos el resultado de la consulta utilizando un objeto "ResultSet" y un bucle "while"
            while (rs.next()) {
                // Por cada fila de la tabla "DIRECCIONCLI" obtenida en el "ResultSet", creamos un objeto "DireccionCli" con los datos de la fila y lo añadimos al ArrayList
                DireccionCli direccion = new DireccionCli(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                lista.add(direccion);
            }
        } catch (SQLException e) {
            // Si se produce algún error al intentar acceder a la base de datos, se muestra el error en la consola mediante "e.printStackTrace()" y se establece el ArrayList a "null"
            e.printStackTrace();
            lista = null;
        }
    // Devolvemos el ArrayList de direcciones
        return lista;

    }

    // Implementamos el método "selectByidCliente()" de la interfaz "IDireccionCliDAO" que se encarga de recuperar
    // una dirección de la tabla "DIRECCIONCLI" de la base de datos
    // Utilizamos un objeto "PreparedStatement" para ejecutar una consulta a la base de datos utilizando la
    // constante "SELECT_BY_IDCLIENTE"
    // Procesamos el resultado de la consulta utilizando un objeto "ResultSet"
    // Creamos un objeto "DireccionCli" con los datos de la fila obtenida en el "ResultSet"
    // Si se produce algún error al intentar acceder a la base de datos, se muestra el error en la consola
    // mediante "e.printStackTrace()" y se establece el objeto "DireccionCli" a "null"
    // Devolvemos el objeto "DireccionCli" creado
    @Override
    public DireccionCli selectByidCliente(int idCliente) {

        try {
            // Preparamos la consulta SQL con el idCliente proporcionado
            PreparedStatement ps = con.prepareStatement(SELECT_BY_IDCLIENTE);
            ps.setInt(1, idCliente);

            // Ejecutamos la consulta y obtenemos los resultados
            ResultSet rs = ps.executeQuery();

            // Nos movemos al primer resultado obtenido
            rs.next();

            // Creamos un objeto DireccionCli con los datos obtenidos de la consulta
            DireccionCli direccion = new DireccionCli(rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getInt(7));

            // Devolvemos el objeto DireccionCli creado
            return direccion;

        } catch (SQLException e) {
            // Si ocurre una excepción, imprimimos un mensaje de error y devolvemos null
            System.err.println("Ese cliente no est\u00e1 registrado");
            return null;
        }
    }


    // Implementamos el método "selectByPais()" de la interfaz "IDireccionCliDAO" que se encarga de recuperar las
    // direcciones de la tabla "DIRECCIONCLI" de la base de datos que coincidan con un país específico
    // Creamos un ArrayList vacío para almacenar las direcciones recuperadas
    // Utilizamos un objeto "PreparedStatement" para ejecutar una consulta a la base de datos utilizando
    // la constante "SELECT_BY_PAIS"
    // Procesamos el resultado de la consulta utilizando un objeto "ResultSet" y un bucle "while"
    // Por cada fila de la tabla "DIRECCIONCLI" obtenida en el "ResultSet", creamos un objeto "DireccionCli"
    // con los datos de la fila y lo añadimos al ArrayList
    // Si se produce algún error al intentar acceder a la base de datos, se muestra el error en la consola
    // mediante "e.printStackTrace()" y se establece el ArrayList a "null"
    // Devolvemos el ArrayList de direcciones
    @Override
    public DireccionCli selectByidDireccion(int idDireccion) {

        try {
            PreparedStatement ps = con.prepareStatement(SELECT_BY_IDDIRECCION);
    // "SELECT * FROM DIRECCIONCLI where Pais like ?"
            ps.setInt(1, idDireccion);
            ResultSet rs = ps.executeQuery();
            rs.next();
    // Para obtener los datos: rs.getInt(1), rs.getString(2)...;
    // rellenamos el objeto DireccionCli con los datos obtenidos
            DireccionCli direccion = new DireccionCli(rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getInt(7));
            return direccion;

        } catch (SQLException e) {
            System.err.println("Ese idDireccion no est\u00e1 registrado en ninguna de las direcciones.");
            return null;
        }
    }

    // Este método actualiza los datos de una dirección en la base de datos
    // Si se produce algún error al intentar acceder a la base de datos, se muestra el error en la consola
    // mediante "e.printStackTrace()" y se devuelve false
    // Si no se produce ningún error, se devuelve true
    @Override
    public boolean delete_ByidDireccion(int idDireccion) {
        try {
            // Preparamos una sentencia SQL para eliminar la dirección
            PreparedStatement ps = con.prepareStatement(DELETE_BY_IDDIRECCION);
            ps.setInt(1, idDireccion);
            // Ejecutamos la sentencia y comprobamos si se ha eliminado la dirección
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Si se produce una excepción, significa que la dirección no se ha eliminado
            System.err.println("Ese id de Dirección no est\u00e1 registrado.");
            return false;
        }
    }


    // Este método inserta una nueva dirección en la base de datos
    // Si se produce algún error al intentar acceder a la base de datos, se muestra el error en la consola
    // mediante "e.printStackTrace()" y se devuelve false
    // Si no se produce ningún error, se devuelve true
    @Override
    public boolean insertDireccionCli(int idDireccion, int idCliente, String pais, String poblacion, String codPostal, String calle, int numero) {
        try {
            // Preparamos la sentencia SQL
            PreparedStatement ps = con.prepareStatement(INSERT);
            // Seteamos los valores en los parámetros de la sentencia
            ps.setInt(1, idDireccion);
            ps.setInt(2, idCliente);
            ps.setString(3, pais);
            ps.setString(4, poblacion);
            ps.setString(5, codPostal);
            ps.setString(6, calle);
            ps.setInt(7, numero);
            // Ejecutamos la sentencia
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            // Si se produce una excepción, la capturamos y mostramos un mensaje de error
            System.err.println("Error al registrar la direcci\u00f3n.");
            return false;
        }
    }

    // Este método actualiza el id del cliente de una dirección en la base de datos, recibiendo como parámetros
    // el id de la dirección y el nuevo id del cliente
    @Override
    public boolean updateDireccionCliIdCliente(int idDireccion, int new_idCliente) {
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_IDCLIENTE);
            // Se prepara la sentencia SQL UPDATE para actualizar el campo idCliente de la dirección con el id especificado
            ps.setInt(1, new_idCliente);
            ps.setInt(2, idDireccion);
            // Se ejecuta la sentencia SQL
            ps.executeUpdate();
            // Si la ejecución de la sentencia SQL no produce errores, se devuelve true
            return true;
        } catch (SQLException e) {
            // Si se produce un error al ejecutar la sentencia SQL, se muestra un mensaje de error y se devuelve false
            System.err.println("Error al actualizar el id del cliente.");
            return false;
        }
    }

    // Este método actualiza el país de una dirección en la base de datos, recibiendo como parámetros
    // el id de la dirección y el nuevo país.
    @Override
    public boolean updateDireccionCliPais(int idDireccion, String new_Pais) {
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_PAIS);
            // Se prepara la sentencia SQL UPDATE para actualizar el campo Pais de la dirección con el id especificado
            ps.setString(1, new_Pais);
            ps.setInt(2, idDireccion);
            // Se ejecuta la sentencia SQL
            ps.executeUpdate();
            // Si la ejecución de la sentencia SQL no produce errores, se devuelve true
            return true;
        } catch (SQLException e) {
            // Si se produce un error al ejecutar la sentencia SQL, se muestra un mensaje de error y se devuelve false
            System.err.println("Error al actualizar el pa\u00eds");
            return false;
        }
    }

    // Este método actualiza la población de una dirección en la base de datos, recibiendo como parámetros
    // el id de la dirección y la nueva población.
    @Override
    public boolean updateDireccionCliCalle(int idDireccion, String new_Calle) {
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_CALLE);
            // Se prepara la sentencia SQL UPDATE para actualizar el campo calle de la dirección con el id especificado
            ps.setString(1, new_Calle);
            ps.setInt(2, idDireccion);
            // Se ejecuta la sentencia SQL
            ps.executeUpdate();
            // Si la ejecución de la sentencia SQL no produce errores, se devuelve true
            return true;
        } catch (SQLException e) {
            // Si se produce un error al ejecutar la sentencia SQL, se muestra un mensaje de error y se devuelve false
            System.err.println("Error al actualizar la calle");
            return false;
        }
    }

    // Este método actualiza el número de una dirección en la base de datos, recibiendo como parámetros
    // el id de la dirección y el nuevo número.
    @Override
    public boolean updateDireccionCliNumero(int idDireccion, int new_numero) {
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_NUMERO);
            ps.setInt(1, new_numero);
            ps.setInt(2, idDireccion);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar el n\u00famero.");
            return false;
        }
    }

    // Este método actualiza la población de una dirección en la base de datos, recibiendo como parámetros
    // el id de la dirección y la nueva población.
    @Override
    public boolean updateDireccionCliPoblacion(int idDireccion, String new_poblacion) {
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_POBLACION);
            ps.setString(1, new_poblacion);
            ps.setInt(2, idDireccion);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar la poblaci\u00f3n.");
            return false;
        }
    }

    // Este método actualiza el código postal de una dirección en la base de datos, recibiendo como parámetros
    // el id de la dirección y el nuevo código postal.
    @Override
    public boolean updateDireccionClicodPostal(int idDireccion, String new_codPostal) {
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_CP);
            ps.setString(1, new_codPostal);
            ps.setInt(2, idDireccion);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar el c\u00f3digo postal.");
            return false;
        }
    }
}
