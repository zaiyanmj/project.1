import java.sql.*;
import java.util.Scanner;

public class Vote {
    public static void vote() {
        try {
            Connection con = DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            String checkUser = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(checkUser);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Invalid Login!");
                return;
            }

            if (rs.getBoolean("voted")) {
                System.out.println("You already voted!");
                return;
            }

            Statement st = con.createStatement();
            ResultSet crs = st.executeQuery("SELECT * FROM candidates");

            System.out.println("\nCandidates:");
            while (crs.next()) {
                System.out.println(crs.getInt("id") + ". " + crs.getString("name"));
            }

            System.out.print("Enter Candidate ID: ");
            int cid = sc.nextInt();

            PreparedStatement votePs = con.prepareStatement(
                "UPDATE candidates SET votes = votes + 1 WHERE id=?");
            votePs.setInt(1, cid);
            votePs.executeUpdate();

            PreparedStatement updateUser = con.prepareStatement(
                "UPDATE users SET voted=true WHERE username=?");
            updateUser.setString(1, username);
            updateUser.executeUpdate();

            System.out.println("Vote Cast Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
