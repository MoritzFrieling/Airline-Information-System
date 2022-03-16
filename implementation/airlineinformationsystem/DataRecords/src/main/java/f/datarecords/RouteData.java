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
public class RouteData {
    String airportA;
    String airportB;

    public RouteData(String airportA, String airportB) {
        this.airportA = airportA;
        this.airportB = airportB;
    }

    public String getAirportA() {
        return airportA;
    }

    public String getAirportB() {
        return airportB;
    }
}
