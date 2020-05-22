package my.algo.sol.loop.managecheckinqueue;

import java.util.List;
import java.util.stream.Collectors;

public class ManageCheckinQueue {

    /*
    n = number of desks
    t = time taken in minutes
    Time Complexity = (t * O(n)) + O(n) => (5 * 3) + 3 = 18
    Space Complexity = O(n) + O(n)
     */
    public int manageQueue(int generalQueue, List<List<Integer>> deskList) {

        List<Desk> desks = convertToDesks(deskList);
        int timeTaken = 0;

        while (generalQueue > 0) {
            timeTaken++;
            for (Desk desk : desks) {

                if (generalQueue <= 0)
                    break;

                if (desk.getWaitingCustomers() >= desk.getSpeed()) {
                    desk.setWaitingCustomers(desk.getWaitingCustomers() - desk.getSpeed());
                } else {
                    if (desk.getWaitingCustomers() > 0) {
                        generalQueue += desk.getWaitingCustomers();
                        desk.setWaitingCustomers(0);
                    }
                    generalQueue -= desk.getSpeed();
                }
            }
        }

        System.out.println("Total time taken : " + timeTaken);
        return timeTaken;
    }

    private List<Desk> convertToDesks(List<List<Integer>> deskList) {
        return deskList
                .stream()
                .map(d -> new Desk(d.get(0), d.get(1)))
                .collect(Collectors.toList());
    }
}

