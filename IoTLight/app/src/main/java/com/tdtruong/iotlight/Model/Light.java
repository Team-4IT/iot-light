package com.tdtruong.iotlight.Model;

public class Light {
    private String id;
    private int intensity_light;

    public Light(String id, int intensity_light) {
        this.id = id;
        this.intensity_light = intensity_light;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIntensity_light() {
        return intensity_light;
    }

    public void setIntensity_light(int intensity_light) {
        this.intensity_light = intensity_light;
    }
}
