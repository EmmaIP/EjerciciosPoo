package com.campusdual.ejercicio6.DAO;

import com.campusdual.ejercicio6.Food;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {
    public FoodDAO() {
    }
    private void saveFood(Food food) {
        String fileName = "Foods.txt";
        File file = new File(fileName);

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(file, true);  //cambiar abajo, no hace falta el stringBuilder
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {

            if(!file.exists()) {
                file.createNewFile();
                System.out.println("Archivo creado: " + fileName);
            }

            StringBuilder stringBuilder = new StringBuilder();
            String newLine;

            while((newLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(newLine);
            }
            stringBuilder.append(food.toString());

            bufferedWriter.write(stringBuilder.toString());

        }
        catch(IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    private List<Food> parseFood() {
        String fileName = "Foods.txt";
        File file = new File(fileName);
        List<Food> foodList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {

            return foodList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
