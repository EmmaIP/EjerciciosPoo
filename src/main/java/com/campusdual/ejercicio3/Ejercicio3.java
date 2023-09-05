package com.campusdual.ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {
    //Utilizando switch escribir un programa que revise un número y diga si es primo o no
    // //el número tiene que estar entre 1 y 20
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Escribe un número del 1 al 20:");
        Integer number = keyboard.nextInt();

        switch (number) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            case 17:
            case 19:
                System.out.println("El número " + number + " es primo");
                break;
            default:
                System.out.println("El número " + number + " no es primo");
                break;


        }
    }
}
