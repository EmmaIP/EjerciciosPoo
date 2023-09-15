package com.campusdual.ejercicio4;

import com.campusdual.alimentos.Food;

import java.util.List;
import java.util.Scanner;

/*
* --Escribe un programa que utilice la clase Dieta y despliegue un menú donde puedas añadir alimentos.
* El menú tendrá las siguientes opciones.
	-1. Crear/reiniciar dieta: crea o reemplaza la dieta inicial
		-a. Sin limite
		-b. Por calorías
		-c. Por macronutrientes
		-d. Por datos personales
	-2. Mostrar información: muestra calorías y macronutrientes de la dieta
	-3. Agregar alimento: agrega un alimento a la dieta actual y añade ese alimento a la lista de alimentos disponible
		-a. Nuevo alimento
		-b. Alimento existente
	-4. Salir
* */
public class Menu {

    public void showMenu(Diet diet) { //método info total de la dieta
        if(diet != null) {
            System.out.println("La información de la dieta es:\n\t" +
                    diet.getTotalCalories() + ": total de calorías\n\t" +
                    diet.getTotalProteins() + ": total de proteínas\n\t" +
                    diet.getTotalFats() + ": total de grasas\n\t" +
                    diet.getTotalCarbs() + ": total de carbos\n\t" +
                    diet.seeNumberFoods() + ": total de alimentos");
            System.out.println("Lista de alimentos:\n\t" + diet.seeFoods());
            System.out.println("Pulse 3 para añadir/modificar alimento");
            System.out.println("Pulse 4 para salir");
        }else{
            System.out.println("No hay ninguna dieta");
            System.out.println("Vuelva al paso 1");
        }
    }

    public Diet createNew() {    //método crear dieta
        Scanner keyboard = new Scanner(System.in);
        String election = keyboard.next().toLowerCase();
        keyboard.nextLine();
        Diet diet = null;
        switch (election) {
            case "a":
                System.out.println("Dieta sin límites creada");
                System.out.println("Pulse 3 para añadir alimento");
                diet = new Diet();
                break;
            case "b":
                System.out.println("Elegir calorías máximas:");
                Integer maxCalories = keyboard.nextInt();
                keyboard.nextLine();
                diet = new Diet(maxCalories);
                System.out.println("Dieta con " + maxCalories + " calorías máximas creada");
                System.out.println("Pulse 3 para añadir alimento");
                break;
            case "c":
                System.out.println("Elegir macros máximos:");
                System.out.println("Número de grasas:");
                Integer maxFats = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Número de carbos:");
                Integer maxCarbs = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Número de proteínas:");
                Integer maxProteins = keyboard.nextInt();
                keyboard.nextLine();
                diet = new Diet(maxFats, maxCarbs, maxProteins);
                System.out.println("Dieta creada con:\n\t " + maxFats + " grasas\n\t"
                        + maxCarbs + " carbos\n\t" + maxProteins + " proteínas");
                System.out.println("Pulse 3 para añadir alimento");
                break;
            case "d":
                System.out.println("Ingrese datos personales:");
                System.out.println("Género: true si es mujer, false si es hombre");
                Boolean women = Boolean.valueOf(keyboard.next().toLowerCase());
                keyboard.nextLine();
                System.out.println("Edad en años:");
                Integer age = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Altura en cm:");
                Integer height = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Peso en kg netos:");
                Integer weightPerson = keyboard.nextInt();
                keyboard.nextLine();
                diet = new Diet(women, age, height, weightPerson);
                System.out.println("Dieta personal creada con "
                        + diet.calculateMetabolism(women, age, height, weightPerson) + " calorías máximas");
                System.out.println("Pulse 3 para añadir alimento");
                break;
            default:
                System.out.println("Debe elegir una opción entre a y d");
                break;
        }
        //de haber aquí un do/while(election.compareToIgnoreCase(""))
        return diet;
    }

    public void addNewFood(Diet diet, List<Food> foods) { //método añadir alimento
        if(diet==null) {
            System.out.println("No hay ninguna dieta creada");
            System.out.println("Vuelva al paso 1");
            return;
        }
        Food food = null;
        System.out.println("Elegir entre 1 y 2:");
        System.out.println("1. Nuevo alimento\n" + "2. Alimento existente");
        Scanner keyboard = new Scanner(System.in);
        Integer election = keyboard.nextInt();
        keyboard.nextLine();
        switch (election) {
            case 1:
                System.out.println("Complete los datos:");
                System.out.println("Nombre:");
                String name = keyboard.next();
                keyboard.nextLine();
                System.out.println("Nivel de grasas:");
                Integer carbs = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Nivel de carbos:");
                Integer fats = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Nivel de proteínas:");
                Integer proteins = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Peso en gramos:");
                Integer weight = keyboard.nextInt();
                keyboard.nextLine();
                Food newFood = new Food(name, carbs, fats, proteins);
                if(diet.getMaxCalories()!= null) {
                    Integer caloriesFood = (int) (newFood.getCalories(weight));
                    if((diet.getTotalCalories() + caloriesFood) > diet.getMaxCalories()) {
                        System.out.println("La cantidad máxima de calorías se ha superado");
                        return;
                    }
                }
                if(diet.getMaxCarbs() != null || diet.getMaxFats() != null || diet.getMaxProteins() != null) {
                    Integer carbsFood = (int) (newFood.getCarbs() * weight/100);
                    Integer fatsFood = (int) (newFood.getFats() * weight/100);
                    Integer proteinsFood = (int) (newFood.getProteins() * weight/100);
                    if(diet.getMaxCarbs() < carbsFood) {
                        System.out.println("Los carbos máximos han sido superados");
                    }
                    if(diet.getMaxFats() < fatsFood) {
                        System.out.println("Las grasas máximas han sido superadas");
                    }
                    if(diet.getMaxProteins() < proteinsFood) {
                        System.out.println("Las proteínas máximas han sido superadas");
                    }
                }
                foods.add(newFood);
                diet.addFood(newFood, weight);
                System.out.println("El alimento se ha añadido a la lista");
                System.out.println("Para añadir otro alimento pulse 3");
                System.out.println("Para ver detalles de la dieta pulse 2");
                System.out.println("Para salir del programa pulse 4");
                break;
            case 2:
                if(foods.size()!= 0) {
                    System.out.println("Elegir entre los siguientes alimentos:");
                    for(int i = 1; i < foods.size(); i++){
                        System.out.println(i + " " + food.getName());
                    }
                    Integer index = keyboard.nextInt();
                    keyboard.nextLine();
                    Food chosenFood = foods.get(index);
                    System.out.println("Peso en gramos:");
                    Integer weightFood = keyboard.nextInt();
                    keyboard.nextLine();
                    diet.addFood(chosenFood, weightFood);
                }else {
                    System.out.println("No existen alimentos en la dieta");
                    System.out.println("Vuelva al paso 3 y seleccione la opción 1 nuevo alimento");
                }
                System.out.println("Para añadir/ver otro alimento pulse 3");
                System.out.println("Para ver detalles de la dieta pulse 2");
                System.out.println("Para salir del programa pulse 4");
                break;
            default:
                System.out.println("Debe elegir entre 1 y 2");
                System.out.println("Para salir del programa pulse 4");
                break;
        }
    }


}
