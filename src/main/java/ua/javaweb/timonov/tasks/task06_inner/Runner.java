package ua.javaweb.timonov.tasks.task06_inner;

public class Runner {
    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {
        System.out.println("Invoke from external to inner, start & stop");
        AirPlainInner airPlainInner = new AirPlainInner();
        System.out.println(airPlainInner.airPlainStart());
        System.out.println(airPlainInner.airPlainStop());

        System.out.println();

        System.out.println("Invoke from inner to external, auto start");
        AirPlainInner.AirPlainEngine leftEngine = airPlainInner.getAirPlainEngineLeft();
        AirPlainInner.AirPlainEngine.Engine engine = leftEngine.getEngine();
        System.out.println(engine.autoStart());

        AirPlainInner.AirPlainEngine rightEngine = airPlainInner.getAirPlainEngineLeft();
        engine = rightEngine.getEngine();
        System.out.println(engine.autoStart());
        System.out.println();
    }

}
