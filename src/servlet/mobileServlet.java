package servlet;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import beans.Category;
import beans.Hardware;
import beans.Result;
import beans.Room;
import databaseUtils.DBHardwareUtils;
import databaseUtils.DBRoomsUtils;
import jdk.internal.dynalink.beans.StaticClass;
import utils.Method;

/**
 * Servlet implementation class mobileServlet
 */
@WebServlet("/mobileServlet")
public class mobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mobileServlet() {
        super();
       gson = new Gson();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Room> roomsList = new ArrayList<>();
		
		try {
			
			roomsList = DBRoomsUtils.returnAllRooms();
			
			String listRoomsJSON = gson.toJson(roomsList);
			
			response.getOutputStream().print(listRoomsJSON);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Hardware> hardwareList = new ArrayList<>();
		
		// recupération JSON
		
		String string = Method.convertStreamToString(request.getInputStream());
		
		System.out.println(string);
		
		// transformation en result
		
		Result result = gson.fromJson(string, Result.class);
		
		try {
			
			// Récup objet HardWare si existant sinon vide
			
			hardwareList = DBHardwareUtils.returnOneHardware(result.getCode());
			
			// test si le hardware existent en base
			
			if (hardwareList.isEmpty()) {
				
				// existe pas => on l'enregistre
				
				Room room = DBRoomsUtils.returnOneRooms(result.getRoom()).get(0);
				
				Category category = Method.findCategoryHardware(result.getCode());
				
				Hardware hardware = new Hardware(result.getCode(), room, category);
				
				DBHardwareUtils.insertHardware(hardware);
				
			} else {
				
				Room room = DBRoomsUtils.returnOneRooms(result.getRoom()).get(0);
				
				// existe => on met à jour la room du hardware
				
				hardwareList.get(0).setRoom(room);
				
				DBHardwareUtils.updateHardware(hardwareList.get(0));
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
			
	}

}
