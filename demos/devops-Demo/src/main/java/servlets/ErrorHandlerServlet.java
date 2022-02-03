package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("Error 404!");
        /*
        This is a string tht contains a boilerplate 404 HTML error page. See it in postman by clicking "preview"
         */
        resp.getWriter().write("\n" +
                "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <title>Page Not Found</title>\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "  <style>\n" +
                "    * {\n" +
                "      line-height: 1.2;\n" +
                "      margin: 0;\n" +
                "    }\n" +
                "\n" +
                "    html {\n" +
                "      color: #888;\n" +
                "      display: table;\n" +
                "      font-family: sans-serif;\n" +
                "      height: 100%;\n" +
                "      text-align: center;\n" +
                "      width: 100%;\n" +
                "    }\n" +
                "\n" +
                "    body {\n" +
                "      display: table-cell;\n" +
                "      vertical-align: middle;\n" +
                "      margin: 2em auto;\n" +
                "    }\n" +
                "\n" +
                "    h1 {\n" +
                "      color: #555;\n" +
                "      font-size: 2em;\n" +
                "      font-weight: 400;\n" +
                "    }\n" +
                "\n" +
                "    p {\n" +
                "      margin: 0 auto;\n" +
                "      width: 280px;\n" +
                "    }\n" +
                "\n" +
                "    @media only screen and (max-width: 280px) {\n" +
                "\n" +
                "      body,\n" +
                "      p {\n" +
                "        width: 95%;\n" +
                "      }\n" +
                "\n" +
                "      h1 {\n" +
                "        font-size: 1.5em;\n" +
                "        margin: 0 0 0.3em;\n" +
                "      }\n" +
                "\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "  <h1>Page Not Found</h1>\n" +
                "  <p>Sorry, but the page you were trying to view does not exist.</p>\n" +
                "</body>\n" +
                "\n" +
                "</html>\n" +
                "<!-- IE needs 512+ bytes: https://docs.microsoft.com/archive/blogs/ieinternals/friendly-http-error-pages -->");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ErrorHandlerServlet caught a ServletException...");
        resp.setStatus(500);
        resp.getWriter().write("ErrorHandlerServlet caught a ServletException.");
    }
}
