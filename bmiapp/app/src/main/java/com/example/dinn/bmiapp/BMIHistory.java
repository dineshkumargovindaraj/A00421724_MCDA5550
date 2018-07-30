package com.example.dinn.bmiapp;

public class BMIHistory {
    private double height;
    private double weight ;
    // TO do add the Date

    public BMIHistory(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getResult() {
        return weight / (height * height);
    }

    @Override
    public String toString() {
        return String.valueOf(getResult());
    }

}
