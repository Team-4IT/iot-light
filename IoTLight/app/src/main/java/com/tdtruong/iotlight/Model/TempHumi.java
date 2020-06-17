package com.tdtruong.iotlight.Model;

public class TempHumi {
    private String id;
    private float temperature;
    private float humidity;

    public TempHumi(String id, float temperature, float humidity) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
