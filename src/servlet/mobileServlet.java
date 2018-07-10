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
import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import beans.Hardware;
import beans.Room;
import databaseUtils.DBRoomsUtils;
import jdk.internal.dynalink.beans.StaticClass;

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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
	String string = convertStreamToString(request.getInputStream());
	
	response.getOutputStream().print(string);
		
	}
	
	static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}

}
