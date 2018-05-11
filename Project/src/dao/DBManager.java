package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	final private static String url = "jdbc:mysql://localhost/usermanagement?useUnicode=true&characterEncoding=utf8";
    final private static String user = "root";
    final private static String pass = "password";

    public static Connection getConnection() {
    	Connection con = null;

    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection(url, user, pass);
    	}catch(SQLException|ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	return con;
    }
}
