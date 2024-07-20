
import java.sql.*;


public class DeleteDao {
	private Connection con;
	
	public DeleteDao(Connection con) {
		this.con=con;
	}
	
	public boolean deleteDao(DeletePojo dp) {
		try {
			String query="delete from products where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,dp.getId());
			
			int row=ps.executeUpdate();
			return row>0;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
}