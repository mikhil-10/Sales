import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    Connection con;

    public LoginDao(Connection con) {
        this.con = con;
    }

   
    String query = "SELECT * FROM users WHERE username = ? AND password = ?";

    public boolean loginVerify(LoginPojo lp) {
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, lp.getUsername());
            ps.setString(2, lp.getPassword());

            ResultSet rs = ps.executeQuery();
            if (rs!=null) {
            	return rs.next();
			}  

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
