import DAO.LoginHashDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) resp;

        String login = (String) httpReq.getParameter("login");
        Cookie[] cookies = httpReq.getCookies();

        if (!(cookies == null)) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                boolean isContain = cookieName.equals("sessionId");
                if (isContain) {
                    String sessionId = cookie.getValue();
                    LoginHashDAO daoLHash = new LoginHashDAO();
                    if (daoLHash.isContainLoginHash(login, sessionId)) {
                        httpReq.getRequestDispatcher("userInfoView.jsp").forward(httpReq, httpRes);
                    } else {
                        httpReq.getRequestDispatcher("/login").forward(httpReq, httpRes);
                    }
                }
            }
        }
        chain.doFilter(req, resp);
    }
}