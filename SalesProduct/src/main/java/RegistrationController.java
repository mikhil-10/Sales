


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String dbname = "jdbc:mysql://localhost:3306/task";  // Corrected JDBC URL
        String dbuname = "root";
        String dbpass = "";

        String name = req.getParameter("name");
        String uname = req.getParameter("uname");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");
        String pass = req.getParameter("pass");

        RegistrationPojo rp = new RegistrationPojo(name, uname, email, contact, pass);

        try (Connection con = DriverManager.getConnection(dbname, dbuname, dbpass)) {
            RegistrationDao regdao = new RegistrationDao(con);
            boolean insert = regdao.userAdd(rp);
            if (insert) {
                RequestDispatcher rd = req.getRequestDispatcher("Success.jsp");
                rd.forward(req, res);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("Failure.jsp");
                rd.forward(req, res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
