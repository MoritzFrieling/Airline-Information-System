package businesslogic;

import datarecords.PlaneModelData;
import persistence.StorageService;

public class PlaneModelManager {
    private final StorageService storageService;


    public PlaneModelManager(StorageService storageService) {
        this.storageService = storageService;
    }

    public boolean add(PlaneModelData planeModelData) throws Exception{
        return storageService.add(planeModelData);
    }
}
