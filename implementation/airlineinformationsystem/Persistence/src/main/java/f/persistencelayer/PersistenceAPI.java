package f.persistencelayer;

public interface PersistenceAPI {
    /**
     * Get CustomerStorageService. Provides a storage object that knows how to
     * store and retrieve customers. Implemented by a default method, to enable
     * creation of customized PersistenceFacade implementations with limited
     * services, for test purposes.
     *
     * @return CustomerStorageService object that knows how to store and
     * retrieve customers.
     */
    default FlightStorageService getFlightStorageService() {
        return null;
    }
}
