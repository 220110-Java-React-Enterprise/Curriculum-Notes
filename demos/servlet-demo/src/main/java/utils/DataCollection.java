package utils;

import java.util.ArrayList;
import java.util.List;

public class DataCollection {
    public List<DataObject> dataCollection;

    public DataCollection() {
        dataCollection = new ArrayList<>();
    }

    public List<DataObject> getDataCollection() {
        return dataCollection;
    }

    public void setDataCollection(List<DataObject> dataCollection) {
        this.dataCollection = dataCollection;
    }
}
