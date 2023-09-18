package com.campusdual.ejercicio5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {

    private String name;
    private String lastName;
    private String surName;
    private Integer weight;
    private Integer height;
    private Integer age;
    private Gender gender;
    private Map<String, Diet> dietList;

    public Customer(String name, String lastName, String surName, Integer weight, Integer height, Integer age, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.surName = surName;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = Gender.getByString(gender);
        this.dietList = new HashMap<>();
    }

    public Customer() {

        this.dietList = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Map<String, Diet> getDietList() {
        return dietList;
    }

    public void setDietList(Map<String, Diet> dietList) {
        this.dietList = dietList;
    }
}
