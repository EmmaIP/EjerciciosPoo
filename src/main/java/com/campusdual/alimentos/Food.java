package com.campusdual.alimentos;

public class Food {

    private String name;
    private Integer carbs;
    private Integer fats;
    private Integer proteins;

    public Food(String name) {
        this.name = name;
        this.carbs = 0;
        this.fats = 0;
        this.proteins = 0;
    }

    public Food (String name,Integer carbs, Integer fats, Integer proteins) {
        this.name = name;
        this.carbs = carbs;
        this.fats = fats;
        this.proteins = proteins;
    }
    public Integer getCalories(Integer weight) {  //método que hay que instanciar al objeto: carrot.getCalories()
        //1g de proteínas da 4 cal
        //1g de carbos da 4 cal
        //1g de grasa da 9 cal
        return(((carbs*4) + (fats*9) + (proteins*4))*weight/100);
    }

    /*método getCalories que no necesita ser instanciado porque es static, se llamaría directamente Food.getCalories(con parámetros)
    public static Integer getCalories(Integer weight, Integer carbos, Integer fats, Integer proteins) {
       return(((carbos*4) + (fats*9) + (proteins*4))*weight/100);
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    public Integer getFats() {
        return fats;
    }

    public void setFats(Integer fats) {
        this.fats = fats;
    }

    public Integer getProteins() {
        return proteins;
    }

    public void setProteins(Integer proteins) {
        this.proteins = proteins;
    }
}
