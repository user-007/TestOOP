package easterRaces.entities.cars;

public class MuscleCar extends BaseCar {
    /*The cubic centimeters for this type of car are 5000. Minimum horsepower is 400 and maximum horsepower is 600.
    If you receive horsepower which is not in the given range throw IllegalArgumentException with message
    "Invalid horse power: {horsepower}.".*/

    public MuscleCar(String model, int horsePower, double cubicCentimetres) {
        super(model, horsePower, cubicCentimetres);
        if (
                cubicCentimetres != 5000 ||
                        !(horsePower >= 400 && horsePower <= 600)


        ) {
            throw new IllegalArgumentException( String.format("Invalid horse power: {horsepower}.",horsePower));
        }
    }
}
