package databaseUtils ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Hardware;
import beans.Room;

public class DBRoomsUtils {
	// ------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------
	private final static String QUERY_FIND_ROOMS = "SELECT * FROM room";
	private final static String QUERY_INSERT_MESSAGE = "INSERT INTO Message(content, createdAt, id_Utilisateur) Values (?, ?, ?);";

	// ------------------------------------------------------------
	// Insert a Message into the DB
	// ------------------------------------------------------------
	
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

	public static Room rsetToRooms(ResultSet rset) throws Exception {
		
			 Room room = new Room(rset.getInt("id"), rset.getString("name"));

		return room;
	}
}
