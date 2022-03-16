package f.businessLogicLayer;

import f.persistencelayer.PersistenceAPI;

public class BusinessLogicAPIImplementation implements BusinessLogicAPI {

    final PersistenceAPI persistenceAPI;

    BusinessLogicAPIImplementation(PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    @Override
    public FlightManager getFlightManager() {
        return new FlightManager(persistenceAPI.getFlightStorageService());
    }
}
