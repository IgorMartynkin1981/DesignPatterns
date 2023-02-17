package org.example.prototype;

import java.util.Objects;

public class Engine {
    private String name;
    private String type;
    private String cylinders;
    private int power;

    public Engine(String name, String type, String cylinders, int power) {
        this.name = name;
        this.type = type;
        this.cylinders = cylinders;
        this.power = power;
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

    public String getCylinders() {
        return cylinders;
    }

    public void setCylinders(String cylinders) {
        this.cylinders = cylinders;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return power == engine.power && name.equals(engine.name) && type.equals(engine.type) && cylinders.equals(engine.cylinders);
    }

    @Override
    public int hashCode() {
        int hash = 17; // объявляем и инициализируем переменную hash
        if (name != null) { // проверяем значение первого поля
            hash = name.hashCode(); // вычисляем хеш первого поля
        }
        if (type != null) { // проверяем значение второго поля
            hash = hash + type.hashCode(); // вычисляем хеш второго поля и общий хеш
        }
        if (cylinders != null) { // проверяем значение второго поля
            hash = hash + cylinders.hashCode(); // вычисляем хеш второго поля и общий хеш
        }
        return hash; // возвращаем хеш
    }

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", cylinders='" + cylinders + '\'' +
                ", power=" + power +
                '}';
    }
}
