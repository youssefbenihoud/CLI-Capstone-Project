package org.amigoscode.clicapstone.Booking;

import org.amigoscode.clicapstone.Car.Car;
import org.amigoscode.clicapstone.User.User;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class BookingService {

    private BookingDao bookingDao = new BookingDao();

    //TODO: Find All Booking Cars
    public Booking[] findAllBooking(){
        return bookingDao.getBookings();
    }

    //TODO: Find All User Booked Cars

    public Booking[] findBookingByUser(UUID userId){
        Booking[] bookingsByUser = bookingDao.getBookingByUser(userId);
        return bookingsByUser;
    }

    //TODO: Book a Car
    public String bookACar(User user, Car car){
        Booking booking = bookingDao.bookACar(user, car);
        return "🎉 Successfully booked car with reg number "+car.getRegNumber()+" for user "+user.toString()+" " +
                "Booking ref: "+ booking.getBookingId();
    }
}
