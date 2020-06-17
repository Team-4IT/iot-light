package com.tdtruong.iotlight.Model;

public class User {
    private String id;
    private String full_name;
    private String usename;
    private String password;
    private String profile_img_url;
    private String create_at;

    public User(String id, String full_name, String usename, String password, String profile_img_url, String create_at) {
        this.id = id;
        this.full_name = full_name;
        this.usename = usename;
        this.password = password;
        this.profile_img_url = profile_img_url;
        this.create_at = create_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_img_url() {
        return profile_img_url;
    }

    public void setProfile_img_url(String profile_img_url) {
        this.profile_img_url = profile_img_url;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }
}
