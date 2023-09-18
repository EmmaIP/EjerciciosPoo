package com.campusdual.ejercicio6;
import com.campusdual.ejercicio6.Diet;
import com.campusdual.ejercicio6.Food;
import com.campusdual.ejercicio6.Gender;
import com.campusdual.ejercicio6.Kb;
import com.campusdual.ejercicio6.exceptions.MaxCaloriesReachedException;
import com.campusdual.ejercicio6.exceptions.MaxCarbsReachedException;
import com.campusdual.ejercicio6.exceptions.MaxFatsReachedException;
import com.campusdual.ejercicio6.exceptions.MaxProteinsReachedException;

import java.util.*;


public class DietProgram {

    private com.campusdual.ejercicio6.Diet diet=null;
    private List<com.campusdual.ejercicio6.Food> foodList;
    private Map<String, com.campusdual.ejercicio6.Diet> dietList;
    private List<Customer> customerList;

    public static final String MAX_CALORIES = "MAX_CALORIES";
    public static final String MAX_CARBS = "MAX_CARBS";
    public static final String MAX_FATS = "MAX_FATS";
    public static final String MAX_PROTEINS = "MAX_PROTEINS";

    public static final String NAME = "NAME";
    public static final String LASTNAME = "LASTNAME";
    public static final String SURNAME = "SURNAME";
    public static final String GENDER = "GENDER";
    public static final Integer WEIGHT = null;
    public static final Integer HEIGHT = null;
    public static final Integer AGE = null;

    public static final String DAY_M = "monday";
    public static final String DAY_T = "tuesday";
    public static final String DAY_W = "wednesday";
    public static final String DAY_TH = "thursday";
    public static final String DAY_F = "friday";
    public static final String DAY_S = "saturday";
    public static final String DAY_SU = "sunday";
    private List<String> daysOfWeek;

        public DietProgram(){

            foodList = new ArrayList<>();
            dietList = new HashMap<>();
            customerList = new ArrayList<>();
            daysOfWeek = Arrays.asList(DAY_M, DAY_T, DAY_W, DAY_TH, DAY_F, DAY_S, DAY_SU);
        }

        public void showMenuProgram(){
            System.out.println("########################################################");
            System.out.println("################# Programa de dietas ###################");
            System.out.println("########################################################");
            Integer option;
            do{
                System.out.println("Escriba una opción:");
                System.out.println("===================================");
                System.out.println("1-Gestión de dietas");
                System.out.println("2-Gestión de clientes");
                System.out.println("3-Salir del programa");
                option = com.campusdual.ejercicio6.Kb.getOption(1,3);
                switch (option){
                    case 1:
                        dietManager();
                        break;
                    case 2:
                        customerManager();
                        break;
                    case 3:
                        System.out.println("Salir del programa");
                        break;
                }
            }while(option != 3);
        }

        private void dietManager() {

            System.out.println("########################################################");
            System.out.println("################# Gestión de dietas ###################");
            System.out.println("########################################################");
            Integer option;
            do{
                System.out.println("Escriba una opción:");
                System.out.println("===================================");
                System.out.println("1-Agregar dieta");
                System.out.println("2-Mostrar dietas y modificarlas");
                System.out.println("3-Eliminar dieta");
                System.out.println("4-Volver atrás");
                option = com.campusdual.ejercicio6.Kb.getOption(1,4);
                switch (option){
                    case 1:
                        createDiet();
                        break;
                    case 2:
                        manageDiets();
                        break;
                    case 3:
                        deleteDiet();
                        break;
                    case 4:
                        break;
                }
            }while(option != 4);
        }

