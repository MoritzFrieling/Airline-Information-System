package persistence;

import datarecords.AirportData;
import datarecords.FlightData;
import datarecords.PlaneData;
import datarecords.PlaneModelData;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;

public interface StorageService {

//    AirportData add(AirportData airportData) throws Exception;
//    PlaneData add(PlaneData planeData) throws Exception;
//    RouteData add(RouteData routeData);
//    FlightData add(FlightData flightData);
//    boolean add(PlaneModelData planeModelData) throws Exception;

    <T> boolean add(T t);

   // boolean add(AccountData accountData) throws Exception;


    PasswordAuthentication getAccountData(PasswordAuthentication passwordAuthentication) throws Exception;
    String getPosition(String str);
    String getSalt(String str) throws Exception;

    List<FlightData> getAllFlights();
    AirportData getAirport(String str);
    ArrayList<String> getAllAirports();
    List<PlaneData> getAllPlanes();
    List<String> getAllRoutes();
    List<PlaneModelData> getAllPlaneModels() throws Exception;

}
