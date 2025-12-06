public class WhatToDo {

    public static void main(String[] args) {
        boolean isNight = false;
        boolean isGoodWeather = false;
        if (isNight) {
            System.out.println("Спать");
        } else if (!isNight && !isGoodWeather) {
            System.out.println("Читать книгу");
        } else if (!isNight && isGoodWeather) {
            System.out.printf("Гулять");
        }
    }
}
