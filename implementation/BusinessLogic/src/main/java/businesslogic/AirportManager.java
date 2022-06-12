package businesslogic;

import datarecords.AirportData;
import persistence.StorageService;

import java.util.ArrayList;

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

    //================================================================================================================//
    /* Primary-Methods                                                                                                */
    //================================================================================================================//

    /**
     * Check in which timezone the Airport is.
     *
     * @return a String with the 3 Letter shortage of the Timezone.
     */
    public String checkTimezone(double d){
        return storageService.checkZone(d);
    }
    
    public boolean add( AirportData airportData ) throws Exception {
        return storageService.add(airportData);
    }

    public ArrayList<String> getAllAirports(){
        return storageService.getAllAirports();
    }

    public ArrayList<AirportData> getAllAirportData(){return storageService.getAllAirportData();}

    /**
     * Takes an airport-name as parameter and returns the db entry for its airport data
     * @return airport-data of airport-name
     */
    public AirportData getAirport(String str){
        return storageService.getAirport(str);
    }


    /**
     * Checks if the airport data contains a null value except for the coordinate data
     * @return true if contains a null value
     */
    public boolean checkNull(AirportData data){
        return data.getAbbreviation().isEmpty() || data.getAirportName().isEmpty() || data.getCityName().isEmpty() || data.getCountryName().isEmpty();
    }

}
