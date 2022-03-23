package businesslogic;

import datarecords.AirportData;
import datarecords.PlaneData;
import persistence.PlaneStorageService;

public class PlaneManager {

    private final PlaneStorageService planeStorageService;

    public PlaneManager(PlaneStorageService planeStorageService) {
        this.planeStorageService = planeStorageService;
    }

    public PlaneData add(PlaneData planeData){
        return planeStorageService.add(planeData);
    }
}
