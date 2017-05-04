package ua.epamkpi.timonov.tasks.task064;

interface IEngine {
    String startEngine();
    String stopEngine();
}

public class AirPlainAnonymous {

    public static final String AIR_PLAIN_ENGINE_STARTED = "Air plain engine started. ";
    public static final String AIR_PLAIN_ENGINE_STOPPED = "Air plain engine stopped. ";
    public static final String ENGINE_STARTED = "Engine started. ";
    public static final String ENGINE_STOPPED = "Engine stopped. ";
    public static final String LEFT = "Left ";
    public static final String RIGHT = "Right ";
    public static final String AIR_PLAIN_STARTED = "Air plain started";
    public static final String AIR_PLAIN_STOPPED = "Air plain stopped";

    private AirPlainEngine airPlainEngineLeft = new AirPlainEngine();
    private AirPlainEngine airPlainEngineRight = new AirPlainEngine();

    static class AirPlainEngine implements IEngine {

        private static boolean isStarted;

        @Override
        public String startEngine() {
            IEngine engine = new IEngine() {
                @Override
                public String startEngine() {
                    setStarted(true);           // invoke from anonymous to external non-static
                    return ENGINE_STARTED       // invoke from anonymous to external static
                            + isStarted();
                }

                @Override
                public String stopEngine() {
                    return ENGINE_STOPPED + AirPlainEngine.isStarted;
                }
            };
            return engine.startEngine() + AIR_PLAIN_ENGINE_STARTED;   // invoke from external to anonymous
        }

        @Override
        public String stopEngine() {
            return AIR_PLAIN_ENGINE_STOPPED;
        }

        public static boolean isStarted() {
            return isStarted;
        }

        public void setStarted(boolean started) {
            isStarted = started;
        }
    }

    public String airPlainStart() {
        return LEFT + airPlainEngineLeft.startEngine() + RIGHT + airPlainEngineRight.startEngine() + AIR_PLAIN_STARTED;
    }

    public String airPlainStop() {
        return LEFT + airPlainEngineLeft.startEngine() + RIGHT + airPlainEngineRight.startEngine() + AIR_PLAIN_STOPPED;
    }

    public AirPlainEngine getAirPlainEngineLeft() {
        return airPlainEngineLeft;
    }

    public AirPlainEngine getAirPlainEngineRight() {
        return airPlainEngineRight;
    }
}
