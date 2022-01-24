package Views;

import Persistence.UserModel;
import Persistence.UserRepo;
import Utils.ContextStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public class LoginView extends View {
    public LoginView() {
        viewName = "login";
        viewManager = ViewManager.getViewManager();
    }
    @Override
    public void renderView() throws SQLException, IOException {
        System.out.println("Uesr Login\n===============");
        System.out.println("Enter username:");
        String username =  viewManager.getScanner().nextLine();

        System.out.println("Enter password: ");
        String password =  viewManager.getScanner().nextLine();

        UserRepo repo = new UserRepo();
        UserModel user = repo.authenticate(username, password);

        if(user == null) {
            System.out.println("\nIncorrect credentials... \n\n\n");
            viewManager.navigate("welcome");
            return;
        }

        ContextStore.setCurrentUser(user);
        viewManager.navigate("itemList");

    }
}
