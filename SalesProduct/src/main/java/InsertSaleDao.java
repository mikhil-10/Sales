
import java.sql.*;
public class InsertSaleDao {
	
	private Connection con;
	public InsertSaleDao(Connection con) {
		this.con=con;
	}
	
	public boolean insert(InsertSalePojo ip) {
		String query="Insert into products (salespersonname,target,unitSold,status,addedby,updatedby) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,ip.getSname());
			ps.setString(2,ip.getTarget());
			ps.setString(3,ip.getUnits());
			ps.setString(4,ip.getStatus());
			ps.setString(5,ip.getAddedby());
			ps.setString(6,ip.getUpdatedby());
			
			int count=ps.executeUpdate();
			return count>0;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
	}
}