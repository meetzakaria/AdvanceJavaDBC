package ReadInsert;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
    private static final String USER = "orclpdbuser";
    private static final String PASSWORD = "isdb62";

    public void insertTransactions(List<Transaction> transactions) throws SQLException {
        String sql = "INSERT INTO transactions (id, name, buyer, seller, price, buy_date, sell_date) VALUES (?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'))";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Transaction txn : transactions) {
                pstmt.setInt(1, txn.getId());
                pstmt.setString(2, txn.getName());
                pstmt.setString(3, txn.getBuyer());
                pstmt.setString(4, txn.getSeller());
                pstmt.setDouble(5, txn.getPrice());
                pstmt.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(txn.getBuyDate()));
                pstmt.setString(7, new SimpleDateFormat("yyyy-MM-dd").format(txn.getSellDate()));
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
    }


    public List<Transaction> fetchTransactions() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                transactions.add(new Transaction(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("buyer"),
                        rs.getString("seller"),
                        rs.getDouble("price"),
                        rs.getString("buy_date"),
                        rs.getString("sell_date")
                ));
            }
        }
        return transactions;
    }
}
