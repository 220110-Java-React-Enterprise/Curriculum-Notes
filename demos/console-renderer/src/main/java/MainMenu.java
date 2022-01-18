public class MainMenu extends View{

    public MainMenu() {
        viewName = "MainMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        //prompt user
        System.out.println("========== Main Menu ==========");
        System.out.println("Enter name: ");

        //get input from user
        String input = viewManager.getScanner().nextLine();

        //preform validation?

        //store this for use later
        DataStore.setName(input);

        //navigate to next menu
        viewManager.navigate("SubMenu");

    }
}
