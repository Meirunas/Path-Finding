import java.util.Scanner;

public class PathFindingOnSquaredGrid {
    private static boolean[][] randomlyGenMatrix;
    private static int Ai, Aj, Bi, Bj;
    
    public static int getAi() {
        return Ai;
    }

    public static int getAj() {
        return Aj;
    }

    public static int getBi() {
        return Bi;
    }

    public static int getBj() {
        return Bj;
    }

    public static boolean[][] getRandomlyGenMatrix() {
        return randomlyGenMatrix;
    }
    
    // draw the N-by-N boolean matrix to standard draw
    public static void show(boolean[][] a, boolean which) {
        int N = a.length;
        StdDraw.setXscale(-1, N);
        StdDraw.setYscale(-1, N);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] == which)
                    StdDraw.square(j, N-i-1, .5);
                else StdDraw.filledSquare(j, N-i-1, .5);
    }
    
    // draw the N-by-N boolean matrix to standard draw including the shortest path for 3 different distance types
    public static void show(boolean[][] a, boolean which, int repetitionNumber) {
        int N = a.length;
        StdDraw.setXscale(-1, N);
        StdDraw.setYscale(-1, N);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] == which) {
                    for (int currentNodeIndex = 0; currentNodeIndex < Dijkstra.getEndNode().getShortestPath().size(); currentNodeIndex++)
                        if (i == Dijkstra.getEndNode().getShortestPath().get(currentNodeIndex).getX()
                                && j == Dijkstra.getEndNode().getShortestPath().get(currentNodeIndex).getY()
                                || i == Dijkstra.getEndNode().getX()
                                && j == Dijkstra.getEndNode().getY()) {
                            if (repetitionNumber == 0) {
                                StdDraw.setPenColor(StdDraw.GREEN);
                                StdDraw.filledSquare(j, N - i - 1, .5);
                            } else if (repetitionNumber == 1) {
                                StdDraw.setPenColor(StdDraw.RED);
                                StdDraw.filledRectangle(j, N - i - 1, .5, .2);
                            } else if (repetitionNumber == 2) {
                                StdDraw.setPenColor(StdDraw.BLUE);
                                StdDraw.filledRectangle(j, N - i - 1, .2, .5);
                            }

                        }
                }
    }

    // draw the N-by-N boolean matrix to standard draw, including the points A (x1, y1) and B (x2,y2) to be marked by a circle
    public static void show(boolean[][] a, boolean which, int x1, int y1, int x2, int y2) {
        int N = a.length;
        StdDraw.setXscale(-1, N);
        StdDraw.setYscale(-1, N);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] == which)
                	if ((i == x1 && j == y1) ||(i == x2 && j == y2)) {
                		StdDraw.circle(j, N-i-1, .5);
                	}
                	else StdDraw.square(j, N-i-1, .5);
                else StdDraw.filledSquare(j, N-i-1, .5);
    }
    
    // return a random N-by-N boolean matrix, where each entry is
    // true with probability p
    public static boolean[][] random(int N, double p) {
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = StdRandom.bernoulli(p);
        return a;
    }
    
    public static void main(String[] args) {
    	// The following will generate a 10x10 squared grid with relatively few obstacles in it
    	// The lower the second parameter, the more obstacles (black cells) are generated
        int N = 10;
        double p = 0.8;
    	randomlyGenMatrix = random(N, p);
    	
    	StdArrayIO.print(randomlyGenMatrix);
    	show(randomlyGenMatrix, true);
    	
    	System.out.println();
    	
    	// Reading the coordinates for points A and B on the input squared grid.    	   	
    	Scanner in = new Scanner(System.in);
        System.out.println("Enter i for A (0," + (N - 1) + ") > ");
        Ai = in.nextInt();
        
        System.out.println("Enter j for A (0," + (N - 1) + ") > ");
        Aj = in.nextInt();
        
        System.out.println("Enter i for B (0," + (N - 1) + ") > ");
        Bi = in.nextInt();
        
        System.out.println("Enter j for B (0," + (N - 1) + ") > ");
        Bj = in.nextInt();

        Dijkstra dijkstra = new Dijkstra();
        for (int repetitionNumber = 0; repetitionNumber < 3; repetitionNumber++) {
            Stopwatch timerFlow = new Stopwatch();
            dijkstra.mainDijkstra(repetitionNumber);
        
            StdOut.println("Elapsed time = " + timerFlow.elapsedTime());
            show(randomlyGenMatrix, true, repetitionNumber);
        }
        show(randomlyGenMatrix, true, Ai, Aj, Bi, Bj);
    }
}