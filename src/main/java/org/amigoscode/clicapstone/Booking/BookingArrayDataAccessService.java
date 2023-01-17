package org.amigoscode.clicapstone.Booking;

import org.amigoscode.clicapstone.Car.Car;
import org.amigoscode.clicapstone.User.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingArrayDataAccessService implements BookingDao{

    private static Booking[] bookings;

    static {
        bookings = new Booking[100];
    }

    public Booking[] getBookings(){
        return bookings;
    }

    public Booking[] getBookingByUser(UUID userId){
        Booking[] results = new Booking[bookings.length+1];
        int i = 0;
        for(Booking booking: bookings){
            if(booking != null && booking.getUser().getId().equals(userId)){
                results[i] = booking;
                i++;
            }
        }
        return results;
    }

    public Car[] getBookedCars(){
        Car[] bookedCars = new Car[bookings.length+1];
        int i = 0;
        for (Booking booking: bookings){
            if(booking != null){
                bookedCars[i] = booking.getCar();
                i++;
            }
        }
        return bookedCars;
    }

    // Booking a Car
    public Booking bookACar(User user, Car car){
            Booking booking = new Booking(
                    UUID.randomUUID(),
                    user,
                    car,
                    LocalDateTime.now(),
                    false
            );
            for(Booking b: bookings){
                if(b == null){
                    b = booking;
                    break;
                }
            }
            return booking;
    }
}
