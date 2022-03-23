package persistence;

import datarecords.AirportData;
import java.util.List;

/**
 * Interface that describes all services offered by the AirportStorageService.
 * @author Informatics Fontys Venlo
 */
public interface AirportStorageService {
    
    AirportData add( AirportData airportData);
    List<AirportData> getAll();
}
