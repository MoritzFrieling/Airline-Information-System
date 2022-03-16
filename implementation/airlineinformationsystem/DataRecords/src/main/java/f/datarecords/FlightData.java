/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f.datarecords;

import f.businessLogicLayer.Plane;
import f.businessLogicLayer.Route;

import java.time.LocalDate;

/**
 *
 * @author phuong
 */
public class FlightData {
    private final int flightID;
    private final String name;
    private final Route route;
    private final LocalDate departureDate;
    private final Plane plane;

    public FlightData(int flightID, String name, Route route, LocalDate departureDate, Plane plane) {
        this.flightID = flightID;
        this.name = name;
        this.route = route;
        this.departureDate = departureDate;
        this.plane = plane;
    }
}
