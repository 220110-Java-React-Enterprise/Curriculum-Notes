package Views;

import Persistence.ItemModel;
import Persistence.ItemRepo;
import Utils.ContextStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public class CreateNewItemView  extends View {
    public CreateNewItemView() {
        viewName = "newItem";
        viewManager = ViewManager.getViewManager();
    }
    @Override
    public void renderView() throws SQLException, IOException {
        System.out.println("Creating new ToDo Item: ");
        System.out.println("Enter task: ");

        String task = viewManager.getScanner().nextLine();
        ItemModel item = new ItemModel(task, false, ContextStore.getCurrentUser().getUserId());
        ItemRepo repo = new ItemRepo();
        repo.create(item);

        viewManager.navigate("itemList");
    }
}
