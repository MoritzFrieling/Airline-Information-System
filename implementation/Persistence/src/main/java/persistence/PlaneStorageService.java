package persistence;

import datarecords.PlaneData;
import datarecords.PlaneModelData;

import java.util.List;

public interface PlaneStorageService {

    PlaneData add(PlaneData planeData);
    List<PlaneData> getAll();
}
