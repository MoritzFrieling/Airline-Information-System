package businesslogic;

import datarecords.CoordinateData;

public class CoordinateManager {


    //================================================================================================================//
    /* Primary Methods                                                                                                */
    //================================================================================================================//


    public CoordinateData add(String coordinate){
        if (isDecimalDegree(coordinate)){
            return new CoordinateData(decimalLatitude(coordinate),decimalLongitude(coordinate));
        } else {
            return new CoordinateData(sexagesimalToLatitude(coordinate),sexagesimalToLongitude(coordinate));
        }


    }



    //================================================================================================================//
    /* Helper Methods                                                                                                 */
    //================================================================================================================//


    /**
     * return if string is Decimal or Sexagesimal
     *
     * @param str coordinate string
     * @return true if Decimal, false if sexagesimal
     */
    static boolean isDecimalDegree(String str){
        return !str.contains("°") && !str.contains("′") && !str.contains("″");
    }


    /**
     * return latitude double of coordinate string like string "+40.345,-70.678"
     *
     * @param str coordinate string
     * @return decimal latitude
     */
    static double decimalLatitude(String str){
        String[] arr = str.split(",");
        return Double.parseDouble(arr[0]);
    }

    /**
     * return longitude double of coordinate string like string "+40.345,-70.678"
     *
     * @param str coordinate string
     * @return decimal longitude
     */
    static double decimalLongitude(String str){
        String[] arr = str.split(",");
        return Double.parseDouble(arr[1]);
    }


    /**
     * Method to convert a Sexagesimal DMS ( Degree Minute Second ) into a Latitude value of a DD ( Decimal Degree ) Coordinate
     *
     * @param sexagesimal DMS-Coordinate, as example: "40° 26′ 46″ N 79° 58′ 56″ W"
     * @return Latitude of the DMS-Coordinate, in this case +40.446
     */
    static double sexagesimalToLatitude(String sexagesimal){

        String latString;
        String[] sexaLatitude;

        if(sexagesimal.contains("N")){
            sexaLatitude = sexagesimal.split("N");
        }else{
            sexaLatitude = sexagesimal.split("S");
        }
        latString = sexaLatitude[0];

        return dmsStringToDouble(latString);

    }


    /**
     * Method to convert a Sexagesimal DMS ( Degree Minute Second ) into a Latitude value of a DD ( Decimal Degree ) Coordinate
     *
     * @param sexagesimal DMS-Coordinate, as example: "40° 26′ 46″ N 79° 58′ 56″ W"
     * @return Latitude of the DMS-Coordinate, in this case -79.982
     */
    static double sexagesimalToLongitude(String sexagesimal){

        String longString;
        String[] sexasplit;
        String[] sexaLongitude;

        if(sexagesimal.contains("N")){
            sexasplit = sexagesimal.split("N");
        }else{
            sexasplit = sexagesimal.split("S");
        }
        if(sexagesimal.contains("W")){
            sexaLongitude = sexasplit[1].split("W");
        }else {
            sexaLongitude = sexasplit[1].split("E");
        }
        longString = sexaLongitude[0];

        return dmsStringToDouble(longString);

    }


    /**
     *  Convert a DMS String into a Double Value
     *
     * @param string DMS String to be converted to a decimal degree
     * @return the DD value as double
     */
    static double dmsStringToDouble(String string){

        //get and convert degree string to double value
        String[] dArr = string.split("°");
        double degree = Double.parseDouble(dArr[0]);

        // get and convert minute string to a double value
        String[] mArr = dArr[1].split("′");
        String mStr = mArr[0];
        double minute = Double.parseDouble(mStr);

        // get and convert second string to a double value
        String[] sArr = mArr[1].split("″");
        String sStr = sArr[0];
        double second = Double.parseDouble(sStr);

        return ( degree + (minute/60) + (second/3600) );

    }
}
