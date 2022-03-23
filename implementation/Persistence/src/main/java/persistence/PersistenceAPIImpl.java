package persistence;

/**
 * Actual creator of storage services.
 * @author Informatics Fontys Venlo
 */
class PersistenceAPIImpl implements PersistenceAPI{

    @Override
    public AirportStorageService getAirportStorageService() {
        return new AirportStorageServiceImpl();
    }

    @Override
    public PlaneStorageService getPlaneStorageService() {
        return new PlaneStorageServiceImpl();
    }
}
