package businesslogic;

import datarecords.PlaneData;
import datarecords.PlaneModelData;
import persistence.StorageService;

import java.util.List;

public class PlaneManager {

    private final StorageService storageService;

    public PlaneManager(StorageService planeStorageService) {
        this.storageService = planeStorageService;
    }

    public PlaneData add(PlaneData planeData) throws Exception {
        return storageService.add(planeData);
    }

    public List<PlaneModelData> getAllPlaneModels() throws Exception{
        return storageService.getAllPlaneModels();
    }

}
