package com.example.dinn.bmiapp;

public class PersonBMIHistory {
    private String height;
    private String weight;
    private String bmi;
    private String date;

    public PersonBMIHistory(){}

    public PersonBMIHistory(String height, String weight, String bmi, String date) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.date = date;
    }


    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.valueOf(getBmi())+"           "+getDate();
    }
}
