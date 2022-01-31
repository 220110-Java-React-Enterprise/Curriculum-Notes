package utils;

public class GlobalStore {
    private static DataObject obj;

    public static DataObject getObj() {
        return obj;
    }

    public static void setObj(DataObject obj) {
        GlobalStore.obj = obj;
    }
}
