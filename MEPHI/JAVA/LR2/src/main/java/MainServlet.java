import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    HashMap<Integer, Set<String>> hashMap;
    SingltoneSet setId;

    public void init() {
        hashMap = new HashMap<Integer, Set<String>>();
        setId = SingltoneSet.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Random random = new Random(System.currentTimeMillis());
        int number1 = -125 + random.nextInt(347 + 125 + 1);
        int number2 = -125 + random.nextInt(347 + 125 + 1);
        int sum =  number1 + number2;
        String hash = Integer.toString(Integer.toString(sum).hashCode()) + System.currentTimeMillis();

        if (hashMap.containsKey(sum))
            hashMap.get(sum).add(hash);
        else {
            Set<String> set = new HashSet<String>();
            set.add(hash);
            hashMap.put(sum, set);
        }

        request.setAttribute("number1", number1);
        request.setAttribute("number2", number2);
        request.setAttribute("hash", hash);
        request.getRequestDispatcher("/count_to_get_in.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int answer = Integer.parseInt(request.getParameter("answer"));
        String gottenHash = request.getParameter("hash");
        if (hashMap.containsKey(answer)) {
            if (hashMap.get(answer).contains(gottenHash)) {
                String uuid = UUID.randomUUID().toString();
                setId.addSessionId(uuid);
                Cookie cookie = new Cookie("sessionId", uuid);
                response.addCookie(cookie);
                request.getRequestDispatcher("/hello_inside.html").forward(request, response);
            }
        } else doGet(request, response);
    }
}