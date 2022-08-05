import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
	static Connection cnx = null;
	
	/**************** Method to connect with DB ********************/

	public static Connection connect() throws SQLException, InstantiationException {

//		Connection cnx = null;
		String url, username = null, password = null;

		/******************** DB URL *********************/

		url = "jdbc:mysql://localhost:3306/vending";

		/******************** User Name ********************/

		username = "root";

		/***************** Default PW ********************/

		password = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			cnx = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return cnx;
	}

}
