import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
        String user = "orclpdbuser";
        String password = "isdb62";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            // Statement তৈরি
            Statement statement = connection.createStatement();

            // SQL কোয়েরি
            String query = "INSERT INTO stud (id, name, age, publish) VALUES ('10', 'John Doe', '12', 'TO_DATE('2025-10-10', 'YYYY-MM-DD'))";
            int rowsAffected = statement.executeUpdate(query);

            System.out.println(rowsAffected + " row(s) inserted.");

            // সংযোগ বন্ধ
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
