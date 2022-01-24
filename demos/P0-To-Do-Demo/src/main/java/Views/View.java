package Views;

import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;
/*
What views do I need?
Register
Login
ToDo Items List
Create new Item
Mark item complete
 */


public abstract class View {

    protected String viewName;
    protected ViewManager viewManager;


    public String getViewName() {
        return viewName;
    }

    public abstract void renderView() throws SQLException, IOException;
}
