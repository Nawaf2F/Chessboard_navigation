
import java.util.ArrayList;
import java.util.Scanner;
/**
 * ChessboardProjectTest class of the Java program.
 */
public class ChessboardProjectTestPart2 {

    public static void main(String[] args) {
        
        Chessboard chessboard;
        Scanner in = new Scanner(System.in);
        int task = in.nextInt();
        int testCase = in.nextInt();
        if(task == 4){
            switch (testCase) {
                case 1:
                    {
                        // Task #4: Test findAllPaths() with sample chessboard 1
                        chessboard = new Chessboard(ChessboardSamples.sChessboard1);
                        PathsTree tree = new PathsTree(chessboard);
                        ArrayList<DLLPath> paths = tree.findAllPaths();
                        int i = 0;
                        for (DLLPath p : paths)
                            System.out.println("Path " + i++ + ": " + p);
                        
                    }
                    break;
                case 2:
                    {
                        // Task #4: Test findAllPaths() with sample chessboard 2
                        chessboard = new Chessboard(ChessboardSamples.sChessboard2);
                        PathsTree tree = new PathsTree(chessboard);
                        ArrayList<DLLPath> paths = tree.findAllPaths();
                        int i = 0;
                        for (DLLPath p : paths)
                            System.out.println("Path " + i++ + ": " + p);
                        
                    }
                    break;
                case 3:
                    {
                        // Task #4: Test findAllPaths() with sample chessboard 3
                        chessboard = new Chessboard(ChessboardSamples.sChessboard3);
                        PathsTree tree = new PathsTree(chessboard);
                        ArrayList<DLLPath> paths = tree.findAllPaths();
                        int i = 0;
                        for (DLLPath p : paths)
                            System.out.println("Path " + i++ + ": " + p);
                        
                    }
                    break;
                case 4:
                    {
                        // Task #4: Test findAllPaths() with sample chessboard 4
                        chessboard = new Chessboard(ChessboardSamples.sChessboard4);
                        PathsTree tree = new PathsTree(chessboard);
                        ArrayList<DLLPath> paths = tree.findAllPaths();
                        int i = 0;
                        for (DLLPath p : paths)
                            System.out.println("Path " + i++ + ": " + p);
                        
                    }
                    break;
                case 5:
                    {
                        // Task #4: Test findAllPaths() with sample chessboard 5
                        chessboard = new Chessboard(ChessboardSamples.sChessboard5);
                        PathsTree tree = new PathsTree(chessboard);
                        ArrayList<DLLPath> paths = tree.findAllPaths();
                        int i = 0;
                        for (DLLPath p : paths)
                            System.out.println("Path " + i++ + ": " + p);
                        
                    }
                    break;
                case 6:
                    {
                        // Task #4: Test findAllPaths() with sample chessboard 6
                        chessboard = new Chessboard(ChessboardSamples.sChessboard6);
                        PathsTree tree = new PathsTree(chessboard);
                        ArrayList<DLLPath> paths = tree.findAllPaths();
                        int i = 0;
                        for (DLLPath p : paths)
                            System.out.println("Path " + i++ + ": " + p);
                        
                    }
                    break;
                default:
                    break;
            }

        }
        
        
        
        
        
    }

    public static DLLPath buildPath(Chessboard chessboard, Move[] movs) {

        DLLPath path = new DLLPath();

        int[] currentCoords = new int[]{0, 0};  // (row, col)
        int[] nextCoords;

        path.addLast(currentCoords[0], currentCoords[1]);

        for (int i = 0; i < movs.length; i++) {
            nextCoords = chessboard.getNeighbourCoords(currentCoords[0], currentCoords[1], movs[i]);
            if (nextCoords != null) {
                path.addLast(nextCoords[0], nextCoords[1]);
            } else {
                // invalid movement: stop here
                break;
            }
            currentCoords = nextCoords;
        }

        return path;

    }

}
