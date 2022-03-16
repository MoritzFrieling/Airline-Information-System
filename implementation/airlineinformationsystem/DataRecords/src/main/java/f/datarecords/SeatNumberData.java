package f.datarecords;

public class SeatNumberData {

    private final Integer rowNumber;
    private final Character seatChar;

    public SeatNumberData(Integer rowNumber, Character seatChar) {
        this.rowNumber = rowNumber;
        this.seatChar = seatChar;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public Character getSeatChar() {
        return seatChar;
    }
}
