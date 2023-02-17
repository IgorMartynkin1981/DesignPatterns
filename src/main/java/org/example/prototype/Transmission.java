package org.example.prototype;

public class Transmission {
    private String name;
    private String type;
    private int power;

    public Transmission(String name, String type, int power) {
        this.name = name;
        this.type = type;
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", power=" + power +
                '}';
    }
}
