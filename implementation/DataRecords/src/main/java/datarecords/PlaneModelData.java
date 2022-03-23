package datarecords;

public class PlaneModelData {

    private final String manufacturer;
    private final String modelNumber;
    private final int seats;
    private final double range;
    private final double weightCapacity;

    public PlaneModelData(String manufacturer, String modelNumber, int seats, double range, double weightCapacity) {
        this.manufacturer = manufacturer;
        this.modelNumber = modelNumber;
        this.seats = seats;
        this.range = range;
        this.weightCapacity = weightCapacity;
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
}
