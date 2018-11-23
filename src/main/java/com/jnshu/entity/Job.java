package com.jnshu.entity;

public class Job {
    private int id;
    private String type;
    private String introduce;
    private int difficulty;
    private String picture;
    private int entry;
    private int need;
    private String pay1;
    private String pay2;
    private String pay3;
    private long create_at;
    private long update_at;
    private String growth;
    private int proCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getEntry() {
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    public int getNeed() {
        return need;
    }

    public void setNeed(int need) {
        this.need = need;
    }

    public String getPay1() {
        return pay1;
    }

    public void setPay1(String pay1) {
        this.pay1 = pay1;
    }

    public String getPay2() {
        return pay2;
    }

    public void setPay2(String pay2) {
        this.pay2 = pay2;
    }

    public String getPay3() {
        return pay3;
    }

    public void setPay3(String pay3) {
        this.pay3 = pay3;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }
    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }

    public int getProCount() {
        return proCount;
    }

    public void setProCount(int proCount) {
        this.proCount = proCount;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", introduce='" + introduce + '\'' +
                ", difficulty=" + difficulty +
                ", picture='" + picture + '\'' +
                ", entry=" + entry +
                ", need=" + need +
                ", pay1='" + pay1 + '\'' +
                ", pay2='" + pay2 + '\'' +
                ", pay3='" + pay3 + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", growth='" + growth + '\'' +
                ", proCount=" + proCount +
                '}';
    }
}

