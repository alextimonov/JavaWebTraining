package ua.javaweb.timonov.tasks.task06_local;

interface IEngine {
    String startEngine(int auto);
    String stopEngine(int auto);
}

interface Invokable {
    String invokeMe();
}

public class AirPlainLocal {

    public static final String AIR_PLAIN_ENGINE_STARTED = "Air plain engine started. ";
    public static final String AIR_PLAIN_ENGINE_STOPPED = "Air plain engine stopped. ";
    public static final String ENGINE_STARTED = "Engine started. ";
    public static final String ENGINE_STOPPED = "Engine stopped. ";
    public static final String LEFT = "Left ";
    public static final String RIGHT = "Right ";
    public static final String AIR_PLAIN_STARTED = "Air plain started";
    public static final String AIR_PLAIN_STOPPED = "Air plain stopped";
    public static final int AUTO = 1;
    public static final int MANUAL = 0;
    public static final String INVOKED_FROM_RUNNER = "I'm invoked from Runner";

    private AirPlainEngine airPlainEngineLeft = new AirPlainEngine();
    private AirPlainEngine airPlainEngineRight = new AirPlainEngine();

    class AirPlainEngine implements IEngine {

        @Override
        public String startEngine(int auto) {
            class EngineStart {
                String start() {
                    return ENGINE_STARTED;
                }

                String autoStart() {
                    return new AirPlainEngine().startEngine(MANUAL);   // invoke from local to external
                }
            }
            if (auto == AUTO) {
                return new EngineStart().autoStart()                    // invoke from external to local
                        + AIR_PLAIN_ENGINE_STARTED;
            } else {
                return new EngineStart().start() + AIR_PLAIN_ENGINE_STARTED;
            }
        }

        @Override
        public String stopEngine(int auto) {
            class EngineStop {
                String stop() {
                    return ENGINE_STOPPED;
                }

                String autoStop() {
                    return new AirPlainEngine().startEngine(MANUAL);
                }
            }
            if (auto == AUTO) {
                return new EngineStop().autoStop() + AIR_PLAIN_ENGINE_STOPPED;
            } else {
                return new EngineStop().stop() + AIR_PLAIN_ENGINE_STOPPED;
            }
        }

        public Invokable getReference() {
            class Invoke implements Invokable {  // invoke local class's method from external scope (Runner)
                public String invokeMe() {
                    return INVOKED_FROM_RUNNER;
                }
            }
            return new Invoke();
        }
    }

    public String airPlainStart() {
        return LEFT + airPlainEngineLeft.startEngine(AUTO) + RIGHT + airPlainEngineRight.startEngine(MANUAL) + AIR_PLAIN_STARTED;
    }

    public String airPlainStop() {
        return LEFT + airPlainEngineLeft.startEngine(MANUAL) + RIGHT + airPlainEngineRight.startEngine(MANUAL) + AIR_PLAIN_STOPPED;
    }

    public AirPlainEngine getAirPlainEngineLeft() {
        return airPlainEngineLeft;
    }

    public AirPlainEngine getAirPlainEngineRight() {
        return airPlainEngineRight;
    }
}