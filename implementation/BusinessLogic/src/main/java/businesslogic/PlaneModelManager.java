package businesslogic;

import datarecords.PlaneModelData;
import persistence.StorageService;

public class PlaneModelManager {
    private final StorageService storageService;


    public PlaneModelManager(StorageService storageService) {
        this.storageService = storageService;
    }

    public PlaneModelData add(PlaneModelData planeModelData) throws Exception{
        return storageService.add(planeModelData);
    }
}
