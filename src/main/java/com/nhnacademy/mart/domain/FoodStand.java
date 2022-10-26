package com.nhnacademy.mart.domain;

import java.util.ArrayList;

public class FoodStand {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food){
        this.foods.add(food);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }
}
