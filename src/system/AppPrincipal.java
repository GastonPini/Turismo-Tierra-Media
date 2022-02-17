//package system;
//
//import java.io.InputStream;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//import model.Atraccion;
//import model.Producto;
//import model.Promocion;
//import model.Usuario;
//
//public class AppPrincipal {
//
//	public static void main(String[] args) throws SQLException {
//		LectorBD lector = new LectorBD();
//		lector.levantarConexion();
//		Catalogador ordenador = new Catalogador();
//
//		ArrayList<Usuario> usuarios = lector.getUsuarios();
//		ArrayList<Atraccion> atraccion = lector.getAtracciones();
//		ArrayList<Promocion> promocion = lector.getPromociones();
//
//		ordenador.ordenarAtraccionMaxCosto(atraccion);
//		ordenador.ordenarPromocionMaxCosto(promocion);
//
//		InputStream stream = System.in;
//		Scanner scanner = new Scanner(stream);
//		ArrayList<Atraccion> sugerenciaUsuario = new ArrayList<Atraccion>();
//		System.out.println("Sistema de sugerencia, compra y generacion de itinerario. Realizado por el grupo Imparable Team. A quienes ningun bug va a parar. O si?");
//		for (Usuario usuario : usuarios) {
//			System.out.println("Bienvenido usuario: " + usuario.getUsername());
//			sugerenciaUsuario = ordenador.listaDeSugerencias(usuario, atraccion/*, promocion*/);
//			for (Producto producto : sugerenciaUsuario) {
//				if (usuario.puedeComprar(producto)) {
//					System.out.println(usuario);
//					System.out.println("�Desea comprar el siguiente producto: " + producto.getNombre() + "?");
//					System.out.println(producto);
//					System.out.print("Ingrese S/N: ");
//					boolean terminado = false;
//					do {
//						String opcion = scanner.next();
//						if (opcion.equals("S") || opcion.equals("s")) {
//							ordenador.comprar(usuario,(Atraccion) producto);
//							System.out.println("Comprado!");
//							terminado = true;
//							System.out.println("");
//						} else if (opcion.equals("N") || opcion.equals("n")) {
//							terminado = true;
//							System.out.println("");
//						} else {
//							System.out.println("No se reconoce este comando.");
//							System.out.print("Por favor ingrese S/N: ");
//						}
//					} while (!terminado);
//
//				}
//			}
//			System.out.println("\n");
//		}
//		System.out.println("Gracias por Comprar, vuelvas prontos.");
//		scanner.close();
//		lector.actualizarBaseDeDatos(usuarios, atraccion);
//		System.exit(0);
//
//	}
//
//	public static void numerarLista(LinkedList<Producto> lista) {
//		int contador = 1;
//		for (Producto p : lista) {
//			System.out.println(contador + " " + p.toString());
//			contador++;
//		}
//	}
//
//}
