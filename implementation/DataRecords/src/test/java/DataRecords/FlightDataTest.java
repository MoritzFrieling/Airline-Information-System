package DataRecords;

import datarecords.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public class FlightDataTest {

    @Test
    void tConstructor() {
        FlightData testFlightData = new FlightData(
                new RouteData(
                        new AirportData("testAirportOrigin","TAO","testCityOrigin","testCountryOrigin"),
                        new AirportData("testAirportDestination","TAD","testCityDestination","testCountryDestination"),
                        1000),
                LocalDateTime.of(2012,1,27,3,55,36,0),
                LocalDateTime.of(2012,1,30,7,30,25,7),
                new PlaneData("0",
                        new PlaneModelData("testManufacturer", "300",30,450,320)),
                30);

    }
}
