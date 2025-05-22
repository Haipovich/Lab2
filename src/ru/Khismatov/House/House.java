package ru.Khismatov.House;

/* Создайте сущность Дом, которая описывается количеством этажей в виде числа. 
У Дома можно запросить текстовую форму, которое имеет представление вида "дом с N этажами", 
где N это число. Гарантировать правильное окончание фразы, в зависимости от количества этажей. 
Создать и вывести на экран дома с 1, 5, 23 этажами. */

public class House {
    private int numFloors; 

    public House(int numFloorsParam) { 
        if (numFloorsParam < 1) {
            System.out.println("Error: Number of floors must be greater than 0");
            this.numFloors = 1; 
            return;
        }
        this.numFloors = numFloorsParam;
    }

    @Override
    public String toString() {
        return "дом с " + numFloors + " " + getFloorEnding(numFloors); 
    }

    private String getFloorEnding(int number) { 
        if (number % 100 >= 11 && number % 100 <= 19) {
            return "этажами";
        }
        switch (number % 10) {
            case 1:
                return "этажом";
            default:
                return "этажами";
        }
    }
}
