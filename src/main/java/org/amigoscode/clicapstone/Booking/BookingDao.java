package org.amigoscode.clicapstone.Booking;

import org.amigoscode.clicapstone.Car.Car;
import org.amigoscode.clicapstone.User.User;

public interface BookingDao {

    Booking[] getBookings();

    Booking bookACar(User user, Car car);
}
