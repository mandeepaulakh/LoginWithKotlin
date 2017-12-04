package com.dupleit.demo.mapproject.Model;

/**
 * Created by rajesh on 4/11/17.
 */

public class MainActiviyModel {

    private int viewType;
    private Object object;

    public MainActiviyModel(int viewType, Object object) {
        this.viewType = viewType;
        this.object = object;
    }

    public int getViewType() {
        return viewType;
    }


    public Object getObject() {
        return object;
    }

}
