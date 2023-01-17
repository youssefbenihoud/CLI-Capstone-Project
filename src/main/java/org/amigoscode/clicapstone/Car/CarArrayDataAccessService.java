package org.amigoscode.clicapstone.Car;

public class CarArrayDataAccessService implements CarDao{

    private static final Car[] cars;

    static {
        cars = new Car[] {
                new Car(
                        "1234",
                        89.00,
                        "Tesla",
                        true
                ),
                new Car(
                        "4569",
                        85.00,
                        "Tesla",
                        true
                ),
                new Car(
                        "7895",
                        25.00,
                        "Toyota",
                        false
                ),
                new Car(
                        "7842",
                        50.00,
                        "Volkswagen",
                        false
                )
        };
    }

    public Car[] getCars(){
        return cars;
    }

    public Car[] getElectricCars(){
        Car[] electricCars = new Car[cars.length+1];
        int i = 0;
        for(Car car: cars){
            if(car.isElectric()){
                electricCars[i] = car;
            }
            i++;
        }

        return electricCars;
    }


}
