package f.persistencelayer;

public class PersistenceAPIImplementation implements PersistenceAPI{
    @Override
    public FlightStorageService getFlightStorageService() {
        return PersistenceAPI.super.getFlightStorageService();
    }
}
