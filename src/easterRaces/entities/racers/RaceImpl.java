package easterRaces.entities.racers;

import easterRaces.entities.drivers.Driver;

import java.util.Collection;
import java.util.List;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private List<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.name = name;
        this.laps = laps;
    }

    @Override
    public String getName() {
      if(name.isEmpty() || name == null || name.length()<5){
          throw new IllegalArgumentException(String.format("Name %s cannot be less than 5 symbols.",name));
      }
      return name;
    }

    @Override
    public int getLaps() {
        if(laps<1){
            throw new IllegalArgumentException("Laps cannot be less than 1.");
        }
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if(driver == null ){
            throw new IllegalArgumentException("Driver cannot be null.");
        }
        else if(driver.getCar() == null){
            throw new IllegalArgumentException(String.format("Driver %s could not participate in race.",driver));
        }
        else if(drivers.contains(driver)){
            throw new IllegalArgumentException(String.format("Driver %s is already added in %s race.",driver,name));
        }
        drivers.add(driver);

    }
}
