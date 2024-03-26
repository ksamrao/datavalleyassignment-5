import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentDAO {

    // Database URL
    static final String DB_URL = "jdbc:mysql://localhost:3306/departments";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "*******";

    public static void main(String[] args) {
        // Department object to be stored in the database
        Department department = new Department(1, "IT");

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            
            // Insert the department into the database
            String sql = "INSERT INTO department VALUES (" + department.getId() + ", '" + department.getName() + "')";
            stmt.executeUpdate(sql);
            System.out.println("Department inserted successfully.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
public class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}