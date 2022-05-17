package businesslogic;

import datarecords.FlightData;
import persistence.StorageService;

public class FlightManager {


    private final StorageService storageService;

    public FlightManager(StorageService flightStorageService) {
        this.storageService = flightStorageService;
    }

    public boolean add(FlightData flightData){
        return storageService.add(flightData);
    }

}
