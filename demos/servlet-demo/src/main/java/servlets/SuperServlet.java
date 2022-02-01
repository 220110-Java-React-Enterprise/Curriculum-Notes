package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.DataObject;
import utils.GlobalStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class SuperServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Fact finding:
        System.out.println("Req URI: " + req.getRequestURI());
        System.out.println("Query String: " + req.getQueryString());
        System.out.println("Context Path: " + req.getContextPath());
        System.out.println("Path Info: " + req.getPathInfo());
        System.out.println("Content Type: " + req.getContentType());



        //get query parameters
        req.getQueryString();
        String queryParam1 = req.getParameter("param1");
        String queryParam2 = req.getParameter("param2");
        String queryParam3 = req.getParameter("param3");

        /*
        So we can get the entire query string, or any value by key. We could separate
        out the tokens based on & delimiter, and then map the key/value pairs in a map data structure.
        Or we can ask, wouldn't someone else have already done this?
         */
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        System.out.println("Query Parameters: ");
        for (String key:keySet) {
            System.out.print("[" + key + "]: ");
            String[] strArray = parameterMap.get(key);
            for (String str : strArray) {
                System.out.println(str);
            }
        }



        //get header metadata
        Enumeration<String> headerNames = req.getHeaderNames();
        System.out.println("Header names: ");
        while(headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }

        //get body
        ObjectMapper mapper = new ObjectMapper();
        DataObject obj = mapper.readValue(req.getInputStream(), DataObject.class);
        GlobalStore.setSuperObj(obj);

        //response stuff:
        resp.setStatus(203);
        resp.setContentType("application/json");
        resp.getWriter().write(mapper.writeValueAsString(obj));


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //set headers
        resp.setHeader("Content-Type", "application/json");
        resp.setHeader("Kyle-Fav-Color", "Blue");
        resp.setHeader("Kyle-Fashion-Season", "Winter");

        //set body (payload)
        //this time im not going to use ObjectMapper to generate the JSON
        DataObject obj = GlobalStore.getSuperObj();
//        String jsonString = "{" +
//                "num:" + obj.getNum() + "," +
//                "str:\"" + obj.getStr() + "\"," +
//                "bool:" + obj.isBool() + "}";
        String jsonString = obj.toString();
        resp.getWriter().write(jsonString);
        resp.setStatus(200);

    }
}
