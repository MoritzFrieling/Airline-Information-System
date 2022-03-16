/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f.datarecords;

import f.businessLogicLayer.Seat;
import f.businessLogicLayer.SeatNumber;

/**
 *
 * @author phuong
 */
public class SeatData {

    private final SeatNumber seatNumber;
    private final String classType;
    private boolean isAvailable;

    public SeatData(SeatNumber seatNumber, String classType) {
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.isAvailable = true;
    }

    public SeatNumber getSeatNumber() {
        return seatNumber;
    }

    public String getClassType() {
        return classType;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    

}
