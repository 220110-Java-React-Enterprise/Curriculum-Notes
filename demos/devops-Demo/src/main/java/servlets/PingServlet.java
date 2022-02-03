package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PingServlet extends HttpServlet {
    /*
    This will take a simple GET request and respond with "Pong!" and status 202, indicating the request was accepted.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(202);
        resp.getWriter().print("Pong!");
    }
}