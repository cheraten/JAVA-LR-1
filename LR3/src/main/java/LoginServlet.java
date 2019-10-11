import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/loginView.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LoginPasswordDAO dao = new LoginPasswordDAO();

        if (dao.isContainUserName(login)) {
            if (dao.isRightPassword(login, password)) {
                LoginHashDAO daoLH = new LoginHashDAO();
                String uuid = daoLH.getHash(login);

                if (uuid == null) {
                    uuid = UUID.randomUUID().toString();
                    LoginHashEntity userLH = new LoginHashEntity(login, uuid);
                    daoLH.save(userLH);
                    Cookie cookie = new Cookie("sessionId", uuid);
                    response.addCookie(cookie);
                }

                Cookie cookie = new Cookie("sessionId", uuid);
                response.addCookie(cookie);

                String loginedUserName = login;
                request.setAttribute("loginedUserName", loginedUserName);
                List<LoginPasswordEntity> usersList = dao.findAll();
                request.setAttribute("usersList", usersList);

                //response.sendRedirect("login/userInfoView.jsp");
                //RequestDispatcher dispatcher //
                //    = this.getServletContext().getRequestDispatcher("/userInfoView.jsp");
                //dispatcher.forward(request, response);

                request.getRequestDispatcher("userInfoView.jsp").forward(request, response);
            } else {
                String errorLoginMessage = "Incorrect password!";
                request.setAttribute("errorLoginMessage", errorLoginMessage);
                RequestDispatcher dispatcher //
                        = this.getServletContext().getRequestDispatcher("/loginView.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            String errorLoginMessage = "User with this login is not in the database.";
            request.setAttribute("errorLoginMessage", errorLoginMessage);
            request.getRequestDispatcher("/loginView.jsp").forward(request, response);
        }
        //при входе с незарегистрированного логина - новый юзер
        /*else {
            String registrationMessage = "New user created! Now sign up to view the list of registered users.";
            request.setAttribute("registrationMessage", registrationMessage);
            request.getRequestDispatcher("/registration").forward(request, response);
        } */
    }

}