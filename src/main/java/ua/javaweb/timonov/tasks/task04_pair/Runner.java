package ua.javaweb.timonov.tasks.task04_pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {

    public static final String CAR_LIST_BY_MARK = "Car list by mark: ";
    public static final String CAR_LIST_BY_YEAR_PRICE = "Car list by year of creation & price more than: ";
    public static final String CAR_LIST_BY_MODEL_AGE = "Car list by model & age more than: ";
    public static final String COMMA_SPACE = ", ";

    public static final String TOYOTA = "TOYOTA";
    public static final String LUXURY = "LUXURY";

    public static final int AMOUNT_OF_CARS = 100;
    public static final int START_YEAR = 1990;
    public static final int YEAR_DIAPASON = 27;
    public static final int START_PRICE = 15000;
    public static final int PRICE_DIAPASON = 10000;
    public static final int MAX_CAR_NUMBER = 10000;
    public static final int ISSUE_YEAR = 2000;
    public static final int MIN_PRICE = 17000;
    public static final int AGE = 10;

    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {
        List<Car> allCars = createListOfCars();
        printCarList("All cars list:", allCars);

        List<Car> carsByMark = Processor.getCarsList(allCars, TOYOTA);
        printCarList(CAR_LIST_BY_MARK + TOYOTA, carsByMark);

        List<Car> carsByYearAndPrice = Processor.getCarsList(allCars, ISSUE_YEAR, MIN_PRICE);
        printCarList(CAR_LIST_BY_YEAR_PRICE + ISSUE_YEAR + COMMA_SPACE + 17000, carsByYearAndPrice);

        List<Car> carsByModelAndYear = Processor.getCarsList(allCars, LUXURY, AGE);
        printCarList(CAR_LIST_BY_MODEL_AGE + LUXURY + COMMA_SPACE + AGE, carsByModelAndYear);
    }

    private void printCarList(String header, List<Car> carList) {
        System.out.println(header);
        carList.forEach(System.out::println);
        System.out.println();
    }

    private List<Car> createListOfCars() {
        List<Car> cars = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < AMOUNT_OF_CARS; i++) {
            Car car = new Car();
            car.setId(i);
            car.setYear((int) (random.nextDouble() * YEAR_DIAPASON + START_YEAR));
            car.setPrice((int) (random.nextDouble() * PRICE_DIAPASON + START_PRICE));
            int number = (int) (random.nextDouble() * MAX_CAR_NUMBER);
            car.setNumber(String.valueOf(number));

            Color[] colors = Color.values();
            int colorIndex = (int) (random.nextDouble() * colors.length);
            Color color = colors[colorIndex];
            car.setColor(color.name());

            Mark[] marks = Mark.values();
            int markIndex = (int) (random.nextDouble() * marks.length);
            Mark mark = marks[markIndex];
            car.setMark(mark.name());

            Model[] models = Model.values();
            int modelIndex = (int) (random.nextDouble() * models.length);
            Model model = models[modelIndex];
            car.setModel(model.name());

            cars.add(car);
        }
        return cars;
    }
}
