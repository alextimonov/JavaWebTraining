package ua.javaweb.timonov.lessons.lesson10;



public class Lesson10 {

    class Inner {
        private int value;

        public int getValue() {
            return value;
        }
    }

    static class Nested {
        private int nonStaticValue;
        private int staticValue;

        public int getNonStaticValue() {
            return nonStaticValue;
        }

        public int getStaticValue() {
            return staticValue;
        }
    }

    static {
//        Inner inner = new Inner();
    }

    public static void main(String[] args) {
        new Lesson10().run();

    }

    private void run() {
        Nested nested = new Nested();
        nested.getStaticValue();
        nested.getNonStaticValue();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("1");
            System.out.println("i = " + i + ", capacity = " + sb.capacity() + ", content: " + sb.toString());
        }
    }
}
