
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegistrationDao {
	Connection con;
	public RegistrationDao(Connection con) {
		this.con=con;
	}
	
	public boolean userAdd(RegistrationPojo rp) {
		String query="insert into users (name,username,email,contact,password) values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,rp.getName());
			ps.setString(2,rp.getUsername());;
			ps.setString(3,rp.getEmail());;
			ps.setString(4,rp.getContact());;
			ps.setString(5,rp.getPassword());;
			
			int ins=ps.executeUpdate();
			return ins>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
		
	}
}
