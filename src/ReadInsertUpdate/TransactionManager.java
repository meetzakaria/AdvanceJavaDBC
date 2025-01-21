package ReadInsert;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        String inputFilePath = "C:\\GIT\\InsertSelect\\items.csv";
        String outputFilePath = "C:\\GIT\\InsertSelect\\output.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String buyer = parts[2].trim();
                String seller = parts[3].trim();
                double price = Double.parseDouble(parts[4].trim());
                String buyDate = parts[5].trim();
                String sellDate = parts[6].trim();

                transactions.add(new Transaction(id, name, buyer, seller, price, buyDate, sellDate));
            }

            System.out.println("File read successfully.");


            TransactionDAO dao = new TransactionDAO();
            dao.insertTransactions(transactions);
            System.out.println("Data inserted into the database.");

            List<Transaction> dbTransactions = dao.fetchTransactions();
            System.out.println("Data fetched from the database.");

            for (Transaction txn : dbTransactions) {
                txn.setName(txn.getName() + "_Updated");
            }

            try (PrintWriter pw = new PrintWriter(new FileWriter(outputFilePath))) {
                pw.println("id,name,buyer,seller,price,buyDate,sellDate");
                for (Transaction txn : dbTransactions) {
                    pw.println(txn);
                }
            }

            System.out.println("Updated data saved to new file: " + outputFilePath);

        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
