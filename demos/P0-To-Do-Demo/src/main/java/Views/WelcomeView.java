package Views;

import Utils.ViewManager;

import java.util.Scanner;

public class WelcomeView extends View {
    public WelcomeView() {
        viewName = "welcome";
        viewManager = ViewManager.getViewManager();
    }


    @Override
    public void renderView() {
        System.out.println("Welcome to ToDoApp!\n" +
                "=======================\n" +
                "1) Register\n" +
                "2) Login\n" +
                "=======================\n");

        String input = viewManager.getScanner().nextLine();


        switch(input) {
            case "1":
                viewManager.navigate("register");
                break;
            case "2":
                viewManager.navigate("login");
                break;
            default:
                System.out.println("\nOops, try again...\n\n\n");
                break;
        }

    }
}
