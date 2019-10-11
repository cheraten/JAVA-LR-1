import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/registrationView.jsp");

        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LoginPasswordDAO dao = new LoginPasswordDAO();

        if (!dao.isContainUserName(login)) {
            LoginPasswordEntity loginPasswordEntity = new LoginPasswordEntity(login,password);
            dao.save(loginPasswordEntity);

            String loginedUserName = login;
            request.setAttribute("loginedUserName", loginedUserName);

            String registrationMessage = "New user created! Now sign up to view the list of registered users.";
            request.setAttribute("registrationMessage", registrationMessage);

            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/loginView.jsp");
            dispatcher.forward(request, response);
        } else {
            String errorRegistrationMessage = "This login is busy!";
            request.setAttribute("errorRegistrationMessage", errorRegistrationMessage);
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/registrationView.jsp");
            dispatcher.forward(request, response);
        }
    }

}