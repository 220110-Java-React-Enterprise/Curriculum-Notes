package Views;

import Persistence.ItemModel;
import Persistence.ItemRepo;
import Utils.ContextStore;
import Utils.CustomLinkedList;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MarkCompleteView  extends View {
    public MarkCompleteView() {
        viewName = "markComplete";
        viewManager = ViewManager.getViewManager();
    }
    @Override
    public void renderView() throws SQLException, IOException {
        ItemRepo repo = new ItemRepo();
        List<ItemModel> list = repo.getAllItemsByUserId(ContextStore.getCurrentUser().getUserId());

        int i = 0;
        for (ItemModel item : list) {
            System.out.println(i + ") " + item.toString());
            i++;
        }
        System.out.println("===========================================");
        System.out.println("B) back\n Q) Quit\n");

        System.out.println("Which task is complete? ");

        String input = viewManager.getScanner().nextLine();

        switch (input) {
            case "B":
                viewManager.navigate("itemList");
                break;
            case "Q":
                viewManager.quit();
                break;
            default:
                try {
                    Integer selection = Integer.parseInt(input);
                    ItemModel selectedItem = list.get(selection);
                    selectedItem.setCompleted(true);
                    repo.update(selectedItem);

                } catch(NumberFormatException e) {
                    System.out.println("\nOops, try again...\n\n\n");
                }

        }

        viewManager.navigate("itemList");

    }
}