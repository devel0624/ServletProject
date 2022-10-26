package com.nhnacademy.mart.domain;

import java.util.ArrayList;

public class BuyList {
    private final ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public static class Item {
        private final String name;
        private final int price;
        private final int amount;
        public Item(String name,int price, int amount) {
            this.name = name;
            this.price = price;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }

        public int getPrice() {
            return price;
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
