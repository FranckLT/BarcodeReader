package databaseUtils;

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

public class DBHardwareUtils {
	
	private final static String QUERY_FIND_HARDWARE = "select * from hardware inner join room on room.id_room = hardware.id_room inner join category on category.id_category = hardware.id_category;";
	private final static String QUERY_FIND_IF_HARDWARE_EXIST = "select * from hardware inner join category on category.id_category = hardware.id_category inner join room on room.id_room = hardware.id_room where number_code=(?)";
	private final static String QUERY_INSERT_HARDWARE = "insert into hardware values (null, (?), (?), (?))";
	private final static String QUERY_UPDATE_HARDWARE = "update hardware set id_room = (?) where number_code = (?)";
	private final static String QUERY_DELETE_HARDWARE = "DELETE FROM hardware where number_code=(?)";
	
	
	public static ArrayList<Hardware> returnAllHardware() throws Exception, SQLException {
		
		ArrayList<Hardware> hardwareList = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		// PreparedStatement stmtUser = null;

		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmt = con.createStatement();

			// Execute SQL instruction for finding messages
			ResultSet rSetHardware = stmt.executeQuery(QUERY_FIND_HARDWARE);

			// Convert the SLQ Table into an arrayList of MessageBean
			while (rSetHardware.next()) {

				// Then converts the Message Table into an ArrayList of Messages
				hardwareList.add(rsetToHardware(rSetHardware));
			}
			return hardwareList;
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
	
	
public static ArrayList<Hardware> returnOneHardware(String number_code) throws Exception, SQLException {
		
		ArrayList<Hardware> hardwareList = new ArrayList<>();

		Connection con = null;
		PreparedStatement stmtNumber = null;

		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmtNumber = con.prepareStatement(QUERY_FIND_IF_HARDWARE_EXIST);

			stmtNumber.setString(1, number_code);
			
			ResultSet resultSet = stmtNumber.executeQuery();
			
			System.out.println(resultSet);

			// Convert the SLQ Table into an arrayList of MessageBean
			while (resultSet.next()) {

				hardwareList.add(rsetToHardware(resultSet));
			}
			return hardwareList;
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

	public static void insertHardware( Hardware hardware ) throws Exception, SQLException {

		Connection con = null;
		PreparedStatement stmtHardware = null;
	
		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmtHardware = con.prepareStatement(QUERY_INSERT_HARDWARE);
	
			stmtHardware.setString(1, hardware.getCode());
			stmtHardware.setInt(2, hardware.getRoom().getId());
			stmtHardware.setInt(3, hardware.getCategory().getId());
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
	
	public static void updateHardware( Hardware hardware ) throws Exception, SQLException {

		Connection con = null;
		PreparedStatement stmtHardware = null;
	
		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmtHardware = con.prepareStatement(QUERY_UPDATE_HARDWARE);
	
			stmtHardware.setString(2, hardware.getCode());
			stmtHardware.setInt(1, hardware.getRoom().getId());
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


	public static void deleteHardware( String name ) throws Exception, SQLException {

		Connection con = null;
		PreparedStatement stmtHardware = null;

		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmtHardware = con.prepareStatement(QUERY_DELETE_HARDWARE);

			stmtHardware.setString(1, name);
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
	
	
	
	
	public static Hardware rsetToHardware(ResultSet rset) throws Exception {
		
		 Hardware hardware = new Hardware(rset.getString("number_code"), DBRoomsUtils.rsetToRooms(rset), DBCategoryUtils.rsetToCategory(rset));	

		 return hardware;
	}


}
