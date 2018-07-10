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

public class Main {

	public static void main(String[] args) throws SQLException, Exception {
		
		Hardware hardware = new Hardware("45T54TE", new Room(1, "sfd"), new Category(3, "sdff"));
		
		DBHardwareUtils.updateHardware(hardware);
		
		
	}

}
