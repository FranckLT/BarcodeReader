package databaseUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.jmx.snmp.SnmpStringFixed;

import beans.Category;
import beans.Hardware;
import beans.Room;

public class DBCategoryUtils {
	
	public final static String QUERY_FIND_ONE_CATEGORY = "select * from category where name_category=(?)";
	private final static String QUERY_FIND_CATEGORIES = "SELECT * FROM category";
	private final static String QUERY_INSERT_CATEGORY = "insert into category values (null, (?))";
	private final static String QUERY_DELETE_CATEGORY = "DELETE FROM category where id=(?)";
	
public static ArrayList<Category> returnOneCategory(String name) throws Exception, SQLException {
	
	ArrayList<Category> categoriesList = new ArrayList<>();

		Connection con = null;
		PreparedStatement stmtNumber = null;

		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmtNumber = con.prepareStatement(QUERY_FIND_ONE_CATEGORY);

			stmtNumber.setString(1, name);
			
			ResultSet resultSet = stmtNumber.executeQuery();
			
			while (resultSet.next()) {

				categoriesList.add(rsetToCategory(resultSet));
			}
			
			return categoriesList;
			
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

public static ArrayList<Category> returnAllCategories() throws Exception, SQLException {
	
	ArrayList<Category> roomsList = new ArrayList<>();

	Connection con = null;
	Statement stmt = null;
	// PreparedStatement stmtUser = null;

	try {
		// Relative instruction to work with Tomcat and Mysql
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
		stmt = con.createStatement();

		// Execute SQL instruction for finding messages
		ResultSet rSetCategories = stmt.executeQuery(QUERY_FIND_CATEGORIES);

		// Convert the SLQ Table into an arrayList of MessageBean
		while (rSetCategories.next()) {

			// Then converts the Message Table into an ArrayList of Messages
			roomsList.add(rsetToCategory(rSetCategories));
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

public static void insertRoom( Category category ) throws Exception, SQLException {

	Connection con = null;
	PreparedStatement stmtHardware = null;

	try {
		// Relative instruction to work with Tomcat and Mysql
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
		stmtHardware = con.prepareStatement(QUERY_INSERT_CATEGORY);

		stmtHardware.setString(1, category.getName());
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

public static void deleteCategory( Category category ) throws Exception, SQLException {

	Connection con = null;
	PreparedStatement stmtHardware = null;

	try {
		// Relative instruction to work with Tomcat and Mysql
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
		stmtHardware = con.prepareStatement(QUERY_DELETE_CATEGORY);

		stmtHardware.setInt(1, category.getId());
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


	
public static Category rsetToCategory(ResultSet rSet) throws Exception {
		
		Category category = new Category(rSet.getInt("id_category"), rSet.getString("name_category"));
		
		return category;
		
	}

}
