package org.example;

import org.example.prototype.Car;
import org.example.prototype.Engine;
import org.example.prototype.Transmission;

import java.util.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Hello world!");

        ArrayList<Car> carArrayList = new ArrayList<>();
        LinkedList<Car> carLinkedList = new LinkedList<>();
        Set<Car> carHashSet = new HashSet<>();

        Engine engine = new Engine("ДВС1", "Бензиновый двигатель", "4", 123);
        Transmission transmission = new Transmission("Коробка передач", "4х ступенчатая", 20);
        Car car = new Car("Лада Приора", "Седан", "Чёрный", engine, transmission);

        Car car1 = (Car) car.clone();

        System.out.println(car);
        System.out.println(car1);

        if (car == car1) {
            System.out.println("Машины ==");
        }
        if (car.equals(car1)) {
            System.out.println("Машины equals");
        }

        if (car.getEngine() == car1.getEngine()) {
            System.out.println("ДВС у машины ==");
        }
        if (car.getEngine().equals(car1.getEngine())) {
            System.out.println("ДВС у машины equals");
        }

        System.out.println("-----ArrayList-----");
        carArrayList.add(car);
        carArrayList.add(car1);
        System.out.println(carArrayList);

        System.out.println("-----LinkedList-----");
        carLinkedList.add(car);
        carLinkedList.add(car1);
        System.out.println(carLinkedList);

        System.out.println("-----HashSet-----");
        carHashSet.add(car);
        carHashSet.add(car1);
        System.out.println(carHashSet);
    }
}