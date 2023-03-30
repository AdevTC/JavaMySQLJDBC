package Modelo;

import java.util.ArrayList;

public interface DireccionCliDAO {

    // Esta interfaz proporciona una clase base con todos los métodos CRUD (insert, read, update, delete) y al menos 2 consultas extra
    // (buscar por nombre, o por salario o por otro campo o actualizar por un solo campo).

    // Obtiene todas las direcciones de clientes
    public ArrayList<DireccionCli> selectAll();

    // Obtiene una dirección de cliente según su idDirección
    public DireccionCli selectByidDireccion(int idDireccion);

    // Obtiene una dirección de cliente según su idCliente
    public DireccionCli selectByidCliente(int idCliente);

    // Inserta una nueva dirección de cliente en la base de datos
    public boolean insertDireccionCli(int idDireccion, int idCliente, String pais, String poblacion, String codPostal, String calle, int numero);

    // Elimina una dirección de cliente según su idDirección
    public boolean delete_ByidDireccion(int idDireccion);

    // Actualiza el idCliente de una dirección de cliente según su idDirección
    public boolean updateDireccionCliIdCliente(int idDireccion, int new_idCliente);

    // Actualiza el país de una dirección de cliente según su idDirección
    public boolean updateDireccionCliPais(int idDireccion, String new_Pais);

    // Actualiza la calle de una dirección de cliente según su idDirección
    public boolean updateDireccionCliCalle(int idDireccion, String new_calle);

    // Actualiza el número de una dirección de cliente según su idDirección
    public boolean updateDireccionCliNumero(int idDireccion, int numero);

    // Actualiza la población de una dirección de cliente según su idDirección
    public boolean updateDireccionCliPoblacion(int idDireccion, String poblacion);

    // Actualiza el código postal de una dirección de cliente según su idDirección
    public boolean updateDireccionClicodPostal(int idDireccion, String codPostal);
}

