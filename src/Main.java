import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Category;
import beans.Hardware;
import beans.Room;
import databaseUtils.DBHardwareUtils;
import databaseUtils.DBRoomsUtils;
import sun.invoke.empty.Empty;
import utils.Method;

public class Main {

	public static void main(String[] args) throws SQLException, Exception {
		
		String string = "!§ç§ç(àç)";
		
		Method.itCodeContainsSpecialChars(string);
		
	}

}
