package com.tdtruong.iotlight.Model;
import com.google.gson.Gson;

import java.util.ArrayList;

public class DataModel {
    public String device_id;
    public ArrayList values;
    public String toString(){
        return new Gson().toJson(this);
    }
}
