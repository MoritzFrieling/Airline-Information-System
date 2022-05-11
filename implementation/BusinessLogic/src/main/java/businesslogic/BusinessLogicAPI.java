package businesslogic;

/**
 * API of the BusinessLogic layer.
 * 
 * @author Informatics Fontys Venlo
 */
public interface BusinessLogicAPI {
    
    AirportManager getAirportManager();

    PlaneManager getPlaneManager();

    PlaneModelManager getPlaneModelManager();
    
    RouteManager getRouteManager();

    FlightManager getFlightManager();

    CoordinateManager getCoordinateManager();

    AccountManager getAccountManager();

    LogInManager getLogInManager();
}
