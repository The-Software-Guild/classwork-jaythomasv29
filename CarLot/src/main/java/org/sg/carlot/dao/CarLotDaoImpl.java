package org.sg.carlot.dao;

import org.sg.carlot.dto.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarLotDaoImpl implements CarLotDao {
    private Map<String, Car> cars = new HashMap<>();

    @Override
    public Car addCar(String VIN, Car car) {
        return cars.put(VIN, car);
    }

    @Override
    public Car getCar(String VIN) {
        return cars.get(VIN);
    }

    @Override
    public List<Car> getCars() {
        return new ArrayList<>(cars.values());
    }

    @Override
    public void editCar(String VIN, Car car) throws NoSuchCarException {
        Car foundCar = cars.get(VIN);
        if(foundCar == null) throw new NoSuchCarException("Car does not exist with Vin: " + VIN);
        foundCar.setMake(car.getMake());
        foundCar.setModel(car.getModel());
        foundCar.setColor(car.getColor());
        foundCar.setPrice(car.getPrice());
//        foundCar.setOdometerMiles(car.getOdometerMiles()); // mileage should not be adjusted ,
//        along with key
//        foundCar.setKey(car.getKey());
    }

    @Override
    public Car removeCar(String VIN) throws NoSuchCarException{
        if(cars.get(VIN) == null) throw new NoSuchCarException("Car does not exist with VIN: " + VIN);
        return cars.remove(VIN);
    }
}
