package persistence;

import datarecords.AccountData;
import datarecords.AirportData;
import datarecords.PlaneData;

import java.net.PasswordAuthentication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface DatabaseManager {

    ResultSet executeSQLSelect(PreparedStatement statement) throws Exception;

    boolean executeSQLInsert(PreparedStatement statement) throws Exception;

    PreparedStatement prepareAirportInsert(AirportData airportData) throws Exception;

    PreparedStatement preparePlaneInsert(PlaneData planeData);

    PreparedStatement prepareAccountInsert(AccountData accountData);

    PasswordAuthentication getAccountData(String string);

    String getSalt(String string);
}
