package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.DataObject;
import utils.GlobalStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataObject obj = GlobalStore.getObj();
        ObjectMapper mapper = new ObjectMapper();
        String JSON = mapper.writeValueAsString(obj);
        resp.getWriter().print(JSON);
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        DataObject payload = mapper.readValue(req.getInputStream(), DataObject.class);
        GlobalStore.setObj(payload);
        resp.setStatus(203);


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doDelete(req, resp);
    }
}
