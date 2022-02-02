package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.DataCollection;
import utils.GlobalStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CollectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataCollection dataCollection = new DataCollection();
        dataCollection.getDataCollection().add(GlobalStore.getObj());
        dataCollection.getDataCollection().add(GlobalStore.getSuperObj());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dataCollection);
        resp.setStatus(200);
        resp.getWriter().write(json);
    }
}
