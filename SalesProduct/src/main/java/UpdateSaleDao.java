
import java.sql.*;
public class UpdateSaleDao {
	private Connection con;
	public UpdateSaleDao(Connection con) {
		this.con=con;
	}
	
	public boolean update(UpdateSalePojo usp) {
		try {
			String query="UPDATE products SET salespersonname = ?, target = ?, unitSold = ?, status = ?, updatedby = ? WHERE id = ?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, usp.getSname());
            ps.setString(2, usp.getTarget());
            ps.setString(3, usp.getUnits());
            ps.setString(4, usp.getStatus());
            ps.setString(5, usp.getUpdatedby());
            ps.setString(6, usp.getId());

			
			int row=ps.executeUpdate();
			return row>0;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
	}
	
}