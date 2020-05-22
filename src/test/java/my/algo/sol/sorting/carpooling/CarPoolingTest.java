package my.algo.sol.sorting.carpooling;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CarPoolingTest {

    private static CarPooling carPooling;

    @BeforeAll
    public static void init() {
        carPooling = new CarPooling();
    }

    @Test
    public void runWithTestData1() {
        int[][] trips = new int[][]{
                {2, 1, 5},
                {3, 3, 7}
        };
        boolean actual = carPooling.carPooling(trips, 4);
        assertThat(actual, is(false));
    }

    @Test
    public void runWithTestData2() {
        int[][] trips = new int[][]{
                {2, 1, 5},
                {3, 3, 7}
        };
        boolean actual = carPooling.carPooling(trips, 5);
        assertThat(actual, is(true));
    }

    @Test
    public void runWithTestData3() {
        int[][] trips = new int[][]{
                {2, 1, 5},
                {3, 5, 7}
        };
        boolean actual = carPooling.carPooling(trips, 3);
        assertThat(actual, is(true));
    }

    @Test
    public void runWithTestData4() {
        int[][] trips = new int[][]{
                {3, 2, 7},
                {3, 7, 9},
                {8, 3, 9}
        };
        boolean actual = carPooling.carPooling(trips, 11);
        assertThat(actual, is(true));
    }

}
