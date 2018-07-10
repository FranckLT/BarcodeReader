import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Room;
import databaseUtils.DBRoomsUtils;

public class Main {

	public static void main(String[] args) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
		List<Room> list = new ArrayList<>();
		
		list = DBRoomsUtils.returnAllRooms();
		
		for (Room room : list) {
			System.out.println(room.getId() + " " + room.getName());
		}

	}

}
