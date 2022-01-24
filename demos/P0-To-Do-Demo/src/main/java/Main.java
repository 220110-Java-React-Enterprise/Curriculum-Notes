import Persistence.ItemModel;
import Persistence.ItemRepo;
import Persistence.UserModel;
import Persistence.UserRepo;
import Utils.ConnectionManager;
import Utils.CustomLinkedList;
import Utils.CustomListInterface;
import Utils.ViewManager;
import Views.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String ...args) {

        ViewManager.getViewManager().registerView(new WelcomeView());
        ViewManager.getViewManager().registerView(new RegisterView());
        ViewManager.getViewManager().registerView(new LoginView());
        ViewManager.getViewManager().registerView(new ItemListView());
        ViewManager.getViewManager().registerView(new CreateNewItemView());
        ViewManager.getViewManager().registerView(new MarkCompleteView());
        //ViewManager.getViewManager().registerView(new NewItemView());


        try {
            Connection conn = ConnectionManager.getConnection();

            ViewManager.getViewManager().navigate("welcome");
            while(ViewManager.getViewManager().isRunning()) {
                ViewManager.getViewManager().render();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
