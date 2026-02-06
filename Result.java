import java.sql.*;

public class Result {
    public static void showResult() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM candidates");

            System.out.println("\nVoting Results:");
            while (rs.next()) {
                System.out.println(
                    rs.getString("name") + " - " + rs.getInt("votes") + " votes"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
