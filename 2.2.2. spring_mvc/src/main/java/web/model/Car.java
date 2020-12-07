package web.model;

public class Car {
    private String model;
    private String brand;
    private int number;

    public Car(String model, String brand, int number) {
        this.model = model;
        this.brand = brand;
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}