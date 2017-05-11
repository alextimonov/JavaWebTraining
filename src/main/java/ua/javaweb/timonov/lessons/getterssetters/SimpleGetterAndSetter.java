package ua.javaweb.timonov.lessons.getterssetters;

//  What are getter and setter?

public class SimpleGetterAndSetter {
    private int number;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int num) {
        this.number = num;
    }
}

//    Setter is the method that updates value of a variable. And a getter is the method that reads value of a variable.
//    Getter and setter are also known as accessor and mutator in Java.