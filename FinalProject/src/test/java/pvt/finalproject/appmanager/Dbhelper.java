package pvt.finalproject.appmanager;

import pvt.finalproject.model.Email;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;


public class Dbhelper {
    private static final String URL = "jdbc:mysql://localhost:3306/mailru?";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    private ResultSet getResultSet(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public String[] getCredentials(int user_id) throws SQLException {
        String query = "SELECT * FROM creds WHERE user_id = " + user_id;
        ResultSet resultSet = getResultSet(query);
        String[] credentials = new String[3];
        resultSet.next();
        credentials[0] = resultSet.getString("login");
        credentials[1] = resultSet.getString("domain");
        credentials[2] = resultSet.getString("password");
        resultSet.close();
        return credentials;
    }

    public Email getEmails() throws SQLException {
        String query = "SELECT * FROM emails WHERE id = 1";
        ResultSet resultSet = getResultSet(query);
        resultSet.next();
        Email email = Email.newEntity().withId(resultSet.getString("id"))
                .withReceivers(resultSet.getString("receivers").split(", "))
                .withSubject(resultSet.getString("subject"))
                .withText(resultSet.getString("text")).build();
        resultSet.close();
        return email;
    }
}
