package ua.epamkpi.timonov.tasks.task03;

public class Car {
    private int id;
    private String mark;
    private String model;
    private int year;
    private String color;
    private double price;
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format(
                "Car { id = %3d, mark = %8s, model = %6s, year = %4d, color = %7s, price = %6.2f, number = %4s }",
                id, mark, model, year, color, price, number
        );
    }
}
