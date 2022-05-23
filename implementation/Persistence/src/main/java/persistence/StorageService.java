package persistence;

import datarecords.*;

import java.net.PasswordAuthentication;
import java.util.List;

public interface StorageService {

    <T> boolean add(T t);

    PasswordAuthentication getAccountData(PasswordAuthentication passwordAuthentication) throws Exception;
    String getPosition(String str);
    String getSalt(String str) throws Exception;

    List<FlightData> getAllFlights();
    List<AirportData> getAllAirports();
    List<PlaneData> getAllPlanes();
    List<RouteData> getAllRoutes();
    List<PlaneModelData> getAllPlaneModels();

}
