package f.businessLogicLayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import f.datarecords.FlightData;
import f.persistencelayer.FlightStorageService;

/**
 *
 * @author phuong
 */
public class FlightManager {

    private final FlightStorageService flightStorageService;

    public FlightManager(FlightStorageService flightStorageService) {
        this.flightStorageService = flightStorageService;
    }

    public FlightData add(FlightData flightData){
        return flightStorageService.add(flightData);
    }
}
