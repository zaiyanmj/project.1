import java.sql.*;
import java.util.Scanner;

public class Register {
    public static void register() {
        try {
            Connection con = DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            String sql = "INSERT INTO users(username,password) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

            System.out.println("Registration Successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
