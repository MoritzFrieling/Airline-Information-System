/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f.datarecords;

import f.businessLogicLayer.PlaneModel;
import f.businessLogicLayer.Seat;
import f.businessLogicLayer.SeatNumber;

import java.util.HashMap;

/**
 *
 * @author phuong
 */
public class PlaneData {
    private final String planeNumber;
    private final PlaneModel planeModel;


    public PlaneData(String planeNumber, PlaneModel planeModel) {
        this.planeNumber = planeNumber;
        this.planeModel = planeModel;
    }

}
