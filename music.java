package My_music;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class music {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop",
                        "root", "");

                Statement stmt = conn.createStatement();
        ) {
            // Issue a SELECT to check the changes
            String strSelect = "select * from music";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ", "
                        + resultSet.getInt("name") + ", "
                        + resultSet.getString("author") + ", "
                        + resultSet.getString("year")
                );
            }
            {

                //SEARCH
                System.out.println("\n\nEnter the music id want to SEARCH");
                Integer enterID = sc.nextInt();
                String strSelect2 = "select *from music where is:" + enterID;
                System.out.println("The SQL Statement is: " + strSelect2 + "\n");
                ResultSet resultSet2 = stmt.executeQuery(strSelect2);
                System.out.println("the records selected are:");
                while (resultSet2.next()) {
                    System.out.println(resultSet2.getInt("id") + ","
                            + resultSet2.getInt("name") + ","
                            + resultSet2.getString("author") + ","
                            + resultSet2.getString("year")
                    );
                }

                //DELETE
                System.out.println("\n\nEnter the music  id you want to DELETE: ");
                Integer deleteID = sc.nextInt();
                String sqlDelete = "delete from music where id = " + deleteID;
                System.out.println("The SQL statement is: " + sqlDelete + "\n");
                int countDeleted = stmt.executeUpdate(sqlDelete);
                System.out.println(countDeleted + " records deleted.\n");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}