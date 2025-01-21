import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class BookOracle {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";
    private static final String USER = "orclpdbuser";
    private static final String PASSWORD = "isdb62";


    public void insertDummyData(String[][] students ){
        String insertQuery = "INSERT INTO book(name, author, genre, price, publish) values (?, ?, ?, ?, ?)";
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){

            for (String[] student: students){
                preparedStatement.setString(1, student[0]);
                preparedStatement.setString(2, student[1]);
                preparedStatement.setString(3, student[2]);
                preparedStatement.setDouble(4, Double.parseDouble(student[3]));
                //preparedStatement.setDate(5, new Date(new SimpleDateFormat("YYYY-MM-DD").parse(student[4]).getTime()));
                preparedStatement.setDate(5, Date.valueOf(student[4]));

                preparedStatement.addBatch();
            }
            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows inserted: "+ rowsInserted.length);
        } catch (SQLException e) {
            System.out.println("Error inserting data: "+e.getMessage());
        }
    }
}