package persistence;

import datarecords.*;

import java.net.PasswordAuthentication;
import java.util.List;

public interface StorageService {

    AirportData add(AirportData airportData) throws Exception;
    PlaneData add(PlaneData planeData) throws Exception;
    RouteData add(RouteData routeData);
    FlightData add(FlightData flightData);
    boolean add(PlaneModelData planeModelData) throws Exception;

    boolean add(AccountData accountData) throws Exception;


    PasswordAuthentication getAccountData(PasswordAuthentication passwordAuthentication) throws Exception;
    String getPosition(String str);
    String getSalt(String str) throws Exception;

    List<FlightData> getAllFlights();
    List<AirportData> getAllAirports();
    List<PlaneData> getAllPlanes();
    List<RouteData> getAllRoutes();
    List<PlaneModelData> getAllPlaneModels() throws Exception;

}
