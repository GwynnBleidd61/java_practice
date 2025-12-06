package test;


import examples.Person;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int a = random.nextInt(7);
            System.out.println(String.format("Dice shows %s", a));
        }
    }
}
