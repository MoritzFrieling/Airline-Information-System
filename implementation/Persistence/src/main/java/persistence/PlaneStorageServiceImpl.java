package persistence;

import datarecords.PlaneData;
import datarecords.PlaneModelData;

import java.util.List;

public class PlaneStorageServiceImpl implements PlaneStorageService{
    @Override
    public PlaneData add(PlaneData planeData) {
        return new PlaneData(planeData.getPlaneNumber(), planeData.getPlaneModelData());
    }
// new PlaneModelData("Boeing","737",230,7000,35000)
    @Override
    public List<PlaneData> getAll() {
        throw new UnsupportedOperationException("Not supported Yet!");
    }
}
