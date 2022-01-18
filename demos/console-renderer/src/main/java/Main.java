public class Main {
    public static void main(String ...args){
        ViewManager viewManager = ViewManager.getViewManager();

        viewManager.registerView(new MainMenu());
        viewManager.registerView(new SubMenu());

        viewManager.navigate("MainMenu");

        while(viewManager.isRunning()) {
            viewManager.render();
        }


    }
}
