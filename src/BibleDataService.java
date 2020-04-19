import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class BibleDataService {
	public String findAll() {
		Connection conn = null;
		String URL = "jdbc:postgresql://localhost:5432/postgres";
		String USER = "postgres";
		String PASS = "root";
		String SQL = "SELECT john FROM testapp.bible";

		// string to hold bible passage
		String j1 = "";

		try {
			conn = DriverManager.getConnection(URL, USER, PASS);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				j1 = rs.getString("john");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return j1;
	}
}
