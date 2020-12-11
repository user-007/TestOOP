package easterRaces.entities.cars;

public abstract class BaseCar implements Car{
    private String model;
    private int horsePower;
    private double cubicCentimetres;

    @Override
    public String getModel()  {
       if(model == null || model.length() < 4){
          throw new IllegalArgumentException(String.format("Model %s cannot be less than 4 symbols.",model));
       }

       return this.model;
    }

    @Override
    public int getHorsePower() {
        //ToDo  - throw Exception
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
       return this.cubicCentimetres ;
    }

    public BaseCar(String model, int horsePower, double cubicCentimetres) {
        this.model = model;
        this.horsePower = horsePower;
        this.cubicCentimetres = cubicCentimetres;
    }

    @Override
    public double calculateRacePoints(int laps) {
      //  cubic centimeters / horsepower * laps
        //  return 0;
        return cubicCentimetres /horsePower*laps;
    }
}
