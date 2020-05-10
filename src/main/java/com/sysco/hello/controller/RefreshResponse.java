package com.sysco.hello.controller;

public class RefreshResponse {
    String color;
    String bannerText;

    public RefreshResponse() {
    }

    public RefreshResponse(String color, String bannerText) {
        this.color = color;
        this.bannerText = bannerText;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBannerText() {
        return bannerText;
    }

    public void setBannerText(String bannerText) {
        this.bannerText = bannerText;
    }
}
