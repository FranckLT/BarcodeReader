package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Category;
import beans.Hardware;
import beans.Room;
import databaseUtils.DBCategoryUtils;
import databaseUtils.DBHardwareUtils;
import databaseUtils.DBRoomsUtils;

/**
 * Servlet implementation class CategoriesPHPServlet
 */
@WebServlet("/CategoriesPHPServlet")
public class CategoriesPHPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriesPHPServlet() {
        super();
        this.gson = new Gson();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ArrayList<Category> listCategories = DBCategoryUtils.returnAllCategories();
			
			ArrayList<Room> listRooms = DBRoomsUtils.returnAllRooms();
			
			ArrayList<Hardware> listHardwares = DBHardwareUtils.returnAllHardware();
			
			String listCategoriesJSON = gson.toJson(listCategories);
			
			String listRoomsJSON = gson.toJson(listRooms);
			
			response.getOutputStream().print(listCategoriesJSON);
			
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
