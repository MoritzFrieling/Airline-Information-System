package persistence;

import datarecords.AirportData;
import datarecords.PlaneModelData;

import java.net.PasswordAuthentication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface DatabaseManager {

    ResultSet executeSQLSelect(PreparedStatement statement) throws Exception;

    <T> boolean executeSQLInsert(T t) throws Exception;

    <T> PreparedStatement prepareAirportInsert(T t) throws Exception;

   <T> PreparedStatement preparePlaneInsert(T t);

    <T> PreparedStatement prepareAccountInsert(T t);

    <T> PreparedStatement preparePlaneModelInsert(T t);

    <T> PreparedStatement prepareRouteInsert(T t);

    <T> PreparedStatement prepareFlightInsert(T t);

    List<PlaneModelData> getAllPlaneModels();

    String getPosition(String str);

    PasswordAuthentication getAccountData(String string);

    String getSalt(String string);

    ArrayList<String> getAirports();

    AirportData getAirport(String str);

    ArrayList<String> getAllRoutes();
}
