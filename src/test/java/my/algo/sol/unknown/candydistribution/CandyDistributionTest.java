package my.algo.sol.unknown.candydistribution;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CandyDistributionTest {

    private static CandyDistribution candyDistribution;

    @BeforeAll
    public static void init() {
        candyDistribution = new CandyDistribution();
    }

    @Test
    public void runWithTestData1() {
        int[] ratings = {1, 0, 2};
        int actual = candyDistribution.candy(ratings);
        assertThat(actual, is(5));
    }

    @Test
    public void runWithTestData2() {
        int[] ratings = {1, 2, 2};
        int actual = candyDistribution.candy(ratings);
        assertThat(actual, is(4));
    }

    @Test
    public void runWithTestData3() {
        int[] ratings = {1,3,2,2,1};
        int actual = candyDistribution.candy(ratings);
        assertThat(actual, is(7));
    }

    @Test
    public void runWithTestData4() {
        int[] ratings = {1, 2, 87, 87, 87, 2, 1}; // 1, 2, 2, 1, 2, 2, 1
        int actual = candyDistribution.candy(ratings);
        assertThat(actual, is(13));
    }

}
