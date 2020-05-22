package my.algo.sol.sorting.carpooling;

import java.util.Map;
import java.util.TreeMap;
/*
You are driving a vehicle that has capacity empty seats initially available for passengers.
The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip:
the number of passengers that must be picked up, and the locations to pick them up and drop them off.
The locations are given as the number of kilometers due east from your vehicle's initial location.
Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.

Example 1:
---------
Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false

Example 2:
---------
Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true

Example 3:
----------
Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true

Example 4:
---------
Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
 */

/*
  t = number of trips
  d = distinct number of location
  Time complexity = O(t) + O(d)
  Space complexity = O(d)
 */
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Boarding> boardings = transformInputs(trips);
        return canAccomodate(boardings, capacity);
    }

    private boolean canAccomodate(Map<Integer, Boarding> boardings, int capacity) {

        for (Map.Entry<Integer, Boarding> boardingEntry : boardings.entrySet()) {

            Boarding boarding = boardingEntry.getValue();
            capacity += boarding.getOffBoardingPassengers();

            if (capacity >= boarding.getOnBoardingPassengers()) {
                capacity -= boarding.getOnBoardingPassengers();
            } else {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, Boarding> transformInputs(int[][] trips) {

        Map<Integer, Boarding> boardings = new TreeMap<>();

        for (int i = 0; i < trips.length; i++) {
            int numPassengers = trips[i][0];
            int startLocation = trips[i][1];
            int endLocation = trips[i][2];

            onBoardPassengers(startLocation, numPassengers, boardings);
            offBoardPassengers(endLocation, numPassengers, boardings);
        }

        return boardings;
    }

    private void onBoardPassengers(int startLocation, int numPassengers, Map<Integer, Boarding> boardings) {
        Boarding boarding;
        if (boardings.containsKey(startLocation)) {
            boarding = boardings.get(startLocation);
            boarding.setOnBoardingPassengers(boarding.getOnBoardingPassengers() + numPassengers);
        } else {
            boarding = new Boarding(numPassengers, 0);
        }
        boardings.put(startLocation, boarding);
    }

    private void offBoardPassengers(int endLocation, int numPassengers, Map<Integer, Boarding> boardings) {
        Boarding boarding;
        if (boardings.containsKey(endLocation)) {
            boarding = boardings.get(endLocation);
            boarding.setOffBoardingPassengers(boarding.getOffBoardingPassengers() + numPassengers);
        } else {
            boarding = new Boarding(0, numPassengers);
        }
        boardings.put(endLocation, boarding);
    }

    class Boarding {

        private Integer onBoardingPassengers;
        private Integer offBoardingPassengers;

        public Boarding(Integer onBoardingPassengers, Integer offBoardingPassengers) {
            this.onBoardingPassengers = onBoardingPassengers;
            this.offBoardingPassengers = offBoardingPassengers;
        }

        public Integer getOnBoardingPassengers() {
            return onBoardingPassengers;
        }

        public void setOnBoardingPassengers(Integer onBoardingPassengers) {
            this.onBoardingPassengers = onBoardingPassengers;
        }

        public Integer getOffBoardingPassengers() {
            return offBoardingPassengers;
        }

        public void setOffBoardingPassengers(Integer offBoardingPassengers) {
            this.offBoardingPassengers = offBoardingPassengers;
        }
    }

}
