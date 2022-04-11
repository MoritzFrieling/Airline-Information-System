package datarecords;

import java.time.LocalDateTime;

public class FlightData {

    private final AirportData origin;
    private final AirportData destination;
    private final LocalDateTime departure;
    private final LocalDateTime arrival;
    //plane missing!


    //calculated later sprint

    //private final int length;

    public FlightData(AirportData origin, AirportData destination, LocalDateTime departure, LocalDateTime arrival) {
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
    }

    public AirportData getOrigin() {
        return origin;
    }

    public AirportData getDestination() {
        return destination;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    @Override
    public String toString() {
        return "origin= " + origin.getCityName() + ", destination= " + destination.getCityName() + "\nArrival= "+getArrival() +", Departure= "+getDeparture();
    }






}

