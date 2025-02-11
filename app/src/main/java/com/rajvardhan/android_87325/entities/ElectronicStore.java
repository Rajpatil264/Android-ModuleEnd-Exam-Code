package com.rajvardhan.android_87325.entities;

import java.io.Serializable;

public class ElectronicStore implements Serializable {
    private int pid;
    private String pname;
    private String category;
    private String price;

    public ElectronicStore(){

    }

    public ElectronicStore(int pid, String pname, String category, String price) {
        this.pid = pid;
        this.pname = pname;
        this.category = category;
        this.price = price;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ElectronicStore{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
