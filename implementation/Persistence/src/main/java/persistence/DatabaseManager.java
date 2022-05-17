package persistence;

import datarecords.AccountData;
import datarecords.AirportData;
import datarecords.PlaneData;
import datarecords.PlaneModelData;

import java.net.PasswordAuthentication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface DatabaseManager {

    ResultSet executeSQLSelect(PreparedStatement statement) throws Exception;

    boolean executeSQLInsert(PreparedStatement statement) throws Exception;

    PreparedStatement prepareAirportInsert(AirportData airportData) throws Exception;

    PreparedStatement preparePlaneInsert(PlaneData planeData);

    PreparedStatement prepareAccountInsert(AccountData accountData);

    PreparedStatement preparePlaneModelInsert(PlaneModelData planeModelData);

    String getPosition(String str);

    PasswordAuthentication getAccountData(String string);

    List<PlaneModelData> preparePlaneModelsGetAll();



    String getSalt(String string);
}
