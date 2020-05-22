package my.algo.sol.graph.digraph.townjudge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TownJudgeTest {
    private static TownJudge townJudge;

    @BeforeAll
    public static void init() {
        townJudge = new TownJudge();
    }

    @Test
    public void runWithTestData1() {
        int[][] trust = new int[][]{
                {1, 2}
        };
        int actual = townJudge.findJudge(2, trust);
        assertThat(actual, is(2));
    }

    @Test
    public void runWithTestData2() {
        int[][] trust = new int[][]{
                {1, 3},
                {2, 3}
        };
        int actual = townJudge.findJudge(3, trust);
        assertThat(actual, is(3));
    }

    @Test
    public void runWithTestData3() {
        int[][] trust = new int[][]{
                {1, 3},
                {2, 3},
                {3, 1}
        };
        int actual = townJudge.findJudge(3, trust);
        assertThat(actual, is(-1));
    }

    @Test
    public void runWithTestData4() {
        int[][] trust = new int[][]{
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3}
        };
        int actual = townJudge.findJudge(4, trust);
        assertThat(actual, is(3));
    }
}
