package datarecords;

import java.time.LocalDateTime;


public class FlightData {

    private final LocalDateTime departure;
    private final LocalDateTime arrival;
    private final PlaneData plane;
    private final RouteData route;
    private final float price;
    private final int economy;
    private final int business;
    private final int firstClass;

    public FlightData(RouteData route, LocalDateTime departure, LocalDateTime arrival, PlaneData plane, float price, int economy, int business, int firstClass) {
        this.route = route;
        this.departure = departure;
        this.arrival = arrival;
        this.plane = plane;
        this.price = price;
        this.business = business;
        this.economy = economy;
        this.firstClass = firstClass;
    }

    public int getEconomy() {
        return economy;
    }

    public int getBusiness() {
        return business;
    }

    public int getFirstClass() {
        return firstClass;
    }

    public RouteData getRoute() {
        return route;
    }

    public float getPrice() {
        return price;
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
        return "Origin: " + getRoute().getOrigin().getCountryName() + ", Destination: " + getRoute().getDestination().getCountryName() + ", Price: "+getPrice()/100+"€\nDeparture: "+getDeparture() +", Arrival: "+getArrival() +"\nPlane Manufacturer: "+getPlane().getPlaneModelData().getManufacturer()+", Model Number: "+getPlane().getPlaneModelData().getModelNumber();
    }






}

