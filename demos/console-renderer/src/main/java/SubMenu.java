public class SubMenu extends View{

    public SubMenu() {
        viewName = "SubMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("========== Sub Menu ==========");
        System.out.println("Welcome, " + DataStore.getName());

        viewManager.quit();

    }
}
