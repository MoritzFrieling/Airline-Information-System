package businesslogic;

import datarecords.PlaneData;
import persistence.StorageService;

public class PlaneManager {

    private final StorageService storageService;

    public PlaneManager(StorageService planeStorageService) {
        this.storageService = planeStorageService;
    }

    public PlaneData add(PlaneData planeData){
        return storageService.add(planeData);
    }
}
