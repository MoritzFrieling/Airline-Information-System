package datarecords;

import java.time.LocalDate;

/**
 * Data carrier for CustomerData.
 * As of Java14, you would typically use so-calles Records. The idea is to have
 * immutable objects, that can only be set using the constructor. The constructor 
 * can do validation and throws an IllegalArgumentException in case of invalid
 * values (no validation in the example below). Furthermore class contains getters 
 * for all fields, and NO SETTERS! Typically this class also contains a toString() 
 * method and if necessary equals() and hashCode().
 * 
 * @author Informatics Fontys Venlo
 */
public class AirportData {
    
    private final int id;
    private final String airportName;
    private final String abbreviation;
    private final String cityName;
    private final String countryName;

    public AirportData(int id, String airportName, String abbreviation, String cityName, String countryName) {
        this.id = id;
        this.airportName = airportName;
        this.abbreviation = abbreviation;
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public int getId() {
        return id;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getCityName() {
        return cityName;
    }
    
    public String getCountryName(){
        return countryName;
    }

   

    @Override
    public String toString() {
        return "Name: " + airportName + ", abbreviation: " + abbreviation + ", city: " +cityName +", country: " + countryName + " ";
    }
    
}
