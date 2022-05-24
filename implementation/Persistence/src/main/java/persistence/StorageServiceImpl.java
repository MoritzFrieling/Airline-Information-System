package persistence;

import datarecords.*;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;

/**
 * This class knows everything about storing and retrieving data from
 * the database. At the moment only returns dummy object with an id that is set.
 * Normally it will connect to a database and do all the handling.
 *
 * @author Jannick Gruschka
 */
public class StorageServiceImpl implements StorageService{


    DatabaseManager databaseManager = new DatabaseManagerImpl();


    @Override
    public <T> boolean add(T t) {
        try {
            return databaseManager.executeSQLInsert(t);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }return false;
    }

    @Override
    public PasswordAuthentication getAccountData(PasswordAuthentication passwordAuthentication) throws Exception {
        return databaseManager.getAccountData(passwordAuthentication.getUserName());
    }

    @Override
    public String getPosition(String str) {
        return databaseManager.getPosition(str);
    }

    @Override
    public String getSalt(String str) throws Exception {
        String s = databaseManager.getSalt(str);

        if(s != null){
            return s;
        }else return "WHYYYYYYY";
    }

    @Override
    public ArrayList<String> getAllAirports() {
        return databaseManager.getAirports();
    }

    @Override
    public AirportData getAirport(String str) {
        return databaseManager.getAirport(str);
    }

    @Override
    public List<PlaneData> getAllPlanes() {
        throw new UnsupportedOperationException("Not supported yet.");    }

    @Override
    public ArrayList<String> getAllRoutes() {
        return databaseManager.getAllRoutes();
    }

    @Override
    public List<PlaneModelData> getAllPlaneModels() throws Exception{
        return databaseManager.getAllPlaneModels();
    }

    @Override
    public List<FlightData> getAllFlights() {
        throw new UnsupportedOperationException("Not supported yet.");    }
}
