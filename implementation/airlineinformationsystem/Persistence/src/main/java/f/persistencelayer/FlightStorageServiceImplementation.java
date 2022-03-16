package f.persistencelayer;

import f.businessLogicLayer.Plane;
import f.businessLogicLayer.PlaneModel;
import f.businessLogicLayer.Route;
import f.datarecords.FlightData;
import f.datarecords.PlaneData;
import f.datarecords.PlaneModelData;
import f.datarecords.RouteData;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class FlightStorageServiceImplementation implements FlightStorageService {

    @Override
    public FlightData add(FlightData flightData) {
        return new FlightData(
                1,
                "why name?",
                new Route(new RouteData(
                        "a",
                        "b")),
                LocalDate.of(2019, Month.AUGUST, 16),
                new Plane(new PlaneData(
                        "1",
                            new PlaneModel(new PlaneModelData(
                                        "Boeing",
                                        10,
                                        40,
                                        100,
                                        2,
                                        4,
                                        6,
                                        600.00,
                                        5000.00,
                                        4000.00)))));
    }

    @Override
    public FlightData update(FlightData flightData) {
        throw new UnsupportedOperationException("Not supported Yet!");
    }

    @Override
    public List<FlightData> getAll() {
        throw new UnsupportedOperationException("Not supported Yet!");
    }
}
