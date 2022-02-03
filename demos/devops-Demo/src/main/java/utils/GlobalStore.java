package utils;

public class GlobalStore {
    private static DataObject obj;
    private static DataObject superObj;

    public static DataObject getObj() {
        return obj;
    }

    public static void setObj(DataObject obj) {
        GlobalStore.obj = obj;
    }

    public static DataObject getSuperObj() {
        return superObj;
    }

    public static void setSuperObj(DataObject superObj) {
        GlobalStore.superObj = superObj;
    }
}
