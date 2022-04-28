package persistence;

import datarecords.AccountData;
import datarecords.AirportData;
import datarecords.PlaneData;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseManagerImpl implements DatabaseManager {

        private final DataSource ds = DBProvider.getDataSource("aisdb.jdbc");
        private Connection con;


        @Override
        public boolean executeSQL(PreparedStatement statement) throws Exception {

            try {

                statement.execute();
                return true;

            } catch (Exception e) {

                e.printStackTrace();
                return false;
            }
        }

        @Override
        public PreparedStatement prepareAirportInsert(AirportData airportData) throws Exception {

            String sql = " INSERT INTO aisdb.ais.airports VALUES (?, ?, ?, ?) ";

            try {
                con = ds.getConnection("aisdemouser","ais");

                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,airportData.getAbbreviation());
                statement.setDouble(2, airportData.getCoordinateData().getLatitude());
                statement.setDouble(3, airportData.getCoordinateData().getLongitude());
                statement.setString(4,airportData.getAirportName());

                return statement;

            } catch (Exception e) {

                e.printStackTrace();

                return null;
            }
        }


        @Override
        public PreparedStatement preparePlaneInsert(PlaneData planeData){
            String sql = " INSERT INTO aisdb.ais.planes VALUES (?, ?) ";

            try {
                con = ds.getConnection("aisdemouser","ais");

                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,planeData.getPlaneNumber());
                statement.setString(2, planeData.getPlaneModelData().getModelNumber());
                return statement;

            } catch (Exception e) {

                e.printStackTrace();

                return null;
            }
        }


        @Override
        public PreparedStatement prepareAccountInsert(AccountData accountData){
            String sql = " INSERT INTO aisdb.ais.accounts VALUES(?, ?, ?, ?, ?, ?) ";

            try {
                con = ds.getConnection("aisdemouser", "ais");

                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, accountData.getFirstname());
                statement.setString(2,accountData.getLastname());
                statement.setString(3, accountData.getPosition());
                statement.setString(4, accountData.getSalt());
                statement.setString(5, accountData.geteMail());
                statement.setString(6, accountData.getPasswordHash());

                return statement;

            }catch (Exception e){

                e.printStackTrace();
                return null;

            }
        }
    }

