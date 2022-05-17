package datarecords;

public class PlaneData {

    private final PlaneModelData planeModelData;
    private final int economySeats;
    private final int businessSeats;
    private final int firstClassSeats;


    public PlaneData(PlaneModelData planeModelData, int economySeats, int businessSeats, int firstClassSeats) {
        this.planeModelData = planeModelData;
        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
        this.firstClassSeats = firstClassSeats;
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public int getFirstClassSeats() {
        return firstClassSeats;
    }

    public PlaneModelData getPlaneModelData() {
        return planeModelData;
    }

    @Override
    public String toString() {
        return "PlaneData{ planeModelData=" + planeModelData.getManufacturer() + "-" + planeModelData.getModelNumber() +
                '}';
    }
}
