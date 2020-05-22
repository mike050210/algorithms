package my.algo.sol.unknown.candydistribution;

/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?

Example 1:
---------
Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:
----------
Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
 */
public class CandyDistribution {

    public int candy(int[] ratings) {

        if (ratings.length == 1)
            return 1;

        int totalCandies = 0;
        for (int i = 0; i < ratings.length; i++) {
            int leftRatings = (i - 1) >= 0 ? ratings[i - 1] : -1;
            int rightRatings = (i + 1) < ratings.length ? ratings[i + 1] : -1;
            totalCandies += candiesPerChild(ratings[i], leftRatings, rightRatings);
        }
        return totalCandies;
    }


    private int candiesPerChild(int myRatings, int leftRatings, int rightRatings) {
        int noOfCandies = 1;

        if (leftRatings == rightRatings) {
            if (myRatings > leftRatings) {
                return noOfCandies + 1;
            } else {
                return noOfCandies;
            }
        }

        if ((myRatings > leftRatings) && (myRatings > rightRatings)) {
            return noOfCandies + 1;
        }

        if ((leftRatings != -1) && (myRatings > leftRatings)) {
            noOfCandies = noOfCandies + 1;
        }

        if ((rightRatings != -1) && (myRatings > rightRatings)) {
            noOfCandies = noOfCandies + 1;
        }
        return noOfCandies;
    }

}
