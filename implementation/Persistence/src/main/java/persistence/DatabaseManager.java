package persistence;

import java.net.PasswordAuthentication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface DatabaseManager {

    ResultSet executeSQLSelect(PreparedStatement statement) throws Exception;

    <T> boolean executeSQLInsert(T t) throws Exception;

    <T> PreparedStatement prepareAirportInsert(T t) throws Exception;

   <T> PreparedStatement preparePlaneInsert(T t);

    <T> PreparedStatement prepareAccountInsert(T t);

    <T> PreparedStatement preparePlaneModelInsert(T t);

    <T> PreparedStatement prepareRouteInsert(T t);

    String getPosition(String str);

    PasswordAuthentication getAccountData(String string);

    String getSalt(String string);
}
