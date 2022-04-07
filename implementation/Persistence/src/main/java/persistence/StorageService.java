package persistence;

import datarecords.AirportData;
import datarecords.PlaneData;
import datarecords.RouteData;

import java.util.List;

public interface StorageService {

    AirportData add(AirportData airportData);
    PlaneData add(PlaneData planeData);
    RouteData add(RouteData routeData);

    List<AirportData> getAllAirports();
    List<PlaneData> getAllPlanes();
    List<RouteData> getAllRoutes();


}
