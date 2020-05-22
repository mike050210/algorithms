package my.algo.sol.loop.managecheckinqueue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ManageCheckinQueueTest {

    private static ManageCheckinQueue manageCheckinQueue;

    @BeforeAll
    public static void init() {
        manageCheckinQueue = new ManageCheckinQueue();
    }

    @Test
    public void stimulationSolTest() {
//        int generalQueue = 10;
//        int expectedTimeInMins = 5;
//        List<List<Integer>> deskList = List.of(List.of(3, 8), List.of(2, 4), List.of(1, 5));

        int generalQueue = 1;
        int expectedTimeInMins = 1;
        List<List<Integer>> deskList = List.of(
                List.of(1, 0), List.of(1, 0), List.of(1, 0), List.of(1, 0), List.of(1, 0));
        int actualTimeInMins = manageCheckinQueue.manageQueue(generalQueue, deskList);
        assertThat(actualTimeInMins, is(expectedTimeInMins));
    }
}

