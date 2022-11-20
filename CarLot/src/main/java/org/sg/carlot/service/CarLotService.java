package org.sg.carlot.service;

import org.sg.carlot.dao.NoSuchCarException;
import org.sg.carlot.dao.OverpaidPriceException;
import org.sg.carlot.dao.UnderpaidPriceException;
import org.sg.carlot.dto.Car;
import org.sg.carlot.dto.CarKey;

import java.math.BigDecimal;
import java.util.List;

public interface CarLotService {
    public Car getACar(String VIN);
    public List<Car> getAllCars();
    public List<Car> getCarsByColor(String color);
    public List<Car> getCarsInBudget(BigDecimal maxPrice);
    public List<Car> getCarByMakeAndModel(String make, String model);

    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount)
            throws NoSuchCarException;

    public CarKey sellCar(String VIN, BigDecimal cashPaid)
            throws NoSuchCarException,
            OverpaidPriceException,
            UnderpaidPriceException;
}
