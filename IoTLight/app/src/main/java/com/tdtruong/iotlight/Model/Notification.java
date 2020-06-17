package com.tdtruong.iotlight.Model;

public class Notification {

    String title;
    String content;
    int warningimage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWarningimage() {
        return warningimage;
    }

    public void setWarningimage(int warningimage) {
        this.warningimage = warningimage;
    }

    public Notification() {
    }

    public Notification(String title, String content, int warningimage) {
        this.title = title;
        this.content = content;
        this.warningimage = warningimage;
    }
}
