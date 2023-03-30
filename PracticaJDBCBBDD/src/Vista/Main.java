package Vista;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


import Controlador.Controlador_JDBC;
import Modelo.DireccionCli;


public class Main {
	
	// Una clase con main que permita interactuar y utilizar de forma accesible todos los m�todos del controlador. 
	// (Un men� de opciones que permita insertar, ver, actualizar y borrar datos de la tabla).

	private static Controlador_JDBC c = new Controlador_JDBC();
	//Este método nos permite seleccionar todas las direcciones de clientes
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Creamos un bucle para que el menú se repita hasta que el usuario lo desee
		boolean salir = false;
		int opcion;
		while (!salir) {
			System.out.println("********************************");
			System.out.println("1. Select All");
			System.out.println("2. Select By idCliente");
			System.out.println("3. Select By idDireccion");
			System.out.println("4. Delete By idDireccion");
			System.out.println("5. Insert Direccion");
			System.out.println("6. Update");
			System.out.println("0. Salir");
			System.out.println("********************************");
			//Creamos un try-catch para que el programa no se caiga si el usuario introduce un valor no válido
			try {
				opcion = sc.nextInt();
				switch (opcion) {
					case 1 -> {
						System.out.println("Ha usado la funci\u00f3n: Select All");
						selectAll();
					}
					case 2 -> {
						Scanner cli = new Scanner(System.in);
						System.out.println("Ha usado la funci\u00f3n: Select By idCliente");
						System.out.print("Introduce el id del cliente: ");
						int idCliente = cli.nextInt();
						selectByidCliente(idCliente);
					}
					case 3 -> {
						Scanner dir = new Scanner(System.in);
						System.out.println("Ha usado la funci\u00f3n: Select By idDireccion");
						System.out.print("Introduce el id de la direccion: ");
						int idDireccion = dir.nextInt();
						selectByidDireccion(idDireccion);
					}
					case 4 -> {
						Scanner d = new Scanner(System.in);
						System.out.println("Ha usado la funci\u00f3n: Delete By idDireccion");
						System.out.print("Introduce el id de la Direcci\u00f3n que quieres eliminar: ");
						int idDir = d.nextInt();
						delete(idDir);
					}
					case 5 -> {
						Scanner entero = new Scanner(System.in);
						Scanner cadena = new Scanner(System.in);
						System.out.println("Ha usado la funci\u00f3n: Insert Direccion");
						System.out.print("Introduce el id de la direcci\u00f3n: ");
						int idDir = entero.nextInt();
						System.out.print("Introduce el id del cliente: ");
						int idCli = entero.nextInt();
						System.out.print("Introduce el pa\u00eds: ");
						String pais = cadena.nextLine();
						System.out.print("Introduce la poblaci\u00f3n: ");
						String poblacion = cadena.nextLine();
						System.out.print("Introduce el c\u00f3digo postal: ");
						String cp = cadena.nextLine();
						System.out.print("Introduce la calle: ");
						String calle = cadena.nextLine();
						System.out.print("Introduce el n\u00famero: ");
						int numero = entero.nextInt();
						insert(idDir, idCli, pais, poblacion, cp, calle, numero);
					}
					case 6 -> {
						System.out.println("Ha seleccionado la opci\u00f3n de UPDATE");
						Scanner scanner = new Scanner(System.in);

						boolean salir2 = false;

						int opcion2;

						while (!salir2) {
							System.out.println("********************************");
							System.out.println("1. Update idCliente");
							System.out.println("2. Update Pa\u00eds");
							System.out.println("3. Update Poblaci\u00f3n");
							System.out.println("4. Update C\u00f3digo Postal");
							System.out.println("5. Update Calle");
							System.out.println("6. Update N\u00famero");
							System.out.println("0. Volver al Men\u00fa Principal");
							System.out.println("********************************");
							try {
								opcion2 = scanner.nextInt();
								switch (opcion2) {
									case 1 -> {
										Scanner cl = new Scanner(System.in);
										Scanner cl1 = new Scanner(System.in);
										System.out.println("Ha utilizado la funci\u00f3n: Update idCliente");
										System.out.print("Introduce el id de la direcci\u00f3n: ");
										int idDir = cl.nextInt();
										System.out.print("Introduce el nuevo id del cliente: ");
										int idCli = cl1.nextInt();
										if (c.updateDireccionCliIdCliente(idDir, idCli)){
											System.out.println("Cliente actualizado");
										} else {
											System.out.println("No se ha podido actualizar");
										}

									}
									case 2 -> {
										Scanner p = new Scanner(System.in);
										Scanner p1 = new Scanner(System.in);
										System.out.println("Ha utilizado la funci\u00f3n: Update País");
										System.out.print("Introduce el id de la direcci\u00f3n: ");
										int idDir = p.nextInt();
										System.out.print("Introduce el nuevo Pa\u00eds: ");
										String new_Pais = p1.nextLine();
										if (c.updateDireccionCliPais(idDir, new_Pais)){
											System.out.println("Pa\u00eds actualizado");
										} else {
											System.out.println("No se ha podido actualizar");
										}
									}
									case 3 -> {
										Scanner pb = new Scanner(System.in);
										Scanner pb1 = new Scanner(System.in);
										System.out.println("Ha utilizado la funci\u00f3n: Update Poblaci\u00f3n");
										System.out.print("Introduce el id de la direcci\u00f3n: ");
										int idDir = pb.nextInt();
										System.out.print("Introduce la nueva poblaci\u00f3n: ");
										String new_poblacion = pb1.nextLine();
										if (c.updateDireccionCliPoblacion(idDir, new_poblacion)){
											System.out.println("Poblaci\u00f3n actualizada");
										} else {
											System.out.println("No se ha podido actualizar");
										}

									}
									case 4 -> {
										Scanner cp = new Scanner(System.in);
										Scanner cp1 = new Scanner(System.in);
										System.out.println("Ha utilizado la función: Update C\u00f3digo Postal");
										System.out.print("Introduce el id de la direcci\u00f3n: ");
										int idDir = cp.nextInt();
										System.out.print("Introduce el nuevo c\u00f3digo postal: ");
										String new_cp = cp1.nextLine();
										if (c.updateDireccionClicodPostal(idDir, new_cp)){
											System.out.println("C\u00f3digo Postal actualizado");
										} else {
											System.out.println("No se ha podido actualizar");
										}

									}
									case 5 -> {
										Scanner ca = new Scanner(System.in);
										Scanner ca1 = new Scanner(System.in);
										System.out.println("Ha utilizado la funci\u00f3n: Update Calle");
										System.out.print("Introduce el id de la direcci\u00f3n: ");
										int idDir = ca.nextInt();
										System.out.print("Introduce la nueva calle: ");
										String new_Calle = ca1.nextLine();
										if (c.updateDireccionCliCalle(idDir, new_Calle)){
											System.out.println("Calle actualizada");
										} else {
											System.out.println("No se ha podido actualizar");
										}

									}
									case 6 -> {
										Scanner num = new Scanner(System.in);
										System.out.println("Ha utilizado la funci\u00f3n: Update Numero");
										System.out.print("Introduzca el id de la direcci\u00f3n: ");
										int idDir = num.nextInt();
										System.out.print("Introduce el nuevo n\u00famero: ");
										int new_numero = num.nextInt();
										if (c.updateDireccionCliNumero(idDir, new_numero)){
											System.out.println("N\u00famero actualizado");
										} else {
											System.out.println("No se ha podido actualizar");
										}
									}
									case 0 -> {
										System.out.println( "\u00BFSeguro que quieres volver al men\u00fa principal?");
										System.out.println("(s/n)");
										Scanner volver = new Scanner(System.in);
										String vuelta = volver.nextLine();

										switch (vuelta) {
											case "s", "S" ->
													salir2 = true;


											default -> {
												System.out.println("\n Error, escribe una opci\u00f3n v\u00e1lida. \n");
												salir = true;
											}
										}
									}

									default ->
											System.out.print("Introduce una de las opciones que se te han mostrado: ");
								} // Final control de errores en ejecución.

							} catch (InputMismatchException e) {
								// "catch" se ejecuta al producirse errores de ejecución dentro de "try".
								System.err.println("Debes insertar un valor v\u00e1lido seg\u00fan la opci\u00f3n elegida");
								scanner.next();
							}
						} // Final del while (!salir2)
					}
					case 0 ->
							salir = true;
					default ->
							System.out.println("Introduce una de las opciones que se te han mostrado");
				} // Final control de errores en ejecución.

			} catch (InputMismatchException e) {
				// "catch" se ejecuta al producirse errores de ejecución dentro de "try".
				System.err.println("Debes insertar un valor v\u00e1lido seg\u00fan la opci\u00f3n elegida");
				sc.next();
			}
		} // Final del while (!salir)
		


	}

	public static void selectAll() {
		ArrayList<DireccionCli> lista = c.selectAll();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}

	public static void selectByidCliente(int idCliente) {
		DireccionCli direccion = c.selectByidCliente(idCliente);
		System.out.println(direccion);
	}

	public static void selectByidDireccion(int idDireccion) {
		DireccionCli byidDireccion = c.selectByidDireccion(idDireccion);
		System.out.println(byidDireccion);
	}

	public static void delete(int idDireccion) {
		boolean delete = c.delete_ByidDireccion(idDireccion);
		System.out.println(delete);
	}


	public static void insert(int idDireccion, int idCliente, String pais, String poblacion, String codPostal, String calle, int numero) {
		boolean insert = c.insertDireccionCli(idDireccion, idCliente, pais, poblacion, codPostal, calle, numero);
		System.out.println(insert);
	}

}
