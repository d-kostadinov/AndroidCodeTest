package com.rockspin.androiddevtest;

import java.util.List;

/**
 * Created by dobrikostadinov on 3/21/17.
 */

public class DataHolder {

    private static DataHolder instance;

    private List<CosmonautData> cosmonautDataList;

    public static DataHolder getInstance() {

        if (instance == null) {
            synchronized (DataHolder.class) {
                if (instance == null) {
                    instance = new DataHolder();
                }
            }
        }

        return instance;
    }

    public List<CosmonautData> getCosmonautDataList() {
        return cosmonautDataList;
    }

    public void setCosmonautDataList(List<CosmonautData> cosmonautDataList) {
        this.cosmonautDataList = cosmonautDataList;
    }

    private DataHolder() {
    }
}
