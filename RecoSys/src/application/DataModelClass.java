package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataModelClass {


    private List<String>nameList;

    private DataModelClass(ArrayList<String> nameList) {
        this.nameList = nameList;
    }

    public String getNameList() {
        return nameList.stream().collect(Collectors.joining("\n"));
    }

    public void setNameList(ArrayList<String> nameList) {
        this.nameList = nameList;
    }
}