package datarecords;

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
    
    
    private final String airportName;
    private final String abbreviation;
    private final String countryName;
    private final CoordinateData coordinateData;
    private final String cityName;
    private final String zone;

    public AirportData(String airportName, String abbreviation, String countryName, CoordinateData coordinateData, String cityName, String zone) {
       
        this.airportName = airportName;
        this.abbreviation = abbreviation;
        this.countryName = countryName;
        this.coordinateData = coordinateData;
        this.cityName = cityName;
        this.zone = zone;
    }

    

    public String getAirportName() {
        return airportName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
    
    public String getCountryName(){
        return countryName;
    }

    public CoordinateData getCoordinateData() { return coordinateData; }

    public String getCityName() {
        return cityName;
    }

    public String getZone() {
        return zone;
    }

    @Override
    public String toString() {
        return "Name: " + airportName + ", abbreviation: " + abbreviation + ", country: " + countryName + ", Coordinates: " + coordinateData.toString() + " ";
    }
    
}
