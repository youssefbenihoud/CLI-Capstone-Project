package org.amigoscode.clicapstone.Booking;

import org.amigoscode.clicapstone.Car.Car;
import org.amigoscode.clicapstone.User.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {

    private UUID bookingId;
    private User user;
    private Car car;
    private LocalDateTime bookingDateTime;
    private boolean isCanceled;

    public Booking() {
    }

    public Booking(UUID bookingId, User user, Car car, LocalDateTime bookingDateTime, boolean isCanceled) {
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.bookingDateTime = bookingDateTime;
        this.isCanceled = isCanceled;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", car=" + car +
                ", bookingDateTime=" + bookingDateTime +
                ", isCanceled=" + isCanceled +
                '}';
    }
}
