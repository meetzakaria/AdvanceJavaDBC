//public class Main {
//    public static void main(String[] args) {
//
//        /*String[][] students = {
//                {"John", "20", "johgh55@example.com"},
//                {"Ashik", "25", "jhugfedy@example.com"},
//                {"Faysal", "22", "joh5@example.com"}
//        };*/
//
//        /*InsertStudentOracle oracle = new InsertStudentOracle();
//        oracle.insertDummyData(students);*/
//
//        String[][] BookList = {
//                {"John", "abc","abc", "100","2025-01-15"},
//                {"Ashik", "abc","abc", "100","2025-01-15"},
//                {"Faysal", "abc","abc", "100","2025-01-15"}
//        };
//
//        InsertBookList oracle = new InsertBookList();
//        oracle.insertBookList(BookList);
//    }
//}

public class Main {
    public static void main(String[] args) {
        String [][] books = {
                {"Bangla", "Professor", "", "500.12", "2025-01-10"},
                {"English", "Nahid", "", "600.12", "2025-01-11"},
                {"Science", "Hemel", "", "700.12", "2025-01-12"},
                {"Math", "Ashik", "", "300.12", "2025-01-15"},

        };


        BookOracle bookOracle = new BookOracle();
        bookOracle.insertDummyData(books);
    }
}