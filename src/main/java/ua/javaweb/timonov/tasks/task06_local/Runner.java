package ua.javaweb.timonov.tasks.task06_local;

public class Runner {
    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {
        System.out.println("Invoke from external to local, start & stop");
        AirPlainLocal airPlainLocal = new AirPlainLocal();
        System.out.println(airPlainLocal.airPlainStart());
        System.out.println(airPlainLocal.airPlainStop());

        System.out.println();

        System.out.println("Invoke from local to external, auto start");
        AirPlainLocal.AirPlainEngine leftEngine = airPlainLocal.getAirPlainEngineLeft();
        System.out.println(leftEngine.startEngine(AirPlainLocal.AUTO));

        AirPlainLocal.AirPlainEngine rightEngine = airPlainLocal.getAirPlainEngineLeft();
        System.out.println(rightEngine.startEngine(AirPlainLocal.AUTO));
        System.out.println();

        System.out.println("Call local class's method from Runner: ");
        Invokable reference = leftEngine.getReference();
        System.out.println(reference.invokeMe());
    }

}
