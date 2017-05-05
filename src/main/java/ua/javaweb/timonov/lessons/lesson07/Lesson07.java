package ua.javaweb.timonov.lessons.lesson07;

class Parent {
    private int value1;

    public Parent() {
        value1 = 10;
        System.out.println("Default constructor, value1 = " + value1);
    }

    public Parent(int value) {
        this.value1 = value;
        System.out.println("Constructor with received value1 = " + value1);
    }
}

class Child extends Parent {
    private int value2;

    public Child() {
    }

    public Child(int value2) {
//        super(15);
//        this();
        this.value2 = value2;
        System.out.println("Constructor with received value2 = " + value2);
    }
}

public class Lesson07 {
    public static void main(String[] args) {
        new Lesson07().run();
    }

    private void run() {
        Parent p = new Child(20);
    }
}
