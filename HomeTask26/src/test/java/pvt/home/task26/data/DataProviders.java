package pvt.home.task26.data;

import org.testng.annotations.DataProvider;
import pvt.home.task26.app.Dbhelper;

import java.sql.SQLException;


public class DataProviders {

	@DataProvider(name = "Emails")
	public static Object[][] emails() throws SQLException {
		return new Object[][] {
			{ new Dbhelper().getEmails() }
		};
	}
}
