package com.campusdual.ejercicio4;

import com.campusdual.alimentos.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuWorking {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Diet diet = null;
        List<Food> foods = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Seleccione entre 1 y 4:\n\t" +
                "1. Crear/reiniciar una dieta\n\t" +
                "2. Mostrar información de la dieta\n\t" +
                "3. Agregar alimento\n\t" +
                "4. Salir");
        Integer election;
        do{
            election = keyboard.nextInt();
            keyboard.nextLine();
            switch (election) {
                case 1:
                    System.out.println("Seleccione una opción entre a y d:\n\t" +
                            "a. Sin límite de calorías\n\t" +
                            "b. Por calorías\n\t" +
                            "c. Por macronutrientes\n\t" +
                            "d. Por datos personales\n\t");
                    diet = menu.createNew(diet);
                    break;
                case 2:
                    menu.showMenu(diet);
                    break;
                case 3:
                    System.out.println("-Añadir alimento-");
                    menu.addNewFood(diet, foods);

                    break;
                case 4:
                    System.out.println("-Salir del programa-");
                    //método acabar()?
                    break;
                default:
                    System.out.println("Debe elegir una opción del 1 al 4");
                    break;
            }
        }
        while(election != 4);
    }
}
