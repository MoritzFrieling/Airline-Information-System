/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f.datarecords;

/**
 *
 * @author phuong
 */
public class AirportData {

    private final String name;
    private final String city;
    private final String country;
    private final String abbreviation;
    //private final double latitude;
    // private final double longtitude;

    public AirportData(String name, String city, String country, String abbreviation) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.abbreviation = abbreviation;

    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

}
