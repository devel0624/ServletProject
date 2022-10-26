package com.nhnacademy.mart.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FoodList {

    public static Map<String, Integer> getFoodList(ArrayList<Food> foods ) {

        Map<String , Integer> foodList = new HashMap<>();

        foods.forEach(food -> {
            if( !foodList.containsKey(food.getName())){
                foodList.put(food.getName(),1);
            } else {
                foodList.replace(food.getName(), foodList.get(food.getName())+1);
            }
        });

        return foodList;
    }



}
