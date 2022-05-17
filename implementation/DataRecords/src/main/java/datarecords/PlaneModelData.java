package datarecords;

public class PlaneModelData {

    private final String manufacturer;
    private final String modelNumber;
    private final int seats;
    private final double range;
    private final double weightCapacity;
    private final int speed;




    public PlaneModelData(String manufacturer, String modelNumber, int seats, double range, double weightCapacity, int speed) {
        this.manufacturer = manufacturer;
        this.modelNumber = modelNumber;
        this.seats = seats;
        this.range = range;
        this.weightCapacity = weightCapacity;
        this.speed = speed;
    }


    @Override
    public String toString() {
        return "PlaneModelData{" +
                "manufacturer='" + manufacturer + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", seats=" + seats +
                ", range=" + range +
                ", weightCapacity=" + weightCapacity +
                ", speed=" + speed +
                '}';
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public int getSeats() {
        return seats;
    }

    public double getRange() {
        return range;
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public int getSpeed() { return speed; }
}
