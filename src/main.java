
public class main
{
    public static void main(String[] args)
    {
        int[][] array = new int[9][9] ;
        for (int i = 0 ; i <= 8 ; i ++)         //set all default values to 0
            for (int j = 0 ; j <= 8 ; j++)
                array[i][j] = 0 ;

        //fill the adjacent matrix
        array[0][1] = 4 ;
        array[0][7] = 8 ;
        array[1][2] = 8 ;
        array[1][7] = 11 ;
        array[1][0] = 4 ;
        array[2][1] = 8 ;
        array[2][3] = 7 ;
        array[2][5] = 4 ;
        array[2][8] = 2 ;
        array[3][2] = 7 ;
        array[3][4] = 9 ;
        array[3][5] = 10 ;
        array[4][3] = 9 ;
        array[4][5] = 10 ;
        array[5][2] = 4 ;
        array[5][3] = 14 ;
        array[5][4] = 10 ;
        array[5][6] = 2 ;
        array[6][5] = 2 ;
        array[6][7] = 1 ;
        array[6][8] = 6 ;
        array[7][0] = 8 ;
        array[7][1] = 11 ;
        array[7][6] = 1 ;
        array[7][8] = 7 ;
        array[8][2] = 2 ;
        array[8][6] = 6 ;
        array[8][7] = 7 ;

        ShortestPath path = new ShortestPath() ; //create Object
        path.dijkstra(array, 0 );       //call Object dijkstra function on Adjacency Matrix ( 0 as origin)

        System.out.println("\n~~Dijkstra's Algorithm takes an adjacency matrix and and an origin \'vertex\'"
                + "\n~~~~keeps an array of shortest distances from origin to each vertex (all set to int max)~~~"
                + "\n~~~~from the origin it tests all adjacent vertexes for the distance to them plus the path already taken"
                + "\n~~~~if the distance to destination vertex is smaller than the recorded distance in the shortestDistanceArray, update it"
                + "\n~~~~repeat for each following adjacent node~~~~" );

    }
}
