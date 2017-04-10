package ua.epamkpi.timonov.lessons.lesson01;

public class HelloWorld {

    public static void main(String[] args) {
        PrintClass printClass = new PrintClass();
        printClass.printMessage();
    }                
}

class PrintClass {
    public void printMessage() {
        System.out.println("Hello, world!");
    }
}                    