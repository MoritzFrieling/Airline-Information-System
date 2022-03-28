package persistence;

import datarecords.RouteData;

import java.util.List;

public interface RouteStorageService {

    RouteData add(RouteData routeData);
    List<RouteData> getAll();
}
