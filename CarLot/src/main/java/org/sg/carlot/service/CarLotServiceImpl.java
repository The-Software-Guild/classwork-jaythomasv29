package org.sg.carlot.service;

import org.sg.carlot.dao.CarLotDao;
import org.sg.carlot.dao.NoSuchCarException;
import org.sg.carlot.dao.OverpaidPriceException;
import org.sg.carlot.dao.UnderpaidPriceException;
import org.sg.carlot.dto.Car;
import org.sg.carlot.dto.CarKey;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CarLotServiceImpl implements CarLotService {
    private CarLotDao carLotDao;

    public CarLotServiceImpl(CarLotDao carLotDao) {
        this.carLotDao = carLotDao;
    }

    @Override
    public Car getACar(String VIN) {
        return carLotDao.getCar(VIN);
    }

    @Override
    public List<Car> getAllCars() {
        return carLotDao.getCars();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        // Get all cars, and add cars only if color matches
        List<Car> allCars = this.getAllCars();
        List<Car> carsWithColor = new ArrayList<>();
        for(Car car: allCars) {
            if(car.getColor().equals(color)) {
                carsWithColor.add(car);
            }
        }
        return carsWithColor;
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) {
        // Get all cars, and add cars only if color matches
        List<Car> allCars = this.getAllCars();
        List<Car> carsWithinBudget = new ArrayList<>();
        for(Car car: allCars) {
            if(car.getPrice().compareTo(maxPrice) <= 0) {
                carsWithinBudget.add(car);
            }
        }
        return carsWithinBudget;
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) {
        // Get all cars, and add cars only if color matches
        List<Car> allCars = this.getAllCars();
        List<Car> carsWithMakeModel = new ArrayList<>();
        for(Car car: allCars) {
            if(car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)) {
                carsWithMakeModel.add(car);
            }
        }
        return carsWithMakeModel;
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException {
        Car foundCar = carLotDao.getCar(VIN);
        if(foundCar == null) throw new NoSuchCarException("No such car");
        BigDecimal totalPercentage = new BigDecimal("100");
        totalPercentage.subtract(percentDiscount); // This gets the new total price after discount 100% - 30% = 70% of total
        foundCar.setPrice(foundCar.getPrice().multiply(totalPercentage));
        return foundCar.getPrice().setScale(2, RoundingMode.HALF_UP);

    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        return null;
    }
}
