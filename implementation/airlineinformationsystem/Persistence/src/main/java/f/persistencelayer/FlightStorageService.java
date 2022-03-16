package f.persistencelayer;

import f.datarecords.FlightData;

import java.util.List;

public interface FlightStorageService {

    FlightData add(FlightData flightData);
    FlightData update(FlightData flightData);
    List<FlightData> getAll();
}
