

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/UpdateSaleController")
public class UpdateSaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String sname=request.getParameter("sname");
		String target=request.getParameter("target");
		String unit=request.getParameter("units");
		String selectStatus=request.getParameter("selectStatus");
		String updatedby=request.getParameter("updateby");
		
		UpdateSalePojo usp=new UpdateSalePojo(id, sname, unit, target, selectStatus,updatedby);
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","")){
			UpdateSaleDao usd=new UpdateSaleDao(con);
			boolean up=usd.update(usp);
			
			if (up) {
				RequestDispatcher rd=request.getRequestDispatcher("Dashboard.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("updateDashboard.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
