package f.datarecords;

public class PlaneModelData {

    String name;
    Integer firstClassCapacity;
    Integer businessClassCapacity;
    Integer economyClassCapacity;
    Integer rowSizeFirstClass;
    Integer rowSizeBusinessClass;
    Integer rowSizeEconomyClass;
    Double speed;
    Double range;
    Double luggageCapacity;

    public PlaneModelData(String name, Integer firstClassCapacity, Integer businessClassCapacity,
                          Integer economyClassCapacity, Integer rowSizeFirstClass, Integer rowSizeBusinessClass,
                          Integer rowSizeEconomyClass, Double speed, Double range, Double luggageCapacity) {

        this.name = name;
        this.firstClassCapacity = firstClassCapacity;
        this.businessClassCapacity = businessClassCapacity;
        this.economyClassCapacity = economyClassCapacity;
        this.rowSizeFirstClass = rowSizeFirstClass;
        this.rowSizeBusinessClass = rowSizeBusinessClass;
        this.rowSizeEconomyClass = rowSizeEconomyClass;
        this.speed = speed;
        this.range = range;
        this.luggageCapacity = luggageCapacity;
    }
}
