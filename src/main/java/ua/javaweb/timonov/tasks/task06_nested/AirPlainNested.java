package ua.javaweb.timonov.tasks.task06_nested;

interface IEngine {
    String startEngine();
    String stopEngine();
}

public class AirPlainNested {

    public static final String AIR_PLAIN_ENGINE_STARTED = " Air plain engine started. ";
    public static final String AIR_PLAIN_ENGINE_STOPPED = " Air plain engine stopped. ";
    public static final String ENGINE_STARTED = "Engine started. ";
    public static final String ENGINE_STOPPED = "Engine stopped. ";
    public static final String LEFT = "Left ";
    public static final String RIGHT = "Right ";
    public static final String AIR_PLAIN_STARTED = "Air plain started";
    public static final String AIR_PLAIN_STOPPED = "Air plain stopped";
    public static final String IS_FOR_PLAIN = "Is AirPlainEngine for plain: ";

    private AirPlainEngine airPlainEngineLeft = new AirPlainEngine();
    private AirPlainEngine airPlainEngineRight = new AirPlainEngine();

    static class AirPlainEngine implements IEngine {

        private Engine engine = new Engine();
        private static boolean isForAirPlain = true;

        static class Engine implements IEngine {

            private static boolean isStarted;

            @Override
            public String startEngine() {
                return ENGINE_STARTED;
            }

            @Override
            public String stopEngine() {
                return ENGINE_STOPPED;
            }

            public String autoStart() {
                Engine engineFromAirPlain = new AirPlainEngine().getEngine();  // invoke from nested non-static to external non-static
                return IS_FOR_PLAIN + isForAirPlain()                          // invoke from nested non-static to external static
                        + new AirPlainEngine().startEngine();
            }

            public String autoStop() {
                return new AirPlainEngine().stopEngine();
            }

            public static boolean isStarted() {
                return isStarted;
            }

            public static void staticInvoke() {
                new AirPlainEngine().getEngine();   // invoke from nested static to external non-static
                isForAirPlain();                    // invoke from nested static to external static
            }
        }

        @Override
        public String startEngine() {
            return engine.startEngine() + Engine.isStarted() + AIR_PLAIN_ENGINE_STARTED;
        }

        @Override
        public String stopEngine() {
            return engine.stopEngine()              // invoke from external non-static to nested non-static
                    + Engine.isStarted()            // invoke from external non-static to nested static
                    + AIR_PLAIN_ENGINE_STOPPED;
        }

        public static boolean isForAirPlain() {
            new Engine().stopEngine();              // invoke from external static to nested non-static
            Engine.isStarted();                     // invoke from external static to nested static
            return isForAirPlain;
        }

        public Engine getEngine() {
            return engine;
        }
    }

    public String airPlainStart() {
        return LEFT + airPlainEngineLeft.startEngine() + RIGHT + airPlainEngineRight.startEngine() + AIR_PLAIN_STARTED;
    }

    public String airPlainStop() {
        return LEFT + airPlainEngineLeft.startEngine() // invoke from external non-static to nested non-static
                + RIGHT + airPlainEngineRight.startEngine() + AIR_PLAIN_STOPPED;
    }

    public AirPlainEngine getAirPlainEngineLeft() {
        return airPlainEngineLeft;
    }

    public AirPlainEngine getAirPlainEngineRight() {
        return airPlainEngineRight;
    }
}

