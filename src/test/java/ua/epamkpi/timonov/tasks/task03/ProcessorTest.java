package ua.epamkpi.timonov.tasks.task03;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProcessorTest {
    public static final String TOYOTA = "TOYOTA";
    public static final String JEEP = "JEEP";
    public static final String KIA = "KIA";
    public static final String HONDA = "HONDA";
    public static final String LUXURY = "LUXURY";
    public static final String CASUAL = "CASUAL";
    public static final String SUPERB = "SUPERB";

    List<Car> allCars = new ArrayList<>();
    List<Car> expectedCars = new ArrayList<>();
    Car car0 = new Car(TOYOTA, LUXURY, 2011, 17_000);
    Car car1 = new Car(JEEP, LUXURY, 2009, 12_000);
    Car car2 = new Car(TOYOTA, SUPERB, 2012, 14_000);
    Car car3 = new Car(KIA, CASUAL, 2012, 10_000);
    Car car4 = new Car(TOYOTA, SUPERB, 2011, 13_000);
    Car car5 = new Car(JEEP, LUXURY, 2011, 15_000);

    @Before
    public void setUp() throws Exception {
        allCars = new ArrayList<>();
        expectedCars = new ArrayList<>();
        allCars.add(car0);
        allCars.add(car1);
        allCars.add(car2);
        allCars.add(car3);
        allCars.add(car4);
        allCars.add(car5);
    }

    @Test
    public void testGetCarsListByMarkNormal1() throws Exception {
        List<Car> carsByMark = Processor.getCarsList(allCars, TOYOTA);
        expectedCars.add(car0);
        expectedCars.add(car2);
        expectedCars.add(car4);
        assertTrue(twoListsAreIdentical(carsByMark, expectedCars));
    }

    @Test
    public void testGetCarsListByMarkNormal2() throws Exception {
        List<Car> carsByMark = Processor.getCarsList(allCars, JEEP);
        expectedCars.add(car1);
        expectedCars.add(car5);
        assertTrue(twoListsAreIdentical(carsByMark, expectedCars));
    }

    @Test
    public void testGetCarsListByMarkNormal3() throws Exception {
        List<Car> carsByMark = Processor.getCarsList(allCars, KIA);
        expectedCars.add(car3);
        assertTrue(twoListsAreIdentical(carsByMark, expectedCars));
    }

    @Test
    public void testGetCarsListByMarkAbnormal1() throws Exception {
        List<Car> carsByMark = Processor.getCarsList(allCars, HONDA);
        assertTrue(twoListsAreIdentical(carsByMark, expectedCars));
    }

    @Test
    public void testGetCarsListByModelAndYearNormal1() throws Exception {
        List<Car> carsByModelAndYear = Processor.getCarsList(allCars, LUXURY, 5);
        expectedCars.add(car0);
        expectedCars.add(car1);
        expectedCars.add(car5);
        assertTrue(twoListsAreIdentical(carsByModelAndYear, expectedCars));
    }

    @Test
    public void testGetCarsListByModelAndYearNormal2() throws Exception {
        List<Car> carsByModelAndYear = Processor.getCarsList(allCars, SUPERB, 4);
        expectedCars.add(car2);
        expectedCars.add(car4);
        assertTrue(twoListsAreIdentical(carsByModelAndYear, expectedCars));
    }

    @Test
    public void testGetCarsListByModelAndYearNormal3() throws Exception {
        List<Car> carsByModelAndYear = Processor.getCarsList(allCars, LUXURY, 7);
        expectedCars.add(car1);
        assertTrue(twoListsAreIdentical(carsByModelAndYear, expectedCars));
    }

    @Test
    public void testGetCarsListByModelAndYearAbnormal1() throws Exception {
        List<Car> carsByModelAndYear = Processor.getCarsList(allCars, CASUAL, 7);
        assertTrue(twoListsAreIdentical(carsByModelAndYear, expectedCars));
    }

    @Test
    public void testGetCarsListByYearAndPriceNormal1() throws Exception {
        List<Car> carsByModelAndYear = Processor.getCarsList(allCars, 2012, 12_000);
        expectedCars.add(car2);
        assertTrue(twoListsAreIdentical(carsByModelAndYear, expectedCars));
    }

    @Test
    public void testGetCarsListByYearAndPriceNormal2() throws Exception {
        List<Car> carsByModelAndYear = Processor.getCarsList(allCars, 2011, 14_000);
        expectedCars.add(car0);
        expectedCars.add(car5);
        assertTrue(twoListsAreIdentical(carsByModelAndYear, expectedCars));
    }

    @Test
    public void testGetCarsListByYearAndPriceNormal3() throws Exception {
        List<Car> carsByModelAndYear = Processor.getCarsList(allCars, 2009, 10_000);
        expectedCars.add(car1);
        assertTrue(twoListsAreIdentical(carsByModelAndYear, expectedCars));
    }

    @Test
    public void testGetCarsListByYearAndPriceAbnormal1() throws Exception {
        List<Car> carsByModelAndYear = Processor.getCarsList(allCars, 2009, 12_000);
        assertTrue(twoListsAreIdentical(carsByModelAndYear, expectedCars));
    }

    private boolean twoListsAreIdentical(List<Car> carsByMark, List<Car> expectedCars) {
        List<Car> carsToCheck = new ArrayList<>(carsByMark);
        for (Car expectedCar : expectedCars) {
            if (carsToCheck.contains(expectedCar)) {
                carsToCheck.remove(expectedCar);
            } else {
                return false;
            }
        }
        return carsToCheck.size() == 0;
    }
}