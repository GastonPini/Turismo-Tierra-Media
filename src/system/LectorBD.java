//package system;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import model.Atraccion;
//import model.Producto;
//import model.Promocion;
//import model.Usuario;
//import nomodel.Absoluta;
//import nomodel.AxB;
//import nomodel.Porcentual;
//
//public class LectorBD {
//
//	public ArrayList<Usuario> getUsuarios() {
//		return usuarios;
//	}
//
//	public ArrayList<Atraccion> getAtracciones() {
//		return atracciones;
//	}
//
//	public ArrayList<Promocion> getPromociones() {
//		return promociones;
//	}
//
//	protected ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//	protected ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
//	protected ArrayList<Promocion> promociones = new ArrayList<Promocion>();
//
//	public void levantarConexion() throws SQLException {
//		Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ignacio\\Desktop\\TurismoTierraMediaWeb\\database\\TierraMedia.db");
//		try {
//			PreparedStatement pstatement2 = conexion
//					.prepareStatement("SELECT Atraccion.ID, Atraccion.Nombre, Atraccion.Costo,"
//							+ " Atraccion.Tiempo, Atraccion.Cupo, TipoAtraccion.Nombre as 'Tipo'\n" + "FROM Atraccion\n"
//							+ "JOIN TipoAtraccion on Atraccion.Tipo = TipoAtraccion.ID");
//			ResultSet rs2 = pstatement2.executeQuery();
//			leerAtraccion(rs2);
//
//			PreparedStatement pstatement3 = conexion.prepareStatement("SELECT * FROM Promocion");
//			ResultSet rs3 = pstatement3.executeQuery();
//
//			PreparedStatement pstatement4 = conexion.prepareStatement("SELECT * FROM Atraccion_Promocion");
//			ResultSet rs4 = pstatement4.executeQuery();
//			leerPromocion(rs3, rs4);
//
//			PreparedStatement pstatement = conexion.prepareStatement("SELECT Usuario.ID, Usuario.Nombre,"
//					+ "TipoAtraccion.Nombre as Preferencia, Usuario.Presupuesto, Usuario.TiempoDisponible\n"
//					+ "FROM Usuario\n" + "JOIN TipoAtraccion on Usuario.Preferencia = TipoAtraccion.ID");
//			ResultSet rs = pstatement.executeQuery();
//
//			PreparedStatement pstatement5 = conexion.prepareStatement("SELECT * \n" + "FROM Itinerario");
//			ResultSet rs5 = pstatement5.executeQuery();
//			leerUsuario(rs, rs5);
//
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//		} finally {
//			try {
//				if (conexion != null)
//					conexion.close();
//			} catch (SQLException e) {
//				System.err.println(e.getMessage());
//			}
//		}
//	}
//
//	public void leerUsuario(ResultSet rs, ResultSet rs5) throws SQLException {
//		while (rs.next()) {
//			String id = rs.getString("ID");
//			String nombre = rs.getString("Nombre");
//			String preferencia = rs.getString("Preferencia");
//			String presupuesto = rs.getString("Presupuesto");
//			String tiempo = rs.getString("TiempoDisponible");
//			String esAdmin = rs.getString("es_admin");
//			String activo = rs.getString("activo");
//			//Usuario usuario = new Usuario(id, nombre, tiempo, presupuesto, preferencia, esAdmin, activo);
//			//usuarios.add(usuario);
//		}
//		while (rs5.next()) {
//			int idU = rs5.getInt("id_Usuario");
//			Integer idP = rs5.getInt("id_Promocion");
//			Integer idA = rs5.getInt("id_Atraccion");
//			/*if (idP.equals(0)) {
//				usuarios.get(idU - 1).setCompra(atracciones.get(idA - 1));
//			} else
//				usuarios.get(idU - 1).setCompra(promociones.get(idP - 1));*/
//		}
//	}
//
//	public void leerAtraccion(ResultSet rs) throws SQLException {
//		while (rs.next()) {
//			String id = rs.getString("ID");
//			String nombre = rs.getString("Nombre");
//			String costo = rs.getString("Costo");
//			String tiempo = rs.getString("Tiempo");
//			String cupo = rs.getString("Cupo");
//			String tipoAtraccion = rs.getString("Tipo");
//			//Atraccion atraccion = new Atraccion(id, nombre, costo, tiempo, cupo, tipoAtraccion);
//			//atracciones.add(atraccion);
//		}
//	}
//
//	public void leerPromocion(ResultSet rs, ResultSet rs2) throws SQLException {
//		while (rs.next()) {
//			String id = rs.getString("ID");
//			String nombre = rs.getString("Nombre");
//			String tipo = rs.getString("Tipo");
//			String datoExtra = rs.getString("DatoExtra");
//			ArrayList<Atraccion> lista = new ArrayList<Atraccion>();
///*
//			if (tipo.equals("Porcentual")) {
//				Promocion promocion = new Porcentual(id, nombre, lista, datoExtra);
//				promociones.add(promocion);
//			} else if (tipo.equals("Absoluta")) {
//				Promocion promocion = new Absoluta(id, nombre, lista, datoExtra);
//				promociones.add(promocion);
//			} else {
//				Atraccion gratis = null;
//				for (Atraccion atraccion : atracciones) {
//					if (atraccion.getNombre().equals(datoExtra)) {
//						gratis = atraccion;
//						lista.add(gratis);
//					}
//				}
//				Promocion promocion = new AxB(id, nombre, lista, gratis);
//				promociones.add(promocion);
//			}
//*/
//		}
//		while (rs2.next()) {
//			Integer promocionID = rs2.getInt("id_promocion");
//			Integer atraccionID = rs2.getInt("id_atraccion");
//			promociones.get(promocionID - 1).agregarAtraccion(atracciones.get(atraccionID - 1));
//		}
//	}
//
//	public void actualizarBaseDeDatos(ArrayList<Usuario> usuarios2, ArrayList<Atraccion> atracciones2)
//			throws SQLException {
//
//		Connection conexion = DriverManager.getConnection("jdbc:sqlite:database/TierraMedia.db");
//		try {
//			for (Usuario usuario1 : usuarios2) {
//				/*for (Producto compra : usuario1.getListaDeCompras()) {
//					if (compra.tipoClase().equals("Atraccion")) {
//						PreparedStatement pstatement = conexion.prepareStatement(
//									"INSERT INTO Itinerario\n" + "(\"id_Usuario\", \"id_Atraccion\")\n"
//										+ "SELECT " + usuario1.getId() + ", " + compra.getId() + " \n"
//										+ "WHERE NOT EXISTS(SELECT 1 FROM Itinerario WHERE  id_Usuario = "
//										+ usuario1.getId() + " AND id_Atraccion = " + compra.getId() + ");");
//						pstatement.executeUpdate();
//					} else {
//						PreparedStatement pstatement = conexion.prepareStatement(
//									"INSERT INTO Itinerario\n" + "	(\"id_Usuario\", \"id_Promocion\")\n" + "	SELECT "
//										+ usuario1.getId() + "," + compra.getId() + " \n"
//										+ "	WHERE NOT EXISTS(SELECT 1 FROM Itinerario WHERE  id_Usuario = "
//										+ usuario1.getId() + " AND id_Promocion = " + compra.getId() + ");");
//						pstatement.executeUpdate();
//					}
//				}*/
//			}
//
//			for (Usuario usuario1 : usuarios2) {
//				PreparedStatement pstatement = conexion.prepareStatement("UPDATE Usuario\n" + "SET Presupuesto = "
//						+ usuario1.getDineroDisponible() + ", TiempoDisponible = " + usuario1.getTiempoDisponible()
//						+ "\n" + "WHERE Usuario.ID = " + usuario1.getId() + ";");
//				pstatement.executeUpdate();
//
//			}
//
//			for (Atraccion atraccion : atracciones2) {
//				PreparedStatement pstatement = conexion.prepareStatement("UPDATE Atraccion\n" + "SET Cupo = "
//						+ atraccion.getCupo() + "\n" + "WHERE Atraccion.ID = " + atraccion.getId() + ";");
//				pstatement.executeUpdate();
//			}
//
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//		} finally {
//			try {
//				if (conexion != null)
//					conexion.close();
//			} catch (SQLException e) {
//				System.err.println(e.getMessage());
//			}
//		}
//
//	}
//
//}
