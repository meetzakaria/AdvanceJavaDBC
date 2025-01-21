import java.sql.*;

public class BookDAO {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";
    private static final String USER = "orclpdbuser";
    private static final String PASSWORD = "isdb62";

    public void updateBookPrice(String bookName, double newPrice) {
        String updateQuery = "UPDATE studentjdbc SET age = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setString(2, bookName);

            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }
}
