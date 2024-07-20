import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String dbname = "jdbc:mysql://localhost:3306/task";
        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");

        LoginPojo lp = new LoginPojo(uname, pass);
        HttpSession session = req.getSession();
        session.setAttribute("uname", uname);
        session.setAttribute("pass", pass);

        try (Connection con = DriverManager.getConnection(dbname, "root", "")) {
            LoginDao ld = new LoginDao(con);
            boolean auth = ld.loginVerify(lp);
            if (auth) {
                RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
                rd.forward(req, res);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
                rd.forward(req, res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
