package persistence;

import datarecords.AccountData;
import datarecords.AirportData;
import datarecords.PlaneData;

import java.sql.PreparedStatement;

public interface DatabaseManager {

    boolean executeSQL(PreparedStatement statement) throws Exception;

    PreparedStatement prepareAirportInsert(AirportData airportData) throws Exception;

    PreparedStatement preparePlaneInsert(PlaneData planeData);

    PreparedStatement prepareAccountInsert(AccountData accountData);
}
