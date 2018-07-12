package databaseUtils ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Category;
import beans.Hardware;
import beans.Room;

public class DBRoomsUtils {
	// ------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------
	private final static String QUERY_FIND_ROOMS = "SELECT * FROM room";
	private final static String QUERY_FIND_ONE_ROOM = "SELECT * FROM room WHERE name_room=(?)";
	private final static String QUERY_FIND_ONE_ROOM_BY_ID = "SELECT * FROM room WHERE id_room=(?)";
	private final static String QUERY_INSERT_ROOM = "insert into room values (null, (?))";
	private final static String QUERY_DELETE_ROOM = "DELETE FROM room where id=(?)";
	
	// ------------------------------------------------------------
	// Gets all Messages from the DB
	// ------------------------------------------------------------
	public static ArrayList<Room> returnAllRooms() throws Exception, SQLException {
		
		ArrayList<Room> roomsList = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		// PreparedStatement stmtUser = null;

		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmt = con.createStatement();

			// Execute SQL instruction for finding messages
			ResultSet rSetRooms = stmt.executeQuery(QUERY_FIND_ROOMS);

			// Convert the SLQ Table into an arrayList of MessageBean
			while (rSetRooms.next()) {

				// Then converts the Message Table into an ArrayList of Messages
				roomsList.add(rsetToRooms(rSetRooms));
			}
			return roomsList;
		} finally {
			// Close the connection
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static ArrayList<Room> returnOneRoom(Room room) throws Exception, SQLException {
		
		ArrayList<Room> roomsList = new ArrayList<>();

			Connection con = null;
			PreparedStatement stmtNumber = null;

			try {
				// Relative instruction to work with Tomcat and Mysql
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
				stmtNumber = con.prepareStatement(QUERY_FIND_ONE_ROOM);

				stmtNumber.setString(1, room.getName());
				
				ResultSet resultSet = stmtNumber.executeQuery();
				
				while (resultSet.next()) {

					roomsList.add(rsetToRooms(resultSet));
				}
				
				return roomsList;
				
			} finally {
				// Close the connection
				if (con != null) {
					try {
						con.close();
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
public static ArrayList<Room> returnOneRoomByID( int id) throws Exception, SQLException {
		
		ArrayList<Room> roomsList = new ArrayList<>();

			Connection con = null;
			PreparedStatement stmtNumber = null;

			try {
				// Relative instruction to work with Tomcat and Mysql
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
				stmtNumber = con.prepareStatement(QUERY_FIND_ONE_ROOM_BY_ID);

				stmtNumber.setInt(1, id);
				
				ResultSet resultSet = stmtNumber.executeQuery();
				
				while (resultSet.next()) {

					roomsList.add(rsetToRooms(resultSet));
				}
				
				return roomsList;
				
			} finally {
				// Close the connection
				if (con != null) {
					try {
						con.close();
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
	public static void insertRoom( Room room ) throws Exception, SQLException {

		Connection con = null;
		PreparedStatement stmtHardware = null;
	
		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmtHardware = con.prepareStatement(QUERY_INSERT_ROOM);
	
			stmtHardware.setString(1, room.getName());
			stmtHardware.executeUpdate();
			
		} finally {
			// Close the connection
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void deleteRoom( Room room ) throws Exception, SQLException {

		Connection con = null;
		PreparedStatement stmtHardware = null;

		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmtHardware = con.prepareStatement(QUERY_DELETE_ROOM);

			stmtHardware.setInt(1, room.getId());
			stmtHardware.executeUpdate();
			
		} finally {
			// Close the connection
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Room rsetToRooms(ResultSet rset) throws Exception {
		
		Room room = new Room(rset.getInt("id_room"), rset.getString("name_room"));

		return room;
	}
	
}