        private String getSelectedDiet() {    //método seleccionar una dieta en concreto por el nombre
            if(dietList.size() == 0) {
                System.out.println("No existe ninguna dieta, cree una primero");
                createDiet();
            }
            System.out.println("Lista de dietas:");
            Integer i = 1;
            List<String> options = new ArrayList<>();
            for (String key: dietList.keySet()) {
                options.add(key);
                System.out.println(i + "." + key);
                i++;
            }
            System.out.println((i + 1) + "." + "Salir");
            Integer  selected = com.campusdual.ejercicio6.Kb.getOption(1, i + 1);
            if(selected== i + 1) {
                return null;
            }
            return options.get(selected -1);
        }
        private void createDiet() {       //método crear nueva dieta recogido del createMenu
            String dietName;
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Crear dieta");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Escriba un nombre para su dieta:");
            System.out.println("===================================");
            dietName = com.campusdual.ejercicio6.Kb.nextLine();
            Boolean dietAlreadyExists;     //comprobar primero que el nombre de dieta ya existe
            do {
                dietAlreadyExists = dietList.containsKey(dietName);
                if(dietAlreadyExists) {
                    System.out.println("Ya existe una dieta con ese nombre");
                }
            }
            while(dietAlreadyExists);

            System.out.println("Escriba una opción:");
            System.out.println("===================================");
            System.out.println("1-Dieta sin límite");
            System.out.println("2-Dieta por calorías");
            System.out.println("3-Dieta por macronutrientes");
            System.out.println("4-Dieta por datos personales");
            System.out.println("5-Dieta por datos del cliente");
            Integer option = com.campusdual.ejercicio6.Kb.getOption(1,5);
            switch (option) {
                case 1:
                    dietList.put(dietName, new com.campusdual.ejercicio6.Diet());
                    System.out.println("Se ha creado una dieta sin límites");
                    break;
                case 2:
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Escriba número de calorías");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    Integer calories = com.campusdual.ejercicio6.Kb.forceNextInt();
                    dietList.put(dietName, new com.campusdual.ejercicio6.Diet(dietName,calories));
                    System.out.println("Se ha creado una dieta con " + calories + " calorías máximas");
                    break;
                case 3:
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Escriba los macronutrientes");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Carbohidratos:");
                    Integer carbs = com.campusdual.ejercicio6.Kb.forceNextInt();
                    System.out.println("Grasas:");
                    Integer fats = com.campusdual.ejercicio6.Kb.forceNextInt();
                    System.out.println("Proteínas:");
                    Integer proteins = com.campusdual.ejercicio6.Kb.forceNextInt();
                    dietList.put(dietName, new com.campusdual.ejercicio6.Diet(fats, carbs, proteins));
                    System.out.println("Se ha creado una dieta con Carbohidratos:" + carbs + ", Grasas:" + fats + " ,Proteínas:" + proteins);
                    break;
                case 4:
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Escriba los datos personales del paciente");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Peso:");
                    Integer weight = com.campusdual.ejercicio6.Kb.forceNextInt();
                    System.out.println("Altura:");
                    Integer height = com.campusdual.ejercicio6.Kb.forceNextInt();
                    System.out.println("Edad:");
                    Integer age = com.campusdual.ejercicio6.Kb.forceNextInt();
                    System.out.println("Mujer u Hombre(m/h):");
                    String sexCharacter = com.campusdual.ejercicio6.Kb.nextLine();
                    dietList.put(dietName, new com.campusdual.ejercicio6.Diet(com.campusdual.ejercicio6.Gender.getByString(sexCharacter), age, height, weight));
                    System.out.println("Se ha creado una dieta de " + this.diet.getMaxCalories() + " calorías máximas");
                    break;
                case 5:
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Dieta específica para el cliente");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    Customer customer = getSelectedCustomer();
                    dietList.put(dietName, new com.campusdual.ejercicio6.Diet(customer.getGender(), customer.getAge(), customer.getHeight(), customer.getWeight()));
                    System.out.println("Se ha creado una dieta de cliente de" + dietList.get(customer).getMaxCalories() + " calorías máximas");
            }
        }
        private void deleteDiet() {  //método borrar una dieta en concreto
            System.out.println("Seleccione una dieta para eliminarla:");
            String selected = getSelectedDiet();
            if(selected == null) {
                System.out.println("Operación cancelada");
            }else {
                if(dietsForCustomers(selected)) {
                    System.out.println("La dieta no se puede eliminar porque está asociada a un cliente");
                    return;
                }
                if(dietList.remove(selected) == null) {
                    System.out.println("No se puede eliminar");
                }
            }
        }

        private void manageDiets() {

            System.out.println("Seleccione una dieta para modificarla:");
            String selected = getSelectedDiet();
            if(selected == null) {
                System.out.println("Operación cancelada");
            } else {
                com.campusdual.ejercicio6.Diet selectedDiet = dietList.get(selected);
                Integer option;
                do{
                    showDetailsMenu(selectedDiet);
                    System.out.println("Opciones para modificar la dieta:");
                    System.out.println("1. Modificar la dieta por las calorías máximas");
                    System.out.println("2. Modificar la dieta por los carbos máximos");
                    System.out.println("3. Modificar la dieta por las grasas máximas");
                    System.out.println("4. Modificar la dieta por las proteínas máximas");
                    System.out.println("5. Añadir un alimento a la dieta");
                    System.out.println("6. Eliminar un alimento de la dieta");
                    System.out.println("7. Salir de las modificaciones");
                    option = com.campusdual.ejercicio6.Kb.getOption(1,7);
                    switch (option){
                        case 1:
                            updateDiet(selectedDiet, MAX_CALORIES);
                            break;
                        case 2:
                            updateDiet(selectedDiet, MAX_CARBS);
                            break;
                        case 3:
                            updateDiet(selectedDiet, MAX_FATS);
                            break;
                        case 4:
                            updateDiet(selectedDiet, MAX_PROTEINS);
                            break;
                        case 5:
                            addFoodMenu(selectedDiet);
                            break;
                        case 6:
                            deleteFoodMenu(selectedDiet);
                            break;
                        case 7:
                            System.out.println("Salir del programa");
                            break;
                    }
                } while(option!=7);
            }
        }

        private void deleteFoodMenu(com.campusdual.ejercicio6.Diet diet) {  //para eliminar un alimento de una dieta concreta
            if (diet == null) {
                System.out.println("Para eliminar alimentos hace falta iniciar una dieta");
                return;
            }
            if (foodList.size() == 0) {
                System.out.println("Para eliminar un alimento de la dieta, deben existir alimentos previos");
                return;
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Elimine un alimento de la lista:");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            Integer i = 1;
            for(com.campusdual.ejercicio6.Food food:foodList){
                System.out.println(i+"- "+food.getName());
                i++;
            }
            Integer element = com.campusdual.ejercicio6.Kb.getOption(1,i);
            foodList.remove(element);
            System.out.println("Se ha eliminado el alimento correctamente");
        }
        private void updateDiet(com.campusdual.ejercicio6.Diet selectedDiet, String attribute) {  //modificar un atributo concreto
            System.out.println("Introduce un nuevo valor");
            Integer maxValue = com.campusdual.ejercicio6.Kb.forceNextInt();
            if(MAX_CALORIES.equalsIgnoreCase(attribute)) {
                selectedDiet.setMaxCalories(maxValue);
            } else if (MAX_CARBS.equalsIgnoreCase(attribute)) {
                selectedDiet.setMaxCarbs(maxValue);
            } else if (MAX_FATS.equalsIgnoreCase(attribute)) {
                selectedDiet.setMaxFats(maxValue);
            } else if (MAX_PROTEINS.equalsIgnoreCase(attribute)) {
                selectedDiet.setMaxProteins(maxValue);
            }
        }

        private void addFoodMenu(com.campusdual.ejercicio6.Diet diet) {  //se le pasa Diet, cambiando this.diet por el parámetro
            if(diet==null){
                System.out.println("Para agregar alimentos hace falta iniciar una dieta");
                return;
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Agregar Alimentos a la dieta");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Escriba una opción:");
            System.out.println("===================================");
            System.out.println("1-Agregar un nuevo alimento");
            System.out.println("2-Agregar más cantidad a un alimento ya existente");

            Integer option = com.campusdual.ejercicio6.Kb.getOption(1,2);
            switch (option){
                case 1:
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Datos de nuevo alimento");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Nombre del alimento:");
                    String name = com.campusdual.ejercicio6.Kb.nextLine();
                    System.out.println("Carbohidratos:");
                    Integer carbs = com.campusdual.ejercicio6.Kb.forceNextInt();
                    System.out.println("Grasas:");
                    Integer fats = com.campusdual.ejercicio6.Kb.forceNextInt();
                    System.out.println("Proteínas:");
                    Integer proteins = com.campusdual.ejercicio6.Kb.forceNextInt();
                    System.out.println("Gramos:");
                    Integer grams = com.campusdual.ejercicio6.Kb.forceNextInt();
                    com.campusdual.ejercicio6.Food newFood = new com.campusdual.ejercicio6.Food(name,carbs,fats,proteins);
                    validateAndAddFoodToDiet(newFood,grams, diet);    //pasar por parámetro Diet
                    foodList.add(newFood);
                    break;
                case 2:
                    if(foodList.size()==0){
                        System.out.println("Para agregar más cantidad, tienen que existir alimentos previos");
                        return;
                    }
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Seleccione un alimento:");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    Integer i = 1;
                    for(com.campusdual.ejercicio6.Food food:foodList){
                        System.out.println(i+"- "+food.getName());
                        i++;
                    }
                    System.out.println(i+"- Cancelar");
                    Integer element = com.campusdual.ejercicio6.Kb.getOption(1,i);
                    if(element==i){
                        System.out.println("Cancelando agregación");
                        return;
                    }
                    com.campusdual.ejercicio6.Food storedFood = foodList.get(element-1);
                    System.out.println("Indique el número de gramos de "+storedFood.getName());
                    Integer foodGrams = com.campusdual.ejercicio6.Kb.forceNextInt();
                    validateAndAddFoodToDiet(storedFood,foodGrams, diet); //añadir parámetro Diet
                    break;
            }
        }

        private void validateAndAddFoodToDiet(Food food, Integer grams, com.campusdual.ejercicio6.Diet diet){ //añadir parámetro Diet
            try{
                diet.addFood(food,grams);
            }catch (MaxCaloriesReachedException ecal){
                System.out.println("Se ha alcanzado el máximo valor de calorías permitido");
            }catch (MaxCarbsReachedException ecar){
                System.out.println("Se ha alcanzado el máximo valor de carbohidratos permitido");
            }catch (MaxFatsReachedException efat){
                System.out.println("Se ha alcanzado el máximo valor de grasas permitido");
            }catch (MaxProteinsReachedException epro){
                System.out.println("Se ha alcanzado el máximo valor de proteínas permitido");
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        private void showDetailsMenu(com.campusdual.ejercicio6.Diet diet) {   //cambiar this-diet por parámetro
            if(diet!=null){
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Detalles de la dieta");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                if(diet.getMaxCalories()!=null){
                    System.out.println("El número máximo de calorías es:"+ diet.getMaxCalories());
                }
                if(diet.getMaxCarbs() != null || diet.getMaxFats() != null || diet.getMaxProteins() != null){
                    System.out.println("Los valores máximos de macronutrientes son: Carbohidratos:"+ diet.getMaxCarbs()+" , Grasas:"+ diet.getMaxFats()+" , Proteinas:"+ diet.getMaxProteins());
                }
                System.out.println("Número de alimentos de la dieta:"+ diet.getFoodNumber());
                System.out.println("Calorías:"+ diet.getTotalCalories());
                System.out.println("Carbohidratos:"+ diet.getTotalCarbs());
                System.out.println("Grasas:"+ diet.getTotalFats());
                System.out.println("Proteínas:"+ diet.getTotalProteins());
                System.out.println("Alimentos de la dieta:"+ diet.getDietIntakes());
            }else{
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("La dieta no esta iniciada");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            }
        }
        private Customer getSelectedCustomer() {    //seleccionar una cliente en concreto
        if(customerList.size() == 0) {
            System.out.println("No existe ningún cliente");
            return null;
        }
        System.out.println("Lista de clientes a escoger:");
        Integer i = 1;
        for (Customer element: customerList) {
            System.out.println(i + "." + element.getName());
            i++;
        }
        System.out.println((i + 1) + "." + "Salir");
        Integer  selected = com.campusdual.ejercicio6.Kb.getOption(1, i);
        if(selected== i + 1) {
            return null;
        }else {
            return customerList.get(selected-1);
            }
        }

        private void customerManager() {
            System.out.println("########################################################");
            System.out.println("################# Gestión de clientes ###################");
            System.out.println("########################################################");
            Integer option;
            do{
                System.out.println("Seleccione una opción:");
                System.out.println("===================================");
                System.out.println("1-Añadir cliente");
                System.out.println("2-Listar clientes y modificar datos");
                System.out.println("3-Eliminar cliente");
                System.out.println("4-Salir");
                option = com.campusdual.ejercicio6.Kb.getOption(1,4);
                switch (option){
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        manageCustomer();
                        break;
                    case 3:
                        deleteCustomer();
                        break;
                    case 4:
                        System.out.println("Salir del programa");
                        break;
                }
            }while(option != 4);
        }

    private void deleteCustomer() {
        System.out.println("Seleccione un cliente para eliminarlo:");
        Customer selected = getSelectedCustomer();
        if(selected == null) {
            System.out.println("Operación cancelada");
        }else {
            if(customerList.remove(selected)) {
                System.out.println("El cliente ha sido eliminado");
            }
        }
    }

    private void manageCustomer() {
        System.out.println("Seleccione un cliente para modificarlo:");
        Customer selected = getSelectedCustomer();
        if(selected == null) {
            System.out.println("Operación cancelada");
        } else {
            Integer option;
            do{
                showDetailsCustomer(selected);
                System.out.println("Opciones para modificar al cliente:");
                System.out.println("1. Cambiar el nombre");
                System.out.println("2. Cambiar el primer apellido");
                System.out.println("3. Cambiar el segundo apellido");
                System.out.println("4. Cambiar el peso");
                System.out.println("5. Cambiar la altura");
                System.out.println("6. Cambiar la edad");
                System.out.println("7. Cambiar el género");
                System.out.println("8. Añadir una dieta");
                System.out.println("9. Eliminar dieta");
                System.out.println("10. Salir");
                option = com.campusdual.ejercicio6.Kb.getOption(1,10);
                switch (option){
                    case 1:
                        updateCustomer(selected, NAME);
                        break;
                    case 2:
                        updateCustomer(selected, LASTNAME);
                        break;
                    case 3:
                        updateCustomer(selected, SURNAME);
                        break;
                    case 4:
                        updateIntCustomer(selected, WEIGHT);
                        break;
                    case 5:
                        updateIntCustomer(selected, HEIGHT);
                        break;
                    case 6:
                        updateIntCustomer(selected, AGE);
                        break;
                    case 7:
                        updateCustomer(selected, GENDER);
                        break;
                    case 8:
                        addDietCustomer(selected);
                        break;
                    case 9:
                        deleteDietCustomer(selected);
                        break;
                    case 10:
                        System.out.println("Salir del programa");
                        break;
                }
            } while(option!=10);
        }
    }


    private void deleteDietCustomer(Customer selected) { //elimina la dieta del día elegido
        System.out.println("Seleccione un día de la semana");
        System.out.println("1. Lunes");
        System.out.println("2. Martes");
        System.out.println("3. Miércoles");
        System.out.println("4. Jueves");
        System.out.println("5. Viernes");
        System.out.println("6. Sábado");
        System.out.println("7. Domingo");
        System.out.println("8. Salir");
        Integer day = com.campusdual.ejercicio6.Kb.getOption(1, 8);
        if(day==8) {
            return;
        }
        String chosenDay = daysOfWeek.get(day -1);
        selected.getDietList().remove(chosenDay);
    }

    private void addDietCustomer(Customer selected) { //le asigna un nombre a la dieta según el día elegido
        System.out.println("Seleccione un día de la semana");
        System.out.println("1. Lunes");
        System.out.println("2. Martes");
        System.out.println("3. Miércoles");
        System.out.println("4. Jueves");
        System.out.println("5. Viernes");
        System.out.println("6. Sábado");
        System.out.println("7. Domingo");
        System.out.println("8. Salir");
        Integer day = com.campusdual.ejercicio6.Kb.getOption(1, 8);
        if(day==8) {
            return;
        }
        String chosenDay = daysOfWeek.get(day -1);  //día elegido
        String dietName = getSelectedDiet();    //con un nombre de dieta
        Map<String, com.campusdual.ejercicio6.Diet> newDietMap = selected.getDietList();
        Diet existingDiet = dietList.get(dietName);
        newDietMap.put(chosenDay, existingDiet);
        selected.setDietList(newDietMap);
    }

    private void updateCustomer(Customer selected, String attribute) { //modifica los atributos string
        System.out.println("Añada un valor nuevo");
        String newValue = com.campusdual.ejercicio6.Kb.nextLine();
        if(NAME.equalsIgnoreCase(attribute)) {
            selected.setName(newValue);
        } else if (LASTNAME.equalsIgnoreCase(attribute)) {
            selected.setLastName(newValue);
        } else if (SURNAME.equalsIgnoreCase(attribute)) {
            selected.setSurName(attribute);
        } else if (GENDER.equalsIgnoreCase(attribute)) {
            selected.setGender(com.campusdual.ejercicio6.Gender.getByString(attribute));
        }
    }
    private void updateIntCustomer(Customer selected, Integer attribute) { //modifica los atributos int
        System.out.println("Añada un valor nuevo");
        Integer newValue = com.campusdual.ejercicio6.Kb.nextInt();
        if(WEIGHT.equals(attribute)) {
            selected.setWeight(newValue);
        } else if (HEIGHT.equals(attribute)) {
            selected.setHeight(newValue);
        } else if (AGE.equals(attribute)) {
            selected.setAge(newValue);
        }
    }

    private void showDetailsCustomer(Customer selected) {  //me quedé aquí

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Información del cliente:");
        System.out.println("===================================");
        System.out.println("Nombre completo : " + selected.getName() + " "
                + selected.getLastName() + " " + selected.getSurName());
        System.out.println("===================================");
        System.out.println("Peso: " + selected.getWeight());
        System.out.println("===================================");
        System.out.println("Altura: " + selected.getHeight());
        System.out.println("===================================");
        System.out.println("Edad: " + selected.getAge());
        System.out.println("===================================");
        String gender = selected.getGender() == Gender.FEMALE ? "Mujer":"Hombre";
        System.out.println("Género: " + gender);
        System.out.println("===================================");
        System.out.println("Lista de dietas del cliente: ");
        int i = 1;
        for (String customerDietName: selected.getDietList().keySet()) {
            System.out.println((i) + "." + customerDietName);
            i++;
        }
    }

    private void addCustomer() {
        String customerName;
        String customerLastName;
        String customerSurName;
        Integer customerWeight;
        Integer customerHeight;
        Integer customerAge;
        String customerGender;
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Añadir cliente");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Escriba el nombre del cliente:");
        System.out.println("===================================");
        customerName = com.campusdual.ejercicio6.Kb.nextLine();
        System.out.println("Escriba el primer apellido del cliente:");
        System.out.println("===================================");
        customerLastName = com.campusdual.ejercicio6.Kb.nextLine();
        System.out.println("Escriba el segundo apellido del cliente:");
        System.out.println("===================================");
        customerSurName = com.campusdual.ejercicio6.Kb.nextLine();
        System.out.println("Anote el peso del cliente en kg:");
        System.out.println("===================================");
        customerWeight = com.campusdual.ejercicio6.Kb.forceNextInt();
        System.out.println("Anote la altura del cliente en cm:");
        System.out.println("===================================");
        customerHeight = com.campusdual.ejercicio6.Kb.forceNextInt();
        System.out.println("Anote la edad del cliente en años:");
        System.out.println("===================================");
        customerAge = com.campusdual.ejercicio6.Kb.forceNextInt();
        System.out.println("Género del cliente:");
        System.out.println("===================================");
        customerGender = Kb.nextLine();
        Customer newCustomer = new Customer(customerName, customerLastName, customerSurName, customerWeight, customerHeight, customerAge, customerGender);
        customerList.add(newCustomer);
    }

    private boolean dietsForCustomers(String dietName) {
        for (Customer customer: customerList) {
            for(String valueKey: customer.getDietList().keySet()) {
                if(dietName.equalsIgnoreCase(customer.getDietList().get(valueKey).getName())) {
                    return true;
                }
            }
        }
        return false;
    }

}

