package easterRaces.entities.cars;

public class SportsCar extends BaseCar {
    public SportsCar(String model, int horsePower, double cubicCentimetres) {
        super(model, horsePower, cubicCentimetres);
        if (
                cubicCentimetres != 3000 ||
                        !(horsePower >= 250 && horsePower <= 450)


        ) {
            throw new IllegalArgumentException( String.format("Invalid horse power: {horsepower}.",horsePower));
        }
    }

}

