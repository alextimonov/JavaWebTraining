package ua.javaweb.timonov.tasks.task04_pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Processor {

    public static final int CURRENT_YEAR = 2017;

    public static List<Car> getCarsList (List<Car> cars, String mark)  {
        List<Car> carsToChange = new ArrayList<>(cars);
        Iterator<Car> iterator = carsToChange.iterator();
        Car car = null;
        while (iterator.hasNext()) {
            car = iterator.next();
            if(!car.getMark().equals(mark)) {
                iterator.remove();
            }
        }
        return carsToChange;
    }

    public static List<Car> getCarsList (List<Car> cars, String model, int years) {
        List<Car> carsToChange = new ArrayList<>(cars);
        Iterator<Car> iterator = carsToChange.iterator();
        Car car = null;
        int carAge;
        while (iterator.hasNext()) {
            car = iterator.next();
            carAge = CURRENT_YEAR - car.getYear();
            if(!(car.getModel().equals(model) && carAge > years)) {
                iterator.remove();
            }
        }
	    return carsToChange;
    }

    public static List<Car> getCarsList (List<Car> cars, int year, int price)  {
        List<Car> carsToChange = new ArrayList<>(cars);
        Iterator<Car> iterator = carsToChange.iterator();
        Car car = null;
        while (iterator.hasNext()) {
            car = iterator.next();
            if(!(car.getYear() == year && car.getPrice() > price)) {
                iterator.remove();
            }
        }
	    return carsToChange;
    }
}
