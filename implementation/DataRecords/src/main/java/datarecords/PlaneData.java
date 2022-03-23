package datarecords;

public class PlaneData {

    private final String planeNumber;

    private final PlaneModelData planeModelData;


    public PlaneData(String planeNumber, PlaneModelData planeModelData) {
        this.planeNumber = planeNumber;
        this.planeModelData = planeModelData;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public PlaneModelData getPlaneModelData() {
        return planeModelData;
    }

    @Override
    public String toString() {
        return "PlaneData{" +
                "planeNumber='" + planeNumber + '\'' +
                ", planeModelData=" + planeModelData.getManufacturer() + "-" + planeModelData.getModelNumber() +
                '}';
    }
}
