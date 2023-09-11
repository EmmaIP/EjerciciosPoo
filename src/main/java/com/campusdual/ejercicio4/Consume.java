package com.campusdual.ejercicio4;

import com.campusdual.alimentos.Food;

public class Consume {
    private Food food;
    private Integer weight;

    public Consume(Food food, Integer weight) {
        this.food = food;
        this.weight = weight;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
