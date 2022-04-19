package businesslogic;

import persistence.PersistenceAPI;

/**
 * Actual business logic implementation.
 *
 * @author Informatics Fontys Venlo
 */
class BusinessLogicAPIImpl implements BusinessLogicAPI {

    final PersistenceAPI persistenceAPI;

    BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    @Override
    public AirportManager getAirportManager() {
        return new AirportManager(persistenceAPI.getStorageService());
    }

    @Override
    public PlaneManager getPlaneManager() {
        return new PlaneManager(persistenceAPI.getStorageService());
    }

    @Override
    public RouteManager getRouteManager() {
        return new RouteManager(persistenceAPI.getStorageService());
    }

    public FlightManager getFlightManager() { return new FlightManager(persistenceAPI.getStorageService()); }
}
