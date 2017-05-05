package ua.javaweb.timonov.tasks.task06_inner;

interface IEngine {
    String startEngine();
    String stopEngine();
}

public class AirPlainInner {

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

    class AirPlainEngine implements IEngine {

        private Engine engine = new Engine();

        class Engine implements IEngine {

            @Override
            public String startEngine() {
                return ENGINE_STARTED;
            }

            @Override
            public String stopEngine() {
                return ENGINE_STOPPED;
            }

            public String autoStart() {
                return AirPlainEngine.this.startEngine();
            }

            public String autoStop() {
                Engine engine1 = getEngine();               // straight to external
                engine1.stopEngine();
                return AirPlainEngine.this.stopEngine();    // to external throw the class name
            }
        }

        @Override
        public String startEngine() {
            return engine.startEngine() + AIR_PLAIN_ENGINE_STARTED; // to inner class
        }

        @Override
        public String stopEngine() {
            return engine.stopEngine() + AIR_PLAIN_ENGINE_STOPPED; // to inner class
        }

        public Engine getEngine() {
            return engine;
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
