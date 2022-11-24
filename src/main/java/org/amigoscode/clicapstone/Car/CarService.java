package org.amigoscode.clicapstone.Car;

import org.amigoscode.clicapstone.Booking.BookingDao;

public class CarService {

    private static CarDao carDao = new CarDao();
    private static BookingDao bookingDao = new BookingDao();

    public static Car[] findAll() {
        return carDao.getCars();
    }

    // Find Car by RegNumber
    public Car getCarByRegNumber(String regNumber){
        for(Car car: findAll()){
            if(car.getRegNumber().equals(regNumber)){
                return car;
            }
        }

        return null;
    }

    //TODO: Find All Electric Cars

    public String findElectricCars() {
        Car[] electricCars = carDao.getElectricCars();
        return electricCars.toString();
    }

    //TODO: Find All Available Cars
    public Car[] findAvailableCars() {
        Car[] bookedCars = bookingDao.getBookedCars();
        Car[] availableCars = new Car[carDao.getCars().length + 1];
        int i = 0;
        for (Car car : carDao.getCars()) {
            for (Car bookedCar : bookedCars) {
                if(car != bookedCar){
                    availableCars[i] = car;
                    i++;
                    break;
                }
            }
        }

        return availableCars;
    }

    // TODO: Find All Available Electric Cars
    public Car[] findAvailableElectricCars() {
        Car[] availableCars = findAvailableCars();
        Car[] availableElectricCars = new Car[availableCars.length + 1];
        int i = 0;
        for (Car car : availableCars) {
            if (car != null && car.isElectric()) {
                availableElectricCars[i] = car;
                i++;
            }
        }
        return availableElectricCars;
    }
}
