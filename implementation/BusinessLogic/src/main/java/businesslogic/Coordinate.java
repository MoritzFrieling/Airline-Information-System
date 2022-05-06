package businesslogic;

import datarecords.CoordinateData;

public class Coordinate {

    private final CoordinateData coordinateData;

    public Coordinate(CoordinateData coordinateData) {
        this.coordinateData = coordinateData;
    }


    //================================================================================================================//
    /* Primary-Methods                                                                                                */
    //================================================================================================================//






    /**
     * Method to get the Distance between this Coordinate and another in Kilometer
     *
     * @param coordinate coordinate to which the distance is to be calculated
     * @return distance between this and another coordinate in KM
     */
     public double rangeTo(Coordinate coordinate){

        double lon1 = Math.toRadians(this.coordinateData.getLongitude());
        double lat1 = Math.toRadians(this.coordinateData.getLatitude());;
        double lon2 = Math.toRadians(coordinate.coordinateData.getLongitude());
        double lat2 = Math.toRadians(coordinate.coordinateData.getLatitude());


        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);

    }

}
