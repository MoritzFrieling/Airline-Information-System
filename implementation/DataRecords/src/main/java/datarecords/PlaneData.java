package datarecords;

public class PlaneData {

    private final PlaneModelData planeModelData;


    public PlaneData(PlaneModelData planeModelData) {
        this.planeModelData = planeModelData;
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
