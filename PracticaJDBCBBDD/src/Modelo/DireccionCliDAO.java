package Modelo;

import java.util.ArrayList;

public interface DireccionCliDAO {

    // Esta interfaz proporciona una clase base con todos los m�todos CRUD (insert, read, update, delete) y al menos 2 consultas extra
    // (buscar por nombre, o por salario o por otro campo o actualizar por un solo campo).

    // Obtiene todas las direcciones de clientes
    public ArrayList<DireccionCli> selectAll();

    // Obtiene una direcci�n de cliente seg�n su idDirecci�n
    public DireccionCli selectByidDireccion(int idDireccion);

    // Obtiene una direcci�n de cliente seg�n su idCliente
    public DireccionCli selectByidCliente(int idCliente);

    // Inserta una nueva direcci�n de cliente en la base de datos
    public boolean insertDireccionCli(int idDireccion, int idCliente, String pais, String poblacion, String codPostal, String calle, int numero);

    // Elimina una direcci�n de cliente seg�n su idDirecci�n
    public boolean delete_ByidDireccion(int idDireccion);

    // Actualiza el idCliente de una direcci�n de cliente seg�n su idDirecci�n
    public boolean updateDireccionCliIdCliente(int idDireccion, int new_idCliente);

    // Actualiza el pa�s de una direcci�n de cliente seg�n su idDirecci�n
    public boolean updateDireccionCliPais(int idDireccion, String new_Pais);

    // Actualiza la calle de una direcci�n de cliente seg�n su idDirecci�n
    public boolean updateDireccionCliCalle(int idDireccion, String new_calle);

    // Actualiza el n�mero de una direcci�n de cliente seg�n su idDirecci�n
    public boolean updateDireccionCliNumero(int idDireccion, int numero);

    // Actualiza la poblaci�n de una direcci�n de cliente seg�n su idDirecci�n
    public boolean updateDireccionCliPoblacion(int idDireccion, String poblacion);

    // Actualiza el c�digo postal de una direcci�n de cliente seg�n su idDirecci�n
    public boolean updateDireccionClicodPostal(int idDireccion, String codPostal);
}

