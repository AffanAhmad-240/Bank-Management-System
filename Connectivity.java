import java.sql.*;

public class Connectivity {
    Connection c;
    Statement s;
    public Connectivity() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bank", "root", "Affan065$");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
