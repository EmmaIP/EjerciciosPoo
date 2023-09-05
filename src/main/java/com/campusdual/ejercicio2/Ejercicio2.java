package com.campusdual.ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args) {
    leapYear(1948);
    leapYear(1947);
    leapYear(1500);
    leapYear(1946);
    }
    //Crear un programa que con un if nos indique si un año es bisiesto o no
    // Año bisiesto es el divisible entre 4, salvo que sea año secular -último de cada siglo,
    // terminado en «00»-,
    // en cuyo caso también ha de ser divisible entre 400.
    public static void leapYear(int year) {
            if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
                System.out.println("El año " + year + " es bisiesto");
            }else {
                System.out.println("El año " + year + " no es bisiesto");
            }

    }
}
