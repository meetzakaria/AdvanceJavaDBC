/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStudentOracle {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
    private static final String USER = "orclpdbuser";
    private static final String PASSWORD = "isdb62";

    public void insertDummyData(String[][] students) {
        String insertQuery = "INSERT INTO studentjdbc (name, age, email) VALUES (?,?,?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (String[] student : students) {
                preparedStatement.setString(1, student[0]);
                preparedStatement.setInt(2, Integer.parseInt(student[1]));
                preparedStatement.setString(3, student[2]);

                preparedStatement.addBatch();
            }

            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows Inserted: " + rowsInserted.length);

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }
}*/