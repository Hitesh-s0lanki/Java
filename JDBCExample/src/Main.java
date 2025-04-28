import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        /*
         * import package
         * load and
         */

        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "mysecretpassword";

        Connection con = DriverManager.getConnection(url, username, password);

        System.out.println("Connected to Postgres SQL database");

        Statement st = con.createStatement();
        String query = "SELECT * FROM student";

        ResultSet result = st.executeQuery(query);

        while (result.next()) {
            String name = result.getString("name");
            System.out.println("Name of the Student : " + name);
        }

        // String[] students = {"Hitesh", "Niraj", "Kapil", "Nikhil", "Shakti"};
        // String query = "INSERT INTO student (name) VALUES (?);";
        //
        // PreparedStatement ps = con.prepareStatement(query);
        //
        // for (int i = 0; i < students.length; i++) {
        // ps.setString(1, students[i]);
        // ps.execute();
        // }

        con.close();

        System.out.println("Connection Closed");
    }
}

// CREATE TABLE student (
// roll_no SERIAL PRIMARY KEY,
// name VARCHAR(100) NOT NULL
// );