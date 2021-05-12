// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the adjacencyMatrix
import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPath {
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V = 9;

    int minDistance(int shortestDistanceArray[], Boolean shortestPathTreeSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (shortestPathTreeSet[v] == false && shortestDistanceArray[v] <= min) {
                min = shortestDistanceArray[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int shortestDistanceArray[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + shortestDistanceArray[i]);
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a adjacencyMatrix represented using adjacency matrix
    // representation
    void dijkstra(int adjacencyMatrix[][], int originVertex) {
        int shortestDistanceArray[] = new int[V]; // The output array. shortestDistanceArray[i] will hold
        // the shortest distance from originVertex to i
        System.out.println("Vertex~ShortestDistance\t step by step");

        // shortestPathTreeSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from originVertex to i is finalized
        Boolean shortestPathTreeSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {                                           //set defaults
            shortestDistanceArray[i] = Integer.MAX_VALUE;
            shortestPathTreeSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        shortestDistanceArray[originVertex] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {                              //
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to originVertex in first
            // iteration.
            int u = minDistance(shortestDistanceArray, shortestPathTreeSet);

            // Mark the picked vertex as processed
            shortestPathTreeSet[u] = true;

            // Update shortestDistanceArray value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)

                // Update shortestDistanceArray[v] only if is not in shortestPathTreeSet, there is an
                // edge from u to v, and total weight of path from originVertex to
                // v through u is smaller than current value of shortestDistanceArray[v]
                if (!shortestPathTreeSet[v] && adjacencyMatrix[u][v] != 0 && shortestDistanceArray[u] != Integer.MAX_VALUE && shortestDistanceArray[u] + adjacencyMatrix[u][v] < shortestDistanceArray[v]) {
                    shortestDistanceArray[v] = shortestDistanceArray[u] + adjacencyMatrix[u][v];
                }
            for (int i = 0 ; i <= 8 ; i++)
                System.out.print(i + " [" + (shortestDistanceArray[i] < 1000 ? "" + shortestDistanceArray[i] : " ? ") + "], ");
            System.out.println();
        }
        System.out.println();
        // print the constructed distance array
        printSolution(shortestDistanceArray);
    }

    void shortestDistanceToAllNodes(int adjacencyMatrix[][])
    {

    }
}

