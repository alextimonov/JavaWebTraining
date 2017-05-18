package ua.javaweb.timonov.lessons.lesson11;

public class Lesson11 {
    public static void main(String[] args) {
        new Lesson11().run();
    }

    private void run() {
        int m = 0;
        if ( ((5<7) || true) | m++ < 10) m = m + 1;
        System.out.println(m);
        System.out.println("qwe" + m + 5);

        L l = new L();
        if (l instanceof K) System.out.println(true);

        A a = new A();
        A ab = new B();
        B b = new B();
        a.go();
        ab.go();
        b.go();
        a.staticGo();
        b.staticGo();



        }

interface K {}
    class L implements K {
    }
}

class A {
    int value = 1;

    static void staticGo() {
        System.out.println("class A: static go()");
    }

    void go() {
        System.out.println("class A: go()");
    }
}

class B extends A {
    int value = 10;

    static void staticGo() {
        System.out.println("class B: static go()");
    }

    void go() {
        System.out.println("class B: go()");
    }
}


/*
    int i = 0;
i += i++ + ++i; // i = i + i++ + ++i;
        int j = 1;
        j += ++j;
        System.out.println(i);
        System.out.println(j);
*/
