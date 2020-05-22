package my.algo.sol.hashing.busydays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class BusyDaysTest {

    @Test
    public void busiestDay() {
        String expected = "2018-01-03";
        BusyDays busyDays = new BusyDays();
        List<String> reservations = List.of("2018-01-01 2018-01-03", "2018-01-02 2018-01-05", "2018-01-03 2018-01-06");
        String actual = busyDays.busiestDay(reservations);
        assertThat(actual, is(expected));
    }
}

