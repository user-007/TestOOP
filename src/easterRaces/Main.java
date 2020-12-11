package easterRaces;

import easterRaces.core.ControllerImpl;
import easterRaces.core.EngineImpl;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.racers.Race;
import easterRaces.io.ConsoleReader;
import easterRaces.io.ConsoleWriter;
import easterRaces.repositories.interfaces.Repository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchFieldException {
        //тук възниква въпросът как да извикам repository - тата, чрез Reflection или по друг начин?
        var fields = ControllerImpl.class.getDeclaredFields();
        //Repository<Car> motorcycleRepository =  fields.getClass().getDeclaredField("carRepository");
        Repository<Car> motorcycleRepository = null;
        Repository<Race> raceRepository  = null;
        Repository<Driver> riderRepository = null;
        Controller controller = new ControllerImpl(riderRepository,motorcycleRepository,raceRepository); // TODO: new ControllerImpl(riderRepository, motorcycleRepository, raceRepository);
        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
