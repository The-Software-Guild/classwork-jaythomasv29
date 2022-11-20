package org.sg.carlot.dao;

import org.sg.carlot.dto.Car;

import java.util.List;

public interface CarLotDao {
    public Car addCar(String VIN, Car car);

    public Car getCar(String VIN);
    public List<Car> getCars();

    public void editCar(String VIN, Car car) throws NoSuchCarException;

    public Car removeCar(String VIN) throws NoSuchCarException;
}