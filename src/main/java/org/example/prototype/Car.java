package org.example.prototype;

import java.util.Objects;

public class Car implements Cloneable, Clonable{
    private String name;
    private String type;
    private String color;
    private Engine engine;
    private Transmission transmission;

    public Car(String name, String type, String color, Engine engine, Transmission transmission) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Car car = (Car) o;
//        return Objects.equals(name, car.name) && Objects.equals(type, car.type) && Objects.equals(color, car.color) && Objects.equals(engine, car.engine) && Objects.equals(transmission, car.transmission);
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 17; // объявляем и инициализируем переменную hash
//        if (name != null) { // проверяем значение первого поля
//            hash = name.hashCode(); // вычисляем хеш первого поля
//        }
//        if (type != null) { // проверяем значение второго поля
//            hash = hash + type.hashCode(); // вычисляем хеш второго поля и общий хеш
//        }
//        if (color != null) { // проверяем значение второго поля
//            hash = hash + color.hashCode(); // вычисляем хеш второго поля и общий хеш
//        }
//        if (engine != null) { // проверяем значение второго поля
//            hash = hash + engine.hashCode(); // вычисляем хеш второго поля и общий хеш
//        }
//        if (transmission != null) { // проверяем значение второго поля
//            hash = hash + transmission.hashCode(); // вычисляем хеш второго поля и общий хеш
//        }
//        return hash; // возвращаем хеш
//    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                ", transmission=" + transmission +
                '}'+'\n';
    }

    @Override
    public Clonable cloneInterface() {
        return this;
    }
}

