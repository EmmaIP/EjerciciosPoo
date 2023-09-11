package com.campusdual.ejercicio4;
import com.campusdual.alimentos.Food;
import java.util.ArrayList;
import java.util.List;

/*
* Escribe una clase dieta, que teniendo en cuenta una serie de alimentos, vaya sumando cantidades en gramos
* y calcule cuentas calorías, carbohidratos, proteinas y grasas genera la ingesta
La clase dieta tiene que tener las siguientes funcionalidades:
	-Diet(): crea una dieta sin límite de calorías
	-Diet(Integer maxCalories): crea una dieta con un máximo de calorías, en cuanto se supera ese máximo cuando se adjunta
	* un alimento se despliega un error
	-Diet(Integer maxFats, Integer maxCarbs, Integer maxProtein): crea una dieta con un máximo de estos tres valores, si
	* se supera alguno de ellos cuando se adjunta un alimento se indicará que atributo lo supera y desplegará un error
	-Diet(Boolean women, Integer age, Integer height, Integer weight): Calcula el metabolismo basal de la persona y lo
	* asigna como máximo de calorías en la dieta
		--CALCULAR METABOLISMO BASAL
			E = edad
			A = altura en centímetros
			P = peso en kilos

			Fórmula Hombres: TMB = 10P + 6,25A – 5E + 5
			Fórmula Mujeres: TMB = 10P + 6,25A – 5E – 161

	-addFood(Food,Integer): agrega un alimento y una cantidad en gramos
	-getTotalCalories(): devuelve el total de calorías
	-getTotalCarbs(): devuelve el total de carbohidratos
	-getTotalFats(): devuelve el total de grasas
	-getTotalProtein(): devuelve el total de proteinas
*
* */
public class Diet {

    //atributos de Diet:
    private Integer maxCalories;
    private Integer weight;
    private List<Food> foods;
    private Integer maxFats;
    private Integer maxCarbs;
    private Integer maxProteins;
    private boolean women;
    private Integer age;
    private Integer height;
    private Integer weightPerson;
    private List<Consume> consumes;

//4 constructores distintos de Diet:
public Diet() {   //opción sin límite de calorías
    this.maxCalories = 0;
    this.consumes =new ArrayList<>();
}
public Diet(Integer maxCalories) {   //opción con máximo de calorías
    this.maxCalories = maxCalories;
    this.consumes =new ArrayList<>();
}
public Diet(Integer maxFats, Integer maxCarbs, Integer maxProteins) {  //opción con máximo de macros
    this.maxFats = maxFats;
    this.maxCarbs = maxCarbs;
    this.maxProteins = maxProteins;
    this.consumes =new ArrayList<>();
 }
 public Diet(Boolean women, Integer age, Integer height, Integer weightPerson) { //opción con persona
    this.women = women;
    this.age = age;
    this.height = height;
    this.weightPerson = weightPerson;
    this.consumes =new ArrayList<>();
}


//métodos de Diet: add, calories, carbs, fats, proteins, foods, metabolism
public void addFood(Food food, Integer weight) {
    Consume consume = new Consume(food, weight);
    consumes.add(consume);

}
public Integer getTotalCalories() {
    Integer totalCal = 0;
    for(Consume element:consumes) {
        totalCal = element.getFood().getCalories(element.getWeight());
        totalCal++;
    }
    return totalCal;
}

public Integer getTotalCarbs() {
    Integer totalCarbs = 0;
    for(Consume element:consumes) {
        totalCarbs = element.getFood().getCarbs()*element.getWeight()/100;
        totalCarbs++;
    }
    return totalCarbs;
}

public Integer getTotalFats() {
    Integer totalFats = 0;
    for(Consume element:consumes) {
        totalFats = element.getFood().getFats()*element.getWeight()/100;
        totalFats++;
    }
    return totalFats;
}
public Integer getTotalProteins() {
    Integer totalProteins = 0;
    for(Consume element:consumes) {
        totalProteins = element.getFood().getProteins()*element.getWeight()/100;
        totalProteins++;
    }
    return totalProteins;
}
public String seeFoods() {
    return consumes.toString();
}
public Integer seeNumberFoods() {
    return consumes.size();
}
public Integer calculateMetabolism(Boolean women, Integer age, Integer height, Integer weightPerson) {
    Integer result = 0;
    if(women) {
        result = (int) ((10*weightPerson) + (6.25*height) -(5*age) - 161);

    }else{
        result = (int) ((10*weightPerson) + (6.25*height) -(5*age) + 5);
    }
    return result;
}

 //getters y setters de todos los atributos de Diet:
    public Integer getMaxCalories() {
        return maxCalories;
    }

    public void setMaxCalories(Integer maxCalories) {
        this.maxCalories = maxCalories;
    }

    public List getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getMaxFats() {
        return maxFats;
    }

    public void setMaxFats(Integer maxFats) {
        this.maxFats = maxFats;
    }

    public Integer getMaxCarbs() {
        return maxCarbs;
    }

    public void setMaxCarbs(Integer maxCarbs) {
        this.maxCarbs = maxCarbs;
    }

    public Integer getMaxProteins() {
        return maxProteins;
    }

    public void setMaxProteins(Integer maxProtein) {
        this.maxProteins = maxProteins;
    }

    public boolean isWomen() {
        return women;
    }

    public void setWomen(boolean women) {
        this.women = women;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeightPerson() {
        return weightPerson;
    }

    public void setWeightPerson(Integer weightPerson) {
        this.weightPerson = weightPerson;
    }
}
