package org.amigoscode;

import org.amigoscode.clicapstone.Booking.Booking;
import org.amigoscode.clicapstone.Booking.BookingService;
import org.amigoscode.clicapstone.Car.Car;
import org.amigoscode.clicapstone.Car.CarService;
import org.amigoscode.clicapstone.User.User;
import org.amigoscode.clicapstone.User.UserDao;
import org.amigoscode.clicapstone.User.UserService;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // whether exiting menu or not
        boolean exit = false;

        //Services
        CarService carService = new CarService();
        UserService userService = new UserService();
        BookingService bookingService = new BookingService();


        while (!exit) {
            //Show Menu
            getMainMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookCar(carService, userService, bookingService, scanner);
                    break;
                case 2:
                    System.out.println("View All User Booked Cars");
                    Arrays.stream(userService.findAll()).forEach(System.out::println);
                    String userId = scanner.next();
                    UUID userIdToUUID = UUID.fromString(userId);
                    Arrays.stream(bookingService.findBookingByUser(userIdToUUID)).filter(user -> user != null).forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("View All Bookings");
                    Arrays.stream(bookingService.findAllBooking()).filter(booking -> booking != null).forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("View Available Cars");
                    Arrays.stream(carService.findAvailableCars()).filter(car -> car != null).forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("View Available Electric Cars");
                    Arrays.stream(carService.findAvailableElectricCars()).filter(eCar -> eCar != null).forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("View All Users");
                    Arrays.stream(userService.findAll()).forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Exit");
                    exit = true;
                    break;
                default:
                    System.out.println(choice + "does not exist! try again!");
                    break;
            }

        }

    }

    private static void bookCar(CarService carService, UserService userService, BookingService bookingService, Scanner scanner) {
        System.out.println("Book Car");
        Arrays.stream(carService.findAvailableCars()).filter(car -> car != null).forEach(System.out::println);
        System.out.println("select car reg number");
        String regNumber = scanner.next();
        Car chosenCar = carService.getCarByRegNumber(regNumber);
        Arrays.stream(userService.findAll()).forEach(System.out::println);
        String userId = scanner.next();
        UUID userIdToUUID = UUID.fromString(userId);
        User chosenUser = userService.getUserById(userIdToUUID);
        System.out.println(bookingService.bookACar(chosenUser, chosenCar));
    }

    private static void getMainMenu() {
        String mainMenu = "" +
                "1️⃣ - Book Car\n" +
                "2️⃣ - View All User Booked Cars\n" +
                "3️⃣ - View All Bookings\n" +
                "4️⃣ - View Available Cars\n" +
                "5️⃣ - View Available Electric Cars\n" +
                "6️⃣ - View all users\n" +
                "7️⃣ - Exit \n\n";

        System.out.println(mainMenu);
    }
}