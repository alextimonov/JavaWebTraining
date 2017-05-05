package ua.javaweb.timonov.tasks.task08_exceptions;

public class OMEModulation {

    public static final int ARRAY_SIZE = 10_000;

    public String stringConcat(String string) {
        return stringConcat(string + string);
    }

    public void arraysInMemory() {
        int[][] array = new int[ARRAY_SIZE][];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = new int[25_000];
        }
    }

    long getAvailableMemory() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();       // current heap allocated to the VM process
        long freeMemory = runtime.freeMemory();         // out of the current heap, how much is free
        long maxMemory = runtime.maxMemory();           // Max heap VM can use e.g. Xmx setting
        long usedMemory = totalMemory - freeMemory;     // how much of the current heap the VM is using
        long availableMemory = maxMemory - usedMemory;  // available memory i.e. Maximum heap size minus the current amount used
        return availableMemory;
    }
}
