package com.tdtruong.iotlight.Model;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AdjustOutputDevice {
    private boolean status = false; // True is On
    private int volume = 0;
    private boolean alert = false;

    public void modify(int temp, int humi){
        if (temp<10 || temp>80 || humi<50 || humi>90){
            this.status = false;
            this.alert = true;
        }
        if (temp>=30 && humi>=50){
            this.status = true;
            this.volume = ((temp-30) / 70) * 5000 - ((humi - 50) / 50)* 500;
            this.volume= max(0,this.volume);
            this.volume = min(this.volume,5000);
        }
    }
    public boolean getStatus() {
        return this.status;
    }
    public int getVolume() {
        return this.volume;
    }
    public boolean getAlert() {
        return this.alert;
    }
}
