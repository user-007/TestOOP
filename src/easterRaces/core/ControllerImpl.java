package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

import java.util.List;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> riderRepository, Repository<Car> motorcycleRepository, Repository<Race> raceRepository) {
        this.driverRepository = riderRepository;
        this.carRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
       Driver drv = new DriverImpl(driver);
       List<Driver> driverList  = (List<Driver>) driverRepository.getAll();
        for (Driver drver:
             driverList) {
            if(drver.getName().equals(driver)){
               throw new IllegalArgumentException(String.format("Driver %s is already created.",driver));
            }
        }
       driverRepository.add(drv);
       return String.format("Driver %s is created.",driver);

    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car  =  null;
        switch (type){
            case "MuscleCar":
                car  = new MuscleCar(model,horsePower,5000);
                break;
            case "SportsCar":
                car = new SportsCar(model,horsePower,3000);
                break;
        }
        List<Car> cars = (List<Car>) carRepository.getAll();
        for (Car c:
             cars) {
            if(c.getModel().equals(model) && c.getHorsePower() == horsePower){
                throw new IllegalArgumentException(String.format("Car %s is already created.",model));
            }
        }
        carRepository.add(car);
        return String.format("%s %s is created.",car.getClass().getSimpleName(),model);


    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if(driverRepository.getByName(driverName) == null){
            throw new IllegalArgumentException(String.format("Driver %s could not be found.",driverName));
        }
        if(carRepository.getByName(carModel) == null){
            throw new IllegalArgumentException(String.format("Car %s could not be found.",carModel));
        }
        //Todo - add car with appropriate constructor
       // driverRepository.getByName(driverName).addCar(new Ca);
        return null;
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if(raceRepository.getByName(raceName) == null){
            throw new IllegalArgumentException(String.format("Race %s could not be found.",raceName));
        }
       if(driverRepository.getByName(driverName) == null){
           throw new IllegalArgumentException(String.format("Driver %s could not be found.",driverName));
       }
        raceRepository.getByName(raceName).addDriver(new DriverImpl(driverName));
        return  String.format("Driver %s added in %s race.",driverName,raceName);
    }

    @Override
    public String startRace(String raceName) {
        return null;
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name,laps);
        if(raceRepository.getByName(race.getName()).equals(name)){
            throw new IllegalArgumentException(String.format("Race %s is already created.",race));
        }
        raceRepository.add(race);

        return String.format("Race %s is created.",race);
    }
}
