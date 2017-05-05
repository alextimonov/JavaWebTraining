package ua.javaweb.timonov.tasks.task06_nested;

public class Runner {
    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {
        System.out.println("Invoke from external to nested, start & stop");
        AirPlainNested airPlainNested = new AirPlainNested();
        System.out.println(airPlainNested.airPlainStart());
        System.out.println(airPlainNested.airPlainStop());

        System.out.println();

        System.out.println("Invoke from nested to external, auto start");
        AirPlainNested.AirPlainEngine leftEngine = airPlainNested.getAirPlainEngineLeft();
        AirPlainNested.AirPlainEngine.Engine engine = leftEngine.getEngine();
        System.out.println(engine.autoStart());

        AirPlainNested.AirPlainEngine rightEngine = airPlainNested.getAirPlainEngineLeft();
        engine = rightEngine.getEngine();
        System.out.println(engine.autoStart());
        System.out.println();
    }

}