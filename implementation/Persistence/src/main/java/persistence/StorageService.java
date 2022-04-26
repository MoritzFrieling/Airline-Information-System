package persistence;

import datarecords.AirportData;
import datarecords.FlightData;
import datarecords.PlaneData;
import datarecords.RouteData;

import java.util.List;

public interface StorageService {

    AirportData add(AirportData airportData) throws Exception;
    PlaneData add(PlaneData planeData) throws Exception;
    RouteData add(RouteData routeData);
    FlightData add(FlightData flightData);


    List<FlightData> getAllFlights();
    List<AirportData> getAllAirports();
    List<PlaneData> getAllPlanes();
    List<RouteData> getAllRoutes();


}
