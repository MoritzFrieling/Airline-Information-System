package datarecords;

import java.time.LocalDateTime;

public class FlightData {

    private final AirportData origin;
    private final AirportData destination;
    private final LocalDateTime departure;
    private final LocalDateTime arrival;
    private final PlaneData plane;
    //plane missing!


    //calculated later sprint

    //private final int length;

    public FlightData(AirportData origin, AirportData destination, LocalDateTime departure, LocalDateTime arrival, PlaneData plane) {
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.plane = plane;
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

    public PlaneData getPlane() {
        return plane;
    }

    @Override
    public String toString() {
        return "Origin: " + origin.getCityName() + ", Destination: " + destination.getCityName() + "\nDeparture: "+getDeparture() +", Arrival: "+getArrival() +"\nPlane Manufacturer: "+getPlane().getPlaneModelData().getManufacturer()+", Model Number: "+getPlane().getPlaneModelData().getModelNumber();
    }






}

