package utils;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import beans.Category;
import databaseUtils.DBCategoryUtils;

public class Method {
	
	public static Category findCategoryHardware(String code) throws SQLException, Exception {
		
		String regex = "_";
		
		String categoryName[] = code.split(regex);
		
		Category category = DBCategoryUtils.returnOneCategory(categoryName[0]).get(0);
		
		return category;
		
	}
	
	public static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
	
	

}
