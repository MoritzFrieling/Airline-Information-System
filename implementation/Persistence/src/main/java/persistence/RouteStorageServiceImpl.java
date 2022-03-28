package persistence;

import datarecords.RouteData;
import java.util.List;

class RouteStorageServiceImpl implements RouteStorageService {

    @Override
    public RouteData add(RouteData routeData) {
        
        return new RouteData(routeData.getOrigin(), routeData.getDestination(), routeData.getDistance());
    }

    @Override
    public List<RouteData> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
