/*
 * Copyright 2022 daniel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package datarecords;

/**
 *
 * @author daniel
 */
public class RouteData {

    private final AirportData origin;
    private final AirportData destination;
    private final double distance;
    
    //calculated later sprint
    
    //private final int length;

    public RouteData(AirportData origin, AirportData destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public AirportData getOrigin() {
        return origin;
    }

    public AirportData getDestination() {
        return destination;
    }

    public double getDistance() {return distance;}

    @Override
    public String toString() {
        return "origin= " + origin.getCountryName() + ", destination= " + destination.getCountryName() + "Distance:" +getDistance();
    }
    
    

    

    
}
