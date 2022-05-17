package businesslogic;

import datarecords.PlaneData;
import persistence.StorageService;

public class PlaneManager {

    private final StorageService storageService;

    public PlaneManager(StorageService planeStorageService) {
        this.storageService = planeStorageService;
    }

    public boolean add(PlaneData planeData) throws Exception {
        return storageService.add(planeData);
    }
}
