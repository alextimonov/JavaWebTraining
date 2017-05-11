package ua.javaweb.timonov.tasks.task08_exceptions;

public class Runner {

    public static final double BILLION = 10E9;

    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {
        new NPEModulation().modulationNPE();
        runOwnExceptionModulation();
        runSOEModulation();
        runOMEModulation();
    }

    private void runOwnExceptionModulation() {
        OwnExceptionModulation ownExceptionClass = new OwnExceptionModulation();
        ownExceptionClass.handleException();
        System.out.println();
        ownExceptionClass.generateExceptionInOneMethod(null);
        System.out.println();
        ownExceptionClass.generateExceptionInOneMethod("String passed");
        System.out.println();
    }

    private void runSOEModulation() {
        SOEModulation soeModulation = new SOEModulation();
        long startTime = 0;
        try {
            startTime = System.nanoTime();
//            soeModulation.createNode();
//            soeModulation.fibonacci(20_000);
            soeModulation.factorial(100_000);
        } catch (StackOverflowError e) {
            double timeElapsed = (System.nanoTime() - startTime) / BILLION;
            System.out.printf("Time elapsed for StackOverflowError: %8.6f s\n\n", timeElapsed );
        }
    }

    private void runOMEModulation() {
        OMEModulation omeModulation = new OMEModulation();
        long startTime = 0;
        try {
            System.out.printf("Available memory before OutOfMemoryError: %10d B\n", omeModulation.getAvailableMemory());
            startTime = System.nanoTime();
//            omeModulation.stringConcat(LOREM_IPSUM);
//            omeModulation.listInMemory();
            omeModulation.arraysInMemory();
        } catch (OutOfMemoryError e) {
            double timeElapsed = (System.nanoTime() - startTime) / BILLION;
            System.out.printf("Available memory after OutOfMemoryError:  %10d B\n", omeModulation.getAvailableMemory());
            System.out.printf("Time elapsed for OutOfMemoryError: %8.6f s", timeElapsed );
        }
    }
}
