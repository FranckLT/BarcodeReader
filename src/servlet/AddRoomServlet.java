package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Room;
import databaseUtils.DBRoomsUtils;
import utils.Method;

/**
 * Servlet implementation class AddRoomServlet
 */
@WebServlet("/AddRoomServlet")
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomServlet() {
        super();
        Gson gson = new Gson();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ArrayList<Room> listRooms = DBRoomsUtils.returnAllRooms();
			
			request.setAttribute("listRooms", listRooms);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/addRoom.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Room> listRoom;
		
		try {
			
			String string = Method.convertStreamToString(request.getInputStream());
			
			if (Method.findAttribute(string).compareTo("code")==0) {
				
				String roomName = Method.findName(string);
				
				Room room = new Room(0, roomName);
				
				DBRoomsUtils.deleteRoom(room);
				
			} else {
				
				String roomName = Method.findName(string).toLowerCase();
				
				if (Method.itCodeContainsSpecialChars(roomName)) {
					
					Room room = new Room(0, roomName);
					
					listRoom = DBRoomsUtils.returnOneRoom(room);
					
					if (listRoom.isEmpty()) {
						
						DBRoomsUtils.insertRoom(room);
						
					}
				} 
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
