package web.service;


import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class CarService {
    private List<Car> cars;

    public CarService() {
        cars = new ArrayList<>();
        cars.add(new Car("x4", "bmw", 111));
        cars.add(new Car("x5", "bmw", 222));
        cars.add(new Car("x6", "bmw", 333));
        cars.add(new Car("x7", "bmw", 444));
        cars.add(new Car("x8", "bmw", 555));
    }

    public int CarCount() {
        return cars.size();
    }

    public List<Car> CarList(Integer count) {
        if (count != null) {
            return cars.stream().limit(count).collect(Collectors.toList());
        } else {
            return cars;
        }
    }
}