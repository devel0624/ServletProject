package com.nhnacademy.mart.domain;


public class Food {
    private final String name;
    private final int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Food(Food food){
        this.name = food.getName();
        this.price = food.getPrice();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
