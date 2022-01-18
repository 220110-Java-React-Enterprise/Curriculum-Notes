public abstract class View {

    protected String viewName;
    protected ViewManager viewManager;


    public String getViewName() {
        return viewName;
    }

    public abstract void renderView();
}
