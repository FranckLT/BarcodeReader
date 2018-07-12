package utils;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.internal.compiler.ast.FunctionalExpression;

import beans.Category;
import databaseUtils.DBCategoryUtils;

public class Method {
	
	public static Category findCategoryHardware(String code) throws SQLException, Exception {
		
		String regex = "_";
		
		String categoryName[] = code.split(regex);
		
		Category category = DBCategoryUtils.returnOneCategory(categoryName[0]).get(0);
		
		return category;
		
	}
	
public static String findCodeHardware(String code) throws SQLException, Exception {
		
		String regex = "_";
		
		String categoryName[] = code.split(regex);
		
		String string = categoryName[1];
		
		return string;
		
	}

public static boolean itCodeContainsSpecialChars(String code) throws SQLException, Exception {
	
	final Pattern pattern = Pattern.compile("[&é(§è!çà)-^_$*€ù%`£=+:/\\\"\';.,?]");
	
	Matcher matcher = pattern.matcher(code);
	
	while (matcher.find()) {
		
		return false;
	}
	
	return true;
	
}
	
public static String findName(String code) throws SQLException, Exception {
		
		String regex = "=";
		
		String name[] = code.split(regex);
		
		return name[1];
		
	}
	
	
	public static String convertStreamToString(java.io.InputStream is) {
		
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    
	    return s.hasNext() ? s.next() : "";
	    
	}
	
	public static boolean verifyCode(String code) throws SQLException, Exception {
		
		String string = findCodeHardware(code);
		
		if (string.length()<1) {
			
			return false;
			
		}
		
		if (!itCodeContainsSpecialChars(string)) {
			
			return false;
			
		}
		
		return true;
		
	}
	

}
