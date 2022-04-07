package persistence;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBProvider {

    static Map<String, DataSource> cache = new HashMap<>();

    static DataSource getDataSource( final String sourceName ) {
        // dataSourceByName is a map, serving as a cache.
        return cache.computeIfAbsent( sourceName,
                ( s ) -> {
                    Properties props = properties( "application.properties" );

                    PGSimpleDataSource source = new PGSimpleDataSource();

                    String prefix = sourceName + ".";
                    String[] serverNames = {
                            props.getProperty( prefix + "dbhost" )
                    };
                    source.setServerNames( serverNames );

                    String user = props.getProperty( prefix + "username" );
                    source.setUser( user );

                    source.setDatabaseName( props.getProperty( prefix + "dbname" ) );
                    source.setPassword( props
                            .getProperty( prefix + "password" ) );
                    String pingQuery = "SELECT current_database(), now()::TIMESTAMP as now;";
                    try (Connection con = source.getConnection();
                         // ping the database for success.
                         PreparedStatement pst = con.prepareStatement( pingQuery ) ) {
                        try (ResultSet rs = pst.executeQuery()) {
                            if ( rs.next() ) {
                                Object db = rs.getObject(  "current_database");
                                Object now = rs.getObject(  "now");
                                System.out.println("connected to db "+ db.toString()+ ", date/time is " + now.toString() );
                            }
                        }

                    } catch ( SQLException ex ) {
                        Logger.getLogger( DBProvider.class.getName() ).log( Level.SEVERE, null, ex );
                    }
                    return source;
                }
        ); // end of lambda.
    }

    // read properties
    static Properties properties( String propFileName ) {
        Properties properties = new Properties();
        try (
                FileInputStream fis = new FileInputStream( propFileName ); ) {
            properties.load( fis );
        } catch ( IOException ignored ) {
            Logger.getLogger( DBProvider.class.getName() ).log(
                    Level.INFO,
                    "attempt to read file from well known location failed'",
                    ignored );
        }
        return properties;
    }
}
