package businesslogic;

import datarecords.AirportData;
import persistence.AirportStorageService;

/**
 * Manages customers in the business logic.
 * Linking pin between GUI and persistence. Connected to customerStorageService 
 * in order to retrieve customers and to persist changes.
 * 
 * @author Informatics Fontys Venlo
 */
public class AirportManager {
    
    private final AirportStorageService customerStorageService;

    public AirportManager( AirportStorageService customerStorageService ) {
        this.customerStorageService = customerStorageService;
    }
    
    public AirportData add( AirportData airportData ){
        return customerStorageService.add(airportData);
    }
    
}
