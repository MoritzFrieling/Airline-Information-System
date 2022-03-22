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
        return new AirportManager(persistenceAPI.getCustomerStorageService());
    }
    
}
