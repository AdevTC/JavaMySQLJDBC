package Modelo;

public class DireccionCli {
    // ESTA CLASE REPRESENTARÁ UNA TABLA DE LA PRÁCTICA DE BBDD DE NAVIDAD (TENDRÁ QUE TENER MÁS DE 4 ATRIBUTOS)
    private int idDireccion;
    private int idCliente;
    private String pais;
    private String poblacion;
    private String codPostal;
    private String calle;
    private int numero;

    // Aquí creamos el constructor.
    public DireccionCli(int idDireccion, int idCliente, String pais, String poblacion, String codPostal, String calle, int numero) {
        this.idDireccion = idDireccion;
        this.idCliente = idCliente;
        this.pais = pais;
        this.poblacion = poblacion;
        this.codPostal = codPostal;
        this.calle = calle;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "DireccionCli [idDireccion=" + idDireccion + ", idCliente=" + idCliente + ", pais=" + pais
                + ", poblacion=" + poblacion + ", codPostal=" + codPostal + ", calle=" + calle + ", numero=" + numero
                + "]";
    }
}
