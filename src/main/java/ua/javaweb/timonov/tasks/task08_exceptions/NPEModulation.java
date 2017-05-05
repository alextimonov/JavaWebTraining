package ua.javaweb.timonov.tasks.task08_exceptions;

public class NPEModulation {

    public void modulationNPE() {
        try {
            String string = null;
            int length = string.length();
        } catch (NullPointerException e) {
            System.out.println("Caught exception: " + e);
        }
        System.out.println();
    }
}
