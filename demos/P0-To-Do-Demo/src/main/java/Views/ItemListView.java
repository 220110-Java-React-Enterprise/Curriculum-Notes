package Views;

import Persistence.ItemModel;
import Persistence.ItemRepo;
import Utils.ContextStore;
import Utils.CustomLinkedList;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ItemListView extends View {
    public ItemListView() {
        viewName = "itemList";
        viewManager = ViewManager.getViewManager();
    }
    @Override
    public void renderView() throws SQLException, IOException {
        System.out.println("To Do Items for user: " + ContextStore.getCurrentUser().getUsername());
        System.out.println("===========================================");
        ItemRepo repo = new ItemRepo();
        List<ItemModel> list = repo.getAllItemsByUserId(ContextStore.getCurrentUser().getUserId());

        int i = 0;
        for (ItemModel item : list) {
            System.out.println(i + ") " + item.toString());
            i++;
        }
        System.out.println("===========================================");

        System.out.println("1) Create new ToDo Item.\n" +
                "2) Mark ToDo Item complete.\n" +
                "Q) Quit.");

        String input = viewManager.getScanner().nextLine();
        switch(input) {
            case "1":
                viewManager.navigate("newItem");
                break;
            case "2":
                viewManager.navigate("markComplete");
                break;
            case "Q":
                viewManager.quit();
                break;
            default:
                System.out.println("\nOops, try again...\n\n\n");
                break;
        }
    }
}
