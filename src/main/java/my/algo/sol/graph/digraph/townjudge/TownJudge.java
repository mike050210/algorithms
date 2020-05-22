package my.algo.sol.graph.digraph.townjudge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:
--------
Input: N = 2, trust = [[1,2]]
Output: 2

Example 2:
--------
Input: N = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:
---------
Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

Example 4:
---------
Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 */
public class TownJudge {

    public int findJudge(int N, int[][] trust) {
        DiGraph diGraph = new DiGraph(N);
        for (int i = 0; i < trust.length; i++) {
            diGraph.addEdge(trust[i][0], trust[i][1]);
        }
        return diGraph.findVertexWithNoEdges();
    }


    class DiGraph {

        private Map<Integer, ArrayList<Integer>> adjacencyMap;

        public DiGraph(int vertices) {
            adjacencyMap = new HashMap<>();
            for (int i = 1; i <= vertices; i++) {
                adjacencyMap.put(i, new ArrayList<>());
            }
        }

        public void addEdge(int from, int to) {
            this.adjacencyMap.get(from).add(to);
        }

        public int findVertexWithNoEdges() {
            for (Map.Entry<Integer, ArrayList<Integer>> entry : this.adjacencyMap.entrySet()) {
                if (entry.getValue().isEmpty()) {
                    return entry.getKey();
                }
            }
            return -1;
        }
    }
}

