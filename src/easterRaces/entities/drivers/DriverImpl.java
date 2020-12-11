package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    // can participate only if he has a car
    private boolean canParticipate;

    @Override
    public String getName() {

        return null;
    }

    @Override
    public Car getCar() {
        return null;
    }

    @Override
    public int getNumberOfWins() {
        return 0;
    }

    @Override
    public void addCar(Car car) {
        if(car == null){
            throw new IllegalArgumentException("Car cannot be null.");
        }
      this.car = car;
        canParticipate = true;
    }

    @Override
    public void winRace() {
        numberOfWins++;
    }

    public DriverImpl(String name) {
        this.name = name;
    }

    @Override
    public boolean getCanParticipate() {
        return false;
    }
}
