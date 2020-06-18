package com.tdtruong.iotlight.Model;
import com.google.gson.Gson;

public class SplitData {
    private int temperature;
    private int humidity;
    public void setData(String inputData){
        Gson g = new Gson();
        DataModel dataModel = g.fromJson(inputData, DataModel.class);

        this.temperature = (int) dataModel.values.get(0);
        this.humidity = (int) dataModel.values.get(1);
    }
    public int getTemp(){
        return this.temperature;
    }
    public int getHumi(){
        return this.humidity;
    }
}
