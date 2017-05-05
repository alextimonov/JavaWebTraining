package ua.javaweb.timonov.lessons.lesson03;

public class Inheritance {
    public static void main(String[] args) {
//        A a = new B(5);
        A a = new B(5);
    }
}

class A {
    private int amount;

    public A() {
        System.out.println("Default A");
    }

    public A(int amount) {
        this.amount = amount;
        System.out.println("A with parameter");
    }
}

class B extends A {
    public B() {
        System.out.println("Default B");
    }

    public B(int amount) {
        System.out.println("B with parameter");
    }
}
