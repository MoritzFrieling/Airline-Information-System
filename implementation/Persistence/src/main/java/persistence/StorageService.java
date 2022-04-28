package persistence;

import datarecords.*;

import java.util.List;

public interface StorageService {

    AirportData add(AirportData airportData) throws Exception;
    PlaneData add(PlaneData planeData) throws Exception;
    RouteData add(RouteData routeData);
    FlightData add(FlightData flightData);
    boolean add(AccountData accountData) throws Exception;


    List<FlightData> getAllFlights();
    List<AirportData> getAllAirports();
    List<PlaneData> getAllPlanes();
    List<RouteData> getAllRoutes();


}
