package ua.javaweb.timonov.lessons.getterssetters;

//    Why getter and setter?

public class WhyGetterAndSetter {

    private int number;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int num) {
        if (num < 10 || num > 100) {
            throw new IllegalArgumentException();
        }
        this.number = num;
    }
}

//    Coder can control how his important variables are accessed and updated in a correct manner,
//    such as changing value of a variable within a specified range.

//    So far, setter and getter methods protect a variable’s value from unexpected changes by outside world – the caller code.

//    Some frameworks such as Hiberate, Spring, Struts… can inspect information or inject their utility code through
//    getter and setter. So providing getter and setter is necessary when integrating your code with such frameworks.