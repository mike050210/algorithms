package my.algo.sol.hashing.busydays;

import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
https://www.hackerrank.com/contests/booking-womenintech/challenges/busy-days

The marketing team at Booking.com wants to identify our partners’ busiest days – the dates with the maximum number of reservations per property.
Once they know which dates are most popular with guests, the marketing team can use this information to acquire more rooms on these high demand dates.
Can you help?

There’s one property per test case, each with a list of reservation check-in and check-out dates (all dates are inclusive).
We need you to find the date with the most reservations at each property.

Input Format:
------------
The first line of each test file contains the number of test cases .
For each test case, the first line contains the number of reservations .
n lines follow, each contain two space separated dates checkin_date,checkout_date  in the YYYY-MM-DD format.

Sample Input:
------------
1
3
2018-01-01 2018-01-03
2018-01-02 2018-01-05
2018-01-03 2018-01-06

Output Format:
-------------
For each test case, print the date with most reservations in the YYYY-MM-DD format in a new line.
If multiple dates have the same number of reservations, return the earliest one.

Sample Output:
-------------
2018-01-03

Explanation:
------------
It is clear from the input that among the 3 reservations made, 2018-01-03 had the maximum number of reservations.
 */
public class BusyDays {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final String DELIMITER = " ";

    public String busiestDay(List<String> reservations) {

        int maxCount = 0;
        String busyDay = null;
        Map<Date, Integer> countMap = new TreeMap<>();

        for (String reservation : reservations) {
            String[] dates = reservation.split(DELIMITER);
            for (String date : dates) {
                Date convertedDate = convertToDate(date);
                int count = (countMap.containsKey(convertedDate)) ? countMap.get(convertedDate) + 1 : 1;
                countMap.put(convertedDate, count);
                if (maxCount < count) {
                    maxCount = count;
                    busyDay = date;
                }
            }
        }
        return busyDay;
    }


    @SneakyThrows(ParseException.class)
    private Date convertToDate(String date) {
        return DATE_FORMAT.parse(date);
    }
}

