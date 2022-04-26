package persistence;

import datarecords.AirportData;
import datarecords.PlaneData;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseManagerImpl implements DatabaseManager {

        private DataSource ds = DBProvider.getDataSource("aisdb.jdbc");
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

                PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
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

                PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
                statement.setString(1,planeData.getPlaneNumber());
                statement.setString(2, planeData.getPlaneModelData().getModelNumber());
                return statement;

            } catch (Exception e) {

                e.printStackTrace();

                return null;
            }
        }
    }

