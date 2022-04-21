package datarecords;

public class CoordinateData {

    // -90 at the South Pole, +90 at the North Pole
    private final double latitude;

    //starting from any random point at the Equator with 0, it measures from - to + 180 around the globe.
    private final double longitude;


    public CoordinateData(Double latitude, Double longitude) {

        this.latitude = latitude;
        this.longitude = longitude;
    }


    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Latitude: " + getLatitude() + ", Longitude: " + getLongitude();
    }
}
