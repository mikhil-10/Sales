

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/InsertSaleController")
public class InsertSaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		
		String id=req.getParameter("id");
		String sname=req.getParameter("sname");
		String target=req.getParameter("target");
		String units=req.getParameter("units");
		String status=req.getParameter("status");
		String addedby=(String) session.getAttribute("uname");
		String updatedby=(String) session.getAttribute("uname");
		InsertSalePojo isp=new InsertSalePojo(id,sname, units, target, status, addedby,updatedby);
		try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","")){
			
			InsertSaleDao isd= new InsertSaleDao(con);
			boolean in=isd.insert(isp);
			 if (in) {
				res.sendRedirect("Dashboard.jsp");
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("Failure.jsp");
                rd.forward(req, res);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
