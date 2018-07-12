package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Category;
import beans.Hardware;
import beans.Room;
import databaseUtils.DBCategoryUtils;
import databaseUtils.DBHardwareUtils;
import databaseUtils.DBRoomsUtils;
import utils.Method;

/**
 * Servlet implementation class WebsiteServlet
 */
@WebServlet("/WebsiteServlet")
public class WebsiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebsiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ArrayList<Hardware> hardwareList = DBHardwareUtils.returnAllHardware();
			
			ArrayList<Room> listRooms = DBRoomsUtils.returnAllRooms();
			
			ArrayList<Category> listCategories = DBCategoryUtils.returnAllCategories();
			
			request.setAttribute("listHardware", hardwareList);
			
			request.setAttribute("listRooms", listRooms);
			
			request.setAttribute("listCategories", listCategories);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String string = Method.convertStreamToString(request.getInputStream());

			String name = Method.findName(string);
			
			DBHardwareUtils.deleteHardware(name);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
