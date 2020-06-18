package com.tdtruong.iotlight.Model;

public class Device {
    private String id;
    private String position;
    private float temperature;
    private float humidity;

    public Device(String id, String position, float temperature, float humidity) {
        this.id = id;
        this.position = position;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public boolean isLimitedTemperature(float temperature){
        return (temperature > 50) || (temperature < 10);
    }

    public boolean isLimitedHumidity(float humidity){
        return (humidity > 85) || (humidity < 20);
    }
}
