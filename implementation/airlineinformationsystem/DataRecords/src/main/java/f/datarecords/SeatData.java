/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f.datarecords;

/**
 *
 * @author phuong
 */
public class SeatData {

    private final String seatNumber;
    private final String classType;
    private boolean isAvailable;

    public SeatData(String seatNumber, String classType) {
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.isAvailable = true;
    }

    public String getSeatNumber() {
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
