package businesslogic;

import datarecords.AirportData;
import persistence.StorageService;

/**
 * Manages customers in the business logic.
 * Linking pin between GUI and persistence. Connected to customerStorageService 
 * in order to retrieve customers and to persist changes.
 * 
 * @author Informatics Fontys Venlo
 */
public class AirportManager {
    
    private final StorageService storageService;

    public AirportManager( StorageService airportStorageService ) {
        this.storageService = airportStorageService;
    }
    
    public boolean add( AirportData airportData ) throws Exception {
        return storageService.add(airportData);
    }
    
}
